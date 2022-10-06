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
	<h1 class="text-center">New Dorm</h1>
	<a href="/dorms">Dashboard</a>
	<form:form action="/dorms/new" method="post" modelAttribute="dorm" class="form-container card border border-dark p-3">
	<div class="row m-3">	
	<form:label path="name" class="col">Name:</form:label>
	<form:input path="name" class="col form-control"/>
	</div>
	<input type="submit" value="Add" class='btn form-control border shadow'/>
	</form:form>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>