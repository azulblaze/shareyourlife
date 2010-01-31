<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="result.list">
	<div class="post">
          <div class="top"></div>
          <div class="middle">
            <span class="date"><s:property value='day'/><small><s:property value='month'/></small></span>
            <h1><a target="_blank" href="/blog/detail/<s:property value='id'/>.html"><s:property value='title'/></a></h1>
            <p><s:property value='review' escape="false"/></p>
            <span class="button readmore"><a target="_blank" href="/blog/detail/<s:property value='id'/>.html">详细内容</a></span>
          </div>
          <div class="bottom"></div>
        </div><!--/post-->
 </s:iterator>
        <div class="post navigation">
          <div class="top"></div>
          <div class="middle">
          <span class="prevBtn">
          <s:if test="(c_tag==null||c_tag=='')&&(c_category==null||c_category=='')">
          	<s:if test="result.page>1">
            <a href="/blog/<s:property value='result.page-1'/>"></a>上一页
            </s:if>
          </s:if>
          <s:if test="(c_tag!=null&&c_tag!='')">
          	<s:if test="result.page>1">
            <a href="/blog/tag/<s:property value='c_tag'/>/<s:property value='result.page-1'/>"></a>上一页
            </s:if>
          </s:if>
          <s:if test="(c_category!=null&&c_category!='')">
          	<s:if test="result.page>1">
            <a href="/blog/category/<s:property value='c_category'/>/<s:property value='result.page-1'/>"></a>上一页
            </s:if>
          </s:if>
          </span>
          <span class="nextBtn">
          <s:if test="(c_tag==null||c_tag=='')&&(c_category==null||c_category=='')">
          	<s:if test="result.page<result.allpage">
            <a href="/blog/<s:property value='result.page+1'/>"></a>下一页
            </s:if>
          </s:if>
          <s:if test="(c_tag!=null&&c_tag!='')">
          	<s:if test="result.page<result.allpage">
            <a href="/blog/tag/<s:property value='c_tag'/>/<s:property value='result.page+1'/>"></a>下一页
            </s:if>
          </s:if>
          <s:if test="(c_category!=null&&c_category!='')">
          	<s:if test="result.page<result.allpage">
            <a href="/blog/category/<s:property value='c_category'/>/<s:property value='result.page+1'/>"></a>下一页
            </s:if>
          </s:if>
          </span>
          </div>
          <div class="bottom"></div>
        </div>