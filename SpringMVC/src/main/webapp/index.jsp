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
</body>
</html>