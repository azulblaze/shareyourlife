<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
	.c_b {
		width:300px;
		font-size:12px;
	}
	.c_h {
		background-color:#b694d1;
		font-weight:bold;
	}
</style>

<div class="c_b">
	
	<div class="c_h" >
		此图片评论总数为(<s:property value="paged_comments_total_count" />)条,当前第(<s:property value="page_index+1" />)页-共(<s:property value="page_count" />)页
	</div>
	<div class="c_h">
		评论列表:
	</div>
	<div>
		<s:iterator value="paged_comments">
			  			<div class="c_h">
			  				<s:property value="commentTime" /> <s:property value="account" />
			  			</div>
			  			<div class="c_d">
			  				<s:property value="comment" />
			  			</div>
		</s:iterator>
	</div>
	
</div>