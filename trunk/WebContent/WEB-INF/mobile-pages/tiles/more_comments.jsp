<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
	.c_h {
		background-color:#b694d1;
		font-weight:bold;
	}
</style>

<div class="div_panel">
	
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
	<div>
		<hr />
	</div>
		   <form action="comment.do" method="post">
			   	<input type="hidden" name="formComment.id_pictures" value="<s:property value='picture_id'/>"/>
			  	<div>
			  		<table width="100%">
			  		<s:iterator value="paged_comments" >
			  			<tr>
			  				<td width="5%"><input type="checkbox" /></td>
			  				<td width="40%"><s:property value="account" /></td>
			  				<td width="55%" align="right"><s:date name="commentTime" format="yyyy/MM/dd HH:mm"/></td>
			  			</tr>
			  			<tr>
			  				<td>&nbsp;</td>
			  				<td colspan="2" ><s:property value="comment" /></td>
			  			</tr>
			  		</s:iterator>
			  		</table>
			  	</div>
			  	<div class="c_h">
			  		添加评论:
			  	</div>
			  	<div>
			  		<textarea name="formComment.comment"></textarea>
				</div>
				<div>			  		
			   		<input type="submit" value="提交"/>
					<s:if test="urlBack != null ">
						&nbsp;<a href="<s:property value='urlBack' />"><input type="button" value="返&nbsp;回" /></a>&nbsp;
					</s:if>			   		
			   	</div>
		   </form>	
	
</div>