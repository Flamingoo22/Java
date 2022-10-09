<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>New Question</title>
</head>
<body>

<h1>What is your question?</h1>
<p><a href="/">Home</a></p>
<hr>
<h6 style="color: red;">${errorMsg}</h6>
<form action="/questions/new" method="post">

	<table>
	    <thead>
	    	<tr>
	            <td class="float-left">Question:</td>
	            <td class="float-left">
					<textarea rows="4" class="input" name="questionText"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Tags:</td>
	            <td class="float-left">
					<input class="input" name="listOfTags" id="listOfTags"/>
	            </td>
	        </tr>
	        <tr>
	        	<td colspan=2><input class="input" class="button" type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
	</table>
</form>

</body>
</html>