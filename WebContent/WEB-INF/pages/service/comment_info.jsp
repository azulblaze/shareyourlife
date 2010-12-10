<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论组件</title>
<link rel="stylesheet" type="text/css" href="/css/view.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/cssmenuvertical.css" media="all">
<script type="text/javascript" src="/js/view.js"></script>

</head>
<body id="main_body" >
	
	<img id="top" src="/images/top.png" alt="">
	<div id="form_container">
	
		<h1 class="logo"><a href="http://zhelazhela.com">zhelazhela.com</a></h1>
		<div class="appnitro">
		<div class="form_description">
			<jsp:include page="/WEB-INF/pages/common/navmenu.jsp" flush="true"/>
			<p style="margin-top:10px;"><a href="/web/user/signup.do">注册</a> | <a href="#">评论组件</a></p>
		</div>
		<p style="line-height:20px;">
			评论组件是一个WEB的评论工具。你需要在你的网页中增加一段代码就可以实现评论功能！<br/>
			例子:<br/>
			将下面一段代码加入到你想发表评论的地方：
			<p class="code">&lt;script language=&quot;javascript&quot; src=&quot;http://zhelazhela.com/zl_js/zl_comment.js&quot;&gt;&lt;/script&gt;</p>
			你就会在你的页面看到下面的效果：<br/>
			<img class="image_view" src="/images/comment_preview.png"/>
			评论框的背景是透明的，所以你可以自己定义背景颜色。评论框的宽度也是自动增长的，所以你可以限制她的宽度：
			<p class="code">&lt;div style=&quot;background-color:green;width:400px;&quot;&gt; &lt;script language=&quot;javascript&quot; src=&quot;http://zhelazhela.com/zl_js/zl_comment.js&quot;&gt;&lt;/script&gt; &lt;/div&gt;</p>
			要使用我们的服务，你必须在执行下面的步骤：<br/>
			<h4>1.注册帐号</h4>
			你必须注册一个帐号，我们才能帮你管理你的评论。注册地址：<a href="/web/user/signup.do">注册</a><br/>
			<h4>2.开通评论服务</h4>
			一旦你完成注册，登录后就可以在<Strong>[服务管理]</strong>下面看到<Strong>[评论组件]</strong>。选择下面的<Strong>[增加评论]</strong>，开通地址：<a href="/web/service/comment/addservice.do">增加评论</a><br/>
			<h4>3.使用代码</h4>
			把系统产生的代码复制到你的网页中，你就可以看到效果了<br/>
			<h4>查看状态</h4>
			登录后，你可以在<Strong>[服务管理->使用状态]</strong>下面查看你开通的评论服务，你可以在这里停止打开服务。<br/>
			你还可以在<Strong>[服务管理->我的评论]</strong>里面管理你网页上的评论内容
			
		</p>
		</div>
		<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	<img id="bottom" src="/images/bottom.png" alt="">
	</body>
</html>