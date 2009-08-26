<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
	.c_h {
		background-color:#b694d1;
		font-weight:bold;
	}
</style>

<div class="div_panel">
	<div>
		<hr />	
	</div>
	<div class="c_d" >
		<span style="font-weight:bold; color: #036; text-decoration: none; border-bottom: 1px solid #666;"><s:property value="msg.fromUser" /></span>
	</div>
	<div class="c_d">
		<s:date name="msg.createTime" format="yyyy/MM/dd HH:mm"/>
	</div>
	<div class="c_d">
		<s:property value="msg.title" />
	</div>
	<div>
		<hr />	
	</div>
	<div class="c_d" style="height:200px;">
		<s:property value="msg.content" escape="false"/>
	</div>
	<div class="c_d">
		<hr />
	</div>
	<div class="c_d">
		<s:if test="urlBack != null ">
			<a href="<s:property value='urlBack' />">返回</a>&nbsp;
		</s:if>
		<a href="">回复</a>&nbsp;
		<a href="">删除</a>
	</div>
</div>