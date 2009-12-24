// JavaScript Document
function redirectAdminLogin(){
	window.location.href="/admin/login.zl"; 
}
function showError(id,msg){
	var e_div = $('<div class="error_info">'+msg+'</div>');
	e_div.appendTo($(id));
}
function showSuccess(id,msg){
	var e_div = $('<div class="success_info">'+msg+'</div>');
	e_div.appendTo($(id));
}