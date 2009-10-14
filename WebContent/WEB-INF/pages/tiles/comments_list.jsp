<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
		<div id="page_link">
		<s:if test="c_page>=2">
		<a href="load_comment.do?id_picture=<s:property value='id_picture'/>">首页</a>
		<a href="load_comment.do?i_page=<s:property value='c_page-1'/>&id_picture=<s:property value='id_picture'/>">上页</a>
		</s:if>
		|
		<s:if test="c_page>=2">
		<s:bean name="org.apache.struts2.util.Counter" id="start_counter">
			<s:param name="first" value="c_page>4?(c_page-4):1" />  
			<s:param name="last" value="c_page-1" />  
		</s:bean>
		<s:iterator value="#start_counter">  
			 <a href="load_comment.do?i_page=<s:property/>&id_picture=<s:property value='id_picture'/>"><s:property/></a>
		</s:iterator>  
		</s:if>
		<b><s:property value="c_page"/></b>
		<s:if test="c_page<pages">
		<s:bean name="org.apache.struts2.util.Counter" id="end_counter">
			<s:param name="first" value="c_page+1" />  
			<s:param name="last" value="(c_page+4)<pages?(c_page+4):pages" />  
		</s:bean>
		<s:iterator value="#end_counter">  
			 <a href="load_comment.do?i_page=<s:property/>&id_picture=<s:property value='id_picture'/>"><s:property/></a>
		</s:iterator>  
		</s:if>
		|
		<s:if test="pages>=2&&c_page<pages">
		<a href="load_comment.do?i_page=<s:property value='c_page+1'/>&id_picture=<s:property value='id_picture'/>">下页</a>
		<a href="load_comment.do?i_page=<s:property value='pages'/>&id_picture=<s:property value='id_picture'/>">尾页</a>
		</s:if>
		</div>
		<s:iterator value="commentlist" id="comment" status="num">
		   用户<img height="45" with="45" src="<s:property value='picture'/>"/><a href="<s:property value='account'/>"/><s:property value="name"/></a>
		   <div><s:property value="comments.comment"/></div>
		   <br/>
		</s:iterator>
		<div id="page_link">
		<s:if test="c_page>=2">
		<a href="load_comment.do?id_picture=<s:property value='id_picture'/>">首页</a>
		<a href="load_comment.do?i_page=<s:property value='c_page-1'/>&id_picture=<s:property value='id_picture'/>">上页</a>
		</s:if>
		|
		<s:if test="c_page>=2">
		<s:bean name="org.apache.struts2.util.Counter" id="start_counter">
			<s:param name="first" value="c_page>4?(c_page-4):1" />  
			<s:param name="last" value="c_page-1" />  
		</s:bean>
		<s:iterator value="#start_counter">  
			 <a href="load_comment.do?i_page=<s:property/>&id_picture=<s:property value='id_picture'/>"><s:property/></a>
		</s:iterator>  
		</s:if>
		<b><s:property value="c_page"/></b>
		<s:if test="c_page<pages">
		<s:bean name="org.apache.struts2.util.Counter" id="end_counter">
			<s:param name="first" value="c_page+1" />  
			<s:param name="last" value="(c_page+4)<pages?(c_page+4):pages" />  
		</s:bean>
		<s:iterator value="#end_counter">  
			 <a href="load_comment.do?i_page=<s:property/>&id_picture=<s:property value='id_picture'/>"><s:property/></a>
		</s:iterator>  
		</s:if>
		|
		<s:if test="pages>=2&&c_page<pages">
		<a href="load_comment.do?i_page=<s:property value='c_page+1'/>&id_picture=<s:property value='id_picture'/>">下页</a>
		<a href="load_comment.do?i_page=<s:property value='pages'/>&id_picture=<s:property value='id_picture'/>">尾页</a>
		</s:if>
		</div>