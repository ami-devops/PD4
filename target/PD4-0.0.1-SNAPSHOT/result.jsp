<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>
<h1>Employee Information</h1>
<h2> Welcome ${emp.empName} </h2>
<h2> Your EmployeeId is :${emp.empId}</h2>
   <table>
    <tr>
        <td>Name</td>
        <td>${emp.empName}</td>
    </tr>
    <tr>
        <td>Salary</td>
        <td>${emp.salary}</td>
    </tr>    
</table>  
</body>
</html>