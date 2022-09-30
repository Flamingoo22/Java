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
	<h1>Customer Name: <c:out value="${user.name}"/></h1>
	<h1>Item name: <c:out value="${user.itemName}"/></h1>
	<h1>Price: <c:out value="${user.price}"/></h1>
	<h1>Description: <c:out value="${user.description}"/></h1>
	<h1>Vendor: <c:out value="${user.vendor}"/></h1>
</body>
</html>