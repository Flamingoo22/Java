<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL DEMO</h1>
	<h2><c:out value="${name}"/></h2>
	<p>${age}</p>
	<p>${isHungry}</p>
	<p><c:out value="${test}"/></p>
	
	<h2>IF STATEMENT</h2>
	<c:if test="${isHungry}">
	<p><c:out value="${name}"/> is Hungry</p>
	</c:if>
	
	<h2>IF-ELSE STATEMENT</h2>
	<c:choose>
		<c:when test="${age<21}">
			<p><c:out value="${name}"/> is under 21 and cannot buy drinks</p>
		</c:when>
		<c:otherwise>
			<p><c:out value="${name}"/> is above 21 , DRINK UP!</p>
		</c:otherwise>
		
	</c:choose>
	
	<h2>FOR EACH</h2>
	<c:forEach var="user2" items="${users}">
		<p><c:out value="${user2}"/></p>
	</c:forEach>
		
</body>
</html>