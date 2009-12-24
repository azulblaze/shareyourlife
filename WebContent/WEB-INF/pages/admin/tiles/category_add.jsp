<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    <div id="content">
    	<div class="line firstline">
    		<div class="input">
    			<div class="label">父类:</div>
    			<select id="category_select">
    				<option value='-1'>全部类别</option>
            </select>
            <select id="category_select">
    				<option value='-1'>全部类别</option>
            </select>
    		</div>
    		<div class="notice"><em>(必填*)</em>您必须选择一个父类来创建子类，如果您希望创建最顶层的类别，请选择[全部类别]</div>
      </div>
      <div class="line">
    		<div class="input"><div class="label">类别名称:</div><input type="text" value="" class="w200"/></div>
    		<div class="notice"><em>(必填*)</em>类别的名称。</div>
      </div>
      <div class="line">
      	<div class="input">
      		<div class="label">类别的基本描述</div>
      			<div class="spec"><em>(必填*)</em>类别的基本描述，比如包含大概什么商品等等...</div>
            </div>
            <div class="news_content"><textarea name="dnews.newsContent" id="news_content"></textarea></div>
      </div>
      <div class="line">
      	<div class="error_info"><s:property value="error"/></div>
		</div>
		<div class="big_sbumit">
			<input type="submit" value="确认增加" />
		</div>
    </div>