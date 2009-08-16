<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
	.c_b {
		width:300px;
		font-size:12px;
	}
	.c_h {
		background-color:#b694d1;
		font-weight:bold;
	}
</style>

<div class="c_b">
	
	<div class="c_h" >
		此图片评论(<s:property value="paged_comments_total_count" />)条,
		当前第(<s:property value="page_index+1" />)页
		-共(<s:property value="page_count" />)页
	</div>
	<div class="c_h">
		<form method="post" action="more_comments.do">
			<input type="hidden" name="formMoreComments.pictureId" value="<s:property value='picture_id' />" />
			评论列表:&nbsp;
			<select name="formMoreComments.pageIndex" >
				<s:iterator status="stat" value="(page_count).{ #this }">
					<option value="<s:property value='#stat.index' />"
						<s:if test="#stat.index == page_index">
							selected="true"
						</s:if>
					><s:property value="#stat.count" /></option>
				</s:iterator>
			</select>
			<input type="submit" value="翻页" />
		</form>
	</div>
	
		   <form action="comment.do" method="post">
			   	<input type="hidden" name="formComment.id_pictures" value="<s:property value='picture_id'/>"/>
			  	<div>
			  		<s:iterator value="paged_comments" >
			  			<div class="c_h">
			  				<s:date name="commentTime" format="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;<s:property value="account" />
			  			</div>
			  			<div class="c_d">
			  				<s:property value="comment" />
			  			</div>
			  		</s:iterator>
			  	</div>
			  	<div class="c_h">
			  		添加评论:
			  	</div>
			  	<div>
			  		<textarea name="formComment.comment"></textarea>
				</div>
				<div>			  		
			   		<input type="submit" value="提交"/>
			   	</div>
		   </form>	
	
</div>