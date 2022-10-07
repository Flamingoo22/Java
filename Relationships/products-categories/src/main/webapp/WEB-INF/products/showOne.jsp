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
	
		<h1 class="text-center"><c:out value="${product.name}"/></h1>
		<a href="/">Home</a>
		
		<div class="border-top border-bottom py-3 my-3">
			<h2>Categories:</h2>
			<ul>			
			<c:forEach var="category" items="${product.categories}">
				<li><c:out value="${category.name}"/></li>
			</c:forEach>
			</ul>
		</div>
		
		<div>
			<h2>Add Category:</h2>
			<form action="/products/${product.id}" method="post">
				<input type="hidden" name="_method" value="put">
				<select name="categories" class="form-select">
			        <c:forEach var="category" items="${categories}" >
			            <option value="${category.id}">
			                <c:out value="${category.name}"/>
			            </option>
			        </c:forEach>
			    </select>
			    <input type="submit" value="Add" class="btn btn-primary form-control mt-4">
			</form>
		</div>
	
	</div>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>