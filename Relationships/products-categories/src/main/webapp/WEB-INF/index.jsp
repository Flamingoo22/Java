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
		<h1 class="text-center">Home Page</h1>
		<p><a href="products/new">Add Product</a></p>
		<p><a href="categories/new">Add Category</a></p>
		<div class="row">
       	<table class="table table-striped col">
			<thead>
				<tr>
					<th class="text-center">Products</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<td>
				<ul>
				<c:forEach var="product" items="${products}">
					<li><a href="products/${product.id}"><c:out value="${product.name}"/></a>
				</c:forEach>
				</ul>
				</td>
				</tr>
			</tbody>
        </table>
        <table class="table table-striped col">
			<thead>
				<tr>
					<th class="text-center">Categories</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<td>
				<ul>
				<c:forEach var="category" items="${categories}">
					<li><a href="categories/${category.id}"><c:out value="${category.name}"/></a>
				</c:forEach>
				</ul>
				</td>
				</tr>
			</tbody>
        </table>
		</div>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>