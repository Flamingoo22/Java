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
<body class="container">
	<div class="navbar">
	<h1>Expense Detail</h1>
	<a href="/expense">Go Back</a>
	</div>
	
	<div class="row ">
		<div class="col-md-3 offset-md-3">
			<div class="row d-flex justify-content-between">
			<p class="col">Expense Name:</p> 
			<p class="col">${expense.name}</p>
			</div>
			<div class="row d-flex justify-content-between">
			<p class="col">Expense Description:</p> 
			<p class="col">${expense.description}</p>
			</div>
			<div class="row d-flex justify-content-between">
			<p class="col">Vendor:</p> 
			<p class="col">${expense.vendor}</p>
			</div>
			<div class="row d-flex justify-content-between">
			<p class="col">Amount Spent:</p> 
			<p class="col">${expense.amount}</p>
			</div>
		</div>
	</div>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>