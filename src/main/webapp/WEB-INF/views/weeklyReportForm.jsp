<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<meta charset="utf-8">
<title>Weekly report</title>
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

<!-- Favicon –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<link rel="icon" type="image/png" href="images/favicon.png">
</head>
<body>
	<div class="container">
		<div class="row">
			<h5>Weekly report</h5>
		</div>
		<div class="row">
			<c:forEach items="${ weeklyReport.dailyReports }" var="dailyReport" varStatus="status">
				<a href="/worktime-tracking/daily-report/${ dailyReport.id }">
					<div class="two columns">
						<div class="row with-border">
							${ dailyReport.dayName } <br> ${ dailyReport.date }
						</div>
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
</body>
	<script src="${pageContext.request.contextPath}/resources/js/weeklyReport.js"></script>
</html>
