<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<a href="reg.do">注册</a>
<h5>找回密码</h5>
<s:actionerror/>
<s:actionmessage/>
<form action="forget_pass.do" method="post">
<input type="hidden" name="submit" value="true"/>
<p>
帐号:<input type="text" name="account"/>
</p>
<p>
邮箱:<input type="text" name="email"/>
</p>
<p>
<input type="submit" value="确定"/>
</p>
</form>
</div>