<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
	.div_panel {
		width:300px;
		font-size:12px;
	}
	.img_user_logo{
		width:16px;
	}
	
</style>


<!-- start: 用户信息 -->
<div class="div_panel">
	欢迎您, solzhang <br />
	系统信息(<a href="">共18条</a> , <a href="">未读5条</a>)<br />
	茄友信息(<a href="">共18条</a> , <a href="">未读0条</a>)
</div>
<div> ----------------------- </div>
<!-- end: 用户信息-->

<!-- start: 当前最新相片 -->
<div class="div_panel">
	<div class="div_title">
		# 当前最新相片 (共<strong>5</strong>页,当前是<strong>1</strong>页)
	</div>
	<div>
		<s:iterator value="pictures" id="picture" status="num">
			<div>
				<table>
					<tr>
						<td valign="top" >
							<a href="picture.do?id_picture=<s:property value='pictures.id'/>" >
								<img src="<s:property value='pictures.min'/>"/>
							</a>					
						</td>
						<td valign="top" >
						 	<div>
						 		茄友:&nbsp;
							 	<img class="img_user_logo" height="45" with="45" src="<s:property value='picture'/>"/>
							 	<a href="<s:property value='account'/>" >
							 		<s:property value="name"/>
							 	</a>
						 	</div>
						 	<div>
						 		 上传时间:&nbsp;<br />
						 		 <s:date name="picturesParameter.uploadTime" format="yyyy-MM-dd HH:mm:ss" />
						 	</div>
						 	<div>
						 		我想要:<br />
						 		<a href="">加好友</a> <a href="">评论</a> <a href="">标签</a>
						 	</div>
						 						
						</td>
					</tr>
				</table>
			</div>			 
		</s:iterator>
	</div>

	<div>
		<a href="" >第一页</a>|
		<a href="" >上一页</a>|
		<a href="" >下一页</a>|
		<a href="">最后一页</a>
	</div>
</div>
<div> ----------------------- </div>

<!-- start: 当前热门标签 -->
<div class="div_panel">
	<div class="div_title">
		# 当前热门标签 (共<strong>5</strong>页,当前是<strong>1</strong>页)
	</div>
	<div>
		朋友 | 聚会 | 同事 | 周末 <br />
		吃饭 | 电影 | 河蟹 | 新闻
	</div>
	<div>
		<a href="" >第一页</a>|
		<a href="" >上一页</a>|
		<a href="" >下一页</a>|
		<a href="">最后一页</a>
	</div>
</div>
<!-- end: 当前热门标签 -->

<!-- end: 当前最新相片 -->

