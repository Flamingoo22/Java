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
	<h3>Create a Project</h3>
    <form:form action="/projects/new" method="POST" modelAttribute="project" class="form">
    	
	    <form:label path="title">Project Title:</form:label>
	    <form:input path="title" class="form-control"/>
	    <p><form:errors path="title" class="text-danger"/></p>
	    
	    <form:label path="description">Project Description:</form:label>
	    <form:textarea col="4" path="description" class="form-control"/>
	    <p><form:errors path="description" class="text-danger"/></p>
	    
	    <form:label path="dueDate" class="form-label">Due Date:</form:label>
	    <form:input path="dueDate" class="form-control" type="date"/>
	    <p><form:errors path="dueDate" class="text-danger"/></p>
	    
	    <input type="submit" value="Submit" class="btn btn-primary">
	    <a href="/dashboard" class="btn border border-dark shadow">Cancel</a>
    </form:form>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>