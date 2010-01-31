<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="/scripts/ajaxfileupload.js" charset="utf-8"></script>
<script>
function bindDelete(select){
	$(select).each(function(){
		$(this).bind("click",function(event){
			event.preventDefault();
			var tr_obj = $(this).parent().parent("tr");
			$.ajax({
				type : "GET",
				url : $(this).attr("href"),
				dataType:"json",
				cache : false,
				success : function(data, textStatus) {
					if(data.result=="login"){
						redirectAdminLogin();
					}
					if(data.result=="success"){
						$(tr_obj).remove();
					}
				}
			});
		})
	})
}
function bindIMGOPEN(){
	$("td img").each(function(){
		openimg($(this),$(this).attr("src"));
	});
}
function init(){
	$("#fileToUpload").val("");
}
function openimg(obj,src){
	$(obj).bind("click",function(event){
		window.open(src, "_blank", "height=350,width=600"); 
	});
}
function createline(data){
	var obj = $('<tr><td><a href="#">'+data.id+'</a></td><td>'+data.relTable+'</td><td>'+data.fileName+'</td><td><img alt="LOGO" height="50" width="200" src="'+data.fileName+'" /></td><td>暂缺</td><td><a href="/admin/del_blogpic.zl?id='+data.id+'"  class="del">删除</a></td></tr>');
	var alink = $(obj).find("img");
	var del_link = $(obj).find(".del");
	bindDelete(del_link);
	openimg(alink,$(alink).attr("src"));
	$("#pic_list").prepend(obj);
}
function ajaxFileUpload(_json,_pre)
{
	$("#loading").ajaxStart(function(){
		$("#s_button").attr("disabled","disabled");
		$(this).show();
		$("#sub_msg_div").empty();
	}).ajaxComplete(function(){
		init();
		$("#s_button").removeAttr("disabled");
		$(this).hide();
	});
	$.ajaxFileUpload
	(
		{
			url:'/admin/upload_blogpic.zl',
			name_value:_json,
			pre:_pre,
			secureuri:false,
			fileElementId:'fileToUpload',
			dataType: 'json',
			success: function (data, status)
			{
				if(data.result=="login"){
					redirectAdminLogin();
				}
				if(data.result=="success"){
					createline(data.pic);
					showSuccess("#sub_msg_div",data.msg);
				}
				if(data.result=="fail"){
					showError("#sub_msg_div",data.msg);
				}
			},
			error: function (data, status, e)
			{
				alert(e);
			}
		}
	)
	return false;
}
$(document).ready(function(){
	var size = <s:property value="result.size"/>;
	var pagesize = <s:property value="result.pagesize"/>;
	var c_page = Math.ceil(size/pagesize);
	writePage(c_page,<s:property value="result.page"/>,"#page_bar","/admin/blogpic_list.zl?page=");
	$("#s_button").bind("click",function(event){
		event.preventDefault();
		if($("#fileToUpload").val()!=""){
			var json={};
			json.name="go";
			ajaxFileUpload(json,"");
		}else{
			alert("请选择你要上传的图片");
		}
	});
	bindDelete(".del");
	bindIMGOPEN();
})
</script>
		<div id="content">
			<form action="/admin/upload_blogpic.zl" method="post" enctype="multipart/form-data" id="_submit">
			<div class="line">
	    		<div class="input"><div class="label">附件</div><input id="fileToUpload" name="pic" type="file" value="" class="w350"/></div>
	    		<div class="notice">选择你要上传的附件</div>
	        </div>
	        <div class="line" id="sub_msg_div">
	      		
			</div>
			<div class="line">
	      		<div class="notice"><img id="loading" src="/images/loading.gif" style="display:none;"/></div>
			</div>
			<div class="big_sbumit">
				<input id="s_button" type="submit" value="确认增加"/>
			</div>
			</form>
		</div>
    	<div class="result">
        	<table class="list" width="100%">
			<thead>
				<tr>
					<th scope="col">编号</th>
					<th scope="col">相关表名</th>
					<th scope="col">地址</th>
					<th scope="col">图片</th>
					<th scope="col">添加日期</th>
					<th scope="col">操作</th>
				</tr>
			</thead>	
			<tfoot>
				<tr>
					<th scope="row">统计</th>
					<td colspan="8" id="page_bar"><s:property value="result.size"/>条 </td>
				</tr>
			</tfoot>
			<tbody id="pic_list">
				<s:iterator value="result.list">
				<tr>
					<td><a href="#"><s:property value="id"/></a></td>
					<td><s:property value='relTable'/></td>
					<td><s:property value='fileName'/></td>
					<td><img alt="LOGO" height="50" width="200" src="<s:property value='fileName'/>" /></td>
					<td><s:date name='updateTime'/></td>
					<td><a href="/admin/del_blogpic.zl?id=<s:property value='id'/>"  class="del">删除</a></td>
				</tr>
				</s:iterator>
             </tbody>
        </table>
        </div>