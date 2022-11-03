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

<h1>All Courses</h1>

<a href="/">Dashboard</a>

<table>
	<thead>
		<tr>
		<td>Class</td>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="c" items="${courses}">
			<tr>
				<td> <a href="/courses/${c.id}"><c:out value="${c.courseName}"/></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>