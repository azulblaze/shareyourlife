<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="/style/rater-star.css" type="text/css"/>
<script type="text/javascript" src="/scripts/rater-star.js"></script>
<script>
var points_msg = ['靠就1分','给2分嘛','算了3分','不错4分','厉害5分','靠就1分','给2分嘛','算了3分','不错4分','厉害5分'];
var options = {  
    max : 10,
    msg:points_msg,
    value:3.4,
    image:'style/images/star.gif',
    url : 'login.html',
    after_ajax  : function(ret) {  
    	alert(ret.ajax);  
	 },
    after_click : function(ret) {  
        this.value  = ret.value;  
        this.enabled= false;  
        $('#content_level').rater(this);  
    }  
}  
$(document).ready(function(){
	$('#content_level').rater(options);
	$('#info_level').rater(options);
})
</script>
        	<div class="post_head">
            	<h2><a href="#">推荐95个极富创意的单页网站设计实例欣赏</a></h2>
                <div class="small">感谢 <a href="#">我是坏蛋</a> 投递 | <a href="#">暴风彬彬</a> 审批 | 2009年12月1日 | 浏览数:1000 <a href="#">来源</a></div>
            </div>
            <div class="post_footer">
            	<span class="first"><img src="images/fatcow_472.png"/>商家:<a href="#">淘宝商城</a></span><span class="time">开始时间: 今天</span><span class="time">结束时间: 10天后</span><br /><span class="first"><img src="images/fatcow_423.png"/>分类:<a href="#">电子产品</a>,<a href="#">服装</a></span>
            </div>
            <div class="post_body">
            	
<p><a href="http://blog.bingo929.com/95-fresh-examples-of-single-page-website-designs.html" title="推荐95个极富创意的单页网站设计实例欣赏"><img src="http://blog.bingo929.com/wp-content/uploads/2009/11/web-design/web-design-title.jpg" alt="推荐99个极富创意的单页网站设计实例欣赏" height="150" ></a></p>
<p>　　今天彬Go将向大家推荐95个极富创意的单页网站设计，随着网络带宽的快速提升，越来越多的Web视觉设计师开始将自己的<a href="http://blog.bingo929.com/category/web-design">网页设计</a>推向单页面的表现形式，他们在不断的尝试各种令人耳目一新的设计方案，像下面的这些例子有很多都是出自个人网站，使用<a href="http://blog.bingo929.com/category/technology/javascript">JavaScript</a>来实现单页面内的内容切换，想理论上的幻灯片效果应用于整个页面的滚动播放，不但新颖富有创意，而且能提高很大程度的视觉冲击力！也许这种设计趋势将慢慢的蔓延到世界的各个国家，但在中国也许真正普遍应用还很困难，不单单是因为带宽远不及外国，还有审美观念的差异。8过作为设计使得你肯定会被下面这95个网站杰作吸引的…
</p>
				<div class="points">
                	<div class="rate">
                    	<div class="rate_line">
                        	<div class="rate_head">信息内容质量:</div>
                            <div id="content_level"></div>
                            <div class="rate_result">当前平均分:7.3 (19次打分)</div>
						</div>
                        <div  class="rate_line">
                        	<div class="rate_head">信息报道水平:</div>
                            <div id="info_level"></div>
                            <div class="rate_result">当前平均分:7.3 (19次打分)</div>
                        </div>
                    </div>
                    <div class="support">
                    	<a href="#" title="支持我"><img src="images/05.gif" alt="支持我"/></a>
                        <br /><span>支持:332</span>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="comment">
            	<div class="commet_bar">
                	<span>评论</span><span class="qty">( 109条 )</span>
                    <div>
                    	<a href="#">我要评论</a>
                    </div>
                </div>
                <div class="submit">
                	<form action="#" method="post">
                    <textarea></textarea>
                    <div class="row"><label>验证码:</label><input class="v_code" type="text" name="" value="" /><img src="images/v_code.png" alt="验证码" title="看不起请点击图片刷新" /><input type="submit" value="提交" class="i_button" /><input type="button" value="取消" class="i_button" /><span class="error">请输入验证码</span></div>
                    </form>
                </div>
                <div class="commet_bar">
                	<span><a href="#">我是小坏</a></span><span class="qty">发表于</span>  ( 2009-10-12 12:12:12 )
                    <div>
                    	<a href="#"><span>支持(103)</span><img src="images/support.png" /></a><a href="#"><span>反对(103)</span><img src="images/against.png" class="end" /></a>
                    </div>
                </div>
                <div class="comment_news">
                	金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？
                </div>
                <div class="commet_bar">
                	<span><a href="#">我是小坏</a></span><span class="qty">发表于</span>  ( 2009-10-12 12:12:12 )
                    <div>
                    	<a href="#"><span>支持(103)</span><img src="images/support.png" /></a><a href="#"><span>反对(103)</span><img src="images/against.png" class="end" /></a>
                    </div>
                </div>
                <div class="comment_news">
                	金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？
                </div>
                <div class="commet_bar">
                	<span><a href="#">我是小坏</a></span><span class="qty">发表于</span>  ( 2009-10-12 12:12:12 )
                    <div>
                    	<a href="#"><span>支持(103)</span><img src="images/support.png" /></a><a href="#"><span>反对(103)</span><img src="images/against.png" class="end" /></a>
                    </div>
                </div>
                <div class="comment_news">
                	金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？
                </div>
                <div class="commet_bar">
                	<span><a href="#">我是小坏</a></span><span class="qty">发表于</span>  ( 2009-10-12 12:12:12 )
                    <div>
                    	<a href="#"><span>支持(103)</span><img src="images/support.png" /></a><a href="#"><span>反对(103)</span><img src="images/against.png" class="end" /></a>
                    </div>
                </div>
                <div class="comment_news">
                	金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？
                </div>
                <div class="commet_bar">
                	<span><a href="#">我是小坏</a></span><span class="qty">发表于</span>  ( 2009-10-12 12:12:12 )
                    <div>
                    	<a href="#"><span>支持(103)</span><img src="images/support.png" /></a><a href="#"><span>反对(103)</span><img src="images/against.png" class="end" /></a>
                    </div>
                </div>
                <div class="comment_news">
                	金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？
                </div>
                <div class="commet_bar">
                	<span><a href="#">我是小坏</a></span><span class="qty">发表于</span>  ( 2009-10-12 12:12:12 )
                    <div>
                    	<a href="#"><span>支持(103)</span><img src="images/support.png" /></a><a href="#"><span>反对(103)</span><img src="images/against.png" class="end" /></a>
                    </div>
                </div>
                <div class="comment_news">
                	金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？
                </div>
                <div class="commet_bar">
                	<span><a href="#">我是小坏</a></span><span class="qty">发表于</span>  ( 2009-10-12 12:12:12 )
                    <div>
                    	<a href="#"><span>支持(103)</span><img src="images/support.png" /></a><a href="#"><span>反对(103)</span><img src="images/against.png" class="end" /></a>
                    </div>
                </div>
                <div class="comment_news">
                	金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？金山打字通，打了还能变n~b，确定不会变s~b？
                </div>
            </div>