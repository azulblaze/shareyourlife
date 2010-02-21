<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script>
$(document).ready(function(){
	$("#react").bind("click",function(event){
		event.preventDefault();
		$.ajax({
			type : "POST",
			url : "/sns/remail.zl?user.email="+$("#email").val(),
			dataType:"json",
			cache : false,
			success : function(data, textStatus) {
				if(data.result=="login"){
					//redirectAdminLogin();
				}
				if(data.result=="success"){
					alert(data.msg);
				}
				if(data.result=="fail"){
					alert(data.msg);
				}
			}
		});
	});
});
</script>
	<div class="line">恭喜您的账号已经注册成功，请立即登陆您的邮箱使用我们发送给您的链接激活账号</div>
	<div class="line">您必须在72小时内激活账号，只有激活后才能使用我们的功能。如果您没有收到链接，请点击下面按钮重新发送</div>
	<div class="line"><input id="react" type="submit" value="重新发送"/></div>
	<div class="line">或者您还可以更换邮箱来接收激活链接</div>
	<div class="line"><input type="text" id="email" name="user.email" value='<s:property value="user.email"/>'/></div>