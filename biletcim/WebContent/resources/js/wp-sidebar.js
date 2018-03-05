$(".navbar-toggle").click(function () {
    $("body").toggleClass("open-wp-navbar");
});
 $(window).bind("load resize", function () {
    var height = $(".wp-sidebar-nav").height();
    
    $("#page-wrapper").css("min-height", (height) + "px");
});

$(document).ready(function () {
    $('ul.nav-second-level > li > a').click(function () {
        var current = $(this).siblings('ul.nav-third-level');
        $('ul.nav-third-level').not(current).slideUp();
        current.slideToggle();
    });
    var selector = 'ul.nav-second-level > li > a';
    $(selector).on('click', function () {
        $(selector).removeClass('dwn');
        $(this).addClass('dwn');
    });
    //    $( 'ul.nav-second-level > li' ).hover(
    //        function(){
    //            $(this).children('ul.nav-third-level').slideDown(200);
    //        },
    //        function(){
    //            $(this).children('ul.nav-third-level').slideUp(200);
    //        }
    //    );
});