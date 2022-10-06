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
<body  class="container">
	<h1>New License</h1>
    <form:form action="/license" method="POST" modelAttribute="license" class="form">
    	
	    <form:label path="person">Person:</form:label>
	    <form:select path="person">
	        <c:forEach var="onePerson" items="${persons}">
	            <!--- Each option VALUE is the id of the person --->
	            <form:option value="${onePerson.id}" path="person">
	            <!--- This is what shows to the user as the option --->
	                <c:out value="${onePerson.firstName}"/>
	                <c:out value="${onePerson.lastName}"/>
	            </form:option>
	        </c:forEach>
	    </form:select>
	    <p><form:errors path="person" class="text-danger"/></p>
	    
	    <form:label path="state">State:</form:label>
	    <form:input path="state" class="form-control"/>
	    <p><form:errors path="state" class="text-danger"/></p>
	    
	    <form:label path="expDate" class="form-label">Rating:</form:label>
	    <form:input path="expDate" type="date" class="form-control"/>
	    <p><form:errors path="expDate" class="text-danger"/></p>
	    
	    <input type="submit" value="Submit" class="btn btn-primary">
    </form:form>
	
	
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>