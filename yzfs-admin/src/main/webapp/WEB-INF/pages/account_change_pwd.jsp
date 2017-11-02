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

<title>博华管理系统 | 博华办公</title>

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

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="login">
	<div class="Header">
		<img src="${contextPath}/static/image/elogo.png" /> <span
			class="Fonts">博华管理后台</span>
		<p class="Fonts_p">TongYiChuangKeGuanLiHouTai</p>
	</div>
	<!-- BEGIN LOGO -->

	<div class="Body">
		<img src="${contextPath}/static/image/bg_pic.png" class="bg_pic" />
		<div class="content " style="padding-top: 1rem" id="Con_login">

			<!-- BEGIN LOGIN FORM -->

			<form id="change_pwd_form">
				<h3 class="form-title" style="color: #333">修改你的密码</h3>

				<div class="alert alert-error hide">

					<button class="close" data-dismiss="alert"></button>

					<span style="color: #333">请输入密码</span>

				</div>

				<div class="control-group">
					<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->

					<label class="control-label visible-ie8 visible-ie9"
						style="color: #333">旧密码</label>

					<div class="controls">

						<div class="input-icon left">
							<i class="icon-user"></i> <input
								class="m-wrap placeholder-no-fix" required="required"
								type="password" placeholder="旧密码" name="oldPwd" />
						</div>

					</div>

				</div>

				<div class="control-group">
					<label class="control-label visible-ie8 visible-ie9">确认密码</label>

					<div class="controls">

						<div class="input-icon left">
							<i class="icon-lock"></i> <input
								class="m-wrap placeholder-no-fix" required="required"
								type="password" placeholder="确认密码" name="surePwd" />
						</div>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label visible-ie8 visible-ie9">新密码</label>

					<div class="controls">

						<div class="input-icon left">
							<i class="icon-lock"></i> <input
								class="m-wrap placeholder-no-fix" required="required"
								type="password" placeholder="新密码" name="newPwd" />
						</div>
					</div>
				</div>

				<div id="login_err_msg" style="color: red;"></div>

				<div class="form-actions"></div>

				<button type="button" id="btn_change_pwd" class="btn blue"
					style="width: 100%">修改密码</button>

			</form>

			<!-- END LOGIN FORM -->

			<!-- BEGIN FORGOT PASSWORD FORM -->



			<!-- END FORGOT PASSWORD FORM -->

			<!-- BEGIN REGISTRATION FORM -->



			<!-- END REGISTRATION FORM -->

		</div>
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
        $("#btn_change_pwd").click(function(){
            var isOk=true;var $this=$(this);
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
            var oldPwd=$("input[name=oldPwd]").val();
            var surePwd=$("input[name=surePwd]").val();
            var newPwd=$("input[name=newPwd]").val();
            
            if (newPwd!=surePwd) {
            	isOk=false;
            	$("#login_err_msg").html("两次输入的密码不一致");
			}
            if (oldPwd==newPwd) {
            	isOk=false;
            	$("#login_err_msg").html("新旧密码不可以相同");
			}
			
            if (!isOk) { return false; }
			$this.attr("disabled",true);
			//登录
			$.ajax({
	    		url:'${contextPath}/change_pwd',
	    		data:$("#change_pwd_form").serialize(),
	    		type:"post",
	    		success:function(result){
	    			if(result.code == 0){
		    			alert("密码修改成功，请重新登录");
	    				window.location.href="${contextPath}/login";
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
       	 	$("#btn_change_pwd").click();
       	 }
      });
    });   
</script>

	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>