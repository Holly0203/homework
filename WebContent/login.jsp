<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
<link href="css/registe.css" rel="stylesheet" type="text/css" />
</head>
<body>
		<!-- 插入图片块 -->
		<div class="header">
		<img src="picture/logo.png">
		<!-- 分割线 -->
		<hr>
		<!-- 中间大模块 -->
		<div class="content">
		<!-- 左侧图片块 -->
		<div  class="picture" >
			<img src="picture/bg1.jpg">
		</div>
		<!-- 注册块 -->
		<div  class="register">
			<!-- 创建一个表单  -->
			<form action="LS" class="form-inline" name="frm">
				<label><h3>登录</h3></label><br> <br>
				<!-- 输入手机号的块 -->
				<div class="form-group">
					<input type="text" name= "lformetext" class="form-control" id="phone"
						onblur="ifexist()" value="" placeholder="请输入手机号">
				</div>
				<br> <br>
				<div class="form-group">
					<input type="password" name ="lpasswordtext" class="form-control" id="password" value=""
						placeholder="请输入密码">
				</div>
				<br> <br>
				<a href="registe.jsp">快速注册</a>
				<br><br>
				<button type="submit"  class="btn btn-default">登录</button>
			</form>
		</div>
	</div>
</body>
</html>