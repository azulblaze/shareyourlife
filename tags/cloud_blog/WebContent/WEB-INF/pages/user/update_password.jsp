<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新密码</title>
<link rel="stylesheet" type="text/css" href="/css/view.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/cssmenuvertical.css" media="all">
<script type="text/javascript" src="/js/view.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script>
$(document).ready(function(){
	$("#form_62643").bind("submit",function(event){
		$(".error").css("display","none");
		if($("#element_1").val()==""){
			$("#element_1").focus();
			return false;
		}else if($("#element_2_1").val()==""){
			$("#element_2_1").focus();
			return false;
		}else if($("#element_2_1").val().length<6){
			$("#element_2_1").focus();
			$(".error").html("密码长度必须大于6个字符");
			$(".error").css("display","");
			return false;
		}else if($("#element_2_2").val()==""){
			$("#element_2_2").focus();
			return false;
		}else if($("#element_2_2").val()!=$("#element_2_1").val()){
			$("#element_2_1").focus();
			$(".error").html("两次输入的密码不一致");
			$(".error").css("display","");
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
		<form id="form_62643" class="appnitro" enctype="multipart/form-data" method="post" action="">
		<div class="form_description">
			<jsp:include page="/WEB-INF/pages/common/navmenu.jsp" flush="true"/>
			<p style="margin-top:10px;"><a href="#">更新密码</a></p>
		</div>						
		<ul class="form_ul">
			
		<li id="li_1" >
		<label class="description" for="element_1">原始密码 </label>
		<div>
			<input id="element_1" name="user.password" class="element text medium" type="password" maxlength="255" value=""/> 
		</div> 
		</li>
		<li id="li_2" >
		<label class="description" for="element_2">新密码 </label>
		<span>
			<input id="element_2_1" name= "newpassword" class="element text medium" type="password" maxlength="255" size="20" value=""/>
			<label>不得少于6个字符</label>
		</span>
		<span>
			<input id="element_2_2" name= "re_newpassword" class="element text medium" type="password" maxlength="255" size="20" value=""/>
			<label>重复输入密码</label>
		</span> 
		</li>
		<li class="error" <s:if test='error==null'>style="display:none;"</s:if>>
			<s:property value="error"/>
		</li>
		<li class="buttons">
			<input type="hidden" name="form_id" value="62643" />
			<input id="saveForm" class="button_text" type="submit" name="submit" value="确定" />
		</li>
			</ul>
		</form>	
		<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	<img id="bottom" src="/images/bottom.png" alt="">
	</body>
</html>