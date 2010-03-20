<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<div><b><s:property value='list_title'/></b></div>
	<s:if test="ugl.size==0">
		您还没有收藏过任何产品.
	</s:if>
	<s:iterator value="ugl.list">
	<div class="good">
		<div class="mytag">标签  <a href="#"><s:property value='tag'/></a>&nbsp;&nbsp;评分：<s:property value='ratting'/></div>
		<a class="pic" href="/sns/goods_detail.zl?goods_id=<s:property value='goods_id'/>"><img src="<s:property value='goods_pic'/>"/></a>
		<div class="middle">
			<div><a href="/sns/goods_detail.zl?goods_id=<s:property value='goods_id'/>"><h4><s:property value='goods_topic'/></h4></a></div>
			<div>查看产品详细信息：<a target="_blank" href="<s:property value='source'/>"><s:property value='source_domain'/></a></div>
			<div><a href=""><s:property value='track_count'/></a> 个人收藏&nbsp;&nbsp;<a href="">分享</a>&nbsp;&nbsp;<a href="">评论(<s:property value='comment_count'/>)</a></div>
		</div>
		<div class="right"><s:if test="istrack==0"><a href="#">收藏物品</a></s:if><s:if test="istrack>0"><a href="#">取消收藏</a></s:if></div>
     </div>
     </s:iterator>