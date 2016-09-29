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
			<td>EVENT</td><td>event Date</td><td>price</td><td>SSN</td><td></td>
		</tr>
		<c:forEach items="${evnts}" var="evnts">
			<tr>
			<td>${evnts.eventname}</td>
		    <td>${evnts.date}</td>
			<td>${evnts.price}</td> 
			<td><a href="<c:url value='/edit-${evnts.id}-event' />">${evnts.id}</a></td>
			<td><a href="<c:url value='/delete-${evnts.id}-event' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/tickets' />">sort for chipest event price</a>
	<a href="<c:url value='/new' />">Add New event</a>
</body>
</html>