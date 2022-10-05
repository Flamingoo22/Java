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
		<div class="row">
			<div class="col offset-md-7">
				<a href="/dashboard">Dashboard</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 offset-md-1">
				<div class="row d-flex justify-content-between">
				<p class="col">Title:</p> 
				<p class="col">${song.title}</p>
				</div>
				<div class="row d-flex justify-content-between">
				<p class="col">Artist:</p> 
				<p class="col">${song.author}</p>
				</div>
				<div class="row d-flex justify-content-between">
				<p class="col">Rating(1-10):</p> 
				<p class="col">${song.rating}</p>
				<form action="/songs/${song.id}" method="post">
			        <input type="hidden" name="_method" value="delete">
			        <input type="submit" value="Delete">
		    	</form>
				</div>
			</div>
			
		</div>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>