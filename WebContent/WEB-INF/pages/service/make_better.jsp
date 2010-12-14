<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帮助我们改善应用</title>
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
		}else if($("#element_3").val()==""&&$("#element_5").val()==""){
			if($("#element_3").val()==""){
				$("#element_3").focus();
			}else{
				$("#element_5").focus();
			}
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
			<p style="margin-top:10px;"><a href="#">服务管理</a>-><a href="#">改善服务</a></p>
		</div>						
		<ul class="form_ul">
		<li id="li_1" >
		<label class="description" for="element_1">标题 </label>
		<span>
			<input id="element_1" name= "better.tittle" class="element text medium" maxlength="255" size="20" value=""/>
		</span>
		</li>
		<li id="li_2" >
		<label class="description" for="element_2_1">改善对象 </label>
		<span>
			<select class="element select medium" name="better.serviceName"><option value="评论组件">评论组件</option></select>
			<label>选择一个服务</label>
		</span>
		<span>
			<select class="element select medium" name="better.type"><option value="界面设计">界面设计</option><option value="代码提高">代码提高</option><option value="创新应用">创新应用</option></select>
			<label>改善内容</label>
		</span> 
		</li>
		<li id="li_3" >
		<label class="description" for="element_3">内容 </label>
		<span>
			<textarea id="element_3" name= "better.content" class="element textarea medium" style="width:570px;"></textarea>
		</span>
		</li>
		<li id="li_5" >
		<label class="description" for="element_5">上传附件 </label>
		<div>
			<input id="element_5" name="file" class="element file" type="file"/> 
		</div>  
		</li>
		<li class="error" <s:if test='error==null'>style="display:none;"</s:if>>
			<s:property value="error"/>
		</li>
		<li class="buttons">
			<input type="hidden" name="form_id" value="62643" />
			<input id="saveForm" class="button_text" type="submit" name="submit" value="提交" />
		</li>
		</ul>
		</form>	
		<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	<img id="bottom" src="/images/bottom.png" alt="">
	</body>
</html>