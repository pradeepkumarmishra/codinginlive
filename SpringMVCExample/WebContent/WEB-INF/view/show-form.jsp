<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

Student Form:
<br>
<form:form action="processForm" modelAttribute="student">
First Name
<form:input name="FirstName"  path="firstName"/>
<form:errors path="firstName" cssClass="error"/>
<br><br>
Last Name
<form:input name="LastName"  path="lastName"/>
<form:errors path="lastName" cssClass="error"/>
<br><br>
Country
<form:select path="country" cssClass="form-control">
<form:option value="India">India</form:option>
<form:option value="France">France</form:option>
</form:select>
<br><br>
Favourite Languge:
<form:radiobuttons path="language" items="${student.languageOptions}"/>
<br><br>
Postal Code:
<form:input path="postalCode"/>
<form:errors path="postalCode" cssClass="error"/>
<br><br>
Enter no of Free pass you want:<br>
<form:input path="freePasses"/>
<form:errors path="freePasses" cssClass="error"/>
<br><br>
Course Code:
<form:input path="courseCode"/>
<form:errors path="courseCode" cssClass="error"/>
<br><br>
<input type="submit" value="Submit">
</form:form>