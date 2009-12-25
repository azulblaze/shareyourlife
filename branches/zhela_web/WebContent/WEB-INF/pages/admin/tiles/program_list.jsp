<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script>
function bindDelete(select){
	$(select).each(function(){
		$(this).bind("click",function(event){
			event.preventDefault();
			var tr_obj = $(this).parent().parent("tr");
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
						$(tr_obj).remove();
					}
				}
			});
		})
	})
}
$(document).ready(function(){
	var size = <s:property value="result.size"/>;
	var pagesize = <s:property value="result.pagesize"/>;
	var c_page = Math.ceil(size/pagesize);
	writePage(c_page,<s:property value="result.page"/>,"#page_bar","/admin/program_list.zl?page=");
	bindDelete(".del");
})
</script>
    	<div class="result">
        	<table class="list" width="100%">
			<thead>
				<tr>
					<th scope="col">编号</th>
					<th scope="col">名称</th>
					<th scope="col">名称缩写</th>
					<th scope="col">网址</th>
					<th scope="col">电子邮箱</th>
					<th scope="col">LOGO</th>
					<th scope="col">描述</th>
					<th scope="col">添加日期</th>
					<th scope="col">操作</th>
				</tr>
			</thead>	
			<tfoot>
				<tr>
					<th scope="row">统计</th>
					<td colspan="8" id="page_bar"><s:property value="result.size"/>条 </td>
				</tr>
			</tfoot>
			<tbody>
				<s:iterator value="result.list">
				<tr>
					<td><a href="#"><s:property value="id"/></a></td>
					<td><s:property value='name'/></td>
					<td><s:property value='shortName'/></td>
					<td><a href="<s:property value='website'/>"><s:property value='website'/></a></td>
					<td><a href="mailto:<s:property value='email'/>"><s:property value='email'/></a></td>
					<td><img alt="LOGO" height="30" width="100" src="<s:property value='log'/>" /></td>
					<td><s:property value='regDate'/></td>
					<td><s:property value='description'/></td>
					<td><a href="/admin/del_program.zl?pi_id=<s:property value='id'/>"  class="del"/>删除</a></td>
				</tr>
				</s:iterator>
             </tbody>
        </table>
        </div>