<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Dojo Overflow</title>
</head>
<body>

<h1>Questions Dashboard</h1>
<p><a href="/questions/new">New Question</a></p>
<hr>
<table>
	<thead>
		<tr>
			<th>Question</th>
			<th>Tags</th>
		</tr>
	</thead>
    <tbody>
		<c:forEach var="question" items="${questions}">
			<tr>
				<td><a href="/answers/${question.id}"><c:out value="${question.text}"></c:out></a></td>
				<td>
					<c:forEach var="tag" items="${question.tags}">
						<span><c:out value="${tag.subject}"></c:out><c:if test = "${question.tags.indexOf(tag)<question.tags.size()-1}">, </c:if></span>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
    </tbody>
</table>

</body>
</html>