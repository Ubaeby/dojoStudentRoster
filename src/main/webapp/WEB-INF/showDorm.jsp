<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> <c:out value="${dorms.name}"/> Students</h1>
<a href="/">Dashboard</a>

<form:form action="/dorms/${dorms.id}" method="post" modelAttribute="student">

<select name="studentId">
	<c:forEach var="s" items="${allStudents}">
	<c:if test="${!dorms.name.equals(s.dorm.name)}">
		<option value="${s.id}">
				<c:out value="${s.name}"/> (<c:out value="${s.dorm.name}"/>)
		</option>
		</c:if>
	</c:forEach>
</select>

<button>Add</button>
</form:form>

<h2>Current Students</h2>
<table>
	<thead>
		<tr>
			<td>Student</td>
			<td>Action</td>
		</tr>
	</thead>

	<tbody>
		<c:forEach var = "s" items="${students}">
			<tr>
				<td> <a href="/students/${s.id}"><c:out value="${s.name}"/></a></td>
				<td><a href="/students/remove/${s.id}">Remove</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>