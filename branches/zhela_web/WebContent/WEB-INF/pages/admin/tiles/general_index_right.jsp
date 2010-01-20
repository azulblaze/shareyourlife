<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="dnews!=null">
<script type="text/javascript" src="/scripts/ajaxfileupload.js" charset="utf-8"></script>
<style>
.upload{
	height:24px;
}
.submitpic{
	padding:2px 5px;
}
.uploaded{
	width:100%;
	border:1px dashed #03F;
	margin-top:10px;
	clear:both;
}
.uploaded input,.uploaded img{
	width:280px;
}
.uploaded input{
	height:24px;
	border:1px solid green;
}
#up_loading{
	display:none;
}
</style>
<script>
function bindremovePic(c_obj,a_obj){
	$(a_obj).bind("click",function(event){
		event.preventDefault();
		$.ajax({
			type : "GET",
			url : $(this).attr("href"),
			dataType:"json",
			cache : false,
			success : function(data, textStatus) {
				if(data.result=="login"){
					redirectAdminLogin();
				}
				if(data.result=="success"){
					$(c_obj).remove();
				}
				if(data.result=="fail"){
					alert(data.msg);
				}
			}
		});
	});
}
function create(addr,id){
	var myhtml = $('<div class="uploaded"><input type="text" value="'+addr+'"/><br /><img src="'+addr+'" /><br/><a href="/admin/delcontentpic.zl?pic_id='+id+'">删除</a></div>');
	bindremovePic($(myhtml),$(myhtml).find("a"));
	$("#pic_box").prepend(myhtml);
}
function ajaxFileUpload(_json,_pre)
{
	$("#up_loading").ajaxStart(function(){
		$("#upload_submit").attr("disabled","disabled");
		$(this).show();
	}).ajaxComplete(function(){
		$("#contentpic_fileToUpload").val("");
		$("#upload_submit").removeAttr("disabled");
		$(this).hide();
	});
	$.ajaxFileUpload
	(
		{
			url:'/admin/uploadcontentpic.zl',
			name_value:_json,
			pre:_pre,
			secureuri:false,
			fileElementId:'contentpic_fileToUpload',
			dataType: 'json',
			success: function (data, status)
			{
				if(data.result=="login"){
					redirectAdminLogin();
				}
				if(data.result=="success"){
					create(data.pic.fileName,data.pic.id);
				}
				if(data.result=="fail"){
					showError("#sub_msg_div",data.msg);
				}
			},
			error: function (data, status, e)
			{
				alert(e);
			}
		}
	);
	return false;
}
$(document).ready(function(){
	$(".uploaded").each(function(){
		var link = $(this).find("a");
		var pic_obj = $(this);
		bindremovePic(pic_obj,link);
	});
	$("#upload_submit").bind("click",function(){
		var file_path = $("#contentpic_fileToUpload").val();
		if(file_path==null||file_path==""){
			return false;
		}
		var json={};
		json.dn_id = "<s:property value='dnews.id'/>";
		ajaxFileUpload(json,"");
		return false;
	});
});
</script>
        	<div class="right_box">
            	<div class="title"><strong>如何上传图片？</strong></div>
                <p style="color:blue;"><img src="/images/howedit.jpg"/><br/>如上图，您可以在这里上传图片到服务器，上传成功后会得到图片地址，然后通过富文本编辑器加入到折扣信息里面。[只能上传PGN,JPG,GIF格式的图片]</p>
            </div>
            <div class="right_box">
                <form action="/admin/uploadcontentpic.zl" method="post" enctype="multipart/form-data">
                	<input type="file" id="contentpic_fileToUpload" name="pic" value="" class="upload" />
                    <input type="submit" id="upload_submit" value="上传" class="submitpic"/>
                </form>
                <div id="up_loading"><img src="/images/loading.gif" />上传中...</div>
            </div>
            <div class="right_box" id="pic_box">
            	<div class="title"><strong>已上传图片</strong></div>
                <p>请直接复制图片下面的地址，然后增加到内容里面！</p>
            	<s:iterator value="loadpic">
            	<div class="uploaded"><input type="text" value="<s:property value='fileName'/>"/><br /><img src="<s:property value='fileName'/>" /><br/><a href="/admin/delcontentpic.zl?pic_id=<s:property value='id'/>">删除</a></div>
            	</s:iterator>
            </div>
            <div class="clear"></div>
</s:if>