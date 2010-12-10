<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论组件-使用状态</title>
<link rel="stylesheet" type="text/css" href="/css/view.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/cssmenuvertical.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/table.css" media="all">
<script type="text/javascript" src="/js/view.js"></script>

</head>
<body id="main_body" >
	
	<img id="top" src="/images/top.png" alt="">
	<div id="form_container">
	
		<h1 class="logo"><a href="http://zhelazhela.com">zhelazhela.com</a></h1>
		<div class="appnitro">
		<div class="form_description">
			<jsp:include page="/WEB-INF/pages/common/navmenu.jsp" flush="true"/>
			<p style="margin-top:10px;"><a href="#">评论组件</a>-><a href="#">使用状态</a></p>
		</div>
		<p>
			<img style="float:left;width:67px;" src="/images/default_header.png"/>
			<div style="float:left;margin-left:10px;">
			<Strong>帐号: </strong>testuser<br/>
			<Strong>名字: </strong>testuser<br/>
			<Strong>邮箱: </strong>testuser<br/>
			<Strong>注册日期: </strong>testuser
			</div>
			<p style="clear:both;margin-bottom:20px;"></p>
		</p>
		<table id="rounded-corner" summary="2007 Major IT Companies' Profit">
			<thead>
				<tr>
					<th scope="col" class="rounded-company">服务名称</th>
					<th scope="col" class="rounded-q1">状态</th>
					<th scope="col" class="rounded-q2">信息</th>
					<th scope="col" class="rounded-q4">操作</th>
				</tr>
			</thead>
				<tfoot>
				<tr>
					<td colspan="3" class="rounded-foot-left"><em>这里显示了你使用过的服务以及当前状态。</em></td>
					<td class="rounded-foot-right">&nbsp;</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td>Microsoft</td>
					<td>20.3</td>
					<td>30.5</td>
					<td>23.5</td>
				</tr>
				<tr>
					<td>Google</td>
					<td>50.2</td>
					<td>40.63</td>
					<td>45.23</td>
				</tr>
				<tr>
					<td>Apple</td>
					<td>25.4</td>
					<td>30.2</td>
					<td>33.3</td>
				</tr>
				<tr>
					<td>IBM</td>
					<td>20.4</td>
					<td>15.6</td>
					<td>22.3</td>
				</tr>
			</tbody>
		</table>
		</div>	
		<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	<img id="bottom" src="/images/bottom.png" alt="">
	</body>
</html>