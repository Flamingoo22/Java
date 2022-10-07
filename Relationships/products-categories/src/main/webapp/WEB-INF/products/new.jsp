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
		<h1 class="text-center">New Category</h1>
	    <form:form action="/products/new" method="POST" modelAttribute="product" class="form row">
	    	
		    <form:label path="name">Name:</form:label>
		    <form:input path="name" class="form-control col"/>
		    <p><form:errors path="name" class="text-danger col"/></p>
		    
		    <form:label path="description">Description:</form:label>
		    <form:input path="description" class="form-control col"/>
		    <p><form:errors path="description" class="text-danger col"/></p>
		    
		    <form:label path="price">Price:</form:label>
		    <form:input path="price" class="form-control col" type="number" step="0.01"/>
		    <p><form:errors path="price" class="text-danger col" /></p>
		    
		    
		    <input type="submit" value="Submit" class="btn btn-primary form-control">
	    </form:form>
	
	</div>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>