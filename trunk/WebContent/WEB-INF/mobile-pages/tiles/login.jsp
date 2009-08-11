<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<small><a href="reg.do">注册</a></small>
<small><font color="red">登录</font></small>
<s:actionerror/>
<form action="login.do" method="post">
<input type="hidden" name="submit" value="true"/>
<p>
<small>帐号:<input type="text" name="formLogin.name"/></small>
</p>
<p>
<small>密码:<input type="password" name="formLogin.password"/></small>
</p>
<p>
<small><input type="submit" value="登录"/></small>
</p>
</form>
</div>