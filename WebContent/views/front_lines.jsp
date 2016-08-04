<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>front_lines</title>
		<link rel="stylesheet" type="text/css" href="static/css/lines.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	<body>
		<c:forEach items="${lines }" var="line">
			<a href="front_line_${line.id}.do"  class="one-line">
				<div  class="one-line-img" style="background-image: url(${line.coverImgPath});"></div>
				<p class="one-line-text">${line.title}</p>
			</a>
		</c:forEach>
	</body>
</html>
