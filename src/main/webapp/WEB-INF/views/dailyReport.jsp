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
		<div class=row>
			<h5>Your worktime for ${ dailyReport.dayName } ${ dailyReport.date }</h5>
		</div>
		<div class=row>
			<form class="myForm" action="${pageContext.request.contextPath}/weekly-report/${ dailyReport.date }/${ dailyReport.weeklyReport.employee.id }">
				<input class="button" type="submit" value="Go back" />
			</form>
		</div>
		<div class="row">
			<table class="reports-tab">
				<thead>
					<tr>
						<th>#</th>
						<th>Project's symbol and name</th>
						<th>Start hour</th>
						<th>End hour</th>
						<th>Hours spent</th>
						<th class="centered">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ dailyReport.partialDailyReports }"
						var="partialDailyReport" varStatus="loop">
						<tr>
							<td>${ loop.index + 1 }</td>
							<td>${ partialDailyReport.project.symbolAndName }</td>
							<td class="centered">${ partialDailyReport.startTime }</td>
							<td class="centered">${ partialDailyReport.endTime }</td>
							<td class="centered">${ partialDailyReport.manHours }</td>
							<td>
								<form class="myForm"
									action="${pageContext.request.contextPath}/daily-report/partial-daily-report/${ partialDailyReport.id }/delete">
									<input class="button" type="submit" value="Delete" />
								</form>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td class="centered"><strong>Sum</strong></td>
						<td class="centered">${ manHourSum }</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="row">
			<form:form method="POST" modelAttribute="partialDailyReport"
				action="">
				<form:hidden path="id" />
				<div class="row">
					<div class="row">
						Pick project<br>
						<form:select path="project.id">
							<form:options items="${ projects }" itemValue="id"
								itemLabel="symbolAndName" />
						</form:select>
					</div>
					<div class="row">
						Select start time<br>
						<form:input type="text" path="startTime" />
					</div>
					<div class="row">
						Select end time<br>
						<form:input type="text" path="endTime" />
						<div class="row">
							<input type="submit" value="submit" />
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>