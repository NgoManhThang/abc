<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/rs/css/main.css" var="style"></c:url>
<link href="${style}" rel="stylesheet" />
<title>Hello</title>
</head>
<body>
	Xin chào
	<h1>${msg}</h1>
</body>
</html>