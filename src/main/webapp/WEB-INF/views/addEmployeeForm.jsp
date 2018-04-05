<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<form:form action="" method="POST" modelAttribute="employee">
		<div class="container">
			<div class=row>
				<p>
					<strong>Add a new employee</strong>
				</p>
			</div>

			<form:hidden path="id" />
			<div class="row">
				<div class="three columns">
					First name<br>
					<form:input path="firstName" />
				</div>
				<div class="three columns">
					Last name<br>
					<form:input path="lastName" />
				</div>
			</div>
			<div class="row">
				<div class="three columns">
					Day of employment
					<form:input type="date" path="dateOfEmployment" />
				</div>
				<div class="three columns">
					Man hour cost
					<form:input path="manHourCost" />
				</div>
			</div>
			<div class="row">
				<input type="submit" value="Submit" />
			</div>
		</div>
	</form:form>
</body>
</html>