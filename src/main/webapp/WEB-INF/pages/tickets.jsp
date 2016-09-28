<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title></title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Events</h2>	
	<table>
		<tr>
			<td>price</td><td>SSN</td><td></td>
		</tr>
		<c:forEach items="${list}" var="evnts">
			<tr>
			<td>${list.price}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/allevents' />">go to all events</a>
</body>
</html>