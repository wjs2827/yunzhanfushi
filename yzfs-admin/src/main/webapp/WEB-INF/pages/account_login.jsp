<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<!--<![endif]-->

<!-- BEGIN HEAD -->
<html lang="en">
<head>

<meta charset="utf-8" />

<title>云展服饰管理系统</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />

<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="${contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<link href="${contextPath}/static/css/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />

<link href="${contextPath}/static/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />

<link href="${contextPath}/static/css/style-metro.css" rel="stylesheet"
	type="text/css" />

<link href="${contextPath}/static/css/style.css" rel="stylesheet"
	type="text/css" />

<link href="${contextPath}/static/css/style-responsive.css"
	rel="stylesheet" type="text/css" />

<link href="${contextPath}/static/css/default.css" rel="stylesheet"
	type="text/css" id="style_color" />

<link href="${contextPath}/static/css/uniform.default.css"
	rel="stylesheet" type="text/css" />

<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->

<link href="${contextPath}/static/css/login-soft.css" rel="stylesheet"
	type="text/css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="${contextPath}/static/image/favicon.ico" />
<style>
.footer {
	width: 100%;
	height: 5rem;
	background: #fff;
	position: fixed;
	font-size: 1rem;
	z-index: 5;
	bottom: 0
}

.body {
	overflow: hidden
}
</style>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="login">
	<div class="Header header-two">
		<img src="${contextPath}/static/image/elogo.png" style="width: 15%" />
		<span class="Fonts">云展服饰后台管理</span>
		<p class="Fonts_p">yun zhan fu shi hou tai guan li</p>
	</div>
	<!-- BEGIN LOGO -->

	<div class="Body">
		<%-- <img src="${contextPath}/static/image/bg_pic.png" class="bg_pic"/> --%>
		<div class="content " style="padding-top: 1rem" id="Con_login">

			<!-- BEGIN LOGIN FORM -->

			<form id="login_form">
				<h3 class="form-title" style="color: #333">登录你的账号</h3>

				<div class="alert alert-error hide">

					<button class="close" data-dismiss="alert"></button>

					<span style="color: #333">请输入用户名和密码</span>

				</div>

				<div class="control-group">
					<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->

					<label class="control-label visible-ie8 visible-ie9"
						style="color: #333">用户名</label>

					<div class="controls">

						<div class="input-icon left">
							<i class="icon-user" style='margin-top: 15px'></i> <input
								class="m-wrap placeholder-no-fix" required="required"
								type="text" style='height: 30px' placeholder="用户名"
								name="loginName" />
						</div>

					</div>

				</div>

				<div class="control-group">

					<label class="control-label visible-ie8 visible-ie9">密码</label>

					<div class="controls">

						<div class="input-icon left">

							<i class="icon-lock" style='margin-top: 15px'></i> <input
								class="m-wrap placeholder-no-fix" required="required"
								type="password" placeholder="密码" style='height: 30px'
								name="password" />

						</div>

					</div>

				</div>
				<div id="login_err_msg" style="color: red;"></div>
				<div class="form-actions">
					<label class="checkbox" style='margin-left: -15px;'> <input
						type="checkbox" name="remember" value="1"
						style="width: 30px; height: 30px; margin-right: 10px" /><span
						style="color: #333; margin-left: 20px">记住密码</span>
					</label>
				</div>

				<button type="button" id="btn_login" class="btn blue"
					style="width: 100%; height: 40px">登录</button>

			</form>

			<!-- END LOGIN FORM -->

			<!-- BEGIN FORGOT PASSWORD FORM -->



			<!-- END FORGOT PASSWORD FORM -->

			<!-- BEGIN REGISTRATION FORM -->



			<!-- END REGISTRATION FORM -->

		</div>
		<div class="footer"></div>
	</div>

	<!-- END LOGO -->

	<!-- BEGIN LOGIN -->



	<!-- END LOGIN -->

	<!-- BEGIN COPYRIGHT -->



	<!-- END COPYRIGHT -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="${contextPath}/static/js/jquery-1.10.1.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/jquery-migrate-1.2.1.min.js"
		type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="${contextPath}/static/js/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/bootstrap.min.js"
		type="text/javascript"></script>

	<!--[if lt IE 9]>

<script src="${contextPath}/static/js/excanvas.min.js"></script>

<script src="${contextPath}/static/js/respond.min.js"></script>

<![endif]-->

	<script src="${contextPath}/static/js/jquery.slimscroll.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/jquery.blockui.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/jquery.cookie.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/jquery.uniform.min.js"
		type="text/javascript"></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="${contextPath}/static/js/jquery.validate.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/jquery.backstretch.min.js"
		type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${contextPath}/static/js/app.js" type="text/javascript"></script>
	<script src="${contextPath}/static/js/security/base64.js"
		type="text/javascript"></script>
	<script src="${contextPath}/static/js/login-soft.js"
		type="text/javascript"></script>

	<!-- END PAGE LEVEL SCRIPTS -->

	<script>

    jQuery(document).ready(function() {

        App.init();
        Login.init();
        
        //登录按钮点击事件
        $("#btn_login").click(function(){
            var isOk=true;
            var $this=$(this);
            $("input[required=required]").each(function(){
				if ($(this).val()==null||$(this).val()==undefined||$(this).val()=="") {
					isOk=false;
					$("#login_err_msg").html($(this).attr("placeholder")+"不能为空!");
					return false;
				}else if($(this).val().indexOf(" ")!=-1){
					isOk=false;
					$("#login_err_msg").html($(this).attr("placeholder")+"不能包含空格!");
					return false;
				}
            });
            if (!isOk) { return false; }
			$this.attr("disabled",true);
			//登录
			$.ajax({
	    		url:'${contextPath}/login',
	    		data:$("#login_form").serialize(),
	    		type:"post",
	    		dataType:"json",
	    		success:function(result){
	    			if(result.code == 0){
	    				window.location.href="${contextPath}/admin/index";
	    			}else{
	    				$("#login_err_msg").html(result.message);
	    			}
	    			$this.attr("disabled",false);
	    	   },
	    	   error:function(){
	    		  $this.attr("disabled",false);
	    	   }
	    	});
        });

      //回车登录
      $("input[name=loginName],input[name=password]").on("keydown", function(event){
       	 if(event != null && event.keyCode == 13){
       	 	$("#btn_login").click();
       	 }
      });
    });   
</script>

	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>