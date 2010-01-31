<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
			
			<h1><s:property value="comment.size"/> 条评论</h1>
            <s:iterator value="comment">
            <div class="comment">
              <span class="reply"><a href="#">回复</a></span>
              <span class="title"><a href="<s:property value='userIndex'/>"><s:property value='userName'/></a><span class="date">(<s:date name="commentTime" format="yyyy－MM－dd HH:mm:ss" />)</span></span>
            
              <p><s:property value='content'/></p>
            </div>
            </s:iterator>