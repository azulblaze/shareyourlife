<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
				<div class="userinfo">
                    <div class="user_head">
                        <div class="picborder_r lf"><a href="/sns/user/<s:property value='userinfo.id'/>"><img title="<s:property value='userinfo.name'/>"  src="<s:property value='userinfo.header'/>"></a></div>
                        <div class="lf">
                            <p class="font_14"><s:property value='userinfo.name'/><br /><s:property value='tag.size'/>个标签<s:property value='userinfo.goods'/>个收集</p>
                        </div>
                    </div>
                    <div class="user_atten MIB_linedot">
                        <ul id="profile_following_follower_update">
                            <li class="MIB_line_r" style="position: relative;"><div class="num"><a href="/1679048885/follow"><s:property value='userinfo.tracks'/></a></div>
                                <a href="/sns/care.zl?user_id=<s:property value='userinfo.id'/>">关注</a></li>
                            <li class="MIB_line_r" style="position: relative;"><div class="num"><a href="/1679048885/fans"><s:property value='userinfo.been_tracks'/></a></div>
                                <a href="/sns/fans.zl?user_id=<s:property value='userinfo.id'/>">追随</a></li>
                            <li class="" style="position: relative;"><div class="num"><a href="/zhelazhela/profile"><s:property value='userinfo.goods'/></a></div>
                                <a href="/zhelazhela/profile">收藏</a></li>
                        </ul>
                    </div>
                    <div><s:if test="userinfo.isfriend<=0"><a href="/sns/add_friend.zl?addFriend.d_user_id=<s:property value='userinfo.id'/>">加关注</a></s:if><s:if test="userinfo.isfriend>0">已关注<a href="/sns/del_friend.zl?addFriend.d_user_id=<s:property value='userinfo.id'/>">取消</a></s:if>&nbsp;&nbsp;<a href="">发短讯</a></div>
                </div>
                <div>
                    <div><b><a href="/sns/user_page.zl?user_id=<s:property value='userinfo.id'/>">我的收藏</a>(<s:property value='userinfo.goods'/>)</b></div>
                    <s:iterator value="tag">
                    <div style="margin-left:10px;"><a href="/sns/user_page.zl?user_id=<s:property value='userinfo.id'/>&tagid=<s:property value='tag_id'/>"><s:property value='tag_name'/></a>(<s:property value='tag_count'/>)</div>
                    </s:iterator>
                </div>