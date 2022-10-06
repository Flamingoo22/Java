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
		<h1 class="text-center">Dorms</h1>
		<p><a href="/dorms/new">Add a new dorm</a></p>
		<p><a href="/students/new">Add a new student</a></p>
       <table class="table table-striped">
		<thead>
			<tr>
				<th>Dorm</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dorm" items="${dorms}">
			<tr>
				<td><c:out value="${dorm.name}"/></td>
				<td class="d-flex">
				<a href="/dorm/${dorm.id}" class="btn btn-primary">See Students</a>
				<form action="dorm/${dorm.id}" method="post">
				<input type="hidden" name="_method" value="delete">
					<input type="hidden" name="_method" value="delete">
        			<input type="submit" value="Delete" class="btn btn-danger">
				</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
      </table>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>