<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1" pageEncoding = "ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv = "Content-Type" content = "text/html; charset = ISO-8859-1">
		<title>Spring Form Demo </title>
		<style>
			body {background-color: #eee; font: helvetica; }
			#container {width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px}
			.green {font-weightL bold; color: green; }
			.message {margin-bottom: 10px; }
			label {width: 120px; display: inline-block; }
			form {line-height: 160%; }
			.hide {display: none; }
		</style>
	</head>
	<body>
		<c:if test = "${not empty message}">
			<div class = "message green">${message}</div>
		</c:if>
		<form:form modelAttribute = "superCar">
			<label for = "brand_input">Brand: </label>
			<form:input path = "brand" id = "brand_input" />
			<form:errors path = "brand" />
			<br/>
			
			<label for = "type_input">Type: </label>
			<form:input path = "type" id = "type_input" size = "50" />
			<br/>
			
			<label for = "engine_input">Engine: </label>
			<form:input path = "engine" id = "engine_input" size = "50" />
			<br/>
			
			<label>Transmission: </label>
			<c:forEach items = "${transmission_enum}" var = "transmission_item">
				<form:radiobutton path = "transmission" value = "${transmission_item}" />${transmission_item}
			</c:forEach>
			<br/>
			
			<label for = "fuel_input">Fuel: </label>
			<form:select path = "fuel" id = "fuel_input">
				<form:option value = "">Select Fuel</form:option>
				<c:forEach items = "${fuel_enum}" var = "fuel_item">
					<form:option value = "${fuel_item}">${fuel_item}</form:option>
				</c:forEach>
			</form:select>
			<br/>
			
			<label>Available: </label>
			<form:checkbox path = "available" />
			<br/>
			
			<label for = "motion_input">Motion: </label>
			<form:input path = "motion" id = "motion_input" size = "50" />
			<br/>
		</form:form> 
	</body>
</html>

