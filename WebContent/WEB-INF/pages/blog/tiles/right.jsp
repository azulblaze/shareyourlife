<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<div class="sidebar">
          <div class="top"></div>
          <div class="middle">
            <h4 class="green">博文分类</h4>
            <ul>
              <s:iterator value="categorys" id="item">
              <li<s:if test='c_category!=null&&c_category==#item'> class="select"</s:if>><a href="/blog/category/<s:property value='item'/>/"><s:property value="item"/></a></li>
              </s:iterator>
            </ul>
          </div>
          <div class="bottom"></div>
          
          <div class="top"></div>
          <div class="middle">
            <h4 class="blue">热门标签</h4>
            <ul class="tags">
            	<s:iterator value="tags" id="item"><a <s:if test='c_tag!=null&&c_tag==#item.name'> class="select"</s:if> href="/blog/tag/<s:property value='name'/>/"><s:property value='name'/>(<s:property value='count'/>)</a></s:iterator>
            </ul>
          </div>
          <div class="bottom"></div>
        </div>