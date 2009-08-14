<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div>
	<small>
		<div>
			用户
			<img height="45" with="45" src="<s:property value='picture.picture'/>"/>
			<a href="<s:property value='picture.account'/>" >
				<s:property value="picture.name"/>
			</a>
		</div>
	   	<div>
	   		<img src="<s:property value='picture.pictures.thumb'/>" />
	   	</div>
	   	<div>
		   <form action="comment.do" method="post">
			   	<input type="hidden" name="formComment.id_pictures" value="<s:property value='picture.pictures.id'/>"/>
			  	评论
			  	<textarea name="formComment.comment"></textarea>
			   	<input type="submit" value="提交"/>
		   </form>
	   </div>
	   <div>
			<form action="tag.do" method="posts">
				标记
		  		<input type="hidden" name="formTag.id_pictures" value="<s:property value='picture.pictures.id'/>" />
		  		<input type="text" name="formTag.name" />
		  		<input type="submit" value="提交" />
		  	</form>
	  </div>
  </small>
</div>  
