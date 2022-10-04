<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
        <h1>Safe Travels</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <td scope="col">Expenses</td>
                    <td scope="col">Vendor</td>
                    <td scope="col">Amount</td>
                    <td scope="col">Actions</td>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="expense" items="${expenses}">
                <tr>
                    <td scope="col"><a href="/expense/${expense.id}"><c:out value="${expense.name}"/></a></td>
                    <td><c:out value="${expense.vendor}"/></td>
                    <td>$<c:out value="${expense.amount}"/></td>
                    <td scope="col"><div class="d-flex">
                    <a href="/expense/edit/${expense.id}">edit</a>
                    <form action="/expense/${expense.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
                    </div></td>
                </tr>
            	</c:forEach>
            </tbody>
        </table>
        <form:form action="/expense" method="POST" modelAttribute="expense" class="fomr">
        <h2>Add an expense:</h2>
        <form:label path="name">Expense Name:</form:label>
        <form:input path="name" class="form-control"/>
        <p><form:errors path="name" class="text-danger"/></p>
        
        <form:label path="vendor">Vendor:</form:label>
        <form:input path="vendor" class="form-control"/>
        <p><form:errors path="vendor" class="text-danger"/></p>
        
        <form:label path="amount" class="form-label">Amount:</form:label>
        <form:input path="amount" class="form-control"/>
        <p><form:errors path="amount" class="text-danger"/></p>
        
        <form:label path="description">Description:</form:label>
        <form:textarea path="description" cols="30" rows="10" class="form-control"></form:textarea>
        <p><form:errors path="description" class="text-danger"/></p>
        
        <input type="submit" value="Submit" class="btn btn-primary">
        </form:form>
    </div>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>