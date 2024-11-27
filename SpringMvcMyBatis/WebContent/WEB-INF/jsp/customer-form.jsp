<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org.TR/html4.loose.dtd">

<html>
	<head>
		<meta http-equiv = "Content-Type" content = "text/html; charset=SO-8859-1">
		<title>Customer Form</title>
	</head>
	<body>
		<c:if test = "${not empty err_message}">
			<h3>
				<font color = "red">${err_message}</font>
			</h3>	
		</c:if>
		<c:if test = "${not empty success_message}">
			<h3>
				<font color = "blue">${success_message}</font>
			</h3>	
		</c:if>
		
		<form:form modelAttribute = "customerForm">
			<label for = "custid">Customer ID: </label>
			<c:if test = "${cust_id == 0}">
				<form:input path = "custId" />
				<form:errors path = "custId" />
			</c:if>
			<c:if test = "${cust_id != 0}">
				<form:hidden path = "custId" />
			</c:if>
			<br />
			
			<label for = "fullname">Full Name: </label>
			<form:input path = "fullname" size = "50" /> 
			<form:errors path = "fullname" />
			<br />
			
			<label for = "address">Address: </label>
			<form:input path = "address" size = "50" /> 
			<form:errors path = "address" />
			<br />
			
			<label for = "email">Email: </label>
			<form:input path = "email" size = "50" /> 
			<form:errors path = "email" /> 
			<br />
			
			<form:hidden path = "flag" />
			<input type = "submit" value = "Submit" />
		</form:form>
		<p> <a href = "index.jsp">Main Menu</a>
	</body>
</html>