<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="div_panel">
	<s:actionerror/>
</div>
<div class="div_panel">
	<form action="upload_pic.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="submit" value="true"/>
		<p>
			文件:<input id="up_file" type="file" name="pic"/>
		</p>
		<p>
			标题:<input type="text" name="title"/>
		</p>
		<p>
			描述:<textarea name="description" cols="10" rows="5"></textarea>
		</p>
		<input type="submit" value="上传"/>
	</form>
</div>