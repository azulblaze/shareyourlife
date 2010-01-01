<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script>
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
});
</script>
	<div id="header">
    	<div class="logo">
        	<a href="/"><img src="/images/zhelazhela.png" /></a>
            <div class="right-side">
            	<img src="images/favicon.gif"/><a id="addfav" href="/">加入收藏夹</a>
                <img src="images/exclamation.gif"/><a href="/html/help.html">帮助</a>
            </div>
        </div>
    	<div class="menu">
            <ul>
                <li<s:if test="nav=='index'"> class='select'</s:if>><a href="/index.zl">折扣信息</a></li>
                <li<s:if test="nav=='news_submit'"> class='select'</s:if>><a href="/news_submit.zl">我来投递</a></li>
                <li><a href="/html/about.html">关于我们</a></li>
            </ul>
		</div>
		<div class="clear"></div>
    </div>