<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#top-nav li em").click(function() {
			var hidden = $(this).parents("li").children("ul").is(":hidden");
			$("#top-nav>ul>li>ul").hide()        
			$("#top-nav>ul>li>a").removeClass();  		
			if (hidden) {
				$(this).parents("li").children("ul").toggle().parents("li").children("a").addClass("zoneCur");
			} 
		});
	});
</script>
	<div id="header">
    	<img src="/images/logo.png" alt="这啦折啦" class="floatleft" />
        <div class="right-side">
        	<s:if test="#session.manager!=null">
        		<a href="#" class="first"><s:property value="#session.manager.name"/></a>&ensp;
            	<a href="login.zl">退出</a> &emsp;
			</s:if>
			<s:if test="#session.manager==null">
            	<a href="login.zl">登录</a> &emsp;
			</s:if>
            <!-- 
            <form class="main-search">
                <label for="search-field" class="search-field-label">Search</label>
                <input type="text" tabindex="1" maxlength="255" class="search-field"/>
                <input type="image" alt="Search" value="Search" src="/images/search.png" class="search-button"/>  
            </form>
            -->
        </div>
	</div>
	<s:if test="#session.manager!=null">
	<div id="top-nav">
		<ul>
			<li>
				<a href="#"><span>折扣新闻<em><img src="/images/zonebar-downarrow.png" alt="展开菜单" /></em></span></a>
				<ul class="sublist">
					<li><a href="go">未审批内容</a></li>
               		<li><a href="go">已拒绝内容</a></li>
               		<li><a href="go">已通过内容</a></li>
               		<li><a href="go">所有内容</a></li>
            	</ul>
         	</li>
         	<li>
				<a href="#"><span>商家信息<em><img src="/images/zonebar-downarrow.png" alt="展开菜单" /></em></span></a>
				<ul class="sublist">
					<li><a href="/admin/static_page.zl?nav=add_program">增加商家</a></li>
                    <li><a href="go">商家列表</a></li>
            	</ul>
         	</li>
         	<li>
				<a href="#"><span>商品类别<em><img src="/images/zonebar-downarrow.png" alt="展开菜单" /></em></span></a>
				<ul class="sublist">
					<li><a href="/admin/static_page.zl?nav=add_category">增加类别</a></li>
               		<li><a href="go">类别列表</a></li>
            	</ul>
         	</li>
         	<li>
				<a href="#"><span>系统设置<em><img src="/images/zonebar-downarrow.png" alt="展开菜单" /></em></span></a>
				<ul class="sublist">
					<li><a href="go">附件管理</a></li>
            	</ul>
         	</li>
		</ul>
	</div>
	<div class="nav_title">
		<h3><tiles:insertAttribute name="nav_title"/></h3>
		<div class="search">
		<form class="main-search">
			<input type="text" tabindex="1" maxlength="255" class="search-field" value="根据标题查找新闻"/>
			<input type="image" alt="Search" value="Search" src="/images/search.png" class="search-button"/>  
      	</form>
    </div>
    <div class="clear"></div>    	
    </div>
	</s:if>