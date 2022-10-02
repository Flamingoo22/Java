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
<body style="padding:0 30%">
	<h1>Here's Your Omikuji!</h1>
	<p class='bg-primary border border-dark fs-1 p-4'> In ${omikuji.getNum()} years, you will be live in <c:out value= '${omikuji.getLocation()}'/> with <c:out value= '${omikuji.getPerson()}'/> as your roommate, <c:out value= '${omikuji.getHobby()}'/> for a living. The next time you see a <c:out value= '${omikuji.getThing()}'/>, you will have good luck. Also, <c:out value= '${omikuji.getMessage()}'/></p>
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>