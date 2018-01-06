<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Data Maintenance</title>
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<h1>客戶資料查詢與維護作業</h1>
<br/>
	<form:form id="main">
		<table class="frame">
			<tr>
				<td>Company Name</td>
				<td><input type="text" name="companyName" class="txt" /></td>
			</tr>
			<tr>
				<td>Contact Name</td>
				<td><input type="text" name="contactName" class="txt" /></td>
			</tr>
			<tr>
				<td>Contact Title</td>
				<td><input type="text" name="contactTitle" class="txt"/></td>
			</tr>
		</table>
		<button type="submit" formaction="${pageContext.request.contextPath}/insert" formmethod="get">新增</button>
		<button type="submit" formaction="${pageContext.request.contextPath}/query" formmethod="get">查詢</button>
		<button type="reset">清除</button>
	</form:form>
</body>
</html>