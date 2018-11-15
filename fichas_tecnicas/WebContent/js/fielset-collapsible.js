$.fn.collapse = function(options) {
	var defaults = {
		closed : false
	}
	settings = $.extend({}, defaults, options);

	return this.each(function() {
		var obj = $(this);
		obj.find("legend").addClass('collapse').click(function() {
			if (obj.hasClass('collapsed'))
				obj.removeClass('collapsed').addClass('collapse');
	
			$(this).removeClass('collapsed');
	
			obj.children().not('legend').toggle("slow", function() {
			 
				 if ($(this).is(":visible"))
					obj.find("legend").addClass('collapse');
				 else
					obj.addClass('collapsed').find("legend").addClass('collapsed');
			 });
		});
		if (settings.closed) {
			obj.addClass('collapsed').find("legend").addClass('collapsed');
			obj.children().filter("p,img,table,ul,div,span,h1,h2,h3,h4,h5").css('display', 'none');
		}
	});
};