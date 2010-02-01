<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<div id="header">
        <div class="logo">
          <a href="/blog"><img src="/blog/images/logo.png" alt=""></a>
        </div>
        
        <div class="navbar">

          <div class="search">
            <form action="http://www.inspira.me/colordreams/style1/blog.html">
              <p><input onclick="this.value=''" name="s" value="搜索" maxlength="255" type="text"></p>
            </form>
          </div>
        
          <ul>
            <li>
              <a href="/index.html">这啦折啦<span>最新打折信息</span></a>
            </li>
            
            <li<s:if test="nav=='list'"> class="current"</s:if>>
              <a href="/blog">官方博客<span>这啦折啦博客</span></a>
            </li>

            <li>
              <a href="/html/about.html">关于我们<span>关于这啦折啦</span></a>
            </li>

            <li<s:if test="nav=='suggest'"> class="current"</s:if>>
              <a href="/blog/suggest.html">联系我们 <span>提交您的意见</span></a>
            </li>

          </ul>

        </div>
        
      </div>