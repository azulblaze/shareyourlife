<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
	.c_h {
		background-color:#b694d1;
		font-weight:bold;
	}
</style>

<div class="div_panel">
	
	<div class="c_h" >
		你共有未读(<s:property value="item_total_count" />)条信息,
		当前第(<s:property value="page_index" />)页
		-共(<s:property value="page_count" />)页
	</div>
	<div class="c_d">
		<form method="post" action="unreadmsglist.do">
			<select name="formMessages.unreadMsgListPageIndex" >
				<s:iterator status="stat" value="(page_count).{ #this }">
					<option value="<s:property value='#stat.index' />"
						<s:if test="#stat.index == page_index">
							selected="true"
						</s:if>
					><s:property value="#stat.count" /></option>
				</s:iterator>
			</select>
			<input type="submit" value="翻页" />
		</form>
	</div>
	<div>
		<s:iterator value="paged_unread_messages" >
			<div class="c_h">
				<s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/>&nbsp;来自 <s:property value="fromUser" />
			</div>
			<div class="c_d">
				<a href="" ><s:property value="title" /></a>
			</div>
		</s:iterator>
	</div>
</div>