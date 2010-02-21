<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>追踪您的商品价格 -- 这啦折啦打折信息分享网</title>
<link rel="stylesheet" href="/sns/style/sns.css" type="text/css"/>
<style>
#good_image{
height:100px;
width:100px;
}
</style>
<script type="text/javascript" src="/scripts/jquery-1.3.2.min.js" charset="utf-8"></script>
<script>
$(document).ready(function(){
	//createUploadIframe("abc","/loadurl.zl?url=<s:property value='source'/>");
});
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
    	<img src="/images/zhelazhela.png" alt="这啦折啦" class="floatleft" />
        <div class="right-side">
            <a href="#" class="first">XXXX</a>&ensp;
            <a href="#">退出</a>
        </div>
        <div class="clear"></div>
	</div>
    <div id="content">
    	<form action="/sns/addgoods.zl" method="post">
    	<div><h4>收集商品到这啦折啦</h4></div>
        <div>商品名称：<input type="text" name="gc.name" id="g_title" value="<s:property value='gc.name'/>" /></div>
        <div>商品类别：<select name="gc.category"><option value="数码产品">数码产品</option><option value="流行服饰">流行服饰</option></select></div>
        <div>来源地址：<input name="gc.source" type="text" value="<s:property value='gc.source'/>"/></div>
        <div>图片：<input name="gc.pic" type="hidden" value="<s:property value='gc.pic'/>" id="g_i_s"/><img src="<s:property value='gc.pic'/>" id="good_image"/><a id="g_i_p" href="#">&lt;</a><span id="g_i_c">2/3</span><a id="g_i_n" href="#">&gt;</a></div>
        <div>描述：<textarea name="gc.desc"><s:property value='gc.desc'/></textarea></div>
        <div>关注商品</div>
        <div>标记为：<select name="gc.tag"><option value="衣服">衣服</option><option value="猫">猫</option></select><a href="#">新建标签</a></div>
        <div>跟踪价格：<input type="radio"  name="gc.track_price" value="1"/>开<input type="radio"  name="gc.track_price" value="-1"/>关</div>
        <div>打分：@@@@@@ [使用星星打分]<input type="hidden" name="gc.rate" value="4"/></div>
        <div>评论：<textarea name="gc.comment"><s:property value='gc.comment'/></textarea></div>
        <div>分享给：<input type="radio"  name="gc.share" value="1"/>我的好友<input type="radio"  name="gc.share" value="2"/>关注我的人<input type="radio"  name="gc.share" value="3"/>我关注的人<input type="radio"  name="gc.share" value="-1"/>不用了</div>
        <div><input type="submit" value="保存" /><input type="checkbox" value="0" name="gc.privacy"  />私人收藏</div>
        </form>
    </div>
    <div id="footer">This is footer</div>
</div>
</body>
</html>