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
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>License Number</th>
				<th>State</th>
				<th>Exp Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="person" items="${persons}">
				<tr>
					<td><c:out value="${person.firstName} ${person.lastName}"/></td>
					<td><c:out value="${person.license.id}"/></td>
					<td><c:out value="${person.license.state}"/></td>
					<td>${person.license.expDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>