<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>

		</tr>
		<c:forEach var="idto" items="${content_view}">
			<tr>
				<td>${idto.name}</td>
				<td>${idto.price}</td>
				<td>${idto.description}</td>
			</tr>
		</c:forEach>
	</table>
		

</body>
</html>