<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
	.c_h {
		background-color:#b694d1;
		font-weight:bold;
	}
</style>

<div class="div_panel">
	<div class="c_d">
		发&nbsp;送&nbsp;者:&nbsp;<s:property value="msg.fromUser" />
	</div>
	<div class="c_d">
		发送时间:&nbsp;<s:date name="msg.createTime" format="yyyy-MM-dd HH:mm:ss"/>
	</div>
	<div class="c_d">
		标&nbsp;&nbsp;&nbsp;&nbsp;题:&nbsp;<s:property value="msg.title" />
	</div>	
	<div class="c_d">
		内&nbsp;&nbsp;&nbsp;&nbsp;容:<br />
		<s:property value="msg.content" />
	</div>
	<div class="c_d">
		---------------------------------------
	</div>
	<div class="c_d">
		<a href="">回复</a>&nbsp;
		<a href="">删除</a>
	</div>
</div>