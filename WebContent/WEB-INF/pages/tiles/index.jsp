<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="Keywords" content="茄子网" />
	<meta name="Description" content="茄子网" />
	<link rel="bookmark" href="favicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
	<link type="images/gif" href="/act_favicon.gif" rel="icon"/>
	<title>茄子网 myqizi.com</title>
	<link rel="stylesheet" href="style/main.css" type="text/css"/>
	<link rel="stylesheet" href="css/jquery.validate.css" type="text/css"/>
	<script type="text/javascript" src="scripts/jquery-1.3.2.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="scripts/jquery.cookie.js" charset="utf-8"></script>
	<script type="text/javascript" src="scripts/jquery.validate.pack.js" charset="utf-8"></script>
	<script type="text/javascript" src="scripts/simplegallery.js" charset="utf-8"></script>
	<script type="text/javascript">
	var mygallery=new simpleGallery({
		wrapperid: "gallery",
		dimensions: [480, 320], 
		imagearray: [
			["images/gallery/1.jpg", "", "", ""],
			["images/gallery/2.jpg", "", "", ""],
			["images/gallery/3.jpg", "", "", ""],
			["images/gallery/4.jpg", "", "", ""]
		],
		autoplay: [true, 3000, 2],
		persist: true,
		fadeduration: 500
	});
	</script>
</head>
<body>
<div id="wrap">
	<div id="welcomePage">
	   <div class="binInfo">
			<div class="logo"><a href="/"><img src="images/logo.png" title="茄子网" /></a></div>
			<div class="info">
			  <a href="/"><img src="images/info.gif" title="我们的茄子 我们的微笑" /></a>
			  <a href="reg.do"><img src="images/regBtn.gif" title="加入我们" class="regBtn" /></a>
			</div>
	   </div>
	   <div class="marrowPic" id="gallery"></div>
	   <ul class="content">
		 <li><img src="images/tj01.gif" title="最高效的分享方式" /></li>
		 <li><img src="images/tj02.gif" title="手机版的茄子网" /></li>
		 <li class="recent">
		   <ul>
		    <li>[09/01] 增加了图片浏览次数</li>
			<li>[09/01] 增加了图片浏览次数</li>
			<li>[09/01] 增加了图片浏览次数</li>
			<li>[09/01] 增加了图片浏览次数</li>
		   </ul>
		 </li>
	   </ul>
	   
	</div>	
	<div id="bottomNav">
		<form action="login.do" method="post" id="login_form">
		<input type="hidden" name="sub" value="true"/>
		<ul class="login">
			<li><img src="images/userName.gif" title="用户名" /></li>
			<li><input type="text" name="formLogin.name" id="formLoginName"/></li>
			<li><img src="images/password.gif" title="密码" /></li>
			<li><input type="password" name="formLogin.password" id="formLoginPassword"/></li>
			<li><a href="login.do" id="login"><img src="images/loginBtn.gif" title="登陆" /></a></li>
			<li><a href="reg.do"><img src="images/regBtn2.gif" title="注册吧" /></a></li>
		</ul>		
		</form>
		<form action="index.do" method="post" id="search_form">
		<ul class="search">
			 <li><img src="images/searchTitle.gif" title="搜搜看" /></li>
			 <li><input name="s" type="text" class="default" value="请输入你想要查找的关键词..." id="s_key" /></li>
			 <li><a href="/"><img src="images/searchBtn.gif" title="走一个" id="search" /></a></li>
		</ul>
		</form>
	</div>
	<div class="copyright">
		<a href="http://www.miibeian.gov.cn/">蜀ICP备09028449号</a>  | <a href="#">关于我们</a> | <a href="#">常见问题</a> | <a href="#">服务条款</a> | <a href="#">隐私权政策</a> |  &copy;2009 <a href="/">myqizi.com</a>
	</div>
</div>
<script>
$(document).ready(function(){
	$("#login").bind("click",function(event){
		event.preventDefault();
		$("#login_form").submit();
	});
	$("#search").bind("click",function(event){
		event.preventDefault();
		$("#search_form").submit();
	});
	$('#formLoginPassword').bind('keyup', function(event){
		if(event.keyCode==13){
			$('#login').click();
		}
	});
	$("#login_form").validate({
		rules: {
			"formLogin.name": {
				required: true
			},
			"formLogin.password": {
				required: true,
				minlength: 6
			}
		},
		messages: {
			"formLogin.name": "",
			"formLogin.password":""
		}
	});
	$("#s_key").bind("focus",function(event){
		$("#s_key").removeClass("default");
		$("#s_key").toggleClass("choice");
		if($("#s_key").val()=="请输入你想要查找的关键词..."){
			$("#s_key").val("");
		}
	}).bind("blur",function(event){
		$("#s_key").removeClass("choice");
		$("#s_key").toggleClass("default");
		if($("#s_key").val()==""){
			$("#s_key").val("请输入你想要查找的关键词...");
		}
	});
})
</script>
</body>
</html>