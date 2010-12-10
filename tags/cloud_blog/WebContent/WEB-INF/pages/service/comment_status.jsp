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
<script type="text/javascript" src="/js/jquery.js"></script>
<script>
function loadCount(code,obj){
	$.ajax({
		type : "GET",
		dataType:"json",
		cache : false,
		url: "/web/service/comment/loadcount.do?code="+code,
		success: function(data){
			if(data.result=="login"){
				window.location.href="/web/user/signin.do";
			}
			if(data.result=="fail"){
				$(obj).html("0");
			}
			if(data.result=="success"){
				$(obj).html(data.data);
			}
      }});
}
function updateStatus(obj,code,status,str,dobj){
	$.ajax({
		type : "GET",
		dataType:"json",
		cache : false,
		url: "/web/service/comment/updateservice.do?code="+code+"&status="+status,
		success: function(data){
			if(data.result=="login"){
				window.location.href="/web/user/signin.do";
			}
			if(data.result=="fail"){
				$(obj).html("发生错误");
			}
			if(data.result=="success"){
				$(obj).html(str);
				if(str=="开启"){
					$("#code_"+code).attr("disabled","disabled");
					$(dobj).html("已停止");
				}else{
					$("#code_"+code).attr("disabled","");
					$(dobj).html("已开启");
				}
			}
      }});
}
function deleteService(obj,code){
	$.ajax({
		type : "GET",
		dataType:"json",
		cache : false,
		url: "/web/service/comment/deleteservice.do?code="+code,
		success: function(data){
			if(data.result=="login"){
				window.location.href="/web/user/signin.do";
			}
			if(data.result="fail"){
				$(obj).html("发生错误");
			}
			if(data.result="success"){
				$("#"+code).remove();
			}
      }});
}
$(document).ready(function(){
	var i_tr = 0;
	$("#list tr").each(function(){
		if(i_tr==0){
			var code = $(this).attr("id");
			var tds = $(this).find("td");
			loadCount(code,tds.eq(3));
			var aes = $(this).find("a");
			aes.eq(0).bind("click",function(event){
				event.preventDefault();
				if($(this).html()=="停止"){
					updateStatus($(this),code,"-1","开启",tds.eq(2));
				}else{
					updateStatus($(this),code,"1","停止",tds.eq(2));
				}
			});
			aes.eq(1).bind("click",function(event){
				event.preventDefault();
				deleteService($(this),code);
			});
			i_tr = 1;
		}else{
			var code_copy = $(this).find("input").val();
			$(this).find("a").bind("click",function(event){
				event.preventDefault();
				if (document.all){                                            //判断Ie
					window.clipboardData.setData('text', code_copy);
					alert("复制成功，直接粘贴到你的网页即可实现评论功能！");
				}else{
					alert("您的浏览器不支持剪贴板操作，请自行复制。");
				}
			});
			i_tr = 0;
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
			<p style="margin-top:10px;"><a href="/web/service/comment/info.do">评论组件</a>-><a href="#">使用状态</a></p>
		</div>
		<table id="rounded-corner" summary="2007 Major IT Companies' Profit">
			<thead>
				<tr>
					<th scope="col" class="rounded-company">服务ID</th>
					<th scope="col" class="rounded-q1">网站地址</th>
					<th scope="col" class="rounded-q1">状态</th>
					<th scope="col" class="rounded-q2">评论条数</th>
					<th scope="col" class="rounded-q4">操作</th>
				</tr>
			</thead>
				<tfoot>
				<tr>
					<td colspan="4" class="rounded-foot-left"><em>你可以直接通过上面的操作来开关评论</em></td>
					<td class="rounded-foot-right">&nbsp;</td>
				</tr>
			</tfoot>
			<tbody id="list">
				<s:iterator value="list">
				<tr id="<s:property value='code'/>">
					<td><s:property value='code'/></td>
					<td><s:property value='parms'/></td>
					<td><s:if test="status==1">使用中</s:if><s:if test="status==-1">已停止</s:if></td>
					<td><s:property value='code'/></td>
					<td><a href="<s:property value='code'/>"><s:if test="status==1">停止</s:if><s:if test="status==-1">开启</s:if></a> <a href="">删除</a></td>
				</tr>
				<tr>
					<td colspan="4" style="border-top:none;"><input id="code_<s:property value='code'/>" style="width:440px;"  <s:if test='status==-1'>disabled="disabled"</s:if> type="text" value='&lt;script language="javascript" src="http://zhelazhela.com/zl_js/service/comment/<s:property value='code'/>.js"&gt;&lt;/script&gt;'/></td>
					<td style="border-top:none;"><a href="">复制代码</a></td>
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