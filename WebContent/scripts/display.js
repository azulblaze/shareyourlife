/*
* jquery.display
*
* andy chen
*/
(function($) {
  $.fn.displayzhela = function(options) {
	  options = $.extend({
		dataType: "json",
		delay: 5000,
		zhelazhela:0,
		day:0.25,
		extStr:"",
		progressUrl: "/view_times.zl",
		success: function() {},
	  }, options);
	  function display(){
		  if(options.zhelazhela<1||loadcookie()){
			  return;
		  }
		  cookie();
		  $.ajax({
			   type: "GET",
			   url:options.progressUrl,
			   dataType:"json",
			   data:"dn_id="+options.zhelazhela,
			   success: function(data){
				 options.success(data);
			   }
		  });
	  }
	  function cookie(){
		  $.cookie('zhelazhela.com'+options.zhelazhela+options.extStr, 'true',options.day);
	  }
	  function loadcookie(){
		  if($.cookie('zhelazhela.com'+options.zhelazhela+options.extStr)){
		  	return true;
		  }
		  return false;
	  }
	  return $(function() {
	   	   window.setTimeout(function(){display();},options.delay);
	  });
  }
})(jQuery);
