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
			<a href="/songs/new">Add New</a>
			<a href="/search/topTen/a">Top Ten</a>
			<form action="/search" method="post">
				<input type="search" name="author"/>
				<input type="submit" value="Search Artist"/>
			</form>
		</div>
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Ratings</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="song" items="${songs}">
					<tr>
						<td><a href="songs/${song.id}"><c:out value="${song.title}"/></a></td>
						<td><c:out value="${song.rating}"/></td>
						<td><form action="/songs/${song.id}" method="post">
					        <input type="hidden" name="_method" value="delete">
					        <input type="submit" value="Delete">
				    	</form></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>