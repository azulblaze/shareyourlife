<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<div id="mainContent">
		<s:actionerror/>
		<div>
		<h5>修改密码</h5>
		<form action="/edit_password.do" method="post">
		<input type="hidden" name="sub" value="true"/>
		<p>
		当前密码:<input type="password" name="formUserProfile.oldpassword"/>
		</p>
		<p>
		新密码:<input type="password" name="formUserProfile.password1"/>
		</p>
		<p>
		重新输入新密码:<input type="password" name="formUserProfile.password2"/>
		</p>
		<p>
		<input type="submit" value="修改"/>
		</p>
		</form>
		</div>
		
		<div>
		<h5>更改头像</h5>
		<form action="/edit_header.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="sub" value="true"/>
		<p>
		<img alt="<s:property value='#session.user.name'/>" src="<s:property value='#session.user.picture'/>">
		</p>
		<p>
		<input type="file" name="header">
		</p>
		<p>
		<input type="submit" value="更改"/>
		</p>
		</form>
		</div>
		
		<div>
		<h5>修改资料</h5>
		<form action="/edit_profile.do" method="post">
		<input type="hidden" name="sub" value="true"/>
		<p>
		签名:<input type="text" name="formUserProfile.signature"/>
		</p>
		<p>
		地址:<input type="text" name="formUserProfile.location"/>
		</p>
		<p>
		自我介绍:<textarea name="formUserProfile.self_introduction"></textarea>
		</p>
		<p>
		<input type="submit" value="更改"/>
		</p>
		</form>
		</div>
		<div class="bottom"></div>
	</div>
