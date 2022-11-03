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

<h1>New Dorm</h1>
<a href="/">Dashboard</a>

<form:form action="/dorms/new" method="post" modelAttribute="dorm">

<form:label path="name">Name: </form:label>
<form:errors path="name"/>
<form:input path="name"/>

<button>Add</button>
</form:form>

</body>
</html>