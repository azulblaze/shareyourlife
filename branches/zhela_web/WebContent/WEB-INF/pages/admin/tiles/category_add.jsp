<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="/scripts/jquery.validate.pack.js" charset="utf-8"></script>
<script>
function createSelect(data,id){
	var select = $("<select id='category_select"+id+"'></select>");
	select.append("<option value='0'>全部类别</option>");
	for(var i in data){
		$(select).append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
	}
	$("#category_select").append(select);
	bindChange("#category_select" + id);
}
function addOption(data){
	var id_str = "#category_select"+data.father;
	if($(id_str).length==1){
		$(id_str).append("<option value='"+data.id+"'>"+data.name+"</option>");
	}
}
function getFatherID(){
	var select_s = $("#category_select select");
	var before = 0;
	var current = 0;
	var len = select_s.length;
	for(var i=0;i<len;i++){
		current = $(select_s.get(i)).val();
		if(current>0){
			before = current;
		}
	}
	return before;
}
function bindChange(id){
	$(id).bind("change",function(event){
		var father_id = parseInt($(id+' option:selected').val());
		$(id+" ~ select").each(function(){
			$(this).remove();
		}) 
		if(father_id>0){
			$.ajax( {
				type : "POST",
				url : "/admin/child_category.zl?f_id="+father_id,
				dataType:"json",
				cache : true,
				success : function(data, textStatus) {
					if(data.result=="login"){
						redirectAdminLogin();
					}
					if(data.result=="success"){
						if(data.data.length>0){
							createSelect(data.data,father_id);
						}
					}
					if(data.result=="fail"){
						showError("#sub_msg_div",data.msg);
					}
				}
			});
		}
		
	});
}
$(document).ready(function(){
	bindChange("#category_select0");
	$("#_submit").validate({
		submitHandler: function(form) {
		$("#sub_msg_div").empty();
		$("#s_button").attr("disabled","disabled");
		$.ajax( {
			type : "POST",
			url : "/admin/add_category.zl",
			dataType:"json",
			data:{"mc.father":getFatherID(),"mc.name":$("input[name='mc.name']").val(),"mc.description":$("textarea[name='mc.description']").val()},
			cache : true,
			success : function(data, textStatus) {
				$("#s_button").removeAttr("disabled");
				if(data.result=="login"){
					redirectAdminLogin();
				}
				if(data.result=="success"){
					showSuccess("#sub_msg_div",data.msg);
					addOption(data.data);
				}
				if(data.result=="fail"){
					showError("#sub_msg_div",data.msg);
				}
			}
		});
		return false;
		},
		errorElement: "div",
		rules: {
			"mc.name": {
				required: true,
				maxlength:20
			}
		},
		messages: {
			"mc.name": {
				required: "",
				maxlength:"名称不能超过20个字。"
			}
		}
	});
})
</script>
    <div id="content">
    	<form action="/admin/add_category.zl" method="post" id="_submit">
    	<div class="line firstline">
    		<div class="input" id="category_select">
    			<div class="label">父类:</div>
    			<select id="category_select0">
    				<option value='0'>全部类别</option>
    			<s:iterator value="categorys">
    				<option value='<s:property value="id"/>'><s:property value="name"/></option>
    			</s:iterator>
            	</select>
    		</div>
    		<div class="notice"><em>(必填*)</em>您必须选择一个父类来创建子类，如果您希望创建最顶层的类别，请选择[全部类别]</div>
      	</div>
      	<div class="line">
    		<div class="input"><div class="label">类别名称:</div><input type="text" value="" name="mc.name" class="w200"/></div>
    		<div class="notice"><em>(必填*)</em>类别的名称。</div>
      	</div>
      	<div class="line">
      	<div class="input">
      		<div class="label">基本描述</div>
      			<div class="spec">类别的基本描述，比如包含大概什么商品等等...</div>
            </div>
            <div class="news_content"><textarea name="mc.description" id="news_content"></textarea></div>
     	 </div>
      	<div class="line" id="sub_msg_div">
      		
	 	 </div>
		<div class="big_sbumit">
			<input type="submit" id="s_button" value="确认增加" />
		</div>
		</form>
    </div>