<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">

	<h1>All Books</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Language</td>
				<td># Pages</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.getId()}"/></td>
				<td><c:out value="${book.getTitle()}"/></td>
				<td><c:out value="${book.getLanguage()}"/></td>
				<td><c:out value="${book.getNumberOfPages()}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>