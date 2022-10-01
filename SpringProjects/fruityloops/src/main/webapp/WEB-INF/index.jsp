<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding:0 20%">
	<h1 style=" color:pink;">Fruit Store</h1>
	<table class="table" style="border: 15px solid pink">
		<thead style="border-bottom:2px solid pink">
			<tr>
				<td class="fw-bold">Name</td>
				<td class="fw-bold">Price</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fruit" items="${fruits}">
			<tr>
				<td><c:out value="${fruit.getName()}"/></td>
				<td><c:out value="${fruit.getPrice()}"/></td> 
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>