<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="pictures" id="picture" status="num">
	<div>
		<small>
			 用户
			<img height="45" with="45" src="<s:property value='picture'/>"/><a href="<s:property value='account'/>" ><s:property value="name"/></a>
			<div>
				<a href="picture.do?id_picture=<s:property value='pictures.id'/>" >
					<img src="<s:property value='pictures.min'/>"/>
				</a>
			</div>
		</small>
	</div>
</s:iterator>