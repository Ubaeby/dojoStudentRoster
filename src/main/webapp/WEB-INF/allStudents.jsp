<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> <c:out value="${students.name}"/>'s courses</h1>
<a href="/">Dashboard</a>

	<form action="/students/${students.id}" method="post" >
		<label for="courses"> Courses</label>
		<select name="courseId" id="courseId">
		<c:forEach var = "c" items="${uCourses}">
			<option value="${c.id}">
				<c:out value="${c.courseName}"/>
			</option>
		</c:forEach>
		</select>
		
		<button>Add</button>
	</form>

<h2>Current Enrolled Courses</h2>

<table>
	<thead>
		<tr>
			<td>Course Name</td>
			<td>Action</td>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="c" items="${aCourses}">
			<tr>
				<td>
					<a href="/courses/${c.id}"> <c:out value="${c.courseName}"/></a>
				</td>
				<td><a href="/courses/remove/${id}/${c.id}">Drop</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>