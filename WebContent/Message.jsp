<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>消息详情页</title>
<link rel="stylesheet" 
      href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
   .context{
      margin:0 auto;
      border:1px solid #F00;
   }
</style> 
</head>
<body>
    <div class="header">
		<img src="picture/logo.png">
		<hr>
		<h3 align="center">消息详情</h3>
	</div>

   <div class="context">

      <form action="update" method="post">
          <c:forEach items="${news11}" var="n">
          文章序号:<input type="text" name="id" style="width:20px" value="${n.id}"><br><br>
		      消息标题：<input type="text" name="title" style="width:500px" value="${n.title}"><br><br>
		         消息正文：<input type="text" name="context" style="width:500px" value="${n.context}"><br><br>
		         发布日期：<input type="text" name="date" style="width:500px" value="${n.date}"><br><br>
		 </c:forEach>
		 <input type="submit" value="保存" >&nbsp;&nbsp;&nbsp;&nbsp;
		 <a href="new" >取消</a>
		 
   </div>

</body>
</html>