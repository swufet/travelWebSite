<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TravelLines</title>
		<link rel="stylesheet" type="text/css" href="static/css/mystyle.css"/>
	</head>
	<body class="bg-gray">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="lines-con">
			<a class="mybtn" href="add_new_line.do">添加路线</a>
			<c:forEach items="${lines }" var="line">
			<div class="one-line" id="line-${line.id }">
				<a href="javascript:deleteLine(${line.id})" class="mybtn f-right one-line-operate">删除</a>
				<a href="update_line_${line.id}.do" class="mybtn f-right one-line-operate">修改</a>
				<div class="one-line-img" style="background-image: url(${line.coverImgPath});"></div>
				<div class="one-line-title">${line.title }</div>
			</div>
			</c:forEach>
		</div>
	</body>
	<script src="static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/js/manageLines.js" type="text/javascript" charset="utf-8"></script>
</html>
