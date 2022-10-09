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
	<body class="container" style="background-color:rgb(213,166,189); font-size:1.2em">
	<div class="navbar">
		<h1 class="col">Project: <c:out value="${project.title}"/></h1>
		<a href="/dashboard" class="btn border border-dark shadow">Back to Dashboard</a>
	</div>
	<p>Project Lead: <c:out value="${project.leadUser.firstName}"/></p>
    <p><form:errors path="ticket" class="text-danger"/></p>
    <form:form action="/projects/${project.id}/tasks" method="POST" modelAttribute="task">
	    <div class="row">
		    <form:label path="ticket" class="col">Add a task ticket for this team:</form:label>
		    <form:textarea path="ticket" class="form-control col"/>
	    </div>
	    
	    <input type="submit" value="Submit" class="btn btn-primary col-md-2 offset-md-10 mt-4">
    </form:form>
    
	<div class="d-flex flex-column gap-5">
		<c:forEach var="task" items="${tasks}">
			<div>
				<p><c:out value="Added by ${task.user.firstName} at "/> <fmt:formatDate pattern="kk:mma MMM d" value = "${task.createdAt}"/>:</p>
				<p><c:out value="${task.ticket}"/></p>
			</div>
		</c:forEach>
		
	</div>
	
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>