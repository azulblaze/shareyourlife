<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    <div id="content">
    	<div class="login">
        	<h3>登录</h3>
        	<form action="login.zl" method="post">
                <div>帐号：</div>
                <input type="text" tabindex="1" maxlength="255" class="text-input" name="muser.account"/>
                <br />
                <div>密码：</div>
                <input type="password" tabindex="2" maxlength="255" class="text-input" name="muser.password"/>
                <br />
                <input type="submit" value="登 录" class="form-submit"/>
            </form>
        </div>
    </div>