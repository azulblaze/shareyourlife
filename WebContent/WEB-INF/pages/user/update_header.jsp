<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传头像</title>
<link rel="stylesheet" type="text/css" href="/css/view.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/cssmenuvertical.css" media="all">
<script type="text/javascript" src="/js/view.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script>
$(document).ready(function(){
	$("#form_62643").bind("submit",function(event){
		if($("#element_5").val()==""){
			$("#element_5").focus();
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
			<p style="margin-top:10px;"><a href="#">上传头像</a></p>
		</div>
		<p>
			<img style="width:200px;height:200px;border:1px solid #eee;" src="<s:property value='#session.user.header'/>"/>
		</p>					
		<ul class="form_ul">
		<li id="li_5" >
		<label class="description" for="element_5">上传头像 </label>
		<div>
			<input id="element_5" name="pic" class="element file" type="file"/> 
		</div>  
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