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
		url:"/web/service/deletebetterinfo.do?id="+_id,
		success: function(data){
			if(data.result=="login"){
				window.location.href="/web/user/signin.do";
			}
			if(data.result=="fail"){
				$(obj).html("发生错误");
			}
			if(data.result=="success"){
				$("#list_"+_id).remove();
				$("#info_"+_id).remove();
			}
      }});
}
$(document).ready(function(){
	$("#list a").each(function(){
		var tmpa = $(this);
		if(tmpa.attr("id")=="del"){
			$(this).bind("click",function(event){
				event.preventDefault();
				deleteComment(tmpa,tmpa.attr("href"));
			});
		}
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
			<p style="margin-top:10px;"><a href="#">服务管理</a>-><a href="#">改善信息</a></p>
		</div>
		<table id="rounded-corner" summary="2007 Major IT Companies' Profit">
			<thead>
				<tr>
					<th style="width:100px;" class="rounded-company">帐号</th>
					<th style="width:80px;" class="rounded-q1">邮箱</th>
					<th style="width:60px;" class="rounded-q2">服务</th>
					<th class="rounded-q3">类型</th>
					<th style="width:50px;" class="rounded-q4">操作</th>
				</tr>
			</thead>
				<tfoot>
				<tr>
					<td colspan="3" class="rounded-foot-left">&nbsp;</td>
					<td colspan="2" class="rounded-foot-right" style="text-align:right;">&nbsp;</td>
				</tr>
			</tfoot>
			<tbody id="list">
				<s:iterator value="list">
				<tr id="list_<s:property value="id"/>">
					<td style="width:100px;white-space:normal;word-wrap:break-word;word-break:break-all;overflow:hidden;"><s:property value="account"/></td>
					<td><s:property value="eMail"/></td>
					<td><s:property value="serviceName"/></td>
					<td><s:property value="type"/></td>
					<td><a id="del" href="<s:property value="id"/>">删除</a></td>
				</tr>
				<tr id="info_<s:property value="id"/>">
					<td style="border-top:none;"><s:property value="tittle"/></td>
					<td colspan="4" style="border-top:none;"><s:property value="content"/><s:if test="attachment!=null"><a target="_blank" href="<s:property value='attachment'/>">附件</a></s:if></td>
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