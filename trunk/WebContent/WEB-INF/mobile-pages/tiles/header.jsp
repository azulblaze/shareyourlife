<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
a img{border:none;}
</style>
<a href="index.do" >
	<img src="/images/mobile/LOGO_mobile.gif"/>
</a>
<div class="div_panel" style="text-align:left;">
<s:if test="#session.user != null && #session.user.status == 1" >
	<a href="index.do">首页</a>
	<a href="profile.do">个人资料</a>
	<a href="upload_pic.do">传图片</a>
	<a href="logout.do">退出</a>
</s:if>
<s:else>
	<a href="login.do">登录</a>

</s:else>
	<a href="reg.do">注册</a>
</div>
