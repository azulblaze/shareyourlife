<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<s:if test="#session.user!=null">
		   <ul id="navmenu">
			  <li><a class="navheader" href="#"><img src="<s:property value='#session.user.header'/>"/><s:property value="#session.user.displayName"/></a>
				<ul>
				  <li><a href="/web/user/changepassword.do">更新密码</a></li>
				  <li><a href="/web/user/changeheader.do">上传头像</a></li>
				</ul>
			  </li>
			  <!-- /web/service/allservice.do -->
			  <li><a href="#">服务管理</a>
				<ul>
				  <li><a href="/web/service/comment/info.do">评论组件</a>
					<ul>
					  <li><a href="/web/service/comment/status.do">使用状态</a></li>
					  <li><a href="/web/service/comment/addservice.do">增加组件</a></li>
					  <li><a href="/web/service/comment/list.do">我的评论</a></li>
					</ul>
				  </li>
				  <li><a href="/web/service/makebetter.do">改善服务</a></li>
				  <s:if test="#session.user.account=='admin'">
				  <li><a href="/web/service/betterinfo.do">改善信息</a></li>
				  </s:if>
				</ul>
			  </li>
			  <li><a href="/web/user/signout.do">退出</a></li>
			</ul>
	</s:if>