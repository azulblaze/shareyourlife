<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="/style/calendar.css" />
<script type="text/javascript" src="/scripts/xheditor-zh-cn.js"></script>
<script type="text/javascript" src="/scripts/set.js"></script>
<script type="text/javascript" src="/scripts/jquery.validate.pack.js"></script>
<script type="text/javascript" src="/scripts/jquery.calendar.js"></script>
<script>
function createSelect(container,data,id,prestr,name){
	var select = $("<select name='"+name+"' id='"+prestr+id+"'></select>");
	select.append("<option value='0'>全部类别</option>");
	for(var i in data){
		$(select).append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
	}
	$(container+" select:last").after(select);
	bindChange(prestr + id);
}
function getCategory(obj){
	var select_s = $(obj+" select option:selected");
	var before = "全部类别";
	var current = "全部类别";
	var len = select_s.length;
	for(var i=0;i<len;i++){
		current = $(select_s.get(i)).text();
		if(current!=null&&current!="全部类别"){
			before = current;
		}
	}
	return before;
}
function bindChange(id,container,prestr,child_select,name){
	$(id).bind("change",function(event){
		var father_id = parseInt($(id+' option:selected').val());
		$(id+" ~ select").each(function(){
			$(this).remove();
		}) 
		if(father_id>0){
			$.ajax( {
				type : "POST",
				url : "/admin/child_category.zl?f_id="+father_id,
				dataType:"json",
				cache : true,
				success : function(data, textStatus) {
					if(data.result=="success"){
						if(data.data.length>0){
							createSelect(container,data.data,father_id,prestr,name);
							try{
								if(child_select!=null&&child_select!=""){
									var _select_child = $(container+" select:last");
									$(_select_child).val(child_select);
									$(_select_child).change();
								}
							}catch(error){}
						}
					}
					if(data.result=="fail"){
						//showError("#sub_msg_div",data.msg);
					}
				}
			});
		}
		
	});
}
var categorys = new Set();
function putcategory(mycategory){
	if(mycategory!=null){
		_category = mycategory;
	}else{
		_category = getCategory("#category_select");
	}
	if(_category=="全部类别"){
		categorys.clear();
		$('#categorys').empty();
	}else{
		if(categorys.remove("全部类别")){
			$('#categorys').empty();
		}
	}
	if(categorys.put(_category)){
		$('#categorys').append('<div class="b_link"><a href="#">'+_category+'</a></div>');
		$('#categorys .b_link').each(function(index,e){
			$(this).unbind('click');
			$(this).bind('click',function(event){
				event.preventDefault();
				categorys.remove($(this).find('a').html());
				$(this).remove();
				$('#dnews_discountCategory').attr("value",categorys.toString());
				if(categorys.size()==0){
					//$("#category_notice").css("display","");
				}
			})
		});
		$('#dnews_discountCategory').attr("value",categorys.toString());
		//$("#category_notice").css("display","none");
	}
}
function initcategory(){
	var sub_category='<s:property value="dnews.discountCategory"/>';
	var sub_cat_arry = sub_category.split(",");
	var sub_len = sub_cat_arry.length;
	for(var i=0;i<sub_len;i++){
		if(sub_cat_arry[i]!=null&&sub_cat_arry[i]!=""){
			putcategory(sub_cat_arry[i]);
		}
	}
}
function setArea(){
	var area_id = parseInt($('#city').val());
	var area_str = "全部地区";
	if(area_id>0){
		area_str = $('#city option:selected').text();
	}else{
		area_id = parseInt($('#province').val());
		if(area_id>0){
			area_str = $('#province option:selected').text();
		}
	}
	$("#dnews_discountArea").attr("value",area_str);
}
var _city_id = '<s:property value="city_id"/>';
function initAreas(){
	$("#province").val('<s:property value="province_id"/>');
	$("#province").change();
}
function initProgramInfo(){
	$("#dnews_pId").val('<s:property value="dnews.pId"/>');
	$("#dnews_pId").change();
}
$(document).ready(function(){
	initcategory();
	initProgramInfo();
	bindChange("#category_select0","#category_select","#category_select_child","","newschildcategory");
	$('#discountStart').cld();
	$('#discountEnd').cld();
	$('#news_review').xheditor(true);
	$('#news_content').xheditor(true);
	$('#category_add').bind("click", function(event) {
		putcategory();
	});
	$("#v_code_img").bind("click",function(event){
		var timer=new Date();
		$("#v_code_img").attr("src","/code.zl?sessionName=comment_submit&mytime="+timer.getHours()+timer.getMinutes()+timer.getSeconds());
	});
	$("#validate_code").bind("focus",function(event){
		if($("#v_code_img").css("display")=="none"){
			$("#v_code_img").click();
			$("#v_code_img").css("display","");
		}
	});
	$("#province").bind("change",function(event){
		var province_id = parseInt($('#province option:selected').val());
		if(province_id>0){
			$.ajax( {
				type : "POST",
				url : "/loadcity.zl?province_id="+province_id,
				dataType:"json",
				cache : true,
				success : function(data, textStatus) {
					if (textStatus == 'success') {
						$("#city").empty();
						$("#city").append('<option value="-1" selected="selected">全部地区</option>');
						try{
							var options = '';
							for(var i=0;i<data.result.length;i++){
								options = options + '<option value="'+data.result[i].id+'">'+data.result[i].name+'</option>';
							}
							$("#city").append(options);
							//just for first load page to init the area information.
							if(_city_id!=null&&_city_id!=""){
								$("#city").val(_city_id);
								_city_id = null;
							}
						}catch(error){
						}
					}
				}
			});
		}else{
			$("#city").empty();
			$("#city").append('<option value="-1" selected="selected">全部地区</option>');
		}
	});
	initAreas();
	$("#_submit").validate({
		submitHandler: function(form) {
			setArea();
			form.submit();
		},
		errorElement: "div",
		rules: {
			"dnews.newsTitle": {
				required: true,
				maxlength:50
			},
			"dnews.discountStart": {
				required: true
			},
			"dnews.discountEnd": {
				required: true
			},
			"dnews.newsSource": {
				required: true
			},
			"dnews.senderName": {
				required: true
			},
			"dnews.pId": {
				required: true
			},
			"dnews.newsReview": {
				required: true
			},
			"dnews.newsContent": {
				required: true
			}
		},
		messages: {
			"dnews.newsTitle": {
				required: "",
				maxlength:"标题不能超过50个字。"
			},
			"dnews.discountStart": {
				required: ""
			},
			"dnews.discountEnd": {
				required: ""
			},
			"dnews.discountStart": {
				required: ""
			},
			"dnews.senderName": {
				required: ""
			},
			"dnews.pId": {
				required: ""
			},
			"dnews.newsReview": {
				required: ""
			},
			"dnews.newsContent": {
				required: ""
			}
		}
	});
})
</script>
        	<div class="rule">
            	<div class="thank_submit">感谢您投递打折信息给<a href="#" class="zhelazhela">这啦折啦</a></div>
                <ul>
                	<li class="intro">为了更好的保证信息的完整性，我们建议您在投递前了解以下信息：</li>
                    <li>1. 请简明扼要地将您所要报道的事物叙述完整.并附上相关资源,文档,为大家送上更易阅读的信息.</li>
                    <li>2. 如消息为转载,请尽量注明文章来源.无主稿件可能会被暂缓发表. </li>
                    <li>3. 欢迎原创. 您的独家报料与独特视角是<a href="#" class="zhelazhela">这啦折啦</a>编辑与访客的宝贵财富.</li>
                    <li>4. 别忘了署名! 写上您的blog地址, 带来意想不到的人气, 也可能发现志同道合的<a href="#" class="zhelazhela">这啦折啦</a>访客.</li>
                    <li>5. 编辑也许会对投递进行适当修改, 以适合在本站发表.</li>
                </ul>
            </div>
            <form action="/admin/edit_news.zl" method="post" id="_submit">
            <div class="line">
            	<div class="input">
                	<div class="label">标题:</div>
                	<input type="hidden" value='<s:property value="dnews.id"/>' name="dnews.id" />
                    <input type="text" class="w200" value='<s:property value="dnews.newsTitle"/>' name="dnews.newsTitle" />
                    <div class="error"></div>
                </div>
                <div class="notice"><em>(必填*)</em>最多20个字，简明扼要。</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">折扣开始时间:</div>
                    <input type="text" class="w100" value='<s:date name="dnews.discountStart" format="yyyy-MM-dd"/>' id="discountStart" bj="cBj" name="dnews.discountStartStr" />
                    <div class="label">结束时间</div>
                    <input type="text" class="w100" value='<s:date name="dnews.discountEnd" format="yyyy-MM-dd"/>' id="discountEnd" bj="cBj" name="dnews.discountEndStr" />
                     
                </div>
                <div class="notice"><em>(必填*)</em>请注明折扣开始时间和结束时间。</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">新闻来源:</div>
                    <input type="text" class="w300" name="dnews.newsSource" value='<s:property value="dnews.newsSource"/>'/>
                    
                </div>
                <div class="notice"><em>(必填*)</em>请提供新闻来源的网址或者其他信息。</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">打折商家:</div>
                    <select name="dnews.pId" id="dnews_pId">
                    	<option value="-1">其他(我们会为您补充)</option>
                    <s:iterator value="programinfos">
                    	<option value='<s:property value="id"/>'><s:property value="name"/></option>
                    </s:iterator>
                    </select>
                    
                </div>
                <div class="notice"><em>(必填*)</em>请选择打折信息中提供打折的商家,如果选项中没有您可以选择【其他】，我们会为您补充完整。</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">打折地区:</div>
                    <select id="province" name="province_id">
                    	<option value="-1" selected="selected">全部地区</option>
                    <s:iterator value="provinces">
                    	<option value='<s:property value="id"/>'><s:property value="name"/></option>
                    </s:iterator>
                    </select>
                    <select id="city" name="city_id">
                    	<option value="-1" selected="selected">全部地区</option>
                    </select>
                    <input type="hidden" id="dnews_discountArea" name="dnews.discountArea" value=""/>
                    
                </div>
                <div class="notice"><em>(必填*)</em>打折设计的范围，请根据需要选择</div>
            </div>
            <div class="line">
            	<div class="input" id="category_select">
                	<div class="label">商品类别:</div>
                    <select id="category_select0">
                    	<option value='0' select='selected'>全部类别</option>
                    <s:iterator value="categorys">
                    	<option value='<s:property value="id"/>'><s:property value="name"/></option>
                    </s:iterator>
                    </select>
                    <input type="button" id="category_add" class="w60" value="增加" />
                    <input type="hidden" id="dnews_discountCategory" name="dnews.discountCategory" value=""/>
                    <div class="error" id="category_notice" style="display:none;">您必须至少选择一种类别。</div>
                </div>
                <div class="option_link" id="categorys"></div>
                <div class="notice">打折产品的类别，可以包含多种，请增加，如果类别实在太多，请选择【各种类别】</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">新闻概要部分:</div>
                    <div class="spec"><em>(必填*)</em>新闻概要部分(尽量简明概要)。</div>
                </div>
                <div class="news_review"><textarea name="dnews.newsReview" id="news_review"><s:property value="dnews.newsReview"/></textarea></div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">信息主要内容:</div>
                	<div class="spec"><em>(必填*)</em>请客观具体的说明打折的情</div>
                </div>
                <div class="news_content"><textarea name="dnews.newsContent" id="news_content"><s:property value="dnews.newsContent"/></textarea></div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">您的网名:</div>
                    <input type="text" class="w200" name="dnews.senderName" value='<s:property value="dnews.senderName"/>'/>
                    
                </div>
                <div class="notice"><em>(必填*)</em>如果信息发布，会显示您的大名。</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">您的主页:</div>
                    <input type="text" class="w300" name="dnews.senderLink" value='<s:property value="dnews.senderLink"/>'/>
                    
                </div>
                <div class="notice">请提供您的博客网址或者个人站点地址，可能能给您带来流量。</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">您的邮箱:</div>
                    <input type="text" class="w200" name="dnews.senderMail" value='<s:property value="dnews.senderMail"/>' />
                    
                </div>
                <div class="notice"><em>(必填*)</em>请留下您的邮箱作为联系方式。</div>
            </div>
            <s:if test="error!=null">
            <div class="line">
            	<div class="error_info"><s:property value="error"/></div>
            </div>
            </s:if>
            <div class="big_sbumit">
            	<input type="submit" value="确认提交折扣信息" />
            </div>
            </form>
