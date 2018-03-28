<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>Partial daily report</title>
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
		<h5>Your worktime for ${dayName} ${dayDate}</h5>
	</div>
	<div class="container">
		<table class="">
			<thead class="">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Project's symbol and name</th>
					<th scope="col">Start hour</th>
					<th scope="col">End hour</th>
					<th scope="col">Time spent [h]</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ partialReports }" var="partialReport">
					<tr>
						<td>1</td>
						<td>${ partialReport.project.symbol } ${ partialReport.project.name }</td>
						<td>${ partialReport.startTime }</td>
						<td>${ partialReport.endTime }</td>
						<td>${ partialReport.manHours }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<form:form method="POST" modelAttribute="partialDailyReport" action="">
			<form:hidden path="id" />
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
						<form:input type="time" path="startTime" />
					</div>
				</div>
				<div class="col-sm">
					<div class="row">Select end time</div>
					<div class="row">
						<form:input type="time" path="endTime" />
					</div>
				</div>
			</div>
			<div class="row"><input type="submit" value="submit"/></div>
		</form:form>
	</div>
</body>
</html>