<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="/css/view.css" media="all">
<script type="text/javascript" src="/js/view.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script>
$(document).ready(function(){
	$("#form_62643").bind("submit",function(event){
		if($("#element_1").val()==""){
			$("#element_1").focus();
			return false;
		} else if($("#element_3").val()==""){
			$("#element_3").focus();
			return false;
		}else{
			return true;
		}
	});
});
</script>
</head>
<body id="main_body" >
	
	<img id="top" src="/images/top.png" alt="">
	<div id="form_container">
	
		<h1 class="logo"><a href="http://zhelazhela.com">zhelazhela.com</a></h1>
		<form id="form_62643" class="appnitro" enctype="multipart/form-data" method="post" action="/web/user/signin.do">
					<div class="form_description">
			<h2>登录</h2>
			<p>没有帐号? <a href="/web/user/signup.do">注册</a></p>
		</div>						
		<ul class="form_ul">
		<li id="li_1" >
		<label class="description" for="element_1">帐号 </label>
		<div>
			<input id="element_1" name="user.account" class="element text medium" type="text" maxlength="255" value="<s:property value='user.account'/>"/> 
		</div> 
		</li>
		<li id="li_3" >
		<label class="description" for="element_3">密码 </label>
		<div>
			<input id="element_3" name="user.password" class="element text medium" type="password" maxlength="255" value="<s:property value='user.password'/>"/> 
		</div> 
		</li>
		<li class="error" <s:if test='error==null'>style="display:none;"</s:if>>
			<s:property value="error"/>
		</li>
		<li class="buttons">
			<input type="hidden" name="form_id" value="62643" />
			<input id="saveForm" class="button_text" type="submit" name="submit" value="登录" />
		</li>
		</ul>
		</form>	
		<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	<img id="bottom" src="/images/bottom.png" alt="">
	</body>
</html>