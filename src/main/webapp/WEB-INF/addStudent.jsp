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

<h1>New Student</h1>

<a href="/">Dashboard</a>

<form:form action="/students/new" method="post" modelAttribute="student">

<form:label path="name">Name: </form:label>
<form:errors path="name"/>
<form:input path="name"/>

<select name="dorm" id="dorm">
	<c:forEach var = "d" items="${dorms}">
	<option value="${d.id}"> <c:out value="${d.name}"/></option>
	</c:forEach>
</select>
<p><c:out value="${error}"/></p>
<button>Submit</button>
</form:form>

</body>
</html>