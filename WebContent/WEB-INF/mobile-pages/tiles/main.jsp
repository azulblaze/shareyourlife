<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- start: 用户信息, 要求登录用户才能显示 -->
<s:if test="#session.user != null && #session.user.status == 1" >
<div class="div_panel">
	欢迎您, <s:property value="#session.user.name" /> <br />
	你的信息(
	<a href="msglist.do">共<s:property value="h_msgs_count" />条</a> , 
	<a href="unreadmsglist.do">未读<s:property value="h_msgs_unread_count" />条</a>)
	<br />
</div>
</s:if>
<!-- end: 用户信息-->

<!-- start: 当前最新相片 -->
<div>
	<div class="div_panel_header">
		&nbsp;当前最新相片 (当前第<strong><s:property value="h_pictures_pageindex+1" /></strong>页)
	</div>
	<div>
		<s:iterator value="h_pictures_list" id="item_picture" status="num">
			<div class="div_panel">
				<table>
					<tr >
						<td valign="top">
							<a href="picture.do?id_picture=<s:property value='pictures.id'/>" >
								<img src="<s:property value='pictures.min'/>"/>
							</a>					
						</td>
						<td align="right" valign="top">
						 	<div>
							 	<img height="16" with="16" src="<s:property value='picture'/>"/>
							 	<a href="<s:property value='account'/>" >
							 		<s:property value="name"/>
							 	</a>
						 	</div>
						 	<div>
						 		 <s:date name="picturesParameter.uploadTime" format="yyyy/MM/dd HH:mm" />
						 	</div>
						 	<div>
						 		<a href="">加好友</a>&nbsp;
						 		<a href="more_comments.do?formMoreComments.pictureId=<s:property value='pictures.id'/>">评论</a>&nbsp;
						 		<a href="more_tags.do?formTag.id_pictures=<s:property value='pictures.id'/>">标签</a>
						 	</div>
						</td>
					</tr>
				</table>
			</div>			 
		</s:iterator>
	</div>

	<div class="div_panel_header" >
		<a href="index.do" >第一页</a>&nbsp;
		<a href="index.do?formHome.picturesPageIndex=<s:property value='h_pictures_pageindex-1' />" >上一页</a>&nbsp;
		<a href="index.do?formHome.picturesPageIndex=<s:property value='h_pictures_pageindex+1' />" >下一页 ... </a>
	</div>
</div>

<!-- start: 当前热门标签 -->
<div>
	<div class="div_panel_header">
		&nbsp;热门标签 (当前第<strong>1</strong>页)
		&nbsp;<a href="">更多</a>
	</div>
	<div class="div_panel" >
		朋友 | 聚会 | 同事 | 周末 <br />
		吃饭 | 电影 | 河蟹 | 新闻
	</div>
	<div class="div_panel" >
		<a href="" >第一页</a>&nbsp;
		<a href="" >上一页</a>&nbsp;
		<a href="" >下一页</a>
	</div>
</div>
<!-- end: 当前热门标签 -->

<!-- end: 当前最新相片 -->

