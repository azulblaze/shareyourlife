<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
$(document).ready(function(){
	var size = <s:property value="dnl.size"/>;
	var pagesize = <s:property value="dnl.pagesize"/>;
	var page = <s:property value="dnl.page"/>;
	var c_page = Math.ceil(size/pagesize);
	var c_url = window.location.href;
	var c_url_index = c_url.indexOf("index.zl");
	if(c_url_index>=0){
		c_url = c_url.substring(c_url_index);
		if(c_url.length==8){
			c_url = c_url+"?z=n&";
		}else{
			c_url_index = c_url.indexOf("&page=");
			if(c_url_index>=0){
				c_url = c_url.substring(0,c_url_index);
			}
			c_url = c_url+"&";
		}
	}
	if(page>1&&c_page>1){
		$(".index_page_link").append('<a href="'+c_url+'page='+(page-1)+'">&larr; 较新的信息</a>');
	}
	if(page<c_page){
		$(".index_page_link").append('<a href="'+c_url+'page='+(page+1)+'">较旧的信息 &rarr;</a>');
	}
})
</script>
			<s:iterator value="dnl.list">
        	<div class="post_head">
            	<h2><a target="_blank" href="/detail.zl?dn_id=<s:property value='id'/>"><s:property value="newsTitle"/></a></h2>
                <div class="small">感谢 <a target="_blank" href="<s:property value='senderLink'/>"><s:property value="senderName"/></a> 的投递 | <s:date name="approveTime" format="yyyy-MM-dd hh:mm:ss"/> | <s:property value='approveUser'/> | <a target="_blank" href="<s:property value='newsSource'/>">来源</a></div>
            </div>
            <div class="post_body">
            <s:property value="newsReview" escape="false"/>
            <br/>
            <a target="_blank" href="/detail.zl?dn_id=<s:property value='id'/>" class="more_link"><img alt="阅读全文" src="images/fatcow_1147.png"><span class="more_txt">继续阅读全文 » »</span></a>
            </div>
            <div class="post_footer">
            	<span class="first"><img src="images/fatcow_472.png"/>地区: <a href='<s:url value="/index.zl"><s:param name="area" value="discountArea" /></s:url>'><s:property value="discountArea"/></a></span><span><img src="images/fatcow_423.png"/>分类:<script>writeCategory('<s:property value="discountCategory"/>');</script></span><span>浏览数:<s:property value='readTimes'/></span><span>支持数:<s:property value='supportTimes'/></span>
            </div>
            </s:iterator>
            <div class="index_page_link"></div>