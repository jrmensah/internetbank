// NAV TOGGLE

$(document).ready(function() {
  $('body').addClass('js');
  
  var $menu = $('#main-nav'),
		$menulink = $('.menu-button'),
		$login = $('#login'),
		$loginlink = $('.login-button'),
		$wrap = $('#wrap');
	
	$menulink.click(function() {
		$menulink.toggleClass('active');
		$login.toggleClass('push');
		$wrap.toggleClass('menu-active');
		return false;
	});
	
	$loginlink.click(function() {
		$loginlink.toggleClass('active');
		$menu.toggleClass('push');
		$wrap.toggleClass('login-active');
		$login.toggleClass('active');
		
		return false;
	});
});




if (matchMedia) {
  var mq = window.matchMedia("(min-width: 38em)");
  mq.addListener(WidthChange);
  WidthChange(mq);
}

// media query change
function WidthChange(mq) {
  if (mq.matches) {
    
$(document).ready(function() {
  
	function closeDropdown () {
    $('.top-level-list-item.dropdown-open').removeClass('dropdown-open');

   	$(document).unbind('click', closeDropdown); // Make sure we clean up the bind though
  }

  $('a.top-level-link').click(function (e) {
		e.preventDefault();
		e.stopPropagation();

		var $menu = $(this).parent(),
		    is_open = $menu.hasClass('dropdown-open');

		closeDropdown();

		if( ! is_open ) {
			$menu.addClass('dropdown-open');
			$open_menu_item = $menu;
      $(document).bind('click', closeDropdown); // This basically binds to every other element on the page.
    }
	});

	// Prevent closeDropdown from firing inside our dropdowns
	$('.dropdown-menu').on('click', function (e) { e.stopPropagation(); });
});		
  }
};