<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div>
	<small><s:actionerror/></small>
</div>
<div>
	<form action="upload_pic.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="submit" value="true"/>
		<p>
			<small>文件:<input id="up_file" type="file" name="pic"/></small>
		</p>
		<p>
			<small>标题:<input type="text" name="title"/></small>
		</p>
		<p>
			<small>描述:<textarea name="description" cols="13" rows="10"></textarea></small>
		</p>
		<input type="submit" value="上传"/>
	</form>
</div>