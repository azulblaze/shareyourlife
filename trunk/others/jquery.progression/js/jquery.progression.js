(function($) {
	$.fn.progression = function(options) {
		var opts = $.extend({
			Current: 50,
			Maximum: 100,
			Background: '#FFFFFF',
			TextColor: '#000000',
			aBackground: '#FF0000',
			aTextColor: '#FFFFFF',
			BorderColor: '#000000',
			Animate: true,
			AnimateTimeOut: 3000,
			Easing: 'linear',
			startFct : null,
			endFct : null
		}, $.fn.progression.defaults, options);
		if(options)
			var newCurrent = options.Current;
		return this.each(function() {
			$this = $(this);
			$innerdiv=$this.find(".progress");
			var o = $.metadata ? $.extend({}, opts, $this.metadata()) : opts;
			if($innerdiv.length!=1)
				BuildBarre($this, o);
			else
			{
				if(newCurrent)
					o.Current = newCurrent;
				o.Maximum = parseInt($this.attr('pmax'));
			}
			if( o.Current > o.Maximum )
			{
				return false;
			}
			var aWidth = Math.round(parseInt($this.attr('pcur'))/o.Maximum*100);
			var Width = Math.round(parseInt(o.Current)/o.Maximum*100);			
			if (typeof o.startFct == 'function')
				o.startFct(o);
			
			if(o.Animate)
			{
				var oldCurrent = parseInt($this.attr('pcur'));
				var Steps = Math.abs(oldCurrent - o.Current);
				var StepsTimeOut = Math.floor(o.AnimateTimeOut/o.Maximum);

				$innerdiv.queue("fx", []);
				$innerdiv.stop();
				$innerdiv.animate({ width: Width+"%" }, {
					duration: Math.round(StepsTimeOut*(Steps+1)), 
					queue: false, 
					easing: o.Easing,
					complete: function(){
						if (typeof o.endFct == 'function')
							o.endFct(o);
					} 
				});
				
				for (i=0; i<=Steps; i++) {
					$innerdiv.animate({opacity: 1},{
							duration: Math.round(StepsTimeOut*i), 
							queue: false, 
							complete: function(){
								if(oldCurrent<=o.Current)
									$(this).progressionSetTextTo(oldCurrent++);
								else
									$(this).progressionSetTextTo(oldCurrent--);
							}
					});
      			}
			}
			else
			{
				$innerdiv.css({ width: Width+'%' });
				$innerdiv.progressionSetTextTo(o.Current);
				
				if (typeof o.endFct == 'function')
					o.endFct(o);
			}
		});
	};
	function BuildBarre($this, o) {
		$this.html('');

		$this.css({
			textAlign: 'left',
			position: 'relative',
			overflow: 'hidden',
			backgroundColor: o.Background,
			borderColor: o.BorderColor,
			color: o.TextColor
		});
		if(o.Width)
			$this.css('width', o.Width);
		if(o.Height)
			$this.css({ height: o.Height, lineHeight: o.Height	});
		if(o.BackgroundImg)
			$this.css({ backgroundImage: 'url(' + o.BackgroundImg + ')' });
		
		$innerdiv=$("<div class='progress'></div>");					

		$("<div class='text'>&nbsp;</div>").css({
			position: 'absolute',
			width: '100%',
			height: '100%',
			textAlign: 'center'
		}).appendTo($this);

		$("<span class='text'>&nbsp;</span>")
			.css({
				position: 'absolute',
				width: $this.width(),
				textAlign: 'center'
			})
			.appendTo($innerdiv);
		
		$this.append($innerdiv);
		$innerdiv.css({
			position: 'absolute',
			width: 0,
			height: '100%',
			overflow: 'hidden',
			backgroundColor: o.aBackground,
			color: o.aTextColor
		});
		if(o.aBackgroundImg)
			$innerdiv.css({ backgroundImage: 'url(' + o.aBackgroundImg + ')' });

		$this.attr('pmax', o.Maximum);
		$this.attr('pcur', 0);
  	};
	$.fn.progressionSetTextTo = function(i) {		
		return this.each(function() {
			$this = $(this).parent();
			if($this.attr('pmax')!=100)	
				$this.find(".text").html(i+"/"+$this.attr('pmax'));
			else
				$this.find(".text").html(i+" %");
				
			$this.attr('pcur', i);
		});
	};
	function debug($txt) {
    	if (window.console && window.console.log)
      		window.console.log('jQuery Progression: ' + $txt);
  	};
  	

	$.fn.progression.defaults = {};

})(jQuery);