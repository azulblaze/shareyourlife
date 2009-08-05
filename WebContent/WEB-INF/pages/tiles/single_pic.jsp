<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
用户<img height="45" with="45" src="<s:property value='picture.picture'/>"/><a href="<s:property value='picture.account'/>"/><s:property value="picture.name"/></a>
   <div><img src="<s:property value='picture.pictures.min'/>"/></div>
   <form action="/comment.do" method="post">
   <input type="hidden" name="formComment.id_pictures" value="<s:property value='picture.pictures.id'/>"/>
   评论<textarea name="formComment.comment"></textarea>
   <input type="submit" value="提交"/>
   </form>
</body>
</html>