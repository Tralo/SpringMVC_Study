<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/testConversionServiceConverter" method="POST">
		<!-- lastname-email-gender-department.id -->
		Employee: <input type="text" name="employee" />
		<input type="submit" value="Submit" />
	 	
	</form>
	<br><br>
	
	<!-- 
		1. 使用 form 标签的原因： 可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显
		2. 注意：
			可以通过 modelAttribute 属性指定绑定的模型属性，若没有
			指定该属性，则默认从request域对象中读取 command 的表单bean
			如果该属性值也不存在，则会发生错误。
	 -->
	 <form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
	 	
	 	<form:errors path="*"></form:errors>
	 	<br>
	 	
	 	<!-- path 属性对应html 表单标签 name 属性 -->
	 	<c:if test="${employee.id == null }">
	 		<!-- path属性对应 html 表单标签的 name 属性值 -->
	 		LastName: <form:input path="lastName" />
	 		<form:errors path="lastName"></form:errors>
	 	</c:if>
	 	<c:if test="${employee.id != null }">
	 		<form:hidden path="id"/>
	 		<!-- 对于 _method 不能使用 form:hidden 标签， 因为modelAttribute对应的bean中没有 _method这个属性 -->
	 		<input type="hidden" name="_method" value="PUT"/>
	 	</c:if>
	 	
	 	<br>
	 	Email: <form:input path="email" />
	 	<form:errors path="email"></form:errors>
	 	<br>
	 	<%  Map<String,String> genders = new HashMap<String,String>(); 
	 		genders.put("1", "Male");
	 		genders.put("0", "Female");
	 		request.setAttribute("genders", genders);
	 	%>
	 	Gender: 
	 	<br>
	 	<form:radiobuttons path="gender" items="${genders }" delimiter="<br>" />
	 	<br>
	 	Department: <form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select>
	 	<br>
	 	<!-- 
	 		1. 数据类型转换问题 
	 		2. 数据类型格式化问题
	 		3. 数据校验问题
	 		1). 如何校验？注解？
	 		1⃣️使用 JSR 303 验证标准
	 		2⃣️加入hibernate validator验证框架
	 		3⃣️在SpringMVC配置文件中添加 <mvc:annotation-driven/>
	 		4⃣️需要在bean的属性上添加对应的注解
	 		5⃣️在目标方法 bean类型的前面添加 @Valid 注解
	 		2). 验证出错转向哪一个页面？
	 		注意： 需校验的 Bean 对象和其绑定结果对象或错误对象时成对出现的，它们之间不允许声明其它的入参
	 		3). 错误消息？如何显示，如何把错误消息进行国际化
	 	 -->
	 	Birth: <form:input path="birth" />
	 	<form:errors path="birth"></form:errors>
	 	<br>
	 	Salary: <form:input path="salary" />
	 	<br>
	 	<input type="submit" value="Submit" />
	 	
	 </form:form>

</body>
</html>