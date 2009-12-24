<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="/scripts/jquery.upload.js" charset="utf-8"></script>
<script>
$(document).ready(function(){
	$("#addform").uploadAjax();
})
</script>
	<div id="content">
		<form action="/admin/add_program.zl" method="post">
		<div class="line firstline">
			<div class="input"><div class="label">全称:</div><input type="text" value="" class="w200"/></div>
    		<div class="notice"><em>(必填*)</em>商家的完整名称。</div>
		</div>
        <div class="line">
			<div class="input"><div class="label">简称:</div><input type="text" value="" class="w200"/></div>
    		<div class="notice"><em>(必填*)</em>商家的名称缩写。</div>
        </div>
        <div class="line">
    		<div class="input"><div class="label">官方网址:</div><input type="text" value="" class="w350"/></div>
    		<div class="notice">商家的官方网址，如果没有留空。</div>
        </div>
        <div class="line">
    		<div class="input"><div class="label">E-mail:</div><input type="text" value="" class="w200"/></div>
    		<div class="notice"><em>(必填*)</em>商家的电子邮箱</div>
        </div>
        <div class="line">
    		<div class="input"><div class="label">LOGO</div><input type="file" value="" class="w350"/></div>
    		<div class="notice">商家的标志图片(LOGO)</div>
        </div>
        <div class="line">
      	<div class="input">
      		<div class="label">商家基本信息</div>
      			<div class="spec"><em>(必填*)</em>商家的基本信息介绍，详细的联系方式最好包含在其中。</div>
            </div>
            <div class="news_content"><textarea name="dnews.newsContent" id="news_content"></textarea></div>
        </div>
        <div class="line">
      		<div class="error_info"><s:property value="error"/></div>
		</div>
		<div class="big_sbumit">
			<input type="submit" value="确认增加" />
		</div>
		</form>
    </div>