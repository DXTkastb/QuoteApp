<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today's Quote</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Oswald">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style>
body {
	font-family: 'Oswald', serif;
	font-size: 40px;
	color: white;
	background:
		url('${pageContext.request.contextPath}/resources/p${random}.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body><br>
	<div style="text-align: center;">
		${quote_string} <br> <br>
		<p style="font-size: 22px">- ${quote_character}</p>
	</div>

	<br>
	<br>
	<div
		style="position: fixed; bottom: 0px; width: 100%; text-align: center;">
		<a class="btn btn-secondary" style="text-align: center;"
			href="${pageContext.request.contextPath}/getquote">show more</a>
	</div>
</body>
</html>