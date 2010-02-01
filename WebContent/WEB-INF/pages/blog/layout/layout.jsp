<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="Keywords" content="<s:property value='cust_title'/> 这啦折啦  打折 折扣 购物卷  最新折扣  免费 优惠 卷 卡 赠送 礼 卷 卡  折" />
	<meta name="Description" content="<s:property value='cust_title'/> 这啦折啦 博客 官方博客 为您提供最新的打折优惠信息,还有更多购物卡 记分卡分享" />
	<link href="/blog/rss" title="RSS 2.0" type="application/rss+xml" rel="alternate" />
	<link rel="bookmark" href="favicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
	<link type="images/gif" href="/act_favicon.gif" rel="icon"/>
	<title><s:property value='cust_title'/><tiles:insertAttribute name="title"/> - 这啦折啦官方博客</title>
	<link rel="stylesheet" type="text/css" href="/blog/styles/index.css" media="all">
	<script type="text/javascript" src="/scripts/jquery-1.3.2.min.js" charset="utf-8"></script>
</head>
<body>
<div class="wrapper">
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<div class="content">
		<tiles:insertAttribute name="right"></tiles:insertAttribute>
		<tiles:insertAttribute name="left"></tiles:insertAttribute>
	</div>
</div>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</body>
</html>