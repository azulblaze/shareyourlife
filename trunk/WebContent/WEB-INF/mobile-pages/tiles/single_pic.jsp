<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
	.c_h {
		background-color:#b694d1;
		font-weight:bold;
	}
</style>

<div class="div_panel">
		<div class="div_panel">
			<img height="16" with="16" src="<s:property value='picture.picture'/>"/>
			<a href="<s:property value='picture.account'/>" >
				<s:property value="picture.name"/>
			</a>&nbsp;<s:date name="picture.picturesParameter.uploadTime" format="yyyy-MM-dd HH:mm:ss"/>
		</div>
	   	<div class="div_panel">
	   		<img src="<s:property value='picture.pictures.thumb'/>" />
	   	</div>
	   	<div class="div_panel_header">
	   		图片说明:
	   	</div>
	   	<div class="div_panel">
	   		<s:property value="picture.picturesParameter.description" />
	   	</div>
	   	<div>
		   <form action="comment.do" method="post">
			   	<input type="hidden" name="formComment.id_pictures" value="<s:property value='picture.pictures.id'/>"/>
			  	<div class="div_panel_header">
			  		最新评论 (<a href="more_comments.do?formMoreComments.pictureId=<s:property value='picture.pictures.id'/>" >更多</a>):
			  	</div>
			  	<div>
			  		<s:iterator value="comments" >
			  			<div class="div_panel">
			  				<table width="100%">
			  					<tr>
			  						<td width="60%">
			  							<s:property value="account" />
			  						</td>
			  						<td width="40%" align="right">
			  							<s:date name="commentTime" format="yyyy-MM-dd HH:mm:ss"/>
			  						</td>
			  					</tr>
			  					<tr>
			  						<td colspan="2">
			  							<s:property value="comment" />
			  						</td>
			  					</tr>
			  				</table>
			  			</div>
			  		</s:iterator>
			  	</div>
			  	<div class="div_panel_header">
			  		添加评论:
			  	</div>
			  	<div class="div_panel">
			  		<textarea name="formComment.comment"></textarea>
				</div>
				<div class="div_panel">			  		
			   		<input type="submit" value="提交"/>
					<s:if test="urlBack != null ">
						&nbsp;<a href="<s:property value='urlBack' />"><input type="button" value="返&nbsp;回" /></a>&nbsp;
					</s:if>				   		
			   	</div>
		   </form>
	   </div>
	   <div>
			<form action="tag.do" method="posts">
				<input type="hidden" name="formTag.id_pictures" value="<s:property value='picture.pictures.id'/>" />
				<div class="div_panel_header">
					标记 (<a href="more_tags.do?formTag.id_pictures=<s:property value='picture.pictures.id'/> ">更多</a>):
				</div>
				<s:if test="tags!=null">
				<div>
					<table>
					<s:iterator value="tags" status="status">
						<s:if test="(#status.index%4 == 0 ) || #status.first">
							<tr>
						</s:if>
								<td>
									<input type="radio" name="formTag.selectedTagId" value="<s:property value='id' />" /><s:property value="name" />
								</td>
						<s:if test="(#status.index%4 == 3) || #status.last" >
							</tr>
						</s:if>	
					</s:iterator>
					</table>
				</div>
				</s:if>
				<div class="div_panel">
					使用新标记
				</div>
		  		<div style="padding:4px 2px">
		  			<input type="text" name="formTag.name" />
				</div>
				<div style="padding:4px 2px">		  			
		  			<input type="submit" value="标记此图片" />
					<s:if test="urlBack != null ">
						&nbsp;<a href="<s:property value='urlBack' />"><input type="button" value="返&nbsp;回" /></a>&nbsp;
					</s:if>			  			
		  		</div>
		  	</form>
	  </div>
</div>  
