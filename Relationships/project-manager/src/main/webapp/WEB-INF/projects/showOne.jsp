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
<body class="container">
	<div class="navbar">
		<h3>Project Details</h3>
		<a href="/dashboard" class="btn border border-dark shadow">Back to Dashboard</a>
	</div>
	<div class="d-flex flex-column gap-5">
	<div class="row">
		<p class="col">Project:</p>
		<p class="col"><c:out value="${project.title}"/></p>
		<div class="col"></div>	
	</div>
	<div class="row">
		<p class="col">Description:</p>
		<p class="col"><c:out value="${project.description}"/></p>	
		<div class="col"></div>	
	</div>
	<div class="row">
		<p class="col">Due Date:</p>
		<p class="col"><fmt:formatDate type = "date" value = "${project.dueDate}"/></p>	
		<div class="col"></div>	
	</div>
		<a href="/projects/${project.id}/tasks" class="btn">See tasks</a>
	</div>
	
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>