<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 
	SpringMVC 处理静态资源 
-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$('.delete').click(function(){
			var href = $(this).attr("href");
			$('form').attr('action',href);
			$('form').submit();
			return false;
		});
	})
</script>
</head>
<body>

	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>

	<c:if test="${empty requestScope.employees }">
		没有任何员工信息
	</c:if>
	<c:if test="${!empty requestScope.employees }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${requestScope.employees }" var="emp">
				<tr>
					<th>${emp.id }</th>
					<th>${emp.lastName }</th>
					<th>${emp.email }</th>
					<th>${emp.gender == 0 ? 'Female' : 'Male' }</th>
					<th>${emp.department.departmentName }</th>
					<th><a href="emp/${emp.id }">Eidt</a></th>
					<th><a class="delete" href="emp/${emp.id }">Delete</a></th>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br><br>
	<a href="emp">Add New Employee</a>
	
</body>
</html>



