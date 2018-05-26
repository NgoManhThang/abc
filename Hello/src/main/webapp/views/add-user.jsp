<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/user/add" var="add"></c:url>
	<form:form action="${add}" method="post" modelAttribute="person">
		<label><spring:message code="person.name" /></label>
		<form:input type="text" path="name" placeholder="Nhập tên" />
		<form:errors path="name" />
		<label><spring:message code="person.tuoi" /></label>
		<form:input type="number" path="age" placeholder="Nhập tuổi" />
		<form:errors path="age" />
		<button type="submit">
			<spring:message code="action.add" />
		</button>
	</form:form>
</body>
</html>