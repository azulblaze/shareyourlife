<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐号注册</title>
<link rel="stylesheet" type="text/css" href="/cloudblog/css/view.css" media="all">
<script type="text/javascript" src="/cloudblog/js/view.js"></script>

</head>
<body id="main_body" >
	
	<img id="top" src="images/top.png" alt="">
	<div id="form_container">
	
		<h1 class="logo"><a href="zhelazhela.com">zhelazhela.com</a></h1>
		<form id="form_62643" class="appnitro" enctype="multipart/form-data" method="post" action="">
					<div class="form_description">
			<h2>帐号注册</h2>
			<p>ZHELA需要您注册一个帐号来获得我们的服务。</p>
		</div>						
			<ul >
			
					<li id="li_1" >
		<label class="description" for="element_1">帐号 </label>
		<div>
			<input id="element_1" name="element_1" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		</li>		<li id="li_2" >
		<label class="description" for="element_2">密码 </label>
		<span>
			<input id="element_2_1" name= "element_2_1" type="password" class="element text medium" maxlength="255" size="20" value=""/>
			<label>不得少于6个字符</label>
		</span>
		<span>
			<input id="element_2_2" name= "element_2_2" type="password" class="element text medium" maxlength="255" size="20" value=""/>
			<label>重复输入密码</label>
		</span> 
		</li>		<li id="li_3" >
		<label class="description" for="element_3">名字 </label>
		<div>
			<input id="element_3" name="element_3" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		</li>		<li id="li_4" >
		<label class="description" for="element_4">E-mail </label>
		<div>
			<input id="element_4" name="element_4" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
		</li>		<li id="li_5" >
		<label class="description" for="element_5">上传头像 </label>
		<div>
			<input id="element_5" name="element_5" class="element file" type="file"/> 
		</div>  
		</li>
			
					<li class="buttons">
			    <input type="hidden" name="form_id" value="62643" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="注册" />
		</li>
			</ul>
		</form>	
		<div id="footer">
			蜀ICP备10002012号   Copyright &copy; 2008-2010 <a href="http://zhelazhela.com">zhelazhela</a>
		</div>
	</div>
	<img id="bottom" src="images/bottom.png" alt="">
	</body>
</html>