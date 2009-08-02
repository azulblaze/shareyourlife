<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %><%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<a href="/login.do">登录</a>
<h5>注册</h5>
<s:actionerror/>
<form action="/reg.do" method="post">
<input type="hidden" name="submit" value="true"/>
<p>
帐号:<input type="text" name="formRegister.account" value="<s:property vlaue='formRegister.account'/>"/>
</p>
<p>
用户名:<input type="text" name="formRegister.name" value="<s:property vlaue='formRegister.name'/>"/>
</p>
<p>
邮箱:<input type="text" name="formRegister.email" value="<s:property vlaue='formRegister.email'/>"/>
</p>
<p>
密码:<input type="password" name="formRegister.password1"/>
</p>
<p>
重复输入密码:<input type="password" name="formRegister.password2"/>
</p>
<p>
<input type="submit" value="注册"/>
</p>
</form>
</div>