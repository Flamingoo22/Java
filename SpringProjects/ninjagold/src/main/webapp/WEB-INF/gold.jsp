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
<body>
	<div class="container d-flex flex-column justify-content-center" style="padding:0 10%">
		<h1 class="text-center">FARM THE GOLD</h1>
        <div class="d-flex gap-3">
            <p>Your Gold:</p>
            <p class="border border-dark" style="width:20%">${gold}</p>
        </div>
	<div class="d-flex gap-2">
            <form action="/process_money" method="POST" style="padding:10px; border:3px solid black" class="container text-center">
                <p>Farm</p>
                <input type="hidden" name="name" value="farm">
                <p>(earns 10-40 golds)</p>
                <input type="submit" value="Find Gold!">
            </form>
            <form action="/process_money" method="POST" style="padding:10px; border:3px solid black" class="container text-center">
                <p>Cave</p>
                <input type="hidden" name="name" value="cave">
                <p>(earns 10-30 golds)</p>
                <input type="submit" value="Find Gold!">
            </form>
            <form action="/process_money" method="POST" style="padding:10px; border:3px solid black" class="container text-center">
                <p>House</p>
                <input type="hidden" name="name" value="house">
                <p>(earns 10-20 golds)</p>
                <input type="submit" value="Find Gold!">
            </form>
            <form action="/process_money" method="POST" style="padding:10px; border:3px solid black" class="container text-center">
                <p>Quest</p>
                <input type="hidden" name="name" value="quest">
                <p>(earns/takes 0-100 golds)</p>
                <input type="submit" value="Find Gold!">
            </form>
            <form action="/process_money" method="POST" style="padding:10px; border:3px solid black" class="container text-center">
                <p>Spa</p>
                <input type="hidden" name="name" value="spa">
                <p>(spend 5-25 golds to enjoy a nice spa)</p>
                <input type="submit" value="Find Gold!">
            </form>
        </div>
        <label for="comment">Activity:</label>
        <div style="padding:10px; border:3px solid black; height:300px; overflow-y:scroll; padding:10px">
		${message}
        </div>
        <a href="/reset" class="btn btn-danger mt-4" style="width:80px">Reset</a>
   	</div>
        
	
</body>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>