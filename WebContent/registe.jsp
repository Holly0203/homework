<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册界面</title>
<link href="css/registe.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- 头部块 -->
	<div class="header">
		<img src="picture/logo.png">
		<!-- 分割线 -->
		<hr>
		<div class="content">
			<!-- 左侧图片块 -->
			<div class="picture">
				<img src="picture/bg1.jpg">
			</div>
			<!-- 注册块 -->
			<div class="register">
				<!-- 创建一个表单  -->
				<form action="<%=request.getContextPath()%>/RS" id="registForm"
					method="post" class="form-inline" name="frm">
					<!-- 1. lable是html的一种标签，常用在input的前边或者后边。
				2.  标签为 input 元素定义标注（标记）。
				3. label 元素不会向用户呈现任何特殊效果。不过，它为鼠标用户改进了可用性。如果您在 label 元素内点击文本，就会触发此控件。就是说，当用户选择该标签时，浏览器就会自动将焦点转到和标签相关的表单控件上。
				4.  标签的 for 属性应当与相关元素的 id 属性相同 -->
					<label><h3>注册</h3></label><br> <br>
					<!-- 输入手机号的块 -->
					<div class="form-group">
						<input type="text" name="formetext" class="form-control"
							id="phone" onblur="ifexist()" value="" placeholder="请输入手机号">
						<!-- <div class="tip" style="color: #F00" hidden="true">该号码已被注册</div> -->
					</div> 
					<br>
					<div class="form-group">
						<input type="text" class="form-control" id="exampleInputEmail3" name="codehh"
							value="" placeholder="请输入验证码">
							<h1 onclick="clickyz(this)"><button type="button" id="rcbtn" class="receivecode">获取验证码</button></h1>
						<!-- <div hidden="true" id="showcode" style="font-size: 24px"></div>
						<div hidden="true" class="pwcodeinput">
							<img height="47" width="100" src="picture/idengtify.png">
							<h5>看不清，换一张</h5>
							<input type="text" class="form-control" id="writepwcode" value="" />
						</div> -->

					</div>
					<br>
					<div class="form-group">
						<input type="password" name="passwordtext" class="form-control"
							id="password" value="" placeholder="请输入密码">
					</div>
					<br>
					<div class="checkbox">
						<label> <input type="checkbox" name="checkbox">我已阅读并同意<a
							href="https://www.baidu.com/duty/yinsiquan.html">《用户注册协议》</a>
						</label>
					</div>
					<br>
					<button type="button" id="formsubmit" 
						class="btn btn-default">提交</button>
				</form>
			</div>
		</div>
</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	var newcode = Math.floor(Math.random() * 10000);
	function ifexist() {
		var newphone = $('#phone').val();
		console.log(newphone);
		if (!(/^1[34578]\d{9}$/.test(newphone))) {
			alert("手机号码有误，请重填");	
		}
		var newpassword = $('#password').val();
		console.log(newpassword);
		if (!(/^.*(?=.{4,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/.test(newpassword))) {
			alert("密码最少4位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符");			
		}
	}
	document.getElementById('showcode').innerHTML = newcode;
	var providecode = $('#showcode').html();
	$('#formsubmit').click(function() {
		console.log($('exampleInputEmail3').val())
		$.ajax({
			url : '/HomeWork/RegisterServlet',
			type : 'post',
			data : {
				"phone" : $('#phone').val(),
				"passwordtext":$('#password').val(),
				"codehh":$('#exampleInputEmail3').val(),
				"providecode" : providecode,
			},
			success : function(data) {
			location.href="login.jsp"
			}

		});
	});
	var newrcbtn = $('#rcbtn').val();
	console.log(newrcbtn);
	if (!(newcode.test(newrcbtn))) {
		alert("验证码输入错误");
		var countdown = 1;
	}
	function clickyz(rcbtn)
	{
	alert("验证码是"+newcode);
	} 
</script>

</html>