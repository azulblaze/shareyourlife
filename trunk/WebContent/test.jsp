<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
    <title>ajaxFileUpload</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="/scripts/jquery-1.3.2.min.js"></script>
    <script src="/scripts/jquery.uploadProgress.js"></script>
    <script type="text/javascript">
    $(function() {
		$('form').uploadProgress({
			progressUrl:"/upload_info.do",
			start:function(){},
			uploading: function(upload) {$("#percents").html(upload.state+"/"+upload.percents);},
			error:function(upload){$("#percents").html(upload.state+"/"+upload.action);},
			complete:function(upload){$("#percents").html(upload.state+"/"+upload.action);},
			interval:1000
	    });
	});
    </script>
    <style type="text/css">
			.bar {
			  width: 300px;
			}
			
			#progress {
			  background: #eee;
			  border: 1px solid #222;
			  margin-top: 20px;
			}
			#progressbar {
			  width: 0px;
			  height: 24px;
			  background: #333;
			}
	</style>
    </head>	
	<body>
		<form action="/upload_pic.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="submit" value="true"/>
			文件:<input type="file" name="pic"/>
			描述:<input type="text" name="description"/>
			<input type="submit" value="上传"/>
		</form>
		<div id="uploading">
	      <div id="progress" class="bar">
	        <div id="progressbar">&nbsp;</div>
	      </div>
	    </div>
		<div id="percents">sss</div>
	</body>
</html>

