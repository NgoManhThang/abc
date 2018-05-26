<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/user/add" var="add"></c:url>
	<form:form action="${add}" method="post" modelAttribute="person">
		<label>Tên</label>
		<form:input type="text" path="name" placeholder="Nhập tên"/>
		<label>Tuổi</label>
		<form:input type="number" path="age" placeholder="Nhập tuổi"/>
		<button type="submit">Thêm</button>
	</form:form>
</body>
</html>