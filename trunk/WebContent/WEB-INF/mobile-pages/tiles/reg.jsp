<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
 <small><a href="login.do">登录</a></small>
 <h5>注册</h5>
<s:actionerror/>
<form action="/reg.do" method="post">
<input type="hidden" name="submit" value="true"/>
<p>
<small>帐号:<input type="text" name="formRegister.account" value="<s:property value='formRegister.account'/>"/></small>
</p>
<p>
<small>用户名:<input type="text" name="formRegister.name" value="<s:property value='formRegister.name'/>"/></small>
</p>
<p>
<small>邮箱:<input type="text" name="formRegister.email" value="<s:property value='formRegister.email'/>"/></small>
</p>
<p>
<small>密码:<input type="password" name="formRegister.password1"/></small>
</p>
<p>
<small>重复输入密码:<input type="password" name="formRegister.password2"/></small>
</p>
<p>
<small><input type="submit" value="注册"/></small>
</p>
</form>
</div>