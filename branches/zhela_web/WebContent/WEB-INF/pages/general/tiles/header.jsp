<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script>
function unConfigNotice(){
	var tmp_conf_close = $.cookie('zhelazhela.com_close');
	if(tmp_conf_close==null){
		tmp_conf_close = "";
	}
	if((loadConfig("#care_area")=="")&&(loadConfig("#care_category")==""&&tmp_conf_close=="")){
		configNotice("您还没有设置您关注的地区以及您感兴趣的类别哦 :)"); 
		$(".pop_content").show(500);
	}
}
function isShowAdd(){
	if(loadConfig("#care_area")==""){
		$("#addarea").show();
	}else{
		$("#addarea").hide();
	}
	if(loadConfig("#care_category")==""){
		$("#addcategory").show();
	}else{
		$("#addcategory").hide();
	}
}
$(document).ready(function() {
	$("#addfav").click(function(event) {
		event.preventDefault();
		var ctrl = (navigator.userAgent.toLowerCase()).indexOf('mac') != -1 ? 'Command/Cmd' : 'CTRL'; 
        if (document.all){
            window.external.addFavorite('http://www.zhelazhela.com','这啦折啦折扣信息分享平台');
		}else if (window.sidebar){
			window.sidebar.addPanel('这啦折啦折扣信息分享平台', 'http://www.zhelazhela.com', "");
		}else {
			alert('您可以尝试通过快捷键' + ctrl + ' + D 收藏本站到到收藏夹');
		}
    });
	$("#c_conf").bind("click",function(event){
		event.preventDefault();
		$.cookie('zhelazhela.com_close', "closed",{expires:0.025});
		$(".pop_content").hide(500);
	});
	$("#config").bind("click",function(event){
		event.preventDefault();
		$(".pop_content").toggle(500);
	});
	$("#oc_area").bind("click",function(event){
		event.preventDefault();
		$("#addarea").toggle(200);
	});
	$("#oc_category").bind("click",function(event){
		event.preventDefault();
		$("#addcategory").toggle(200);
	});
	initConfig();
	isShowAdd();
	setTimeout(unConfigNotice,2000);
});
</script>
	<div id="header">
    	<div class="logo">
        	<a href="/index.zl" title="查看所有的折扣信息"><img src="/images/zhelazhela.png" /></a>
            <div class="right-side">
            	<img src="/images/cog.png" title="设置信息"/><a href="#" id="config">设置</a>
                <img src="/images/feed.png" title="订阅内容"/><a id="rss_link" href='<s:url value="/rss.zl"><s:param name="area" value="#session.c_areas" /><s:param name="category" value="#session.c_categorys" /></s:url>'>订阅信息</a>
            	<img src="/images/favicon.gif"/><a id="addfav" href="/">加入收藏夹</a>
                <img src="/images/exclamation.gif"/><a href="/html/help.html">帮助</a>
            </div>
        </div>
    	<div class="menu">
            <ul>
                <li<s:if test="nav=='index'"> class='select'</s:if>><a href="/">折扣信息</a></li>
                <li<s:if test="nav=='news_submit'"> class='select'</s:if>><a href="/news_submit.zl">我来投递</a></li>
                <li><a href="/html/about.html">关于我们</a></li>
            </ul>
		</div>
		<div class="clear"></div>
    </div>