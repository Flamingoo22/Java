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
		<div class="navbar">
			<h1><c:out value="${book.title}"/></h1>
			<a href="/books">back to the shelves</a>
		</div>
		
		<div>
			<p><span class="text-danger fw-bold"><c:out value="${book.user.userName}"/></span> read <span class="text-warning fw-bold"><c:out value="${book.title}"/></span> by <span class="text-success fw-bold"><c:out value="${book.author}"/></span>.</p>
			<p><c:out value="Here are ${book.user.userName}'s thoughs:"/></p>
			<div class="border-top border-bottom py-3">
				<c:out value="${book.thought}"/>
			</div>
		</div>
		<c:if test="${user_id == book.user.id}">
		<div class="row">
			<div class="d-flex col-md-3 offset-md-10 gap-3 mt-3">
				<a href="/books/${book.id}/edit" class="btn btn-primary">Edit</a>
				<form action="/books/${book.id}" method="post">
			        <input type="hidden" name="_method" value="delete">
			        <input type="submit" value="Delete" class="btn btn-danger">
			    </form>
			</div>
		</div>
		</c:if>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>