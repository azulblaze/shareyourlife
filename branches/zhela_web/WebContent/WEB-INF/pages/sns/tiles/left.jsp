<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="#session.user.id == userinfo.id">
<jsp:include page="my_left.jsp"></jsp:include>
</s:if>
<s:if test="#session.user.id != userinfo.id">
<jsp:include page="dest_left.jsp"></jsp:include>
</s:if>