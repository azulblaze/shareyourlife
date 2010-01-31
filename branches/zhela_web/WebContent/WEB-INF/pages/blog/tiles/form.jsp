<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="/scripts/jquery.validate.pack.js" charset="utf-8"></script>
<script>
$(document).ready(function(){
	$("#v_code_img").bind("click",function(event){
		var timer=new Date();
		$("#v_code_img").attr("src","/code.zl?sessionName=blog_suggest&mytime="+timer.getHours()+timer.getMinutes()+timer.getSeconds());
	});
	$("#validate_code").bind("focus",function(event){
		if($("#v_code_img").css("display")=="none"){
			$("#v_code_img").click();
			$("#v_code_img").css("display","");
		}
	});
	$("#_submit").bind("click",function(event){
		event.preventDefault();
		$("#sug").submit();
	});
	$("#sug").validate({
		errorElement: "span",
		errorClass:"leftNote",
		rules: {
			"blogQa.userName": {
				required: true,
				maxlength:10
			},
			"blogQa.userEmail": {
				required: true,
				email:true
			},
			"blogQa.title": {
				maxlength:100,
				required: true
			},
			"blogQa.content": {
				maxlength:1000,
				required: true
			},
			"validate_code": {
				required: true
			}
		},
		messages: {
			"blogQa.userName": {
			required: "请填写您的名字",
			maxlength: "名字不能超过10个字"
			},
			"blogQa.userEmail": {
				required: "请填写email",
				email:"email正确格式xxx@xxx.xxx"
			},
			"blogQa.title": {
				maxlength:"标题不能超过100个字",
				required: "必须填写标题"
			},
			"blogQa.content": {
				maxlength:"",
				required: ""
			},
			"validate_code": {
				required: ""
			}
		}
	});
});
</script>
	<div class="post">
          <div class="top"></div>
          <div class="middle">
          	<h1>填写您的建议</h1>
          	<s:if test="#session.msg=='not'">
            <div class="error">
              <p><img src="/blog/images/cross.png" alt="">
                请您填写完整后再提交！
              </p>
            </div>
            </s:if>
            <s:if test="#session.msg=='yes'">
            <div class="success">
              <p><img src="/blog/images/button_ok.png" alt="">
                非常感谢您得支持，如果需要我们会尽快的联系您！
              </p>
            </div>
            </s:if>
            <form action="/blog/suggest.zl" method="post" id="sug">
              
              <ul class="form">
                <li>
                  <label>名字:</label><input name='blogQa.userName' value="<s:property value='blogQa.userName'/>" type="text">
                </li>
                <li>
                  <label>邮箱:</label><input name='blogQa.userEmail' value="<s:property value='blogQa.userEmail'/>" type="text">
                </li>
                <li>
                  <label>标题:</label><input name='blogQa.title' value="<s:property value='blogQa.title'/>" type="text">
                </li>
                <li>
                  <label>内容:</label><textarea name='blogQa.content' cols="35" rows="5"><s:property value='blogQa.content'/></textarea>
                </li>
                <li class="validcode">
                  <label>验证码</label><input id="validate_code" value="" name="validate_code" type="text"><img src="/images/v_code.png" id="v_code_img" style="display:none;" title="看不起请点击图片刷新"/>
                </li>
                <li>
                  <span class="button submit"><a id="_submit" href="#">提交</a></span>
                </li>
              </ul>
              
            </form>
          </div>
          <div class="bottom"></div>
        </div>
      </div>
<%
session.removeAttribute("msg");
%>