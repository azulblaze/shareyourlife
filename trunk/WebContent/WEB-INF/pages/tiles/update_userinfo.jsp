<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:actionerror/>
<div>
<h5>修改密码</h5>
<form action="/login.do" method="post">
<input type="hidden" name="submit" value="true"/>
<p>
当前密码:<input type="password" name="formLogin.name"/>
</p>
<p>
新密码:<input type="password" name="formLogin.password"/>
</p>
<p>
重新输入新密码:<input type="password" name="formLogin.password"/>
</p>
<p>
<input type="submit" value="修改"/>
</p>
</form>
</div>

<div>
<h5>更改头像</h5>
<form action="/login.do" method="post">
<input type="hidden" name="submit" value="true"/>
<p>
<img alt="头像" src="/dl.gif">
</p>
<p>
<input type="file" name="header">
</p>
<p>
<input type="submit" value="更改"/>
</p>
</form>
</div>

<div>
<h5>修改资料</h5>
<form action="/login.do" method="post">
<input type="hidden" name="submit" value="true"/>
<p>
签名:<input type="text" name="formLogin.name"/>
</p>
<p>
地址:<input type="text" name="formLogin.password"/>
</p>
<p>
自我介绍:<<textarea name=""></textarea>
</p>
<p>
<input type="submit" value="更改"/>
</p>
</form>
</div>
