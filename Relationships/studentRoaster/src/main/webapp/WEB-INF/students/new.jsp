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
	<h1 class="text-center">New Student</h1>
	<a href="/dorms">Dashboard</a>
	<form:form action="/students/new" method="post" modelAttribute="student" class="form-container p-3 border rounded">
		<div class="row m-2">	
			<form:label path="name" class="col">Name:</form:label>
			<form:input path="name" class="col form-control"/>
		</div>
		<div class="row m-2">
			<form:label path="dorm" class="col">Select Dorm:</form:label>
			<form:select path="dorm" class="col form-select">
				<c:forEach var="dorm" items="${dorms}">
					<form:option value="${dorm.id}">
						<c:out value="${dorm.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</div>
		<input type="submit" value='Add' class="btn form-control shadow"/>
	</form:form>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>