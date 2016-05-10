<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*" %>
<%@ page import="com.mindtree.model.*" %>
<html>
<head>
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
}.CSSTableGenerator tr:hover td{}
.CSSTableGenerator td{
	vertical-align:middle;
	border:1px solid #000000;
	border-width:0px 1px 1px 0px;
	text-align:center;
	padding:7px;
	font-size:11px;
	font-family:Arial;
	font-weight:normal;
}.CSSTableGenerator tr:last-child td{
	border-width:0px 1px 0px 0px;
}.CSSTableGenerator tr td:last-child{
	border-width:0px 0px 1px 0px;
}.CSSTableGenerator tr:last-child td:last-child{
	border-width:0px 0px 0px 0px;
}
.CSSTableGenerator tr:first-child td{	
	border:0px solid #000000;
	text-align:center;
	border-width:0px 0px 1px 1px;
	font-size:14px;
	font-family:Arial;
	font-weight:bold;
}

.CSSTableGenerator tr:first-child td:first-child{
	border-width:0px 0px 1px 0px;
}
.CSSTableGenerator tr:first-child td:last-child{
	border-width:0px 0px 1px 1px;
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
	
}

.empArea
{
	float:right;
	margin-right:250px;
	margin-top:50px;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meetings</title>
</head>
<body>
<div class="CSSTableGenerator" >
                <table >
                    <tr>
                        <td>
                            Meeting Start Time
                        </td>
                        <td >
                            Meeting End Time
                        </td>
                        <td>
                            Subject
                        </td>
                        <td>
                            Meeting Booked By
                        </td>
                    </tr>
                    
				<c:forEach begin="0" end="${meetings.size() - 1}" varStatus="loop">           
                    <tr>
                        <td>
                             ${meetings.get(loop.index).getStartTime()}
                        </td>
                        <td>
                            ${meetings.get(loop.index).getEndTime()}
                        </td>
                        <td>
                            ${meetings.get(loop.index).getSubject()}
                        </td>
                        
                         <td>
                            ${meetings.get(loop.index).getEmployee().getEmpId() } - ${meetings.get(loop.index).getEmployee().getFirstName()} 
                        </td>
                    </tr>                
                   </c:forEach>
                   
                </table>
            </div>
            
            <a href="index.jsp"><button>Back</button></a>
</body>
</html>

