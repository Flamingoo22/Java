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
<body style="font-size:2em">
	<h1><c:out value="${book.getTitle()}"/></h1>
	
	<p>Description: <c:out value="${book.getDescription()}"/></p>
	<p>Language: <c:out value="${book.getLanguage()}"/></p>
	<p>Number of Pages: <c:out value="${book.getNumberOfPages()}"/></p>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>