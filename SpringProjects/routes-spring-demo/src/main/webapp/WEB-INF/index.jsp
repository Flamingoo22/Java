<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<h2><c:out value='${"<h1> something hanis </h1>"}'/></h2>
	
	<p><c:out value="${name}"/></p>
	<p>${number}</p>
	
	<% for (int i = 0; i < 5; i++) %>
	
</body>
</html>