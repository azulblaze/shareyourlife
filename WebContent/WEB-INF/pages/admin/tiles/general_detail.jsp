<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="/style/rater-star.css" type="text/css"/>
<script type="text/javascript" src="/scripts/jquery.validate.pack.js"></script>
<script type="text/javascript" src="/scripts/rater-star.js"></script>
<script type="text/javascript" src="/scripts/display.js"></script>
<script>
function writeCategory(categorys){
	var sub_cat_arry = categorys.split(",");
	var sub_len = sub_cat_arry.length;
	var cat_link = "";
	for(var i=0;i<sub_len;i++){
		if(sub_cat_arry[i]!=null&&sub_cat_arry[i]!=""){
			cat_link = cat_link + '<a href="/index.zl?category='+encodeURI(sub_cat_arry[i])+'">'+sub_cat_arry[i]+'</a>,';
		}
	}
	if(cat_link!=""){
		cat_link = cat_link.substring(0,cat_link.length-1);
		document.write(cat_link);
	}
}
function bindDelete(select){
	$(select).each(function(){
		var title = $(this).attr("title");
		if(title!="编辑信息"){
			$(this).bind("click",function(event){
				event.preventDefault();
				$(".result").empty();
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
							$(".result").append(title+"操作成功");
						}
						if(data.result=="fail"){
							alert("操作失败，可能该信息已经被删除了");
						}
					}
				});
			});
		}
	})
}
$(document).ready(function(){
	bindDelete(".control a");
})
</script>
<div class="control_bar">
	<div class="result">
		<s:if test="dn.approveUser!=null">
			<s:if test="dn.approveResult">
				该信息已经通过了审核
			</s:if>
			<s:if test="!dn.approveResult">
				该信息已经被拒绝发布了
			</s:if>
		</s:if>
		<s:if test="dn.approveUser==null">
			该信息还未被审批过
		</s:if>
	</div>
	<div class="control">
    	<a title="通过审核" href="/admin/approve_news.zl?approve_action=1&dn_id=<s:property value='dn.id'/>"><img src="/images/pass.png" /></a><a title="拒绝审核" href="/admin/approve_news.zl?approve_action=0&dn_id=<s:property value='dn.id'/>"><img src="/images/reject.png" /></a><a title="编辑信息" href="/admin/edit_news.zl?edit=true&dnews.id=<s:property value='dn.id'/>"><img src="/images/edit.png" /></a><a title="删除信息" href="/admin/approve_news.zl?approve_action=-1&dn_id=<s:property value='dn.id'/>"><img src="/images/del.png" /></a>
    </div>
</div>
        	<div class="post_head">
            	<h2><a href="#"><s:property value='dn.newsTitle'/></a></h2>
                <div class="small">感谢 <a target="_blank" href="<s:property value='dn.senderLink'/>"><s:property value="dn.senderName"/></a> 投递 | <s:property value='dn.approveUser'/> 审批 | <s:date name="dn.approveTime" format="yyyy-MM-dd hh:mm:ss"/> | 浏览数:<s:property value='dn.readTimes'/> <a target="_blank" href="<s:property value='newsSource'/>">来源</a></div>
            </div>
            <div class="post_footer">
            	<span class="first"><img src="/images/fatcow_472.png"/>商家:<a target="_blank" href="<s:property value='dn.programInfo.website'/>"><s:property value='dn.programInfo.name'/></a></span><span class="time">开始时间: <s:date name="dn.discountStart" format="yyyy年MM月dd日"/></span><span class="time">结束时间: <s:date name="dn.discountEnd" format="yyyy年MM月dd日"/></span><br /><span class="first"><img src="/images/fatcow_423.png"/>分类:<script>writeCategory('<s:property value="dn.discountCategory"/>');</script></span>
            </div>
            <div class="post_body">
            	<p>
            		<s:property value="dn.newsContent" escape="false"/>
            	</p>
            </div>