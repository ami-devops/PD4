<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Booked Room Details</title>
<style>
@CHARSET "ISO-8859-1";
.CSSTableGenerator {
	margin:0px;padding:0px;
	width:100%;
	border:1px solid #000000;
	
	-moz-border-radius-bottomleft:3px;
	-webkit-border-bottom-left-radius:3px;
	border-bottom-left-radius:3px;
	
	-moz-border-radius-bottomright:3px;
	-webkit-border-bottom-right-radius:3px;
	border-bottom-right-radius:3px;
	
	-moz-border-radius-topright:3px;
	-webkit-border-top-right-radius:3px;
	border-top-right-radius:3px;
	
	-moz-border-radius-topleft:3px;
	-webkit-border-top-left-radius:3px;
	border-top-left-radius:3px;
</style>
</head>
<body>
<h1>Enter Booking Details:</h1>
<div class="CSSTableGenerator" >
<form action="viewMeetingDetails" method="POST" name="form1">
<label>Meeting Date:</label><br>
<input type="text" name="startDate" required pattern="\d{1,2}-\d{1,2}-\d{2,4}" placeholder="DD-MM-YYYY">
<small>e.g 26-04-2016</small><br>
<label>Meeting Room:</label><br>
<input type="text" name="roomId" required placeholder="Meeting room">
<small>e.g MTE-MR-4F-06</small><br><br>	
<button type="submit">Retrieve Meeting Details</button>
</form>
</div>
</body>
</html>