<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
        	<div class="configure">
            	<div class="configure_top"></div>
            	<div class="configure_main">
                	<div class="title">定制折扣信息</div>
                </div>
            	<div class="configure_bottom"></div>
            </div>
            <div class="right_box">
            	<div class="title">本周最受欢迎折扣信息</div>
                <ul>
                	<s:iterator  value="weeklywelcome.list">
                	<li><a target="_blank" href="/detail.zl?dn_id=<s:property value='id'/>"><s:property value='newsTitle'/></a></li>
                	</s:iterator>
                </ul>
            </div>
            <div class="right_box">
            	<div class="title">本周最热门折扣信息</div>
                <ul>
                	<s:iterator  value="weeklyhot.list">
                	<li><a target="_blank" href="/detail.zl?dn_id=<s:property value='id'/>"><s:property value='newsTitle'/></a></li>
                	</s:iterator>
                </ul>
            </div>
            <div class="right_box" style="display:none;">
            	<div class="title">关键字</div>
                <ul>
                	<a href="http://jandan.net/search/youtube">youtube</a>&nbsp;
<a href="http://jandan.net/search/公司">公司</a>&nbsp;
<a href="http://jandan.net/search/乐高">乐高</a>&nbsp;
<a href="http://jandan.net/search/华丽">华丽</a>&nbsp;
<a href="http://jandan.net/search/火星">火星</a>&nbsp;
<a href="http://jandan.net/search/变形金刚">变形金刚</a>&nbsp;
<a href="http://jandan.net/search/机器人">机器人</a>&nbsp;
<a href="http://jandan.net/search/UFO">UFO</a>&nbsp;
<a href="http://jandan.net/search/总统">总统</a>&nbsp;
<a href="http://jandan.net/search/世界">世界</a>&nbsp;
<a href="http://jandan.net/search/迪拜">迪拜</a>&nbsp;
<a href="http://jandan.net/search/firefox">firefox</a>&nbsp;
<a href="http://jandan.net/search/geek">geek</a>&nbsp;
<a href="http://jandan.net/search/美元">美元</a>&nbsp;
<a href="http://jandan.net/search/纽约">纽约</a>&nbsp;
<a href="http://jandan.net/search/传说">传说</a>&nbsp;
<a href="http://jandan.net/search/blackberry">blackberry</a>&nbsp;
<a href="http://jandan.net/search/PSP">PSP</a>&nbsp;
<a href="http://jandan.net/search/月球">月球</a>&nbsp;
<a href="http://jandan.net/search/黑洞">黑洞</a>&nbsp;
<a href="http://jandan.net/search/猩猩">猩猩</a>&nbsp;
<a href="http://jandan.net/search/猴子">猴子</a>&nbsp;
<a href="http://jandan.net/search/生态">生态</a>&nbsp;
<a href="http://jandan.net/search/专题">专题</a>&nbsp;
<a href="http://jandan.net/search/街拍">街拍</a>&nbsp;
<a href="http://jandan.net/search/月球">月球</a>&nbsp;
<a href="http://jandan.net/search/每日一美女">美女</a>&nbsp;
<a href="http://jandan.net/search/苹果">苹果</a>&nbsp;
<a href="http://jandan.net/search/盖茨">盖茨</a>&nbsp;
<a href="http://jandan.net/search/印度">印度</a>&nbsp;
<a href="http://jandan.net/search/日本">日本</a>&nbsp;
<a href="http://jandan.net/search/太空">太空</a>&nbsp;
<a href="http://jandan.net/search/山寨">山寨</a>&nbsp;
<a href="http://jandan.net/search/周末啦">周末啦</a>&nbsp;
<a href="http://jandan.net/search/一日一狗">一日一狗</a>&nbsp;
<a href="http://jandan.net/search/greasemonky">GreaseMonky</a>&nbsp;
<a href="http://jandan.net/search/周末一小坨">周末一小坨</a>&nbsp;
<a href="http://jandan.net/search/NASA">NASA</a>&nbsp;
<a href="http://jandan.net/search/无聊图集">无聊图集</a>&nbsp;
<a href="http://jandan.net/search/低俗">低俗</a>&nbsp;
<a href="http://jandan.net/search/周末啦">周末啦</a>&nbsp;
<a href="http://jandan.net/search/猛男">猛男</a>&nbsp;
<a href="http://jandan.net/search/发霉啦">发霉啦(FML)</a>&nbsp;
<a href="http://jandan.net/search/YD周一">YD周一</a>&nbsp;
<a href="http://jandan.net/search/冷新闻">冷新闻</a>&nbsp;
<a href="http://jandan.net/search/无厘头科学">无厘头科学</a>&nbsp;
                </ul>
            </div>
            <div class="right_box" style="display:none;">
            	<div class="title">链接</div>
                <ul class="link">
                	<li><a href="#">小众软件</a></li>
                    <li><a href="#">DP|Paveo</a></li>
                    <li><a href="#">4空间</a></li>
                    <li><a href="#">阿瓦的家</a></li>
                    <li><a href="#">就喜欢网</a></li>
                    <li><a href="#">有意思吧</a></li>
                    <li><a href="#">美剧迷</a></li>
                </ul>
            </div>
            <div class="clear"></div>
