/*
* jquery.display
*
* andy chen
*/
(function($) {
  $.fn.displayqiezi = function(options) {
	  options = $.extend({
		dataType: "json",
		delay: 5000,
		qiezi:0,
		day:0.25,
		extStr:"",
		progressUrl: "/view_times.do",
		success: function() {},
	  }, options);
	  function display(){
		  if(options.qiezi<1||loadcookie()){
			  return;
		  }
		  cookie();
		  $.ajax({
			   type: "GET",
			   url:options.progressUrl,
			   dataType:"json",
			   data:"id_picture="+options.qiezi,
			   success: function(data){
				 options.success(data);
			   }
		  });
	  }
	  function cookie(){
		  $.cookie('myqiezi.com'+options.qiezi+options.extStr, 'true',options.day);
	  }
	  function loadcookie(){
		  if($.cookie('myqiezi.com'+options.qiezi+options.extStr)){
		  	return true;
		  }
		  return false;
	  }
	  return $(function() {
	   	   window.setTimeout(function(){display();},options.delay);
	  });
  }
})(jQuery);
