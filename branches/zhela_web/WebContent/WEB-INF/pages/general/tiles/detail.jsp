<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="/style/rater-star.css" type="text/css"/>
<script type="text/javascript" src="/scripts/jquery.validate.pack.js"></script>
<script type="text/javascript" src="/scripts/rater-star.js"></script>
<script type="text/javascript" src="/scripts/display.js"></script>
<script>
function writeCategory(categorys){
	var sub_cat_arry = categorys.split(",");
	var sub_len = sub_cat_arry.length;
	var cat_link = "";
	for(var i=0;i<sub_len;i++){
		if(sub_cat_arry[i]!=null&&sub_cat_arry[i]!=""){
			cat_link = cat_link + '<a href="/index.zl?category='+encodeURI(sub_cat_arry[i])+'">'+sub_cat_arry[i]+'</a>,';
		}
	}
	if(cat_link!=""){
		cat_link = cat_link.substring(0,cat_link.length-1);
		document.write(cat_link);
	}
}
var points_msg = ['太杯具啦','实在太差劲了','叫我怎么说好呢','我只能给你4分','我来鼓励你下','及格了','还行吧','良品','非常不错','传说中的满分'];
function getOption(obj,addr,all_p,times){
	var av_p = 0;
	if(times!=0){
		av_p = all_p/times;
	}
	var option = {  
		    max : 10,
		    msg:points_msg,
		    value:av_p,
		    image:'style/images/star.gif',
		    url : addr,
		    after_ajax  : function(ret) {
	    		var result = eval('('+ret.ajax+')');
	    		$(obj+" ~ .rate_result").empty();
	    		$(obj+" ~ .rate_result").append("当前平均分:"+result.avg_points+" ("+result.times+"次打分)");
	    		this.value  = result.avg_points;  
		        this.enabled= false;  
		        $(obj).rater(this);
			 },
		    after_click : function(ret) {  
		        this.value  = ret.value;  
		        this.enabled= false;  
		        $(obj).rater(this);  
		    }  
		};
	return option;
}
function submit_box_focus(){
	$("textarea[name='comments.content']").bind("focus",function(){
		if($(this).val()=="沙发，还不快抢！"){
			$(this).val("");
		}
	});
}
function bindAS(aobj,sobj,as){
	var c_obj;
	if(as){
		c_obj = sobj;
	}else{
		c_obj = aobj;
	}
	$(c_obj).bind("click",function(event){
		event.preventDefault();
		$.ajax({
			type : "GET",
			url : $(this).attr("href"),
			dataType:"json",
			cache : false,
			success : function(data, textStatus) {
				if(data.result=="success"){
					if(as){
						$(aobj).empty();
						$(aobj).append('<span>反对('+data.against+')</span><img src="images/against.png" class="end" />');
						$(sobj).empty();
						$(sobj).append('<span style="color:grey;">已支持('+data.support+')</span><img src="images/support.png" class="end" />');
					}else{
						$(aobj).empty();
						$(aobj).append('<span style="color:grey;">已反对('+data.against+')</span><img src="images/against.png" class="end" />');
						$(sobj).empty();
						$(sobj).append('<span>支持('+data.support+')</span><img src="images/support.png" class="end" />');
					}
					$(aobj).unbind("click");
					$(aobj).bind("click",function(event1){
						event1.preventDefault();
					});
					$(sobj).unbind("click");
					$(sobj).bind("click",function(event1){
						event1.preventDefault();
					});
				}
			}
		});
	});
}
function createComment(data){
	var obj = $('<div class="commet_bar"><span><a href="'+data.userIndex+'">'+data.userName+'</a></span><span class="qty">发表于</span>  ( '+(data.commentTime.year+1900)+'-'+(data.commentTime.month+1)+'-'+(data.commentTime.date)+' '+data.commentTime.hours+':'+data.commentTime.minutes+':'+data.commentTime.seconds+' )<div><a href="/comment_s.zl?c_id='+data.id+'" class="s_link"><span>支持('+data.supportTimes+')</span><img src="images/support.png" /></a><a href="/comment_a.zl?c_id='+data.id+'" class="a_link"><span>反对('+data.againstTimes+')</span><img src="images/against.png" class="end" /></a></div></div><div class="comment_news">'+data.content+'</div>');
	var alink = $(obj).find(".a_link");
	var slink = $(obj).find(".s_link");
	bindAS(alink,slink,true);
	bindAS(alink,slink,false);
	return obj;
}
function loadComment(){
	$.ajax({
		type : "GET",
		url : "/comment_list.zl?comments.discountInfoId=<s:property value='dn.id'/>",
		dataType:"json",
		cache : false,
		success : function(data, textStatus) {
			if(data.size==0){
				$("#submit_box").css("display","");
				$("textarea[name='comments.content']").val("沙发，还不快抢！");
			}else{
				$("#submit_box").css("display","none");
				var len = data.data.length;
				$("#qty_num").append("( "+len+"条 )");
				for(var i=0;i<len;i++){
					$(".comment").append(createComment(data.data[i]));
				}
			}
		}
	});
}
$(document).ready(function(){
	$("input[name='validate_code']").val("");
	loadComment();
	submit_box_focus();
	$('#content_level').rater(getOption('#content_level',"point_c.zl?dn_id=<s:property value='dn.id'/>",<s:property value='dn.contentPoints'/>,<s:property value='dn.contentPointsTimes'/>));
	$('#info_level').rater(getOption('#info_level',"point_p.zl?dn_id=<s:property value='dn.id'/>",<s:property value='dn.publishPoints'/>,<s:property value='dn.publishPointsTimes'/>));
	$("#want_comment").bind("click",function(event){
		event.preventDefault();
		$(".submit").css("display","");
	});
	$("#del_comment").bind("click",function(event){
		event.preventDefault();
		$(".submit").css("display","none");
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
	$("#support_me").bind("click",function(event){
		event.preventDefault();
		$.ajax({
			type : "GET",
			url : "/support.zl?dn_id=<s:property value='dn.id'/>",
			dataType:"json",
			cache : false,
			success : function(data, textStatus) {
				$("#support_div").empty();
				$("#support_div").append('<img src="images/05.gif" alt="已支持"/><br /><span>支持:'+data.points+'</span>');
			}
		});
	});
	$("#_submit").validate({
		submitHandler: function(form) {
			$("#s_button").attr("disabled","disabled");
			$("#error_span").empty();
			$("#error_span").css("display","none");
			$.ajax( {
				type : "POST",
				url : "/comment.zl",
				dataType:"json",
				data:{"comments.discountInfoId":"<s:property value='dn.id'/>","comments.userName":$("input[name='comments.userName']").val(),"comments.userIndex":$("input[name='comments.userIndex']").val(),"comments.userEmail":$("input[name='comments.userEmail']").val(),"comments.content":$("textarea[name='comments.content']").val(),"validate_code":$("input[name='validate_code']").val()},
				cache : true,
				success : function(data, textStatus) {
					$("#v_code_img").css("display","none");
					$("#s_button").removeAttr("disabled");
					if(data.result=="success"){
						if(data.msg!=null){
							$("#error_span").empty();
							$("#error_span").css("display","");
							$("#error_span").append("<span style='color:green;'>"+data.msg+"</span>");
						}
						$("textarea[name='comments.content']").val("");
						$(".submit").after(createComment(data.data));
					}
					if(data.result=="fail"){
						$("#error_span").empty();
						$("#error_span").css("display","");
						$("#error_span").append(data.msg);
					}
					$("#s_button").attr("disabled","");
					$("input[name='validate_code']").val("");
				}
			});
			return false;
		},
		errorElement: "em",
		rules: {
			"comments.userName": {
				maxlength:10
			},
			"comments.userEmail": {
				maxlength:100,
				email:true
			},
			"comments.content": {
				required: true,
				maxlength:500
			},
			"validate_code":{
				required: true
			},
			"comments.userIndex":{
				url:true
			}
		},
		messages: {
			"comments.userName": {
				maxlength:""
			},
			"comments.userEmail": {
				maxlength:"",
				email:""
			},
			"comments.content": {
				required: "",
				maxlength:""
			},
			"validate_code":{
				required: ""
			},
			"comments.userIndex":{
				url:""
			}
		}
	});
	$(this).displayzhela({extStr:"",zhelazhela:<s:property value='dn.id'/>,delay:3000});
})
</script>
        	<div class="post_head">
            	<h2><a href="#"><s:property value='dn.newsTitle'/></a></h2>
                <div class="small">感谢 <a target="_blank" href="<s:property value='dn.senderLink'/>"><s:property value="dn.senderName"/></a> 投递 | <s:property value='dn.approveUser'/> 审批 | <s:date name="dn.approveTime" format="yyyy-MM-dd hh:mm:ss"/> | 浏览数:<s:property value='dn.readTimes'/> <a target="_blank" href="<s:property value='newsSource'/>">来源</a></div>
            </div>
            <div class="post_footer">
            	<span class="first"><img src="images/cart.png"/>商家:<a target="_blank" href="<s:property value='dn.programInfo.website'/>"><s:property value='dn.programInfo.name'/></a></span><span class="time">开始时间: <s:date name="dn.discountStart" format="yyyy年MM月dd日"/></span><span class="time">结束时间: <s:date name="dn.discountEnd" format="yyyy年MM月dd日"/></span><br /><span class="first"><img src="images/fatcow_472.png"/>地区: <a href='<s:url value="/index.zl"><s:param name="area" value="dn.discountArea" /></s:url>'><s:property value="dn.discountArea"/></a></span><span><img src="images/fatcow_423.png"/>分类:<script>writeCategory('<s:property value="dn.discountCategory"/>');</script></span>
            </div>
            <div class="post_body">
            	<p>
            		<s:property value="dn.newsContent" escape="false"/>
            	</p>
            	<div class="points">
                	<div class="rate">
                    	<div class="rate_line">
                        	<div class="rate_head">信息内容质量:</div>
                            <div id="content_level"></div>
                            <div class="rate_result">
                            	<s:if test="dn.contentPointsTimes==0">
                            		还没有人评分
                            	</s:if>
                            	<s:if test="dn.contentPointsTimes>0">
                            		当前平均分:<s:property value='dn.aveCPoints'/> (<s:property value='dn.contentPointsTimes'/>次打分)
                            	</s:if>
                            </div>
						</div>
                        <div  class="rate_line">
                        	<div class="rate_head">信息报道水平:</div>
                            <div id="info_level"></div>
                            <div class="rate_result">
                            	<s:if test="dn.publishPointsTimes==0">
                            		还没有人评分
                            	</s:if>
                            	<s:if test="dn.publishPointsTimes>0">
                            		当前平均分:<s:property value='dn.avePPoints'/> (<s:property value='dn.publishPointsTimes'/>次打分)
                            	</s:if>
                            </div>
                        </div>
                    </div>
                    <div class="support" id="support_div">
                    	<a href="#" title="支持我" id="support_me"><img src="images/05.gif" alt="支持我"/></a>
                        <br /><span>支持:<s:property value='dn.supportTimes'/></span>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="comment">
            	<div class="commet_bar">
                	<span>评论</span><span class="qty" id="qty_num"></span>
                    <div>
                    	<a href="#" id="want_comment">我要评论</a>
                    </div>
                </div>
                <div class="submit" id="submit_box">
                	<form action="/comment.zl" method="post" id="_submit">
                	<div class="row userinput"><label class="first">网名:</label><input type="text" name="comments.userName" /><label>邮箱:</label><input type="text" name="comments.userEmail" /><label>网址:</label><input name="comments.userIndex" type="text" /></div>
                    <textarea name="comments.content"></textarea>
                    <div class="row"><label>验证码:</label><input class="v_code" type="text" name="validate_code" id="validate_code" /><img src="images/v_code.png" id="v_code_img" style="display:none;" title="看不起请点击图片刷新"/><input type="submit" value="提交" id="s_button" class="i_button" /><input type="button" value="取消" class="i_button" id="del_comment" /><span id="error_span" class="error">请输入验证码</span></div>
                    </form>
                </div>
            </div>