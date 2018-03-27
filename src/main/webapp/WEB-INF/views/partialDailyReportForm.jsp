<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Partial daily report</title>
</head>
<body>
	<div class="container">
		<form:form method="POST" modelAttribute="partialDailyReport" action="">
			<form:hidden path="id" />
			<div class="row">
				<h4>You are reporting worktime for ${dayName} ${dayDate}</h4>
			</div>
			<div class="row">
				<div class="col-sm">
					<div class="row">Pick project</div>
					<div class="row">
						<form:select path="project.id">
							<form:options items="${ projects }" itemValue="id"
								itemLabel="symbolAndName" />
						</form:select>
					</div>
				</div>
				<div class="col-sm">
					<div class="row">Select start time</div>
					<div class="row">
						<form:input path="startTime" />
					</div>
				</div>
				<div class="col-sm">
					<div class="row">Select end time</div>
					<div class="row">
						<form:input path="endTime" />
					</div>
				</div>
			</div>
			<div class="row"><input type="submit" value="submit"/></div>
		</form:form>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>