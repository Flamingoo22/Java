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
			<h1>Welcome!</h1>
			<p>Join our growing community</p>
		</div>
		<div class="row">
			<div class="col">
				<h2>Register</h2>
			    <form:form action="/register" method="POST" modelAttribute="newUser" class="form">
				    <form:label path="firstName">First Name:</form:label>
				    <form:input path="firstName" class="form-control"/>
				    <p><form:errors path="firstName" class="text-danger"/></p>
				    
				    <form:label path="lastName">Last Name:</form:label>
				    <form:input path="lastName" class="form-control"/>
				    <p><form:errors path="lastName" class="text-danger"/></p>
				    
				    <form:label path="email">Email::</form:label>
				    <form:input path="email" class="form-control"/>
				    <p><form:errors path="email" class="text-danger"/></p>
				    
				    <form:label path="password" class="form-label">Password:</form:label>
				    <form:input path="password" class="form-control"/>
				    <p><form:errors path="password" class="text-danger"/></p>
				    
				    <form:label path="confirm" class="form-label">Confirm Password:</form:label>
				    <form:input path="confirm" class="form-control"/>
				    <p><form:errors path="confirm" class="text-danger"/></p>
				    
				    <input type="submit" value="Submit" class="btn btn-primary">
			    </form:form>
			</div>
			<div class="col">		
				<h2>Log In</h2>	
				<form:form action="/login" method="POST" modelAttribute="newLogin" class="form">
				    <form:label path="email">Email:</form:label>
				    <form:input path="email" class="form-control"/>
				    <p><form:errors path="email" class="text-danger"/></p>
				    
				    <form:label path="password">Password:</form:label>
				    <form:input path="password" class="form-control"/>
				    <p><form:errors path="password" class="text-danger"/></p>
				    
				    <input type="submit" value="Submit" class="btn btn-primary">
			    </form:form>
			</div>
		
		</div>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>