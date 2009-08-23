<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="div_panel">
	<s:actionerror/>
	<form action="login.do" method="post">
		<input type="hidden" name="submit" value="true"/>
		<p>
		帐号:<input type="text" name="formLogin.name"/>
		</p>
		<p>
		密码:<input type="password" name="formLogin.password"/>
		</p>
		<p>
		<input type="submit" value="登录"/>
		</p>
	</form>
</div>