<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="helloworld">Hello World</a>
	<br><br>
	
	<a href="springmvc/testRequestMapping">Test ReqestMapping</a>
	
	<br><br>
	
	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="提交">
	</form>
	
	<br><br>
	
	<a href="springmvc/testParamsAndHeaders?username=haha&age=10">Test ParamsAndHeaders</a>
	
	<br><br>
	
	<a href="springmvc/testAntPath/ggaa/abc">Test AntPath</a>
	
	<br><br>
	<a href="springmvc/testPathVariable">Test PathVariable</a>
	<br><br>
	<a href="springmvc/testRest/1">Test Rest Get</a>
	<br><br>
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="Test Rest POST">
	</form>
	
	<br><br>
	
	<form action="springmvc/testRestDelete/1" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="Test Rest Delete">
	</form>
	<br><br>
	<form action="springmvc/testRestPut/1" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="Test Rest Put">
	</form>
	<br><br>
	<a href="springmvc/testRequestParam?username&age=100">Test RequestParam</a>
	
	<br><br>
	<a href="springmvc/testRequestHeader">Test RequestHeader</a>
	
	<br><br>
	<a href="springmvc/testCookieValue">Test CookieValue</a>
	<br><br>
	<form action="springmvc/testPojo" method="post">
		username: <input type="text" name="username" /><br>
		password: <input type="password" name="password"/><br>
		email: <input type="text" name="email"/><br>
		age: <input type="text" name="age"/><br>
		province: <input type="text" name="address.province"/><br>
		city: <input type="text" name="address.city"/><br>
		<input type="submit" value="Submit" >
	</form>
	<br><br>
	<a href="springmvc/testModelAndView">Test ModelAndView</a>
	<br><br>
	<a href="springmvc/testMap">Test Map</a>
	
	<br><br>
	<a href="springmvc/testSessionAttributes">Test SessionAttributes</a>
	<!-- 模拟修改操作
		1.原始数据: 1, Tom, 123456, a@a.com, 12
		2.密码不能修改
		3.表单回显，模拟操作直接在表单填写对应的属性值
	 -->
	<br><br>
	<form action="springmvc/testModelAttribute" method="post">
		<input type="hidden" name="id" value="1" />
		username: <input type="text" name="username" value="Tome" /><br>
		email: <input type="text" name="email" value="a@a.com"/><br>
		age: <input type="text" name="age" value="12"/><br>
		
		<input type="submit" value="Submit" >
	</form>
</body>
</html>