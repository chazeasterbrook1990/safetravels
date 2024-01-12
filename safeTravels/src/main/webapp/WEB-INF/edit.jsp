<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styles.css" />
<title>Edit Your Expense</title>
</head>
<body>
	<h1>Edit Expense</h1>
	<a href="/expenses">Go Back</a>
	<form:form action="/expenses/edit/${id}" method="POST" modelAttribute="expense">
		<form:label path="name">Expense Name:</form:label>
		<form:errors path="name"/>
		<form:input path="name" name="name"/>
		<form:label path="vendor">Vendor:</form:label>
		<form:errors path="vendor"/>
		<form:input path="vendor" name="vendor"/>
		<form:label path="amount">Amount:</form:label>
		<form:errors path="amount"/>
		<form:input path="amount" name="amount"/>
		<form:label path="description">Description:</form:label>
		<form:errors path="description"/>
		<form:textarea path="description" name="description" id="" cols="30" rows="10"></form:textarea>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>