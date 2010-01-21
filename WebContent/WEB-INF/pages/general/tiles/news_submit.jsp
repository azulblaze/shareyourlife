<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="/style/calendar.css" />
<script type="text/javascript" src="/scripts/xheditor-zh-cn.js"></script>
<script type="text/javascript" src="/scripts/set.js"></script>
<script type="text/javascript" src="/scripts/jquery.validate.pack.js"></script>
<script type="text/javascript" src="/scripts/jquery.calendar.js"></script>
<script>
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
function initProgramInfo(){
	$("#dnews_pId").val('<s:property value="dnews.pId"/>');
	$("#dnews_pId").change();
}
$(document).ready(function(){
	initcategory();
	bindChange("#category_select0","#category_select","#category_select_child","","newschildcategory");
	initProgramInfo();
	$('#discountStart').cld();
	$('#discountEnd').cld();
	//$('#news_review').xheditor(true);
	$('#news_content').xheditor(true);
	$('#category_add').bind("click", function(event) {
		putcategory();
	});
	$("#v_code_img").bind("click",function(event){
		var timer=new Date();
		$("#v_code_img").attr("src","/code.zl?sessionName=news_submit&mytime="+timer.getHours()+timer.getMinutes()+timer.getSeconds());
	});
	$("#validate_code").bind("focus",function(event){
		if($("#v_code_img").css("display")=="none"){
			$("#v_code_img").click();
			$("#v_code_img").css("display","");
		}
	});
	bindArea("#province","#city",'<s:property value="city_id"/>');
	initAreas("#province",'<s:property value="province_id"/>');
	$("#_submit").validate({
		submitHandler: function(form) {
			setArea('#city','#province',"#dnews_discountArea");
			//if(categorys.size()<1){
				//$("#category_notice").css("display","");
				//$("#category_select").focus();
				//return;
			//}
			//$("#category_notice").css("display","none");
			form.submit();
		},
		errorElement: "div",
		rules: {
			"dnews.newsTitle": {
				required: true,
				maxlength:50
			},
			"dnews.newsSource": {
				url: true
			},
			"dnews.senderName": {
				required: true
			},
			"dnews.senderMail": {
				email: true
			},
			"dnews.newsContent": {
				required: true
			},
			"validate_code": {
				required: true
			},
			"dnews.senderLink":{
				url:true
			}
		},
		messages: {
			"dnews.newsTitle": {
				required: "",
				maxlength:"标题不能超过50个字。"
			},
			"dnews.newsSource": {
				url: "必须以http://开头的URL地址"
			},
			"dnews.senderName": {
				required: ""
			},
			"dnews.senderMail": {
				email: "您的E-mail格式不正确。"
			},
			"dnews.newsContent": {
				required: ""
			},
			"validate_code": {
				required: ""
			},
			"dnews.senderLink":{
				url:"请输入正确的url地址，http://开头"
			}
		}
	});
})
</script>
        	<div class="rule">
            	<div class="thank_submit">感谢您投递打折信息给<a href="#" class="zhelazhela">这啦折啦</a></div>
                <br/>
            </div>
            <form action="/news_submit.zl" method="post" id="_submit">
            <div class="line">
            	<div class="input">
                	<div class="label">标题:</div>
                    <input type="text" class="w200" value='<s:property value="dnews.newsTitle"/>' name="dnews.newsTitle" />
                    <div class="error"></div>
                </div>
                <div class="notice"><em>(必填*)</em>最多20个字，简明扼要。</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">打折日期:</div>
                    <input type="text" readonly="readonly" class="w100" value='<s:property value="dnews.discountStartStr"/>' id="discountStart" bj="cBj" name="dnews.discountStartStr" />
                    <div class="label">结束时间</div>
                    <input type="text" readonly="readonly" class="w100" value='<s:property value="dnews.discountEndStr"/>' id="discountEnd" bj="cBj" name="dnews.discountEndStr" />
                     
                </div>
                <div class="notice">请注明折扣开始时间和结束时间。</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">新闻来源:</div>
                    <input type="text" class="w300" name="dnews.newsSource" value='<s:property value="dnews.newsSource"/>'/>
                    
                </div>
                <div class="notice">请提供新闻来源的网址(以http://开头)。</div>
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
                <div class="notice">请选择打折信息中提供打折的商家,如果选项中没有您可以选择【其他】，我们会为您补充完整。</div>
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
                <div class="notice">打折设计的范围，请根据需要选择</div>
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
                    <input type="hidden" name="dnews.newsReview" value=""/>
                    <div class="error" id="category_notice" style="display:none;">您必须至少选择一种类别。</div>
                </div>
                <div class="option_link" id="categorys"></div>
                <div class="notice">打折产品的类别，可以包含多种，请增加，如果类别实在太多，请选择【各种类别】</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">详细内容:</div>
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
                <div class="notice">请留下您的邮箱作为联系方式。</div>
            </div>
            <div class="line">
            	<div class="input">
                	<div class="label">验证码:</div>
                    <input type="text" class="w60" name="validate_code" id="validate_code"/>
                    <img src="images/v_code.png" id="v_code_img" style="display:none;"/>
                </div>
                <div class="notice"><em>(必填*)</em>终于到最后一步啦，填写好验证码提交，如果看不清楚点击图片刷新，再次感谢您的无私贡献。</div>
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
