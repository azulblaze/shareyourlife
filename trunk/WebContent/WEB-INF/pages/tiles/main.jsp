<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="style/index.css" rel="stylesheet" type="text/css" />
<div id="mainContent">
	<!-- 最近提交的图片 -->
	<div class="panel" >
		<div class="title">
			最新提交的图片
		</div>
		<div class="panel_content">
			<table width="100%">
				<s:iterator value="pictures" id="picture" status="stat">
					<s:if test="#stat.index%4==0" >
						<tr>
							<td>
					</s:if>
					<s:else>
							<td>
					</s:else>
							  <div class="picbox" >
							  	<div class="pic">
							  		<span></span><em><s:property value="picturesParameter.title" /></em>
								  	<a href="/picture.do?id_picture=<s:property value='pictures.id'/>" title="<s:property value='picturesParameter.title' />"/>
								  		<img src="<s:property value='pictures.large'/>"/>
								  	</a>
							  	</div>
							  	<div class="picinfo">
							  		<s:date name="picturesParameter.uploadTime" format="yyyy年MM月dd日" />
							  	</div>
							  </div>
				  			</td>
				  	<s:if test="#stat.index%4==3 || #stat.last ">
				  		</tr>
				  	</s:if>
				</s:iterator>	
			</table>	
		</div>
	</div>
		
	<!-- 最近提交图片的用户 -->
	<div class="panel" >
		<div class="title" >
			最活跃的茄友
		</div>
		<div class="panel_content">
			<table width="100%">
				<s:iterator value="active_accounts" status="stat">
					<s:if test="#stat.index%6==0" >
						<tr>
							<td>
					</s:if>
					<s:else>
							<td>
					</s:else>
							  <div class="logobox" >
							  	<div class="logo_pic">
								  <img width="70" height="90" src="<s:property value='picture'/>"/>
							  	</div>
							  	<div clss="logo_name">
							  		<s:property value="account" /><br />
							  	</div>
							  </div>
				  			</td>
				  	<s:if test="#stat.index%6==5 || #stat.last">
				  		</tr>
				  	</s:if>
				</s:iterator>	
			</table>				
		</div>
	</div>
	
	<!-- 最近被标记的标签 -->	
	<div class="panel">
		<div class="title">
			最热门的标签
		</div>
		<div class="panel_content">
			<table width="100%">
				<s:iterator value="pop_tags" status="stat">
					<s:if test="#stat.index%6==0" >
						<tr>
							<td>
					</s:if>
					<s:else>
							<td>
					</s:else>
							  	<div clss="logo_name">
							  		<a href="#">
							  			<s:property value="name" /> (<s:property value="pictureCount" />)<br />
							  		</a>
							  	</div>
				  			</td>
				  	<s:if test="#stat.index%6==5 || #stat.last">
				  		</tr>
				  	</s:if>
				</s:iterator>	
			</table>				
		</div>
	</div>	
</div>