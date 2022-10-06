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

	<h1>New Person</h1>
    <form:form action="/persons" method="POST" modelAttribute="person" class="form">
	    
	    <form:label path="firstName">First Name:</form:label>
	    <form:input path="firstName" class="form-control"/>
	    <p><form:errors path="firstName" class="text-danger"/></p>
	    
	    <form:label path="lastName">Last Name:</form:label>
	    <form:input path="lastName" class="form-control"/>
	    <p><form:errors path="lastName" class="text-danger"/></p>

	    
	    <input type="submit" value="Submit" class="btn btn-primary">
    </form:form>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>