<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Dorms</h1>

<a href="/dorms/new">Add a new dorm</a>
<a href="/students/new">Add a new student</a>
<a href="/courses/new">Add a new class</a>
<a href="/courses">View all classes</a>

	<table>
		<thead>
			<tr>
				<td>Dorm</td>
				<td>Action</td>
			</tr>
		</thead>
	
		<tbody>
			<c:forEach var="d" items="${dorms}">
				<tr>
					<td><c:out value="${d.name}"/></td>
					<td>
						<a href="/dorms/${d.id}">See Students</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>