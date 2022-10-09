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
<body class="container">
	<div class="navbar">
		<h1>Welcome, <c:out value="${user.firstName}"/>!</h1>	
		<a href="/logout">Log out</a>
	</div>
	<div>
		<div class="navbar">
		<h4>All Projects:</h4>
		<a href="/projects/new" class="btn border border-dark shadow">+ new projects</a>		
		</div>
		<table class="table table-striped">
			<thead>
				<tr class="row">
					<th class="col">Project</th>
					<th class="col">Team lead</th>
					<th class="col">Due Date</th>
					<th class="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${projects}">
				<tr class="row">
					<td class="col"><a href="projects/${project.id}"><c:out value="${project.title}"/></a></td>
					<td class="col"><c:out value="${project.leadUser.firstName}"/></td>
					<td class="col"><fmt:formatDate type = "date" value = "${project.dueDate}"/></td>
					<td class="col">
					<form action="/projects/${project.id}/join" method="post">
					        <input type="hidden" name="_method" value="put">
					        <input type="submit" value="Join">
			    	</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
       	</table>
	
	</div>
	
	<div>
		<h4>Your Projects:</h4>
       	<table class="table table-striped">
			<thead>
				<tr class="row">
					<th class="col">Project</th>
					<th class="col">Team lead</th>
					<th class="col">Due Date</th>
					<th class="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${user.projects}">
				<tr class="row">
					<td class="col"><a href="projects/${project.id}"><c:out value="${project.title}"/></a></td>
					<td class="col"><c:out value="${project.leadUser.firstName}"/></td>
					<td class="col"><fmt:formatDate type = "date" value = "${project.dueDate}"/></td>
					<td class="col"><c:choose>
					<c:when test="${user.id == project.leadUser.id}">
						<div class="d-flex gap-3">
							<a href="/projects/edit/${project.id}" class="btn border border-dark p-1">Edit</a>
							
							<form action="/projects/${project.id}" method="post">
						        <input type="hidden" name="_method" value="delete">
						        <input type="submit" value="Delete" class="btn border border-dark p-1">
					    	</form>					
						</div>
					</c:when>
					<c:otherwise>
						<form action="/projects/${project.id}/leave" method="post">
					        <input type="hidden" name="_method" value="put">
					        <input type="submit" value="Leave" class="btn border border-dark p-1">
			    		</form>
					</c:otherwise>
					</c:choose></td>
				</tr>
				</c:forEach>
			</tbody>
         </table>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>