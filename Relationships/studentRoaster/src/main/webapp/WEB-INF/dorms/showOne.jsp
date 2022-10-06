<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
	<h1 class="text-center"><c:out value="${dorm.name}"/> Students</h1>
	<a href="/dorms">Dashboard</a>
	<form action="/dorm/${dorm.id}/a" method="post" class="row m-3 p-3 border shadow">
		<input type="hidden" name="_method" value="put">
		<div class="col">
			<div class="">
			<label for="students">Students:</label>
			<select name="students">
				<c:forEach var="student" items="${students}">
					<option value="${student.id}">
						<c:out value="${student.name} (${student.dorm.name})"/>
					</option>
				</c:forEach>
			</select>
			</div>		
		</div>
		<input type="submit" value="Add" class="form-control col"/>
	</form>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Student</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${dorm.students}">
			<tr>
				<td><c:out value="${student.name}"/></td>
				<td><form action="/dorm/${dorm.id}" method="post">
			       	<input type="hidden" name="_method" value="put">
			        <input type="hidden" name="student_id" value="${student.id}">
			        <input type="submit" value="Remove">
		    	</form></td>
			</tr>
			</c:forEach>
		</tbody>
	  </table>
	
	
	
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>