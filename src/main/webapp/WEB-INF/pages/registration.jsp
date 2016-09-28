<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Events Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="events" commandName="events">
		<form:input type="hidden" path="id" />
		<table>
			<tr>
				<td><label for="eventname">Event Name: </label> </td>
				<td><form:input path="eventname" /></td>
				<td><form:errors path="eventname" cssClass="error"/></td>
		    </tr>
	    
		     <tr>
				<td><label for="EventDate">Event Date: </label> </td>
				<td><form:input path="date" /></td>
				<td><form:errors path="date" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="price">Ticket Price: </label> </td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" cssClass="error"/></td>
		    </tr>
	
			<%-- <tr>
				<td><label for="ssn">SSN: </label> </td>
				<td><form:input path="ssn" id="ssn"/></td>
				<td><form:errors path="ssn" cssClass="error"/></td>
		    </tr>  --%>
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/events' />">List of All Events</a>
</body>
</html>