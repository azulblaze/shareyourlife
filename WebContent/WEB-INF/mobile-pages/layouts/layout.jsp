<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" 
    "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<style>
			body {
				font-size:12px;
			}
			body textarea{
				font-size:12px;
			}
			.div_panel{
				border-bottom: 1px solid #DDDDDD;
				padding:4px 2px
			}
			.div_panel_header{
				border-bottom: 1px solid #DDDDDD;
				padding:4px 2px;
				color: #a012b4;
			}
		</style>	
	</head>
	<body>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</body>
</html>