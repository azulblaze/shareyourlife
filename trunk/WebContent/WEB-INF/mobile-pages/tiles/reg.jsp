<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="div_panel">
	
		 <a href="login.do">登录</a>
		 <h5>注册</h5>
		<s:actionerror/>
		<form action="reg.do" method="post">
			<input type="hidden" name="submit" value="true"/>
			<div>
				帐号:
				<input type="text" name="formRegister.account" value="<s:property value='formRegister.account'/>"/>
			</div>
			<div>
				用户名:
				<input type="text" name="formRegister.name" value="<s:property value='formRegister.name'/>"/>
			</div>
			<div>
				邮箱:
				<input type="text" name="formRegister.email" value="<s:property value='formRegister.email'/>"/>
			</div>
			<div>
				密码:
				<input type="password" name="formRegister.password1"/>
			</div>
			<div>
				重复输入密码:
				<input type="password" name="formRegister.password2"/>
			</div>
			<div>
				<input type="submit" value="注册"/>
			</div>
		</form>
	
</div>