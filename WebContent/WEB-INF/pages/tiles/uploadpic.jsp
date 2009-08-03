<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<a href="/reg.do">注册</a>
<h5>登录</h5>
<s:actionerror/>
<form action="/upload_pic.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="submit" value="true"/>
<p>
文件:<input type="file" name="pic"/>
</p>
<p>
描述:<input type="text" name="description"/>
</p>
<p>
<input type="submit" value="上传"/>
</p>
</form>
</div>