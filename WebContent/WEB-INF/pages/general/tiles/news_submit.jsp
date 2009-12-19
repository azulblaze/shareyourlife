<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<form action="news_submit.zl" method="post">
<div>
新闻标题<input type="text" name="dnews.newsTitle"/>
</div>

<div>
新闻来源<input type="text" name="dnews.newsSource"/>
</div>

<div>
您的网名<input type="text" name="dnews.senderName"/>
</div>

<div>
您的个人主页<input type="text" name="dnews.senderLink"/>
</div>

<div>
您的邮箱<input type="text" name="dnews.senderMail"/>
</div>

<div>
<input type="hidden" name="dnews.pId" value="1"/>
折扣商家<select><option>淘宝商城</option><option>新蛋科技</option></select><input type="button" value="增加"/>
</div>
<div>
<input type="hidden" name="dnews.discountCategory" value="电子产品,服装"/>
商品类别<select><option>所有产品</option><option>电子产品</option></select><input type="button" value="增加"/>
</div>
<div>
<input type="hidden" name="dnews.discountArea" value="成都">
打折范围：省份<select><option>所有地区</option><option>四川</option><option>湖南</option></select>市<select><option>成都</option><option>绵阳</option><option>自贡</option></select><input type="button" value="增加"/>
</div>

<div>
打折开始时间<input type="text" name="dnews.discountStart"/>结束时间<input type="text" name="dnews.discountEnd"/>
</div>

<div>
新闻概要部分(尽量简明概要):<br />
<textarea name="dnews.newsReview"></textarea>
</div>

<div>
新闻详细信息(总长度不超过10000字):<br />
<textarea name="dnews.newsContent"></textarea>
</div>
<div>
<img src="/code.zl?sessionName=validate_code"/>
<input name="validate_code" type="text">
</div>
<input type="submit" value="提交"/>
</form>