<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>激活链接已经通过邮件发送到您的邮箱，请激活。</div>
<div><a href="/re_send_mail.do">重新发送</a>激活链接</div>
<div>
更换邮箱接收激活链接
<form action="/re_send_mail.do" method="post">
新邮箱：<input type="text" name="mail">
<input type="submit" value="提交"/>
</form>
</div>

<a href="<s:property value='#session.user.account'/>">激活</a>