<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
a img{
border:none;
}
</style>
<form method="post" action="dashboard.do">
From:<input type="text" name="from"/>
To:<input type="text" name="to"/>
<input type="hidden" name="submit" value="true"/>
<input type="submit" value="Search"/>
</form>
<s:if test="pil!=null&&pil.pis!=null">
<table width="100%" border="1">
  <tr>
    <td>图片</td>
    <td>状态</td>
    <td>用户信息</td>
    <td>图片操作</td>
    <td>用户操作</td>
  </tr>
<s:iterator value="pil.pis" id="picture" status="num">
  <tr id="<s:property value='pictures.id'/>">
    <td><a href="/picture.do?id_picture=<s:property value='pictures.id'/>"/><img src="<s:property value='pictures.min'/>"/></a></td>
    <td><s:if test="picturesParameter.status==-1">已屏蔽</s:if><s:if test="picturesParameter.status==1">正常</s:if></td>
    <td><img height="45" with="45" src="<s:property value='picture'/>"/><br/><a href="<s:property value='account'/>"/><s:property value="name"/></a></td>
    <td><a href="delete_picture.do?id_picture=<s:property value='pictures.id'/>"/>删除</a><br/><a href="disable_picture.do?id_picture=<s:property value='pictures.id'/>"/>屏蔽</a><br/></td>
    <td><a href="disable_user.do?user_account=<s:property value='account'/>"/>屏蔽</a></td>
  </tr>
</s:iterator>
</table>
</s:if>