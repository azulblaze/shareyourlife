<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="Keywords" content="这啦折啦  打折 折扣 购物卷  最新折扣  免费 优惠 卷 卡 赠送 礼 卷 卡  折" />
	<meta name="Description" content="这啦折啦 为您提供最新的打折优惠信息,还有更多购物卡 记分卡分享" />
	<link href="/rss.zl" title="RSS 2.0" type="application/rss+xml" rel="alternate" />
	<link rel="bookmark" href="favicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
	<link type="images/gif" href="/act_favicon.gif" rel="icon"/>
	<title><s:property value='cust_title'/><tiles:insertAttribute name="title"/> - 这啦折啦折扣信息分享平台</title>
	<link href="/style/base.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="/style/general.css" type="text/css"/>
	<script type="text/javascript" src="/scripts/jquery-1.3.2.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="/scripts/jquery.cookie.js" charset="utf-8"></script>
</head>
<script>
function createSelect(container,data,id,prestr,name){
	var select = $("<select name='"+name+"' id='"+prestr+id+"'></select>");
	select.append("<option value='0'>全部类别</option>");
	for(var i in data){
		$(select).append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
	}
	$(container+" select:last").after(select);
	bindChange(prestr + id);
}
function getCategory(obj){
	var select_s = $(obj+" select option:selected");
	var before = "全部类别";
	var current = "全部类别";
	var len = select_s.length;
	for(var i=0;i<len;i++){
		current = $(select_s.get(i)).text();
		if(current!=null&&current!="全部类别"){
			before = current;
		}
	}
	return before;
}
function bindChange(id,container,prestr,child_select,name){
	$(id).bind("change",function(event){
		var father_id = parseInt($(id+' option:selected').val());
		$(id+" ~ select").each(function(){
			$(this).remove();
		}) 
		if(father_id>0){
			$.ajax( {
				type : "POST",
				url : "/admin/child_category.zl?f_id="+father_id,
				dataType:"json",
				cache : true,
				success : function(data, textStatus) {
					if(data.result=="success"){
						if(data.data.length>0){
							createSelect(container,data.data,father_id,prestr,name);
							try{
								if(child_select!=null&&child_select!=""){
									var _select_child = $(container+" select:last");
									$(_select_child).val(child_select);
									$(_select_child).change();
								}
							}catch(error){}
						}
					}
					if(data.result=="fail"){
						//showError("#sub_msg_div",data.msg);
					}
				}
			});
		}
		
	});
}
function bindArea(_province,_city,_city_id){
	$(_province).bind("change",function(event){
		var province_id = parseInt($(_province+' option:selected').val());
		if(province_id>0){
			$.ajax( {
				type : "POST",
				url : "/loadcity.zl?province_id="+province_id,
				dataType:"json",
				cache : true,
				success : function(data, textStatus) {
					if (textStatus == 'success') {
						$(_city).empty();
						$(_city).append('<option value="-1" selected="selected">全部地区</option>');
						try{
							var options = '';
							for(var i=0;i<data.result.length;i++){
								options = options + '<option value="'+data.result[i].id+'">'+data.result[i].name+'</option>';
							}
							$(_city).append(options);
							//just for first load page to init the area information.
							if(_city_id!=null&&_city_id!=""){
								$(_city).val(_city_id);
								_city_id = null;
							}
						}catch(error){
						}
					}
				}
			});
		}else{
			$(_city).empty();
			$(_city).append('<option value="-1" selected="selected">全部地区</option>');
		}
	});
}
function setArea(city,province,toobj){
	var area_id = parseInt($(city).val());
	var area_str = "全部地区";
	if(area_id>0){
		area_str = $(city+' option:selected').text();
	}else{
		area_id = parseInt($(province).val());
		if(area_id>0){
			area_str = $(province+' option:selected').text();
		}
	}
	if(toobj!=null){
		$(toobj).attr("value",area_str);
	}
	return area_str;
}
function initAreas(obj,values){
	$(obj).val(values);
	$(obj).change();
}
function bindClear(obj1,obj2){
	$(obj1).bind("click",function(event){
		event.preventDefault();
		var _c_button = $(obj2+" a").clone(true);
		$(obj2).empty();
		$(obj2).prepend(_c_button);
	});
}
function bindAddCategoryOrArea(bobj,clr,container,dest){
	$(bobj).bind("click",function(event){
		event.preventDefault();
		configNotice("更改了设置一定要记住点击右上角的保存哦 :)"); 
		var _area = "";
		if(dest=="area"){
			_area = setArea("#c_city","#c_province",null);
			if(_area=="全部地区"){
				$(clr).click();
			}
		}else{
			_area = getCategory("#configcategory");
			if(_area=="全部类别"){
				$(clr).click();
			}
		}
		var _area_exsit = $(container).text();
		if(dest=="area"){
			if(_area_exsit.indexOf("全部地区")>=0){
				$(clr).click();
			}
		}else{
			if(_area_exsit.indexOf("全部类别")>=0){
				$(clr).click();
			}
		}
		_area_exsit = $(container).text();
		if(_area_exsit.length==4){
			$(container).prepend(_area);
		}else{
			if(_area_exsit.indexOf(_area)<0){
				$(container).prepend(_area+",");
			}
		}
	});
}
function loadConfig(destobj){
	var text = $(destobj).text();
	text = text.replace("[设置]", "");
	return text;
}
function saveURL(){
	var my_areas_load = loadConfig("#care_area");
	var my_category_load = loadConfig("#care_category");
	var url = "/index.zl?x=c&area="+encodeURI(my_areas_load)+"&category="+encodeURI(my_category_load);
	$.cookie('zhelazhela.com_area_category', url,{expires:10});
	$.cookie('zhelazhela.com_area', my_areas_load,{expires:10});
	$.cookie('zhelazhela.com_category', my_category_load,{expires:10});
	return url;
}
function initConfig(){
	var changerss = false;
	var tmp_area_load = $.cookie('zhelazhela.com_area');
	if(tmp_area_load!=null&&tmp_area_load!=''){
		if($("#care_area").text().length==4){
			$("#care_area").prepend(tmp_area_load);
			changerss = true;
		}
	}
	var tmp_category_load = $.cookie('zhelazhela.com_category');
	if(tmp_category_load!=null&&tmp_category_load!=''){
		if($("#care_category").text().length==4){
			$("#care_category").prepend(tmp_category_load);
			changerss = true;
		}
	}
	$("#rss_link").attr("href","/rss.zl?area="+encodeURI(tmp_area_load)+"&category="+encodeURI(tmp_category_load));
}
function configNotice(msg){
	$("#config_notice").empty();
	$("#config_notice").html(msg);
}
$(document).ready(function(){
	bindChange("#config_category_select0","#configcategory","#configcategory_child",'',"c_category_child");
	bindArea("#c_province","#c_city","-1");
	bindAddCategoryOrArea("#c_add_area","#c_clear_area","#care_area","area");
	bindAddCategoryOrArea("#c_add_category","#c_clear_category","#care_category","category");
	bindClear("#c_clear_area","#care_area");
	bindClear("#c_clear_category","#care_category");
	$("#s_conf").bind("click",function(event){
		event.preventDefault();
		configNotice("<b>[订阅信息]</b>也会根据您的设置发生改变,别忘记重新订阅哦");
		$("#c_conf").click();
		setTimeout(function(){window.location.href=saveURL();},2000);
	});
	<s:if test="(#session.c_categorys!=null&&#session.c_categorys!='')||(#session.c_areas!=null&&#session.c_areas!='')">
	saveURL();
	</s:if>
});
</script>
<body>
<div id="wrap">
<table class="pop_content">
	<tr><td class="corner_1"></td><td></td><td class="corner_2"></td></tr>
    <tr><td></td><td>
    <div class="content">
    	<div class="bar">
        	<span>设置您关注的地区以及类别</span><div class="pop_right"><a href="#" id="s_conf">[保存]</a> <a href="#" id="c_conf">[关闭]</a></div>
        </div>
        <div class="titleline">
        	<div class="t_head">关注区域:</div>
            <div class="words" id="care_area"><s:property value="#session.c_areas"/><a id="oc_area" href="#">[设置]</a></div>
        </div>
        <div class="titleline" id="addarea">
        	<div class="adding">
        	<select id="c_province">
        		<option value="-1" selected="selected">全部地区</option>
        	<s:iterator value="provinces">
        		<option value='<s:property value="id"/>'><s:property value="name"/></option>
	        </s:iterator>
        	</select>
        	<select id="c_city">
        		<option value="-1" selected="selected">全部地区</option>
        	</select>
            <a href="#" id="c_add_area">增加</a><a href="#" id="c_clear_area">清除</a>
        	</div>
        </div>
        <div class="titleline">
        	<div class="t_head">关注类别:</div>
        	<div class="words" id="care_category"><s:property value="#session.c_categorys"/><a id="oc_category" href="#">[设置]</a></div>
         </div>
        <div class="titleline" id="addcategory">
        	<div class="adding" id="configcategory">
        	<select id="config_category_select0">
        		<option value='0' select='selected'>全部类别</option>
	            <s:iterator value="categorys">
	            <option value='<s:property value="id"/>'><s:property value="name"/></option>
	            </s:iterator>
        	</select>
            <a href="#" id="c_add_category">增加</a><a href="#" id="c_clear_category">清除</a>
        	</div>
        </div>
        <div class="titleline unconfig" id="config_notice">如果您想查看所有的折扣信息,可以点左上角的LOGO查看哟&gt;.&lt;</div>
        <div class="clear" style="height:5px;"></div>
    </div>
    </td><td></td></tr>
    <tr><td class="corner_4"></td><td></td><td class="corner_3"></td></tr>
</table>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
    <div id="content">
    	<div class="left">
<tiles:insertAttribute name="left"></tiles:insertAttribute>
    	</div>
    	<div class="right">
<tiles:insertAttribute name="right"></tiles:insertAttribute>
    	</div>
    	<div class="clear"></div>
    </div>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	<div class="count_web">
		<a href="http://www.linezing.com"><img src="http://img.tongji.linezing.com/1445848/tongji.gif"/></a>
	</div>
</div>
</body>
</html>