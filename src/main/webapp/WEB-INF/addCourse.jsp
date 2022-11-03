<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<h1>New Course</h1>
<a href="/">Dashboard</a>

<form:form action="/courses/new" method="post" modelAttribute="course">

<form:label path="courseName"> Name:</form:label>
<form:errors path="courseName"/>
<form:input path="courseName"/>

<button>Add</button>
</form:form>

</body>
</html>