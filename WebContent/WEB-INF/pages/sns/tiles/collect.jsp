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
<script type="text/javascript" src="/scripts/set.js" charset="utf-8"></script>
<script>
var images = new Set();
function mapURL(baseURL,href){
	var _https = /^https:\/\//.test(baseURL);
    if(/^http[s]*:\/\//.test(href)){return href};
    var p1=baseURL.replace(/^http[s]*:\/\/|\?.*$|\/$/g,"").split("/");
    if(p1.length>1&&/\w+\.\w+$/.test(p1[p1.length-1])){p1.pop()}
    if(href.charAt(0)=="/"){if(_https){return "https://"+p1[0]+href}else{return "http://"+p1[0]+href;}};
    if(!/^\.\.\//.test(href)){if(_https){return "https://"+p1.join("/")+"/"+href;}else{return "http://"+p1.join("/")+"/"+href;}};
    var p2=href.split("/");
    for(var i=0;i<p2.length;i++){
        if(p2[i]==".."&&p1.length>1) p1.pop();
        else break;
    };
    p2.splice(0,i);
	if(_https){
		return "https://"+p1.join("/")+"/"+p2.join("/").replace(/\.\.\//g,"");
	}else{
		return "http://"+p1.join("/")+"/"+p2.join("/").replace(/\.\.\//g,"");
	}
}
function createUploadIframe(id, uri)
{
		//create frame
        var frameId = 'jLoadUrlFrame' + id;
        
        if(window.ActiveXObject) {
            var io = document.createElement('<iframe id="' + frameId + '" name="' + frameId + '" />');
            if(typeof uri== 'boolean'){
                io.src = 'javascript:false';
            }
            else if(typeof uri== 'string'){
                io.src = uri;
            }
        }
        else {
            var io = document.createElement('iframe');
            io.id = frameId;
            io.name = frameId;
            io.src = uri;
        }
        io.style.position = 'absolute';
        io.style.top = '-1000px';
        io.style.left = '-1000px';

        document.body.appendChild(io);
        if(window.attachEvent){
            document.getElementById(frameId).attachEvent('onload', CreateImage);
        }
        else{
            document.getElementById(frameId).addEventListener('load', CreateImage, false);
        }
        return io;
}
function CreateImage(){
	var io = document.getElementById("jLoadUrlFrameabc");
	var content;
	var title;
    try 
	{				
		if(io.contentWindow)
		{
			title = io.contentWindow.document.title;
			content = io.contentWindow.document.body?io.contentWindow.document.body.innerHTML:null;
		}else if(io.contentDocument)
		{
			title = io.contentDocument.document.title;
			content = io.contentDocument.document.body?io.contentDocument.document.body.innerHTML:null;
		}						
    }catch(e)
	{
		jQuery.handleError(s, xml, null, e);
	}
	$("#g_title").val(title);
	$(content).find("img").each(function(){
		var addr = $(this).attr("src");
		if (addr.match(/price.360buy.com/)) return true;	
		if (addr.match(/logo/i)) return true;
		if (addr.match(/newrank/)) return true;
		if (addr.match(/space/)) return true;
		if (addr.match(/blank/)) return true;
		if (addr.match(/\/tps/)) return true;
		if (addr.match(/header/)) return true;
		if (addr.match(/banner/)) return true;
		if (addr.match(/\/skin/)) return true;
		if (addr.match(/wrapper_/)) return true;
		if (addr.match(/doubleclick/)) return true;
		if (addr.match(/247realmedia/)) return true;
		if (addr.match(/offermatica/)) return true;
		if (addr.match(/adimages/)) return true;
		if (addr.match(/tribalfusion/)) return true;
		if (addr.match(/eBillmeCashback\.gif/)) return true;
		if (addr.match(/\/Marketing\/Images/)) return true;
		if (addr.match(/\/ads\/marketing/)) return true;
		if (addr.match(/\/adx\/images\/ADS/)) return true;
		if (addr.match(/\/pagead\/imgad/)) return true;
		if (addr.match(/nonsub_promo\.jpg/)) return true;
		var link = $(this).parent().find("a");
		if(link!=null&&link.size()>0){
			if ($(link).attr("href").match(/doubleclick/)) return true;
            if ($(link).attr("href").match(/adsremote/)) return true;
            if ($(link).attr("href").match(/revresda\.com/)) return true;
		}
		addr = mapURL("<s:property value='source'/>",addr);
		if (addr.match(/com\/images/)) return true;
		if (addr.match(/cn\/images/)) return true;
		if (addr.match(/com.cn\/images/)) return true;
		if (addr.match(/net\/images/)) return true;
		if (addr.match(/com\/image/)) return true;
		if (addr.match(/cn\/image/)) return true;
		if (addr.match(/com.cn\/image/)) return true;
		if (addr.match(/net\/image/)) return true;
		images.put(addr);
	});
	bindclick();
}
function bindclick(){
	var curr = 0;
	var _images = images.toArray();
	var size = _images.length;
	$("#good_image").attr("src",_images[curr]);
	$("#g_i_s").val(_images[curr]);
	$("#g_i_c").html(""+(curr+1)+"/"+size);
	$("#g_i_p").bind("click",function(event){
		event.preventDefault();
		if(curr>0&&size>0){
			curr = curr - 1;
			$("#good_image").attr("src",_images[curr]);
			$("#g_i_s").val(_images[curr]);
			$("#g_i_c").html(""+(curr+1)+"/"+size);
		}
	});
	$("#g_i_n").bind("click",function(event){
		event.preventDefault();
		if(curr<(size-1)&&size>0){
			curr = curr + 1;
			$("#good_image").attr("src",_images[curr]);
			$("#g_i_s").val(_images[curr]);
			$("#g_i_c").html(""+(curr+1)+"/"+size);
		}
	});
}
$(document).ready(function(){
	createUploadIframe("abc","/loadurl.zl?url=<s:property value='source'/>");
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
        <div>商品名称：<input type="text" name="gc.name" id="g_title"/></div>
        <div>商品类别：<select name="gc.category"><option value="数码产品">数码产品</option><option value="流行服饰">流行服饰</option></select></div>
        <div>来源地址：<input name="gc.source" type="text" value="<s:property value='source'/>"/></div>
        <div>图片：<input name="gc.pic" type="hidden" value="" id="g_i_s"/><img src="images/good.jpg" id="good_image"/><a id="g_i_p" href="#">&lt;</a><span id="g_i_c">2/3</span><a id="g_i_n" href="#">&gt;</a></div>
        <div>描述：<textarea name="gc.desc"></textarea></div>
        <div>关注商品</div>
        <div>标记为：<select name="gc.tag"><option value="衣服">衣服</option><option value="猫">猫</option></select><a href="#">新建标签</a></div>
        <div>跟踪价格：<input type="radio"  name="gc.track_price" value="1"/>开<input type="radio"  name="gc.track_price" value="-1"/>关</div>
        <div>打分：@@@@@@ [使用星星打分]<input type="hidden" name="gc.rate" value="4"/></div>
        <div>评论：<textarea name="gc.comment"></textarea></div>
        <div>分享给：<input type="radio"  name="gc.share" value="1"/>我的好友<input type="radio"  name="gc.share" value="2"/>关注我的人<input type="radio"  name="gc.share" value="3"/>我关注的人<input type="radio"  name="gc.share" value="-1"/>不用了</div>
        <div><input type="submit" value="保存" /><input type="checkbox" value="0" name="gc.privacy"  />私人收藏</div>
        </form>
    </div>
    <div id="footer">This is footer</div>
</div>
</body>
</html>