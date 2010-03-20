<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<div>我关注的用户</div>
	<s:iterator value="firend.list">
	<div class="good">
		<a class="pic" href="/sns/user/<s:property value='id'/>"><img src="<s:property value='header'/>"/></a>
		<div class="middle">
			<div><a href="/sns/user/<s:property value='id'/>"><s:property value='name'/></a></div>
			<div><a href="#"><s:property value='tracks'/></a>个关注 <a href="#"><s:property value='been_tracks'/></a>个追随 <a href=""><s:property value='goods'/></a>个收藏</div>
		</div>
		<div class="right"><s:if test="isfriend<=0"><a href="#">关注他</a></s:if><s:if test="isfriend>0"><a href="#">取消关注</a></s:if></div>
	</div>
	</s:iterator>