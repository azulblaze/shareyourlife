<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="/style/rater-star.css" type="text/css"/>
<script type="text/javascript" src="/scripts/rater-star.js"></script>
<script>
function writeCategory(categorys){
	var sub_cat_arry = categorys.split(",");
	var sub_len = sub_cat_arry.length;
	var cat_link = "";
	for(var i=0;i<sub_len;i++){
		if(sub_cat_arry[i]!=null&&sub_cat_arry[i]!=""){
			cat_link = cat_link + '<a href="/index.zl?category='+encodeURI(sub_cat_arry[i])+'">'+sub_cat_arry[i]+'</a>,';
		}
	}
	if(cat_link!=""){
		cat_link = cat_link.substring(0,cat_link.length-1);
		document.write(cat_link);
	}
}
var points_msg = ['太杯具啦','实在太差劲了','叫我怎么说好呢','我只能给你4分','我来鼓励你下','及格了','还行吧','良品','非常不错','传说中的满分'];
function getOption(obj,addr,all_p,times){
	var av_p = 0;
	if(times!=0){
		av_p = all_p/times;
	}
	var option = {  
		    max : 10,
		    msg:points_msg,
		    value:av_p,
		    image:'style/images/star.gif',
		    url : addr,
		    after_ajax  : function(ret) {
	    		var result = eval('('+ret.ajax+')');
	    		$(obj+" ~ .rate_result").empty();
	    		$(obj+" ~ .rate_result").append("当前平均分:"+result.avg_points+" ("+result.times+"次打分)");
	    		this.value  = result.avg_points;  
		        this.enabled= false;  
		        $(obj).rater(this);
			 },
		    after_click : function(ret) {  
		        this.value  = ret.value;  
		        this.enabled= false;  
		        $(obj).rater(this);  
		    }  
		};
	return option;
}
$(document).ready(function(){
	$('#content_level').rater(getOption('#content_level',"point_c.zl?dn_id=<s:property value='dn.id'/>",<s:property value='dn.contentPoints'/>,<s:property value='dn.contentPointsTimes'/>));
	$('#info_level').rater(getOption('#info_level',"point_p.zl?dn_id=<s:property value='dn.id'/>",<s:property value='dn.publishPoints'/>,<s:property value='dn.publishPointsTimes'/>));
	$("#want_comment").bind("click",function(event){
		event.preventDefault();
		$(".submit").css("display","");
	});
	$("#del_comment").bind("click",function(event){
		event.preventDefault();
		$(".submit").css("display","none");
	});
	$("#v_code_img").bind("click",function(event){
		var timer=new Date();
		$("#v_code_img").attr("src","/code.zl?sessionName=news_submit&mytime="+timer.getHours()+timer.getMinutes()+timer.getSeconds());
	});
	$("#validate_code").bind("focus",function(event){
		if($("#v_code_img").css("display")=="none"){
			$("#v_code_img").click();
			$("#v_code_img").css("display","");
		}
	});
	$("#support_me").bind("click",function(event){
		event.preventDefault();
		$.ajax({
			type : "GET",
			url : "/support.zl?dn_id=<s:property value='dn.id'/>",
			dataType:"json",
			cache : false,
			success : function(data, textStatus) {
				$("#support_div").empty();
				$("#support_div").append('<img src="images/05.gif" alt="已支持"/><br /><span>支持:'+data.points+'</span>');
			}
		});
	});
})
</script>
        	<div class="post_head">
            	<h2><a href="#"><s:property value='dn.newsTitle'/></a></h2>
                <div class="small">感谢 <a target="_blank" href="<s:property value='dn.senderLink'/>"><s:property value="dn.senderName"/></a> 投递 | <s:property value='dn.approveUser'/> 审批 | <s:date name="dn.approveTime" format="yyyy-MM-dd hh:mm:ss"/> | 浏览数:<s:property value='dn.readTimes'/> <a target="_blank" href="<s:property value='newsSource'/>">来源</a></div>
            </div>
            <div class="post_footer">
            	<span class="first"><img src="images/fatcow_472.png"/>商家:<a target="_blank" href="<s:property value='dn.programInfo.website'/>"><s:property value='dn.programInfo.name'/></a></span><span class="time">开始时间: <s:date name="dn.discountStart" format="yyyy年MM月dd日"/></span><span class="time">结束时间: <s:date name="dn.discountEnd" format="yyyy年MM月dd日"/></span><br /><span class="first"><img src="images/fatcow_423.png"/>分类:<script>writeCategory('<s:property value="dn.discountCategory"/>');</script></span>
            </div>
            <div class="post_body">
            	<p>
            		<s:property value="dn.newsContent" escape="false"/>
            	</p>
            	<div class="points">
                	<div class="rate">
                    	<div class="rate_line">
                        	<div class="rate_head">信息内容质量:</div>
                            <div id="content_level"></div>
                            <div class="rate_result">
                            	<s:if test="dn.contentPointsTimes==0">
                            		还没有人评分
                            	</s:if>
                            	<s:if test="dn.contentPointsTimes>0">
                            		当前平均分:<s:property value='dn.aveCPoints'/> (<s:property value='dn.contentPointsTimes'/>次打分)
                            	</s:if>
                            </div>
						</div>
                        <div  class="rate_line">
                        	<div class="rate_head">信息报道水平:</div>
                            <div id="info_level"></div>
                            <div class="rate_result">
                            	<s:if test="dn.publishPointsTimes==0">
                            		还没有人评分
                            	</s:if>
                            	<s:if test="dn.publishPointsTimes>0">
                            		当前平均分:<s:property value='dn.avePPoints'/> (<s:property value='dn.publishPointsTimes'/>次打分)
                            	</s:if>
                            </div>
                        </div>
                    </div>
                    <div class="support" id="support_div">
                    	<a href="#" title="支持我" id="support_me"><img src="images/05.gif" alt="支持我"/></a>
                        <br /><span>支持:<s:property value='dn.supportTimes'/></span>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="comment">
            	<div class="commet_bar">
                	<span>评论</span><span class="qty">( 109条 )</span>
                    <div>
                    	<a href="#" id="want_comment">我要评论</a>
                    </div>
                </div>
                <div class="submit">
                	<form action="#" method="post">
                    <textarea disabled="disabled"></textarea>
                    <div class="row"><label>验证码:</label><input class="v_code" type="text" name="validate_code" id="validate_code" /><img src="images/v_code.png" id="v_code_img" style="display:none;" title="看不起请点击图片刷新"/><input type="submit" value="提交" class="i_button" /><input type="button" value="取消" class="i_button" id="del_comment" /><span class="error">请输入验证码</span></div>
                    </form>
                </div>
                <div class="commet_bar">
                	<span><a href="#">我是小坏</a></span><span class="qty">发表于</span>  ( 2009-10-12 12:12:12 )
                    <div>
                    	<a href="#"><span>支持(103)</span><img src="images/support.png" /></a><a href="#"><span>反对(103)</span><img src="images/against.png" class="end" /></a>
                    </div>
                </div>
            </div>