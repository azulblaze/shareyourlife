<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="/scripts/ajaxfileupload.js" charset="utf-8"></script>
<script type="text/javascript" src="/scripts/jquery.validate.pack.js" charset="utf-8"></script>
<script>
function init(){
	$("input[name='pi.name']").val("");
	$("input[name='pi.short_name']").val("");
	$("input[name='pi.website']").val("");
	$("input[name='pi.email']").val("");
	$("textarea[name='pi.description']").val("");
	$("#fileToUpload").val("");
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
			url:'/admin/add_program.zl',
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
	$("#_submit").validate({
		submitHandler: function(form) {
			var json={};
			json.name = $("input[name='pi.name']").val();
			json.short_name = $("input[name='pi.short_name']").val();
			json.website = $("input[name='pi.website']").val();
			json.email = $("input[name='pi.email']").val();
			json.description = $("textarea[name='pi.description']").val();
			var pre = "pi.";
			ajaxFileUpload(json,"pi.");
			return false;
		},
		errorElement: "div",
		rules: {
			"pi.name": {
				required: true,
				maxlength:20
			},
			"pi.short_name": {
				required: true,
				maxlength:20
			},
			"pi.email": {
				required: true,
				email: true
			},
			"pi.description": {
				required: true
			}
		},
		messages: {
			"pi.name": {
				required: "",
				maxlength:"全称不能超过20个字。"
			},
			"pi.short_name": {
				required: "",
				maxlength:"全称不能超过20个字。"
			},
			"pi.email": {
				required: "",
				email: "您的E-mail格式不正确。"
			},
			"pi.description": {
				required: ""
			}
		}
	});
});
</script>
	<div id="content">
		<form action="/admin/add_program.zl" method="post" enctype="multipart/form-data" id="_submit">
		<div class="line firstline">
			<div class="input"><div class="label">全称:</div><input type="text" name="pi.name" value="" class="w200"/></div>
    		<div class="notice"><em>(必填*)</em>商家的完整名称。</div>
		</div>
        <div class="line">
			<div class="input"><div class="label">简称:</div><input type="text" name="pi.short_name" value="" class="w200"/></div>
    		<div class="notice"><em>(必填*)</em>商家的名称缩写。</div>
        </div>
        <div class="line">
    		<div class="input"><div class="label">官方网址:</div><input type="text" value="" name="pi.website" class="w350"/></div>
    		<div class="notice">商家的官方网址，如果没有留空。</div>
        </div>
        <div class="line">
    		<div class="input"><div class="label">E-mail:</div><input type="text" value="" name="pi.email" class="w200"/></div>
    		<div class="notice"><em>(必填*)</em>商家的电子邮箱</div>
        </div>
        <div class="line">
    		<div class="input"><div class="label">LOGO</div><input id="fileToUpload" name="pic" type="file" value="" class="w350"/></div>
    		<div class="notice">商家的标志图片(LOGO)</div>
        </div>
        <div class="line">
      	<div class="input">
      		<div class="label">商家基本信息</div>
      			<div class="spec"><em>(必填*)</em>商家的基本信息介绍，详细的联系方式最好包含在其中。</div>
            </div>
            <div class="news_content"><textarea name="pi.description"></textarea></div>
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