<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*" %>
<%@ page import="com.mindtree.model.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<% List<Employee> employees = (List<Employee>)session.getAttribute("employees"); %>
<% List<MeetingRoom> meetingRooms = (List<MeetingRoom>)session.getAttribute("meetingRooms"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Meeting</title>

<script>
function getXMLHttpRequest() {
    var xmlHttpReq = false;
    // Mozilla/Safari/Chrome
    if (window.XMLHttpRequest) {
           xmlHttpReq = new XMLHttpRequest();
    }
    // IE
    else if (window.ActiveXObject) {
           xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlHttpReq;
}
function getReadyStateHandlerFunction(xmlHttpRequest,elementId)
{
    return function(){
           if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200)
                 {
                 document.getElementById(elementId).innerHTML = xmlHttpRequest.responseText;
                 }
    }
}
function makeRequest(methodType,url,elementId,formName)
{
    var xmlHttpRequest= getXMLHttpRequest(); 
    xmlHttpRequest.onreadystatechange = getReadyStateHandlerFunction(xmlHttpRequest,elementId);       
 xmlHttpRequest.open(methodType, url, true);
    xmlHttpRequest.setRequestHeader("Content-Type",
                 "application/x-www-form-urlencoded");
    xmlHttpRequest.send(null);
    
    }

</script>

<style>
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
}.CSSTableGenerator table{
    border-collapse: collapse;
        border-spacing: 0;
	width:100%;
	height:100%;
	margin:0px;padding:0px;
}.CSSTableGenerator tr:last-child td:last-child {
	-moz-border-radius-bottomright:3px;
	-webkit-border-bottom-right-radius:3px;
	border-bottom-right-radius:3px;
}
.CSSTableGenerator table tr:first-child td:first-child {
	-moz-border-radius-topleft:3px;
	-webkit-border-top-left-radius:3px;
	border-top-left-radius:3px;
}
.CSSTableGenerator table tr:first-child td:last-child {
	-moz-border-radius-topright:3px;
	-webkit-border-top-right-radius:3px;
	border-top-right-radius:3px;
}.CSSTableGenerator tr:last-child td:first-child{
	-moz-border-radius-bottomleft:3px;
	-webkit-border-bottom-left-radius:3px;
	border-bottom-left-radius:3px;
}.CSSTableGenerator tr:hover td{
	
}
.CSSTableGenerator tr:nth-child(odd){ background-color:#ffaa56; }
.CSSTableGenerator tr:nth-child(even)    { background-color:#ffffff; }
.CSSTableGenerator td{
	vertical-align:middle;
	border:1px solid #000000;
	border-width:0px 1px 1px 0px;
	text-align:left;
	padding:7px;
	font-size:10px;
	font-family:Arial;
	font-weight:normal;
	color:#000000;
}.CSSTableGenerator tr:last-child td{
	border-width:0px 1px 0px 0px;
}.CSSTableGenerator tr td:last-child{
	border-width:0px 0px 1px 0px;
}.CSSTableGenerator tr:last-child td:last-child{
	border-width:0px 0px 0px 0px;
}
.CSSTableGenerator tr:first-child td{
		background:-o-linear-gradient(bottom, #ff7f00 5%, #bf5f00 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ff7f00), color-stop(1, #bf5f00) );
	background:-moz-linear-gradient( center top, #ff7f00 5%, #bf5f00 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#ff7f00", endColorstr="#bf5f00");	background: -o-linear-gradient(top,#ff7f00,bf5f00);

	background-color:#ff7f00;
	border:0px solid #000000;
	text-align:center;
	border-width:0px 0px 1px 1px;
	font-size:14px;
	font-family:Arial;
	font-weight:bold;
	color:#ffffff;
}
.CSSTableGenerator tr:first-child:hover td{
	background:-o-linear-gradient(bottom, #ff7f00 5%, #bf5f00 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ff7f00), color-stop(1, #bf5f00) );
	background:-moz-linear-gradient( center top, #ff7f00 5%, #bf5f00 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#ff7f00", endColorstr="#bf5f00");	background: -o-linear-gradient(top,#ff7f00,bf5f00);

	background-color:#ff7f00;
}
.CSSTableGenerator tr:first-child td:first-child{
	border-width:0px 0px 1px 0px;
}
.CSSTableGenerator tr:first-child td:last-child{
	border-width:0px 0px 1px 1px;
}

.btn {
  background: #ff7f00;
  background-image: -webkit-linear-gradient(top, #ff7f00, #bf5f00);
  background-image: -moz-linear-gradient(top, #ff7f00, #bf5f00);
  background-image: -ms-linear-gradient(top, #ff7f00, #bf5f00);
  background-image: -o-linear-gradient(top, #ff7f00, #bf5f00);
  background-image: linear-gradient(to bottom, #ff7f00, #bf5f00);
  -webkit-border-radius: 18;
  -moz-border-radius: 18;
  border-radius: 18px;
  font-family: Arial;
  color: #ffffff;
  font-size: 15px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #3cb0fd;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
}

form
{
	float:left;
	margin-right:100px;
}

label {width: 300px; padding-right: 20px; display: inline-block }
.details
{
	float:right;
	margin-right:100px;
	/* box-shadow: 10px 10px 5px #888888; */
	
}

.empArea
{
	float:right;
	margin-right:250px;
	margin-top:50px;
}

</style>
</head>
<body>
<h3>Enter booking details</h3>
<div class="CSSTableGenerator" >
<form action="addMeeting" method="GET" name="form1" commandName="meeting">
<label>Subject:</label> <br>
<input type="text" name="subject" placeholder="Meeting Topic" required><br>
<label>Start Date:</label><br>
<input type="text"  name="startDate" required pattern="\d{1,2}-\d{1,2}-\d{2,4}" placeholder="DD-MM-YYYY">
<small>e.g 25-04-2016</small><br>
<label>Start Time:</label><br>
<input type="text"  name="startTime" required pattern="\d{1,2}:\d{2}" placeholder="HH:MM">
<small>e.g 7:00</small><br>
<label>End Date:</label><br>
<input type="text"  name="endDate" required pattern="\d{1,2}-\d{1,2}-\d{2,4}" placeholder="DD-MM-YYYY">
<small>e.g 25-04-2016</small><br>
<label>End Time:</label><br>
<input type="text" name="endTime" required pattern="\d{1,2}:\d{2}" placeholder="HH:MM">
<small>e.g 8:00</small><br>
<label>Meeting Room:</label><br>
<select name="meetingRoomSelect" onchange="makeRequest('GET','ScheduleMeetingController?meetingRoomSelect=' + 
												form1.meetingRoomSelect.value+'&employeeSelect=' +
												form1.employeeSelect.value,'details','null')">
<%int count1 = 0; %>
<c:forEach begin="0" end="${meetingRooms.size() - 1}" varStatus="loop">
	
	 <option value="<%=meetingRooms.get(count1).getRoomId() %>"><%=meetingRooms.get(count1).getRoomId() %></option>
	
	<%count1++; %>
</c:forEach>

</select><br>
<label>Booked By Employee:</label><br>
<select name="employeeSelect" onchange="makeRequest('GET','ScheduleMeetingController?meetingRoomSelect=' + 
												form1.meetingRoomSelect.value+'&employeeSelect=' +
												form1.employeeSelect.value,'details','null')">
<%int count2 = 0; %>
<c:forEach begin="0" end="${employees.size() - 1}" varStatus="loop">
	
	 <option value="<%=employees.get(count2).getEmpId() %>"><%=employees.get(count2).getEmpId() %></option>
	
	<%count2++; %>
</c:forEach>
</select> <br>
		
<br>
<button type="submit">Create Meeting Schedule</button><a href = "index.jsp">
<button type="button">Back</button></a>
</form>
</div>
<div id="details">
	<output class='info' id='roomDetails'>Room Details:</output><br>
	<output class='info' id='location'>Location: <%=meetingRooms.get(0).getRoomLocation()%></output><br>
	<output id='seats' class='info'>#Seats: <%=meetingRooms.get(0).getRoomSize() %></output><br>
	<div id='empArea'>
	<output id='empDetails' class='info'>Employee Details:</output><br>
	<output id='empName' class='info'>Name: <%=employees.get(0).getFirstName() %>  <%=employees.get(0).getLastName() %></output><br>
	<output id='empEmail' class='info'>Email: <%=employees.get(0).getEmail() %></output>
	</div>
</div>
</body>
</html>