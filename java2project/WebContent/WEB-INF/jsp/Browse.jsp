<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet" type="text/css">
<title>客戶資料瀏覽</title>
  <script type="application/javascript">

        function ready() {            
			document.getElementById("companyName").value = getQueryString("companyName");
			document.getElementById("contactName").value = getQueryString("contactName");
			document.getElementById("contactTitle").value = getQueryString("contactTitle");
        }
        
        function getQueryString(name){

           return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
           // [?|&]: ? or & 
           // ([^&;]+?): +? 表示 [^&;] 出現一次以上，而[^&;]表示除了 "&", ";" 以外的字元
           // (&|#|;|$): 表示出現"&" or "#" or ";" or "$"
           // /\+/g: /../ 中間是 Reqular expression \+ 表示 "+", g 表示所有符合 RE 的字串，此例是 "+""
           
        }
	</script>	
</head>
<body onload="ready()">
	<form:form id="form"  modelAttribute="customers">
		<table class="frame">
			<tr>
				<td>Company Name</td>
				<td><input type="text" id="companyName" name="companyName" class="txt"
					 /></td>
			</tr>
			<tr>
				<td>Contact Name</td>
				<td><input type="text" id="contactName" name="contactName" class="txt"  /></td>
			</tr>
			<tr>
				<td>Contact Title</td>
				<td><input type="text" id="contactTitle" name="contactTitle" class="txt"
					 /></td>
			</tr>
		</table>
		<button type="submit" formaction="${pageContext.request.contextPath}/insert" formmethod="get">新增</button>
		<button type="submit" formaction="${pageContext.request.contextPath}/query"  formmethod="get">查詢</button>
		<button type="reset">清除</button>

		
		<table class="frame">
			<tr>
				<th></th>
				<th></th>
				<th>Company Name</th>
				<th>Contact Name</th>
				<th>Contact Title</th>
				<th>Country</th>
			</tr>
			<c:forEach var="customer" items="${customers}">
				<tr>
					<c:url var="updateURL" value="update">
						<c:param name="custid" value="${customer.custid}" />
						<c:param name="companyName" value="${companyName}" />
						<c:param name="contactName" value="${contactName}" />
						<c:param name="contactTitle" value="${contactTitle}" />
					</c:url>
					<td><a href="${updateURL}"/>修改</a></td>
					<c:url var="deletionURL" value="delete">
						<c:param name="custid" value="${customer.custid}" />
						<c:param name="companyName" value="${companyName}" />
						<c:param name="contactName" value="${contactName}" />
						<c:param name="contactTitle" value="${contactTitle}" />
					</c:url>
					<td><a href="${deletionURL}"  onclick="return doDeletion()"/>刪除</a></td>
					<td>${customer.companyName}</td>
					<td>${customer.contactName}</td>
					<td>${customer.contactTitle}</td>
					<td>${customer.country}</td>
				</tr>
			</c:forEach>
		</table>

		<button type="submit" formaction="${pageContext.request.contextPath}/insert" formmethod="get">新增</button>
		<button type="submit" formaction="${pageContext.request.contextPath}/query"  formmethod="get">查詢</button>
		<button type="reset">清除</button>
	</form:form>
	<script>

		function doDeletion() {
			return confirm("確定刪除嗎 ?");
		}
	</script>

</body>
</html>