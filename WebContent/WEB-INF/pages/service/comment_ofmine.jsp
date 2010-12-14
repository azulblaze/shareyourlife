<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论组件-我的评论</title>
<link rel="stylesheet" type="text/css" href="/css/view.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/cssmenuvertical.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/table.css" media="all">
<script type="text/javascript" src="/js/view.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script>
function deleteComment(obj,_id){
	$.ajax({
		type : "GET",
		dataType:"json",
		cache : false,
		url:"/web/service/comment/deletecomment.do?id="+_id,
		success: function(data){
			if(data.result=="login"){
				window.location.href="/web/user/signin.do";
			}
			if(data.result=="fail"){
				$(obj).html("发生错误");
			}
			if(data.result=="success"){
				$("#list_"+_id).remove();
			}
      }});
}
function selectService(){
	$("#select_server").bind("change",function(){
		window.location.href="/web/service/comment/list.do?code="+$(this).val();
	});
}
$(document).ready(function(){
	selectService()
	$("#list a").each(function(){
		var tmpa = $(this);
		$(this).bind("click",function(event){
			event.preventDefault();
			deleteComment(tmpa,tmpa.attr("href"));
		});
	});
});
</script>
</head>
<body id="main_body" >
	
	<img id="top" src="/images/top.png" alt="">
	<div id="form_container">
	
		<h1 class="logo"><a href="http://zhelazhela.com">zhelazhela.com</a></h1>
		<div class="appnitro">
		<div class="form_description">
			<jsp:include page="/WEB-INF/pages/common/navmenu.jsp" flush="true"/>
			<p style="margin-top:10px;"><a href="/web/service/comment/info.do">评论组件</a>-><a href="#">我的评论</a></p>
		</div>
		<table id="rounded-corner" summary="2007 Major IT Companies' Profit">
			<thead>
				<tr>
					<th style="width:100px;" class="rounded-company">地址</th>
					<th style="width:80px;" class="rounded-q1">IP地址</th>
					<th style="width:60px;" class="rounded-q2">用户名</th>
					<th class="rounded-q3">内容</th>
					<th style="width:50px;" class="rounded-q4">操作</th>
				</tr>
			</thead>
				<tfoot>
				<tr>
					<td colspan="5" style="text-align:right;"><s:if test="select!=null"><em>服务ID:<s:property value="select.code"/> 网址:<s:property value="select.parms"/></em></s:if></td>
				</tr>
				<tr>
					<td colspan="3" class="rounded-foot-left">评论服务<select style="width:250px;" id="select_server"><s:if test="select!=null"><option selected="selected" value="<s:property value='select.code'/>"/><s:property value='select.code'/>-<s:property value='select.parms'/></option></s:if><s:iterator value="sbs"><option value="<s:property value='code'/>"/><s:property value='code'/>-<s:property value='parms'/></option></s:iterator></select></td>
					<td colspan="2" class="rounded-foot-right" style="text-align:right;"><em><s:if test="list.lastPage>0"><a href="/web/service/comment/list.do?code=<s:property value='select.code'/>&page=<s:property value='list.lastPage'/>" >上一页</a></s:if><s:if test="list.nextPage>0"><a href="/web/service/comment/list.do?code=<s:property value='select.code'/>&page=<s:property value='list.nextPage'/>" >下一页</a></s:if></em></td>
				</tr>
			</tfoot>
			<tbody id="list">
				<s:iterator value="list.comment">
					<tr id="list_<s:property value="id"/>">
					<td style="width:100px;white-space:normal;word-wrap:break-word;word-break:break-all;overflow:hidden;"><s:property value="web_url"/></td>
					<td><s:property value="ip"/></td>
					<td><s:property value="username"/></td>
					<td><s:property value="content"/></td>
					<td><a href="<s:property value="id"/>">删除</a></td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
		</div>	
		<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	<img id="bottom" src="/images/bottom.png" alt="">
	</body>
</html>