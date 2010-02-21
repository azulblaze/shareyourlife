<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<form action="reg.zl" method="post">
	<div class="line">账号:<input type="text" value='<s:property value="user.account"/>' name="user.account"/></div>
	<div class="line">姓名:<input type="text" value='<s:property value="user.name"/>' name="user.name"/></div>
	<div class="line">邮箱:<input type="text" value='<s:property value="user.email"/>' name="user.email"/>请正确填写邮箱，我们将发送账号激活码到您的邮箱</div>
	<div class="line">密码:<input type="password" value="" name="user.password"/></div>
	<div class="line">密码确认:<input type="password" value="" name="user.repassword"/></div>
	<div class="line">安全问题:<select name="user.questionid"><s:iterator value="questions">
	<option value='<s:property value="id"/>'><s:property value="question"/></option>
	</s:iterator></select></div>
	<div class="line">答案:<input type="text" value='<s:property value="user.answer"/>' name="user.answer"/></div>
	<div class="line"><input type="submit" value="确定"/></div>
	</form>