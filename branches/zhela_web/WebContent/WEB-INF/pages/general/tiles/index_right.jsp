<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
$(document).ready(function(){
	bindChange("#search_category_select0","#searchcategory","#searchcategory_child",'<s:property value="#session.s_category_child"/>',"s_category_child");
	$("#search_category_select0").val('<s:property value="#session.fathercategory"/>');
	$("#search_category_select0").change();
	bindArea("#s_province","#s_city",'<s:property value="#session.s_city_id"/>');
	<s:if test="#session.s_province_id!=null&&#session.s_province_id>-1">
	initAreas("#s_province",'<s:property value="#session.s_province_id"/>');
	</s:if>
	$("#search_submit").bind("click",function(event){
		event.preventDefault();
		setArea('#s_city','#s_province',"#search_discountArea");
		$("#search_discountCategory").val(getCategory("#searchcategory"));
		if($("#s_key").val()==null||$("#s_key").val()==""){
			$("#s_key").css("border","1px solid red");
			return;
		}
		$("#seach_form").submit();
	})
});
</script>

        	<div class="search">
        		<form action="/index.zl" method="get" id="seach_form">
            	<h3>搜索折扣</h3>
                <div class="title_row">
                	<span>关键字</span><input id="s_key" type="text" name="keyword" value='<s:property value="#session.keyword"/>'/>
                </div>
                <div class="title_row">
                	<div><span>地&nbsp;&nbsp;&nbsp;区</span></div>
                	<div class="area_select">
	                	<select id="s_province" name="s_province_id">
	                    	<option value="-1" selected="selected">全部地区</option>
	                    <s:iterator value="provinces">
	                    	<option value='<s:property value="id"/>'><s:property value="name"/></option>
	                    </s:iterator>
	                    </select>
	                    <select id="s_city" name="s_city_id">
	                    	<option value="-1" selected="selected">全部地区</option>
	                    </select>
                    </div>
                	<input type="hidden" id="search_discountArea" name="area" value="<s:property value='area'/>"/>
                </div>
                <div class="clear"></div>
                <div class="title_row">
                	<div><span>类&nbsp;&nbsp;&nbsp;别</span></div>
                	<div class="area_select"  id="searchcategory">
	                	<select id="search_category_select0" name="fathercategory">
	                    	<option value='0' select='selected'>全部类别</option>
	                    <s:iterator value="categorys">
	                    	<option value='<s:property value="id"/>'><s:property value="name"/></option>
	                    </s:iterator>
	                    </select>
                    </div>
                	<input type="hidden" id="search_discountCategory" name="category" value="<s:property value='category'/>"/>
                	<input type="hidden" name="andstr" value="1"/>
                </div>
                <div class="s_button">
                	<a href="#" id="search_submit"><img src="/images/search_b.png" /></a>
                </div>
                </form>
                <div class="clear"></div>
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
                </ul>
            </div>
            <div class="right_box" style="display:none;">
            	<div class="title">链接</div>
                <ul class="link">
                	<li><a href="#">小众软件</a></li>
                </ul>
            </div>
            <div class="clear"></div>
