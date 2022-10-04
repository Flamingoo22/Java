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
	<h1>Donation Page</h1>
	<table class="table">
		<thead>
			<tr>
				<th> Donation</th>
				<th> Quantity</th>
				<th> Donor</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="donation" items="${allDonation}">
			<tr>
				<td><a href="/donation/show/${donation.id}" class="btn text-primary"><c:out value="${donation.donationName}"/></a></td>
				<td><c:out value="${donation.quantity}"/></td>
				<td><c:out value="${donation.donor}"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>