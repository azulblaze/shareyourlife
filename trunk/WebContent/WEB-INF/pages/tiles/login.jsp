<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<div id="mainContent">
		<div class="content">
			<div>
				<a href="reg.do">注册</a>
				<h5>登录</h5>
				<s:actionerror/>
				<form action="login.do" method="post">
				<input type="hidden" name="sub" value="true"/>
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
			<div><a href="forget_pass.do">忘记密码</a></div>
		</div>
		<div class="bottom"></div>
	</div>