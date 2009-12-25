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
					if(data.result=="fail"){
						alert(data.msg);
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
	writePage(c_page,<s:property value="result.page"/>,"#page_bar","/admin/category_list.zl?page=");
	bindDelete(".del");
})
</script>
    	<div class="result">
        	<table class="list" width="100%">
			<thead>
				<tr>
					<th scope="col">编号</th>
					<th scope="col">父类</th>
					<th scope="col">子类数量</th>
					<th scope="col">是否系统</th>
					<th scope="col">名称</th>
					<th scope="col">描述</th>
					<th scope="col">添加时间</th>
					<th scope="col">操作</th>
				</tr>
			</thead>	
			<tfoot>
				<tr>
					<th scope="row">统计</th>
					<td colspan="6" id="page_bar"><s:property value="result.size"/>条 </td>
				</tr>
			</tfoot>
			<tbody>
				<s:iterator value="result.list">
				<tr>
					<td><a href="#"><s:property value="id"/></a></td>
					<td><a href="#"><s:property value="father"/></a></td>
					<td>
						<s:if test="child>0">
							<a href="/admin/category_list.zl?f_id=<s:property value='id'/>"><s:property value="child"/></a>
						</s:if>
						<s:if test="child==0">
							无
						</s:if>
					</td>
					<td><s:property value="isSystem"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="description"/></td>
					<td><s:property value="addTime"/></td>
					<td><a href="/admin/del_category.zl?c_id=<s:property value='id'/>" class="del"/>删除</a></td>
				</tr>
				</s:iterator>
             </tbody>
        </table>
        </div>