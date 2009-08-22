<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="scripts/jquery.autocomplete.pack.js" charset="utf-8"></script>
<link href="css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />
用户<img height="45" with="45" src="<s:property value='picture.picture'/>"/><a href="<s:property value='picture.account'/>"/><s:property value="picture.name"/></a>
   <div><img src="<s:property value='picture.pictures.thumb'/>"/></div>
   <div>
   	总共评论条数:<span id="count_num"><s:property value="comments_count"/></span>
   	<br/>
   	<div id="comment">
   		
   	</div>
   </div>
   <form action="/comment.do" method="post">
   <input type="hidden" name="formComment.id_pictures" value="<s:property value='picture.pictures.id'/>"/>
   评论<textarea name="formComment.comment"></textarea>
   <input type="submit" value="提交"/>
   </form>
   <div>
   	
   </div>
  标记<form action="/tag.do" method="post">
  <input type="hidden" name="formTag.id_pictures" value="<s:property value='picture.pictures.id'/>"/>
  <input type="text" name="formTag.name" id="tagname">
  <input type="submit" value="提交"/>
  </form>
<script>
function clicklink(){
	$("#page_link a").each(function(){
		$(this).bind("click",function(event){
			event.preventDefault();
			loadComments($(this).attr("href"));
		})
	});
}
function loadComments(url){
	$.ajax({
		type:"POST",
		url:url,
		cache:false,
		success:function(data,textStatus){
			if(textStatus == 'success'){
				$("#comment").empty(); 
				$("#comment").append(data);
				clicklink();
			}
		}
	});
}
$(document).ready(function(){
	$("#tagname").autocomplete("load_similar_tag.do",{delay:10,matchContains:true,autoFill:true,multiple:true,multipleSeparator:","});
	if($("#count_num").html()>0){
		loadComments("load_comment.do?id_picture=<s:property value='picture.pictures.id'/>");
	}
});
</script>