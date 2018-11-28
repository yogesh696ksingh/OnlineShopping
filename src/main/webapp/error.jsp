<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Show Error Page</title>
</head>

<body>
	<h1>Error!!!</h1>




	<div>
		<b>Error:</b> ${pageContext.exception}<br> <b>URI:</b>
		${pageContext.errorData.requestURI} <br> <b>Status code:</b>${pageContext.errorData.statusCode}<br>
		<b>Stack trace:</b>
		<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
			<p>${trace}</p>
		</c:forEach>
	</div>
</body>
</html>