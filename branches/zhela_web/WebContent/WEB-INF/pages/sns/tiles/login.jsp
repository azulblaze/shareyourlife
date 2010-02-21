<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<form action="login.zl" method="post">
	<input type="hidden" value="<s:property value='url'/>" name="url"/>
	<div class="line">账号:<input type="text" value="" name="user.account"/></div>
	<div class="line">密码:<input type="password" value="" name="user.password"/></div>
	<div class="line"><input type="submit" value="确定"/></div>
	<div class="line"><a href="#">忘记密码</a></div>
	<div class="line"><a href="#">激活账号</a></div>
	</form>