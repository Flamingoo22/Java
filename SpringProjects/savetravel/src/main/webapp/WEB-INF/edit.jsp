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
	<h1>Edit Expense</h1>

    <form:form action="/expense/edit/${expense.id}" method="POST" modelAttribute="expense" class="form">
    	<form:input path="id" type="hidden" class="form-control" value='${expense.id}'/>
    	<input type="hidden" name="_method" value="put">
    	
    	
	    <form:label path="name">Expense Name:</form:label>
	    <form:input path="name" class="form-control" value='${expense.name}'/>
	    <p><form:errors path="name" class="text-danger"/></p>
	    
	    <form:label path="vendor">Vendor:</form:label>
	    <form:input path="vendor" class="form-control" value='${expense.vendor}'/>
	    <p><form:errors path="vendor" class="text-danger"/></p>
	    
	    <form:label path="amount" class="form-label">Amount:</form:label>
	    <form:input path="amount" class="form-control" value='${expense.amount}'/>
	    <p><form:errors path="amount" class="text-danger"/></p>
	    
	    <form:label path="description">Description:</form:label>
	    <form:textarea path="description" cols="30" rows="10" class="form-control" value='<c:out value="${expense.description}"/>'/>
	    <p><form:errors path="description" class="text-danger"/></p>
	    
	    <input type="submit" value="Submit" class="btn btn-primary">
    </form:form>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>