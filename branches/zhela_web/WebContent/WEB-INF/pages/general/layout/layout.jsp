<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="bookmark" href="favicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
	<link type="images/gif" href="/act_favicon.gif" rel="icon"/>
	<title><tiles:insertAttribute name="title"/> - 这啦折啦后台管理</title>
	<link rel="stylesheet" href="style/base.css" type="text/css"/>
	<link rel="stylesheet" href="style/admin.css" type="text/css"/>
	<script type="text/javascript" src="scripts/jquery-1.3.2.min.js" charset="utf-8"></script>
</head>
<body>
<div id="wrap">
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<tiles:insertAttribute name="body"></tiles:insertAttribute>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>
</html>