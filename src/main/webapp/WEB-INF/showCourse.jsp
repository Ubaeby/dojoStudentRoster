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

<h1>Students taking <c:out value="${courses.courseName}"/> </h1>

<a href="/">Dashboard</a>

<table>
	<thead>
		<tr>
		<td>Names</td>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="s" items="${aStudents}">
			<tr>
				<td><a href="/students/${s.id}"><c:out value="${s.name}"/></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>