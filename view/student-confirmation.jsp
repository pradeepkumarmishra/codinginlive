<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Confirmed</title>
</head>
<body>
Student is confirmed with below details:<br><br>
Name: ${student.firstName} ${student.lastName}<br><br>
Country: ${student.country}<br><br>
Language: ${student.language}<br><br>
Postal Code: ${student.postalCode}<br><br>
Free Passes you chose:${student.freePasses}<br><br>
Course Code:${student.courseCode}


</body>
</html>