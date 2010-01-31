<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="/scripts/jquery.validate.pack.js" charset="utf-8"></script>
<script>
function error_msg(msg){
	if(msg==null||msg==""){
		$("#c_error").hide();
	}else{
		$("#c_error p").empty();
		$("#c_error p").append('<img src="/blog/images/cross.png" alt="">'+msg);
		$("#c_error").show();
	}
}
function success_msg(msg){
	if(msg==null||msg==""){
		$("#c_success").hide();
	}else{
		$("#c_success p").empty();
		$("#c_success p").append('<img src="/blog/images/button_ok.png" alt="">'+msg);
		$("#c_success").show();
	}
}
function createComment(data){
	$("#comment_content").append('<div class="comment"><span class="reply"><a href="#">回复</a></span><span class="title"><a href="'+data.userIndex+'">'+data.userName+'</a><span class="date">('+(data.commentTime.year+1900)+'－'+(data.commentTime.month+1)+'－'+data.commentTime.date+' '+data.commentTime.hours+':'+data.commentTime.minutes+':'+data.commentTime.seconds+')</span></span> <p>'+data.content+'</div>');
}
function loadcomment(){
	$.ajax( {
		type : "GET",
		url : "/blog/c_list.zl?id=<s:property value='blog.id'/>",
		cache : false,
		success : function(data, textStatus) {
			$("#comment_content").append(data);
		}
	});
}
$(document).ready(function(){
	loadcomment();
	$("#v_code_img").bind("click",function(event){
		var timer=new Date();
		$("#v_code_img").attr("src","/code.zl?sessionName=blog_comment&mytime="+timer.getHours()+timer.getMinutes()+timer.getSeconds());
	});
	$("#validate_code").bind("focus",function(event){
		if($("#v_code_img").css("display")=="none"){
			$("#v_code_img").click();
			$("#v_code_img").css("display","");
		}
	});
	var c_s = true;
	$("#s_button").bind("click",function(event){
		event.preventDefault();
		if(c_s){
			error_msg("");
			success_msg("");
			$("#blog_c").submit();
		}
	});
	$("#blog_c").validate({
		submitHandler: function(form) {
			c_s = false;
			$.ajax( {
				type : "POST",
				url : "/blog/comment.zl",
				dataType:"json",
				data:{"blogComment.blogId":"<s:property value='blog.id'/>","blogComment.userName":$("input[name='blogComment.userName']").val(),"blogComment.userIndex":$("input[name='blogComment.userIndex']").val(),"blogComment.userEmail":$("input[name='blogComment.userEmail']").val(),"blogComment.content":$("textarea[name='blogComment.content']").val(),"validate_code":$("input[name='validate_code']").val()},
				cache : true,
				success : function(data, textStatus) {
					$("#v_code_img").css("display","none");
					$("#s_button").removeAttr("disabled");
					if(data.result=="success"){
						if(data.msg!=null){
							success_msg(data.msg);
							createComment(data.data);
						}
						$("textarea[name='blogComment.content']").val("");
					}
					if(data.result=="fail"){
						error_msg(data.msg);
					}
					c_s = true;
					$("#validate_code").val("");
				}
			});
			return false;
		},
		errorElement: "span",
		errorClass:"leftNote",
		rules: {
			"blogComment.userName": {
				maxlength:10
			},
			"blogComment.userEmail": {
				maxlength:100,
				email:true
			},
			"blogComment.content": {
				required: true,
				maxlength:500
			},
			"validate_code":{
				required: true
			},
			"blogComment.userIndex":{
				url:true
			}
		},
		messages: {
			"blogComment.userName": {
				maxlength:""
			},
			"blogComment.userEmail": {
				maxlength:"",
				email:""
			},
			"blogComment.content": {
				required: "",
				maxlength:""
			},
			"validate_code":{
				required: ""
			},
			"blogComment.userIndex":{
				url:""
			}
		}
	});
});
</script>
	<div class="post">
          <div class="top"></div>
          <div class="middle">
            <span class="date"><s:property value="blog.day"/><small><s:property value="blog.month"/></small></span>
            <h1><s:property value="blog.title"/></h1>
            <p><s:property value="blog.content" escape="false"/></p>
            <p class="detail_tag">标签：<s:iterator value="blog.tags"><a href="/blog/tag/<s:property value='name'/>"/><s:property value='name'/></a></s:iterator><p>
          </div>
          <div class="bottom"></div>
        </div><!--/post-->
        
        
        <div class="post"><!--comments-->
          <div class="top"></div>
          <div class="middle" id="comment_content">
          </div>
          <div class="bottom"></div>
        </div><!--/comments-->



        <div class="post"><!--response form-->
          <div class="top"></div>
          <div class="middle">
            <h1>发表评论</h1>
            
            <form action="/blog/comment.zl" method="post" id="blog_c">
              <ul class="form">
                <li>
                  <label>名字:</label><input value="" name="blogComment.userName" maxlength="255" type="text">
                </li>
                <li>
                  <label>邮箱:</label><input value="" name="blogComment.userEmail" maxlength="255" type="text">
                </li>
                <li>
                  <label>网址:</label><input value="" name="blogComment.userIndex" type="text">
                </li>
                <li>
                  <label>内容:</label><textarea cols="35" rows="5" name="blogComment.content"></textarea>
                </li>
                <li class="validcode">
                  <label>验证码</label><input id="validate_code" value="" name="validate_code" type="text"><img src="/images/v_code.png" id="v_code_img" style="display:none;" title="看不起请点击图片刷新"/>
                </li>
                <li>
                  <span class="button submit"><a id="s_button" href="#">评论</a></span>
                </li>
              </ul>
            </form>
            <div class="error" id="c_error" style="display:none;">
              <p>
              </p>
            </div>
            <div class="success" id="c_success" style="display:none;">
              <p>
              </p>
            </div>
          </div>
          <div class="bottom"></div>
        </div>