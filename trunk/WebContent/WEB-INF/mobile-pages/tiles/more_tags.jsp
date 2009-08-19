<%@ page language="java"
	contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<style>
.c_h {
	background-color: #b694d1;
	font-weight: bold;
}
</style>

<div class="div_panel">
	<div class="c_h">你的标记共有
		(<s:property value="paged_tags_total_count" />)条, 当前第
		(<s:property value="page_index+1" />)页 -共
		(<s:property value="page_count" />)页
	</div>
	<div class="c_h">
		<form method="post" action="more_tags.do">
			<input type="hidden" name="formTag.id_pictures"	value="<s:property value='picture_id' />" />
		 	你所拥有的标记列表:&nbsp; 
			<select name="formTag.pageIndex">
				<s:iterator status="stat" value="(page_count).{ #this }">
					<option value="<s:property value='#stat.index' />"
						<s:if test="#stat.index == page_index">
										selected="true"
						</s:if>
					>
						<s:property	value="#stat.count" />
					</option>
				</s:iterator>
			</select> 
			<input type="submit" value="翻页" />
		</form>
	</div>

	<!-- tags list start here -->
	<div>
		<form action="tag.do" method="posts">
			<input type="hidden" name="formTag.id_pictures" value="<s:property value='picture_id'/>" />
			<table>
			<s:iterator value="paged_tags" status="status">
				<s:if test="(#status.index%3 == 0 ) || #status.first">
					<tr>
				</s:if>
						<td>
							<input type="radio" name="formTag.selectedTagId" value="<s:property value='id' />" />
							<a href="tags_detail.do?formTag.id_tag=<s:property value='id' />" >
								<s:property value="name" />(<s:property value="pictureCount" />)
							</a>
						</td>
				<s:if test="(#status.index%3 == 2) || #status.last" >
					</tr>
				</s:if>	
				<s:else>
					&nbsp;|&nbsp;
				</s:else>
			</s:iterator>
			</table>
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
	<!-- tags list end here -->
</div>