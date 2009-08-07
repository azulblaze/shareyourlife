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
    //<![CDATA[
    $(document).ready(function() { 
        $(function() {
            $('#upload_form').uploadProgress({
                progressBar: '#progress_indicator',
                progressUrl: 'http://localhost:8080/upload_info.do',
                start: function() {
                    //$("#upload_form").hide();
                    filename = $("#id_file").val().split(/[\/\\]/).pop();
                    $("#progress_filename").html('Uploading ' + filename + "...");
                    $("#progress_container").show();
                },
                uploading: function(upload) {
                    if (upload.percents == 100) {
                        window.clearTimeout(this.timer);
                        $("#progress_filename").html('Processing ' + filename + "...");
                    } else {
                        $("#progress_filename").html('Uploading ' + filename + ': ' + upload.percents + '%');
                    }
                },
                dataType:"json",
                interval: 3000
            });
        });
    });
    //]]>
    </script>
    <style type="text/css">
    #progress_container {
        font-size: .9em;
        width: 100%;
        height: 1.25em;
        position: relative;
        margin: 3em 0;
        display: block;
    }
    
    #progress_filename {
        font-size: .9em;
        width: 100%;
    }
    
    #progress_bar {
        width: 100%;
        border: 1px solid #999;
    }
    
    #progress_indicator {
        background: #8a9;
        width: 0;
        height: 4px;
    }
    </style>
    </head>	
	<body>
	<iframe name="mytarget" style="display:none;"></iframe>
		<form action="/upload_pic.do" method="post" enctype="multipart/form-data" target="mytarget">
			<input type="hidden" name="submit" value="true"/>
			文件:<input type="file" name="pic"/>
			描述:<input type="text" name="description"/>
			<input type="text" name="description"/>
			<input type="submit" value="上传"/>
		</form>
		<a href="javascript:my_get();">GetData</a>
        <div id="progress_container">
        <div id="progress_filename"></div>
        <div id="progress_bar">
            <div id="progress_indicator"></div>
        </div>
        </div>
	</body>
</html>

