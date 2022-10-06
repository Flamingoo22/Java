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
<body class="container">
	<div class="navbar">
	<h1>Donation Page</h1>
	<a href="/donation/new">New Donation</a>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th> Donation</th>
				<th> Quantity</th>
				<th> Donor</th>
				<th> Action </th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="donation" items="${allDonation}">
			<tr>
				<td><a href="/donation/show/${donation.id}" class="btn text-primary"><c:out value="${donation.donationName}"/></a></td>
				<td><c:out value="${donation.quantity}"/></td>
				<td><c:out value="${donation.donor}"/></td>
				<td>
					<div class="d-flex">
					<a href="/donation/edit/${donation.id}" class="btn btn-primary">Edit</a>
						<form action="/donation/delete/${donation.id}" method="post" >
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete" class="btn btn-danger">
						</form>
					</div>
				</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>