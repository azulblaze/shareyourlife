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
  $.fn.uploadProgress = function(options) {
  options = $.extend({
    dataType: "json",
    interval: 2000,
    progressUrl: "/progress",
    start: function() {},
    uploading: function() {},
    complete: function() {},
    success: function() {},
    error: function() {},
	frameName:"progressFrame",
    timer: ""
  }, options);
  
  $(function() {
	iframe = document.createElement('iframe');
    iframe.name = options.frameName;
    $(iframe).css({width: '0', height: '0',display:'none'});
    document.body.appendChild(iframe);
  });
  
  return this.each(function(){
	$(this).attr({target:iframe.name});
    $(this).bind('submit', function() {
      var uuid = "";
      for (i = 0; i < 32; i++) { uuid += Math.floor(Math.random() * 16).toString(16); }
      
      /* update uuid */
      options.uuid = uuid;
      /* start callback */
      options.start();
 
      /* patch the form-action tag to include the progress-id if X-Progress-ID has been already added just replace it */
      if(old_id = /XProgressID=([^&]+)/.exec($(this).attr("action"))) {
        var action = $(this).attr("action").replace(old_id[1], uuid);
        $(this).attr("action", action);
      } else {
       $(this).attr("action", jQuery(this).attr("action") + "?XProgressID=" + uuid);
      }
      var uploadProgress = jQuery.uploadProgress;
      options.timer = window.setInterval(function() { uploadProgress(this, options) }, options.interval);
    });
  });
  };
  function clearSession(options){
	  $.ajax({
			type: "GET",
			cache:false,
   			url: options.progressUrl+"?XProgressID=" + options.uuid+"&clear=true",
		});
  };
jQuery.uploadProgress = function(e, options) {
  jQuery.ajax({
    type: "GET",
	cache:false,
    url: options.progressUrl+"?XProgressID=" + options.uuid,
    dataType: options.dataType,
    success: function(upload) {
      if (upload.state == 'uploading') {        
        options.uploading(upload);
      }
      if (upload.state == 'done' || upload.state == 'error') {
        options.complete(upload);
      }
      if (upload.state == 'done') {
		if(upload.picture!=null&&upload.picture.status!='unloaded'){
			clearSession(options);
			window.clearInterval(options.timer);
		}
        options.success(upload);
      }
      if (upload.state == 'error') {
		window.clearInterval(options.timer);
		clearSession(options);
        options.error(upload);
      }
    }
  });
};
 
})(jQuery);
