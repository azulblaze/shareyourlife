javascript:(function(){
	f='http://localhost:8080/sns/collection.zl?source='+encodeURIComponent(window.location.href);
	if(document.getElementById){
		window.win = window.open(f,'kartmev3','location=no,links=no,scrollbars=yes,toolbar=no,status=no,menubar=no,width=600,height=650');
	}
})();