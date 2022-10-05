<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<a href="/dashboard">Dashboard</a>
	    <form:form action="/songs/new" method="POST" modelAttribute="song" class="form">
	    	
		    <form:label path="title">Title:</form:label>
		    <form:input path="title" class="form-control"/>
		    <p><form:errors path="title" class="text-danger"/></p>
		    
		    <form:label path="author">Artist:</form:label>
		    <form:input path="author" class="form-control"/>
		    <p><form:errors path="author" class="text-danger"/></p>
		    
		    <form:label path="rating" class="form-label">Rating:</form:label>
		    <form:input path="rating" class="form-control" min="1" max="5"/>
		    <p><form:errors path="rating" class="text-danger"/></p>
		    
		    <input type="submit" value="Submit" class="btn btn-primary">
	    </form:form>
	</div>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>