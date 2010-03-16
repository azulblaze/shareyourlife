<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
			<h3><s:property value="gd.name"/></h3>
        	<div class="wrapper-line">
            	<div class="goods_thumb"><img src="<s:property value='gd.pic'/>" /></div>
                <div class="goods-sum">
                	<div class="line">
                    	<div class="left">来自于 <a href="<s:property value='gd.source'/>"><s:property value='gd.source_domain'/></a><br /><a href="<s:property value='gd.source'/>">查看详细信息</a></div>
                        <div class="right"><br /><a href="care_goods.zl?goods_id=<s:property value='gd.id'/>&goods_sn=<s:property value='gd.sn'/>">关注该产品</a></div>
                    </div>
                    <div class="line"><a href="#"><s:property value='gd.comment_size'/> 条评论</a></div>
                    <s:if test="gd.offer_size>0">
                    <div class="line"><a href="#"><s:property value='gd.offer_size'/> 个购买信息</a></div>
                    </s:if>
                    <div class="line"><a href="#">与朋友分享</a></div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="wrapper-line">
                <div class="care_user">
                	<div>被<s:property value='gd.track_size'/>个用户关注  <s:property value='gd.trackuser.page'/>/<s:property value='gd.trackuser.allpage'/> <a href="#">上一页</a><a href="#">下一页</a></div>
                	<s:iterator value="gd.trackuser.list">
                	<div class="user">
                    	<a href="/sns/user/<s:property value='user_id'/>"><div class="header"><img src="<s:property value='avatar'/>" /></div><div class="tagname"><s:property value='tag'/><br /><s:property value='user_name'/></div></a>
                        <div class="clear"></div>
                    </div>
                    </s:iterator>
                    <div class="clear"></div>
                </div>
                <div class="goods_desc">
                	<div class="subject">详细描述</div>
                	<p><s:property value='gd.desc'/></p>
                </div>
                <div class="goods_offer">
                	<div>产品购买信息  <s:property value='gd.offers.page'/>/<s:property value='gd.offers.allpage'/> <a href="#">上一页</a><a href="#">下一页</a></div>
                    <table width="700">
                    	<tr><td>名称</td><td>价格</td><td>&nbsp;</td></tr>
                    	<s:iterator value="gd.offers.list">
                        <tr><td><s:property value='topic'/></td><td>$<s:property value='price'/></td><td><a href="#">查看</a></td></tr>
                        </s:iterator>
                    </table>
                </div>
                <div class="goods_comment">
                	<div class="subject">评论(<s:property value='gd.comment_size'/>条)</div>
                	<s:iterator value="gd.comments.list">
                    <div class="comment">
                    	<div class="header"><a href="/sns/user/<s:property value='user_id'/>"><img src="<s:property value='avatar'/>" /><br/><s:property value='user_name'/></a></div><div class="comment_content"><s:property value='content'/></div><div class="clear"></div>
                    </div>
                    </s:iterator>
                    <div class="clear"></div>
                </div>
                <div class="goods_comment">
                	<form action="/sns/comment.zl" method="post">
                	<input type="hidden" name="goodcomment.goodsId" value="<s:property value='gd.id'/>"/>
                	<s:if test="gd.sn!=null&&gd.sn!='000'">
                	<input name="goodcomment.sn" type="hidden" value="<s:property value='gd.sn'/>"/>
                	</s:if>
                	<div>回复:XXXX<a href="">清除</a></div>
                	<div><textarea name="goodcomment.content"></textarea></div>
                	<div><input type="submit" value="确定"/></div>
                	</form>
                </div>
            </div>