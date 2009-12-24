/*
* jquery.uploadProgress
*
* Copyright (c) 2008 Piotr Sarnacki (drogomir.com)
*
* Licensed under the MIT license:
* http://www.opensource.org/licenses/mit-license.php
*
*/
(function($) {
  $.fn.uploadAjax = function(options) {
	  options = $.extend({
	    dataType: "json",
		frameName:"uploadFrame",
	  }, options);
	  $(function() {
		iframe = document.createElement('iframe');
	    iframe.name = options.frameName;
	    $(iframe).attr("id",options.frameName);
	    $(iframe).css({width: '0', height: '0',display:'none'});
	    document.body.appendChild(iframe);
	    window.frames[options.frameName].innerHTML="ddd";
	    alert($(window.frames[options.frameName]).val());
	  });
	  return this.each(function(){
		$(this).attr({target:iframe.name});
	    $(this).bind('submit', function() {
	    	
	    });
	  });
  };
})(jQuery);
