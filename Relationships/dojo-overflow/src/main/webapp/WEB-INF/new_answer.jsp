<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Question</title>
</head>
<body>

<h1>${question.questionText}</h1>

<h3 class="in-line">
Tags:
<c:forEach var="tag" items="${question.tags}">
	<button type="button"><c:out value="${tag.subject}"></c:out></button>
</c:forEach>
</h3>
<p><a href="/">Home</a></p>
<hr>
<table>
	<thead>
		<tr>
			<th class="float-left">Answers</th>
		</tr>
	</thead>
    <tbody>
		<c:forEach var="answer" items="${question.answers}">
			<tr>
				<td class="float-left"><c:out value="${answer.answerText}"></c:out></td>
			</tr>
		</c:forEach>
    </tbody>
</table>

<hr>
<h4>Add your answer:</h4>
<form:form action="/answers/${question.id}" method="post" modelAttribute="answer">
	<table>
	    <thead>
	    	<tr>
	            <td class="float-left">Answer:</td>
	            <td class="float-left">
	            	<form:errors path="answerText" class="text-danger"/>
					<form:textarea rows="4" class="input" path="answerText"/>
	            </td>
	        </tr>
	        <tr>
	        	<td colspan=2><input class="input" class="button" type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
	</table>
</form:form>

</body>
</html>