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
	<form:form action="/donation/edit/${donation.id}" method="post" modelAttribute="donation" class="container">
		<input type="hidden" name="_method" value="put">
		<div class="form-group">
			<form:label path="donationName">Donation Name</form:label>
			<form:input path="donationName" class="form-control"/>
			<form:errors path="donationName"/>
		</div>
		<div class="form-group">
			<form:label path="quantity">Quantity</form:label>
			<form:input path="quantity" class="form-control"/>
			<form:errors path="quantity"/>
		</div>
		<div class="form-group">
			<form:label path="donor">Donor</form:label>
			<form:input path="donor" class="form-control"/>
			<form:errors path="donor"/>
		</div >
		<input type="submit" value="Edit Donation" class="btn btn-primary form-group"/>
	</form:form>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>