<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 
		1. 使用 form 标签的原因： 可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显
		2. 注意：
			可以通过 modelAttribute 属性指定绑定的模型属性，若没有
			指定该属性，则默认从request域对象中读取 command 的表单bean
			如果该属性值也不存在，则会发生错误。
	 -->
	 <form:form action="emp" method="post" modelAttribute="employee">
	 	<!-- path 属性对应html 表单标签 name 属性 -->
	 	LastName: <form:input path="lastName" />
	 	<br>
	 	Email: <form:input path="email" />
	 	<br>
	 	<%  Map<String,String> genders = new HashMap<String,String>(); 
	 		genders.put("1", "Male");
	 		genders.put("1", "Female");
	 		request.setAttribute("genders", genders);
	 	%>
	 	Gender: <form:radiobuttons path="gender" items="${genders }" />
	 	<br>
	 	Department: <form:select path="department" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select>
	 	<br>
	 	<input type="submit" value="Submit" />
	 	
	 </form:form>

</body>
</html>