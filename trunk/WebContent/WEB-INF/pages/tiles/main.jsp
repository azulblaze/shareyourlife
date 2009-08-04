<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>Here are main page</div>
<s:iterator value="pictures" id="picture" status="num">
   <div><img src="<s:property value='pictures.min'/>"/></div>
</s:iterator>