<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="div_panel">

	<div class="div_panel" >
		<span style="font-weight:bold; color: #036; text-decoration: none; border-bottom: 1px solid #666;"><s:property value="msg.fromUser" /></span>
	</div>
	<div class="div_panel">
		<s:date name="msg.createTime" format="yyyy/MM/dd HH:mm"/>
	</div>
	<div class="div_panel">
		<s:property value="msg.title" />
	</div>

	<div class="div_panel" style="height:200px;">
		<s:property value="msg.content" escape="false"/>
	</div>

	<div style="padding:4px 2px;">
		<s:if test="urlBack != null ">
			<a href="<s:property value='urlBack' />"><input type="button" value="返 回" /></a>&nbsp;
		</s:if>
		<a href="msgsend.do?a=reply&amp;msgid=<s:property value='msg.id' />"><input type="button" value="回 复" /></a>&nbsp;
		<a href="delete_msgs.do?formMessages.selectedMessageID=<s:property value='msg.id' />"><input type="button" value="删 除" /></a>
	</div>
</div>