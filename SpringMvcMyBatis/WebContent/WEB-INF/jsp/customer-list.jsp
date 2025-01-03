<%@ page language = "java" contentType = "text/html;charset = ISO-8859-1" pageEncoding = "ISO-8859-1" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org.TR/html4.loose.dtd">

<html>
	<head>
		<meta http-equiv = "Content-Type" content = "text/html; charset = ISO-8859-1">
		<title>Customer List</title>
	</head>
	<body>
		<div>
			<table border = "1">
				<thead>
					<tr>
						<th>ID</th>
						<th>Full Name</th>
						<th>Address</th>
						<th>Email</th>
						<th width = "100"></th>
						<th width = "100"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items = "${customers}" var = "cust">
						<tr>
							<td>${cust.getCustId()}</td>
							<td>${cust.getFullName()}</td>
							<td>${cust.getAddress()}</td>
							<td>${cust.getEmail()}</td>
							<td><a href = "<c:url value = '/update-customer-${cust.getCustId()}'/>">edit</a></td>
							<td><a href = "<c:url value = '/delete-customer-${cust.getCustId()}'/>"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<p><a href = "index.jsp">Main Menu</a>
		</div>
	</body>
</html>