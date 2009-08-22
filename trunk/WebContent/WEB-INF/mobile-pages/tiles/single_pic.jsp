<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style>
	.c_h {
		background-color:#b694d1;
		font-weight:bold;
	}
</style>

<div class="div_panel">
		<div class="c_h">
			<img height="16" with="16" src="<s:property value='picture.picture'/>"/>
			<a href="<s:property value='picture.account'/>" >
				<s:property value="picture.name"/>
			</a>&nbsp;<s:date name="picture.picturesParameter.uploadTime" format="yyyy-MM-dd HH:mm:ss"/>
		</div>
	   	<div>
	   		<img src="<s:property value='picture.pictures.thumb'/>" />
	   	</div>
	   	<div class="c_h">
	   		图片说明:
	   	</div>
	   	<div>
	   		<s:property value="picture.picturesParameter.description" />
	   	</div>
	   	<div>
		   <form action="comment.do" method="post">
			   	<input type="hidden" name="formComment.id_pictures" value="<s:property value='picture.pictures.id'/>"/>
			  	<div class="c_h">
			  		最新评论 (<a href="more_comments.do?formMoreComments.pictureId=<s:property value='picture.pictures.id'/>" >更多</a>):
			  	</div>
			  	<div>
			  		<s:iterator value="comments" >
			  			<div class="c_h">
			  				<s:property value="account" /> <s:date name="commentTime" format="yyyy-MM-dd HH:mm:ss"/>
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
	   <div>
			<form action="tag.do" method="posts">
				<input type="hidden" name="formTag.id_pictures" value="<s:property value='picture.pictures.id'/>" />
				<div class="c_h">
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
				<div class="c_h">
					使用新标记
				</div>
		  		<div>
		  			<input type="text" name="formTag.name" />
				</div>
				<div>		  			
		  			<input type="submit" value="标记此图片" />
		  		</div>
		  	</form>
	  </div>
</div>  
