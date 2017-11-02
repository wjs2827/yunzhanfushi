/**
 * == OhSnap!.js ==
 * A simple jQuery/Zepto notification library designed to be used in mobile apps
 *
 * author: Justin Domingue
 * date: september 5, 2013
 * version: 0.1.2
 * copyright - nice copyright over here
 */

function ohSnap(text, color, icon) {
  // text : message to show (HTML tag allowed)
  // Available colors : red, green, blue, orange, yellow --- add your own!
  
  // Set some variables
  var time = '1000';
  var $container = $('#ohsnap');
  
  var icon_markup = "";
  
  if(icon) {
    icon_markup = "<span class='" + icon + "'></span> ";  
  }
  
  // Generate the HTML
  var html = $('<div class="alert alert-' + color + '">' + icon_markup + text + '</div>');

  // Append the label to the container
  $container.append(html);

  // Remove the notification on click
  //html.on('click', function () { ohSnapX($(this)); });
  
  // After 'time' seconds, the animation fades out
  setTimeout(function () {
    ohSnapX($container.children('.alert').first());
  }, time);
}

function ohSnapX(element) {
  // Called without argument, the function removes all alerts
  // element must be a jQuery object
  
  if (typeof element !== "undefined" ) {
    element.remove();
  } else {
    $('.alert').remove();
  }
}

//图片的绝对路径
var contextPath = $("link[rel=stylesheet]").first().attr("href");
contextPath = contextPath.substring(0,contextPath.indexOf("/", 1));

/*加载中*/

function  onDialog(){
	var $container=$('#publicDiload');
	var html ='<div class="modal-dialog-class"></div>';
	html+='<div  class="diloagClass" tabindex="-1" data-backdrop="static" data-keyboard="false">';
	html+='<img src="/yzfs-admin/static/image/loading.gif" class="dialog-img">';
	html+='</div>';
	$container.append(html);
    $(".modal-dialog-class").css({display:'block'});
    $(".diloagClass").css({display:'block'});
}

/*取消加载中*/

function  offDialog(){
    $(".modal-dialog-class").css({display:'none'});
    $(".diloagClass").css({display:'none'});
}






