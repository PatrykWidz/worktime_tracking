<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<meta charset="utf-8">
<title>User panel</title>
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
	<div class="user">
		<div class="row">
			<h5>Welcome to your user panel!</h5>
		</div>
		<div class="row">
			<div class="five columns">
				<img
					src="${pageContext.request.contextPath}/resources/img/avatar.png" />
			</div>
			<div class="three columns">
				<div class="row">${ employee.fullName }</div>
				<div class="row">Position</div>
				<div class="row">My status</div>
			</div>
		</div>
		<div class="row menu">
			<strong>MENU</strong>
			<ul>
				<li><a href="/worktime-tracking/weekly-report/${ currentDate }/${ employee.id }">Report worktime</a></li>
			</ul>
		</div>
	</div>
</body>
</html>