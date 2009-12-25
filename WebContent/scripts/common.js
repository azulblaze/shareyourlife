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
function writePage(size,current,bar,action){
	var start = (current-3)>1?(current-3):1;
	var end = (current+3)>size?size:(current+3);
	var Str = "";
	for(var i=start;i<=end;i++){
		if(i==current){
			Str = Str + ' <strong>'+i+'</strong>';
		}else{
			Str = Str + ' <a href="'+action+i+'">'+i+'</a>';
		}
	}
	$(bar).append(Str);
}