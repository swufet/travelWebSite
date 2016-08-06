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
		<jsp:include page="header_guides.jsp"></jsp:include>
		<div class="workers-con">
			<a class="mybtn" href="add_guide.do">添加员工</a>
			<a class="mybtn f-right" href="guides.do">最新添加</a>
			<a class="mybtn f-right namebtn" href="guides_byname.do">姓名排序</a>
			<hr />
			<div class="guides-con">
			<c:if test="${guides ne null }">
			<c:forEach items="${guides }" var="guide">
				<a href="update_guide_${guide.id }.do" class="one-worker-con">
					<div class="one-worker">
					<c:if test="${guide.coverImgPath ne null }">
						<div class="one-worker-img" style="background-image: url(${guide.coverImgPath});"></div>
					</c:if>
					<c:if test="${guide.coverImgPath eq null }">
						<div class="one-worker-img" style="background-image: url(static/img/guidebg.jpg);"></div>
					</c:if>
					<c:if test="${guide.trueName ne null }">
						<p>${guide.trueName }</p>
					</c:if>
					<c:if test="${guide.trueName eq null }">
						<p>&nbsp</p>
					</c:if>
					</div>
				</a>
			</c:forEach>
			</c:if>
			</div>
		</div>
	</body>
</html>
