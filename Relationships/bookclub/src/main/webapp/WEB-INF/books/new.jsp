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
		<div>
			<div>
				<a href="/books">back to the shelves</a>
			</div>
		</div>
		<h1>Add a Book to Your Shelf!</h1>
	    <form:form action="/books/new" method="POST" modelAttribute="book" class="form">
	    	<form:input path="user" value="${user_id}" type="hidden"/>
		    <form:label path="title">Title:</form:label>
		    <form:input path="title" class="form-control"/>
		    <p><form:errors path="title" class="text-danger"/></p>
		    
		    <form:label path="author">Author:</form:label>
		    <form:input path="author" class="form-control"/>
		    <p><form:errors path="author" class="text-danger"/></p>
		    
		    <form:label path="thought" class="form-label">Thoughts:</form:label>
		    <form:input path="thought" class="form-control"/>
		    <p><form:errors path="thought" class="text-danger"/></p>
		    
		    <input type="submit" value="Submit" class="btn btn-primary">
	    </form:form>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>