<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class='container'>
	<h1>Send an Omikuji!</h1>
	<form action = "/omikuji/process" method="POST" class='form'>
	<label class="form-label">Pick any number from 5 to 25</label>
	<input type = "number" name="number" class='form-control'>
	<label class="form-label">Enter the name of any city.</label>
	<input type = "text" name="location" class='form-control'>
	<label class="form-label">Enter the name of any real person.</label>
	<input type = "text" name="person" class='form-control'>
	<label class="form-label">Enter professional endeavor or hobby:</label>
	<input type = "text" name="hobby" class='form-control'>
	<label class="form-label">Enter any type of living thing.</label>
	<input type = "text" name="thing" class='form-control'>
	<label class="form-label">Say something nice to someone:</label>
	<textarea name="message" class='form-control'></textarea>
	<label class="form-label">Send and show a friend</label>
	<input type = "submit" class='btn btn-primary'>
	</form>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>