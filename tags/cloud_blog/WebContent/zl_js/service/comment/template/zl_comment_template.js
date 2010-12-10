var zl_domain="http://zhelazhela.com/";
var post_comment_addr = zl_domain+"api/services/comments/post/zlIDzl";
var get_comment_addr = zl_domain+"api/services/comments/zlIDzl/";
var zl_head=document.getElementsByTagName('HEAD').item(0);
var zl_style=document.createElement('link');
zl_style.href=zl_domain+"zl_css/zl_css.css";
zl_style.rel='stylesheet';
zl_style.type='text/css';
zl_head.appendChild(zl_style);
var zl_dom = '<div id="zl_container">'
+'<form id="zl_form" name="zl_form" method="post" action="#public">'
+'<div id="zl_info">'
+'<div><Strong><a href="zhelazhela.com">ZHELA评论</a></strong>欢迎使用ZHELA评论系统</div>'
+'</div>'
+'<ul>'
+'<li id="zl_display_name">'
+'<label for="zl_username" class="zl_label">'
+'名字'
+'<span>*</span>'
+'</label>'
+'<div>'
+'<input id="zl_username" name="username" size="38" tabindex="1" type="text">'
+'</div>'
+'<p style="clear:both;"></p>'
+'</li>'
+'<li id="zl_login" style="display:none;">'
+'<label for="zl_account" class="zl_label">'
+'登录'
+'<span>*</span>'
+'</label>'
+'<span class="zl_login_label">'
+'<input id="zl_account" class="zl_login_label" name="account" tabindex="2" type="text">'
+'<label for="zl_account" class="zl_login_label">帐号</label>'
+'</span>'
+'<span class="zl_login_label">'
+'<input id="zl_password" class="zl_login_label" name="password" tabindex="3"type="password">'
+'<label for="zl_password" class="zl_login_label">密码</label>'
+'</span>'
+'<p style="clear:both;"></p>'
+'</li>'
+'<li id="zl_comment">'
+'<label for="zl_content" class="zl_label">'
+'评论'
+'<span>*</span>'
+'</label>'
+'<div>'
+'<textarea id="zl_content" name="content" tabindex="4" rows="3" ></textarea>'
+'</div>'
+'<p style="clear:both;"></p>'
+'</li>'
+'<li>'
+'<div>'
+'<input id="zl_submit" name="zl_submit" class="zl_button" value="提交" type="button">'
+'</div>'
+'</li>'
+'<p style="clear:both;"></p>'
+'</ul>'
+'</form>'
+'<ul id="zl_list">'
+'</ul>'
+'</div>';
document.write(zl_dom);
zl_dom="";
document.write("<script src='"+zl_domain+"zl_js/zl_dom.js'></script>");