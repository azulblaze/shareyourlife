<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="/scripts/xheditor-zh-cn.js"></script>
<script type="text/javascript" src="/scripts/ajaxfileupload.js" charset="utf-8"></script>
<script type="text/javascript" src="/scripts/jquery.validate.pack.js" charset="utf-8"></script>
<script>
$(document).ready(function(){
	$('#blog_review').xheditor(true);
	$('#blog_content').xheditor(true);
	$("#_submit").validate({
		errorElement: "em",
		rules: {
			"blogDetail.title": {
				required: true,
				maxlength:50
			},
			"blogDetail.category": {
				required: true,
				maxlength:20
			},
			"blogDetail.review": {
				required: true
			},
			"blogDetail.content": {
				required: true
			}
		},
		messages: {
			"blogDetail.title": {
				required: "请填写标题",
				maxlength:"标题长度小于50个字"
			},
			"blogDetail.category": {
				required: "请填写类别",
				maxlength:"类别长度小于20个字"
			},
			"blogDetail.review": {
				required: "",
			},
			"blogDetail.content": {
				required: ""
			}
		}
	});
});
</script>
	<div id="content">
		<form action="/admin/add_blog.zl" method="post" id="_submit">
		<div class="line firstline">
			<div class="input"><div class="label">标题:</div><input type="text" name="blogDetail.title" value="<s:property value='blog.title'/>" class="w200"/></div>
    		<div class="notice"><em>(必填*)</em>博客标题</div>
		</div>
        <div class="line">
    		<div class="input"><div class="label">类别:</div><input type="text" value="<s:property value='blog.category'/>" name="blogDetail.category" class="w350"/></div>
    		<div class="notice"><em>(必填*)</em>博文的类别，很重要，因为可以通过类别来浏览TagStr</div>
        </div>
        <div class="line">
    		<div class="input"><div class="label">关键字:</div><input type="text" value="<s:property value='tag'/>" name="tag" class="w350"/></div>
    		<div class="notice">推荐填写，请使用英文的逗号［,］来分隔多个关键字</div>
        </div>
        <div class="line" style="clear:both;">
	      	<div class="input">
	      		<div class="label">预览内容</div>
	      		<div class="spec"><em>(必填*)</em>预览内容将用来显示在列表页面,最好有张图片效果比较好。</div>
	        </div>
	        <div class="news_content"><textarea id="blog_review" name="blogDetail.review" style="width:480px;"><s:property value='blog.review'/></textarea></div>
        </div>
        <div class="line" style="clear:both;">
	        <div class="input">
	      		<div class="label">详细内容</div>
	      		<div class="spec"><em>(必填*)</em>详细内容就是博客的详细页面看到的信息</div>
	        </div>
	        <div class="news_content"><textarea id="blog_content" name="blogDetail.content" style="width:480px;height:300px;"><s:property value='blog.content'/></textarea></div>
	    </div>
        <div class="line" id="sub_msg_div" style="clear:both;">
      		
		</div>
		<div class="big_sbumit" style="clear:both;">
			<input id="s_button" type="submit" value="确认发表"/>
		</div>
		<div class="clear"></div>
		</form>
    </div>