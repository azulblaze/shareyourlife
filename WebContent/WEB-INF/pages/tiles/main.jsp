<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>Here are main page</div>
<s:iterator value="pictures" id="picture" status="num">
   用户<img height="45" with="45" src="<s:property value='picture'/>"/><a href="<s:property value='account'/>"/><s:property value="name"/></a>
   <div><img height="100" with="100" src="<s:property value='pictures.min'/>"/></div>
   <br/>
</s:iterator>