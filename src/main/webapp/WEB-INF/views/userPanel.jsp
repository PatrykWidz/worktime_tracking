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
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/skeleton.css">

  <!-- Favicon
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="icon" type="image/png" href="images/favicon.png">
  </head>
<body>
	<div class="container">
		<div class="row">
			<h5>Welcome to your user panel!</h5>
		</div>
		<div class="row">
			<div class="three columns"><img src="${pageContext.request.contextPath}/resources/img/avatar.png"/></div>
			<div class="six columns">
				<div class="row"><p>${ fullName }</p></div>
				<div class="row"><p>Position</p></div>
				<div class="row"><p>My status</p></div>
			</div>
		</div>
		<div class="row">
				<p>What would you like to do?</p>
		</div>
		<div class="row">
				<p><a href="/worktime-tracking//weekly-report/1">Report my worktime</a></p>
		</div>
	</div>
</body>
</html>