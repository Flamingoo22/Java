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
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="POST" modelAttribute="ninjas">
	<form:label path="dojo">Dojo:</form:label>
	<form:select path="dojo" class="form-select" aria-label="Default select">
		<c:forEach var="dojo" items="${dojos}">
			<form:option value="${dojo.id}" path="dojo">
				<c:out value="${dojo.name}"/>
			</form:option>
		</c:forEach>
	</form:select>
	<form:errors path="firstName" class="text-danger"/>
	<form:label path="firstName">First Name:</form:label>
	<form:input path="firstName" class="form-control"/>
	<form:errors path="lastName" class="text-danger"/>
	<form:label path="lastName">Last Name:</form:label>
	<form:input path="lastName" class="form-control"/>
	<form:errors path="age" class="text-danger"/>
	<form:label path="age">Age:</form:label>
	<form:input path="age" type="number" class="form-control"/>
	<input type="submit" value="Create" class="btn btn-primary"/>
	</form:form>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>