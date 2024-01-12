<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Safe Travels Assignment</title>
<link rel="stylesheet" href="css/styles.css" />
</head>
<body>
	<h1>Safe Travels</h1>
	<table>
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="expense" items="${expenses}">
			<tr>
				<td><c:out value="${expense.name}"></c:out></td>
				<td><c:out value="${expense.vendor}"></c:out></td>
				<td><c:out value="${expense.amount}"></c:out></td>
				<td><a href="/expenses/edit/${expense.id}">Edit</a></td>
				<td><a href="/expenses/delete/${expense.id}" >Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<h2>Add an Expense:</h2>
	<form:form action="/expenses" method="POST" modelAttribute="expense">
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