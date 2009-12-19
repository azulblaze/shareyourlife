<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="Keywords" content="茄子网" />
	<meta name="Description" content="茄子网" />
	<link rel="bookmark" href="favicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
	<link type="images/gif" href="/act_favicon.gif" rel="icon"/>
	<title><tiles:insertAttribute name="title"/></title>
	<link href="style/main.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="scripts/jquery-1.3.2.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="scripts/jquery.cookie.js" charset="utf-8"></script>
</head>
<body id="login">
<div id="wrap">
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<tiles:insertAttribute name="body"></tiles:insertAttribute>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>
</html>