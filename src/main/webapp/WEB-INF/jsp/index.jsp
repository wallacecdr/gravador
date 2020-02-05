<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="controls">
		<button id="recordButton">
			<img src="img/play.png"></img>
		</button>
		<button id="pauseButton">
			<img src="img/pause.png"></img>
		</button>
		<button id="stopButton">
			<img src="img/stop.png"></img>
		</button>
	</div>
	<div id="formats"></div>
  	<h3></h3>
  	<ol id="recordingsList"></ol>

	<script src="js/recorder.js"></script>
	<script src="js/app.js"></script>
</body>
</html>