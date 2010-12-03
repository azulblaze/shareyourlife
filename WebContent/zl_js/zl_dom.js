var zl_domain="http://zhelazhela.com/";
function newXMLHttpRequest() {
	var xmlreq = false;
	if (window.XMLHttpRequest) {
		xmlreq = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try { 
			xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) { 
			try {
				xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) {
			} 
		}
	}
	return xmlreq;
} 
var submit = document.getElementById("zl_submit");
var zl_display_name = document.getElementById("zl_display_name");
var zl_comment = document.getElementById("zl_comment");
var zl_list = document.getElementById("zl_list");
var post_comment_addr = zl_domain+"api/services/comments/post/129134358831101";
var post_request = newXMLHttpRequest();
var get_request = newXMLHttpRequest();
var get_comment_addr = zl_domain+"api/services/comments/129134358831101/";
var web_url = location.href;
if(web_url.substring(0,7)=="http://"){
	web_url= web_url.substring(7);
}
if(web_url.substring(0,8)=="https://"){
	web_url= web_url.substring(8);
}
if(web_url.substring(0,4)=="www."){
	web_url= web_url.substring(4);
}
function createLine(_json){
	var _utime = _json.update_time;
	return '<li><label>'+_json.username+'<span>( '+_utime.substring(0,10)+' '+_utime.substring(11,19)+' )</span></lable><div>'+_json.content+'</div></li>'
}
var ZLappendComment = function(json_text) {
	try{
		var json = eval('(' + json_text + ')');
		if(json!=null&&json.username!=null){
			zl_list.innerHTML = createLine(json) + zl_list.innerHTML;
		}
	}catch(error){
	}
}
function ZLappendScript(address){
	var zl_head = document.getElementsByTagName('HEAD').item(0);
    var zl_script = document.createElement("script");
    zl_script.type = "text/javascript";
    zl_script.src=address;
    zl_head.appendChild(zl_script); 
}
function post_comment(nickname,content){
	var params = encodeURI("t="+new Date().getTime()+"&u="+web_url+"&dn="+nickname+"&c="+content);
	ZLappendScript(post_comment_addr+"?"+params);
}
var ZLloadComment = function(json_text) {
	try{
		var json = eval('(' + json_text + ')');
		var _tmpcontent = "";
		for(var i=0;i<json.s_comments.length;i++){
			_tmpcontent = _tmpcontent + createLine(json.s_comments[i]);
		}
		if(_tmpcontent!=""){
			_tmpcontent = _tmpcontent + '<li class="page">';
			if(json.lastPage>0){
				_tmpcontent = _tmpcontent+ '<a href="javascript:'+'get_comment('+json.lastPage+')'+'">上一页</a>'
			}
			if(json.nextPage>0){
				_tmpcontent = _tmpcontent+ '<a href="javascript:'+'get_comment('+json.nextPage+')'+'">下一页</a>'
			}
			_tmpcontent = _tmpcontent + '</li>';
			zl_list.innerHTML = _tmpcontent;
		}else{
			zl_list.innerHTML = "";
		}
	}catch(error){
	}
 }
function get_comment(page){
	ZLappendScript(encodeURI(get_comment_addr+page+"?u="+web_url+"&t="+new Date().getTime()));
	//get_request.open("GET", encodeURI(get_comment_addr+page+"?u="+web_url+"&t="+new Date().getTime()), true);
	//get_request.onreadystatechange = loadComment;
	//get_request.send(null);
}
get_comment(1);

function clearFocuse(){
	zl_display_name.setAttribute("class","");
	zl_display_name.setAttribute("className","");
	zl_comment.setAttribute("class","");
	zl_comment.setAttribute("className","");
};
submit.onclick = function(){
	clearFocuse();
	var dn = document.getElementById("zl_username").value;
	if(dn==""||dn.replace(/^\s+|\s+$/g, '')==""){
		zl_display_name.setAttribute("class","zl_focused");
		zl_display_name.setAttribute("className","zl_focused");
		return;
	}
	var content = document.getElementById("zl_content").value;
	if(content==""||content.replace(/^\s+|\s+$/g, '')==""){
		zl_comment.setAttribute("class","zl_focused");
		zl_comment.setAttribute("className","zl_focused");
		return;
	}
	post_comment(dn,content);
	document.getElementById("zl_content").value="";
};