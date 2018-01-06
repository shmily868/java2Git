<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet" type="text/css">
</head>
<body>
		<table class="frame">	
			<form:input type="hidden" name="custid" path="custid" />
			<tr>
				<td>*companyname</td>
				<td><form:input type="text" path="companyName"/></td>
			</tr>
			<tr>
				<td>*contactname</td>
				<td><form:input type="text" path="contactName"/></td>
			</tr>
			<tr>
				<td>*contacttitle</td>
				<td><form:input type="text" name="contacttitle" class="txt" path="contactTitle"/></td>
			</tr>
			<tr>
				<td>*address</td>
				<td><form:input type="text" name="address" class="txt" path="address"/></td>
			</tr>
			<tr>
				<td>*city</td>
				<td><form:input type="text" name="city" class="txt" path="city"/></td>
			</tr>
			<tr>
				<td>region</td>
				<td><form:input type="text" name="region" class="txt" path="region"/></td>
			</tr>
			<tr>
				<td>postalcode</td>
				<td><form:input type="text" name="postalcode" class="txt" path="postalCode"/></td>
			</tr>
			<tr>
				<td>*country</td>
				<td><form:input type="text" name="country" class="txt" path="country"/></td>
			</tr>
			<tr>
				<td>*phone</td>
				<td><form:input type="text" name="phone" class="txt" path="phone"/></td>
			</tr>
			<tr>
				<td>*fax</td>
				<td><form:input type="text" name="fax" class="txt" path="fax" /></td>
			</tr>
		</table>
</body>
</html>