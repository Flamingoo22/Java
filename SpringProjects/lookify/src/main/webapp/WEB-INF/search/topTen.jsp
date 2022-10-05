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
<body>
	<div class="container">
		<div class="navbar">
			<h1>Top Ten Songs:</h1>
			<a href="/dashboard">Dashboard</a>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Ratings</th>
					<th>Authors</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="song" items="${topTen}">
				<tr>
					<td><c:out value="${song.rating}"/></td>
					<td><c:out value="${song.title}"/></td>
					<td><c:out value="${song.author}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	 </div>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>