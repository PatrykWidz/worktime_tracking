<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<meta charset="utf-8">
<title>Administrator panel</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Mobile Specific Metas
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<link href="//fonts.googleapis.com/css?family=Raleway:400,300,600"
	rel="stylesheet" type="text/css">

<!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/normalize.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/skeleton.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/custom.css">


<!-- Favicon
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<link rel="icon" type="image/png" href="images/favicon.png">
</head>
<body>
	<div class="container">
		<h4>List of employees</h4>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Date of employment</th>
					<th>Man hour cost</th>
					<th>Action</th>
				</tr>
			</thead>
				<c:forEach items="${ employees }" var="employee" varStatus="loop">
					<tr>
						<td> ${ loop.index + 1 } </td>
						<td> ${ employee.fullName } </td>
						<td> ${ employee.dateOfEmployment } </td>
						<td> ${ employee.manHourCost } </td>
						<td> Edit Delete </td>
					</tr>
				</c:forEach>
		</table>
		<div class="row">
			<a href="${pageContext.request.contextPath}/employee/add">Add new employee</a>
		</div>
	</div>
</body>
</html>