<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导游列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="static/css/mystyle.css"/>
</head>
<body>
	<div class="serch-nav" id="serch-nav">
		<form action="serch_name.do" method="post">
			<input type="submit" class="mybtn f-right" value="立即搜索"/>
			<input type="text" placeholder="输入导游姓名搜索" class="serch-text f-right" name="name"/>
		</form>
	</div>
	<div class="hasnav">
		<c:if test="${guides ne null }">
		<c:forEach items="${guides }" var="guide">
			<a href="front_guide_${guide.id }.do" class="one-worker-con">
				<div class="one-worker">
					<div class="one-worker-img" style="background-image: url(${guide.coverImgPath});"></div>
					<p>${guide.trueName }</p>
				</div>
			</a>
		</c:forEach>
		</c:if>
	</div>
</body>
<script src="static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="static/js/front_guides.js" type="text/javascript" charset="utf-8"></script>
</html>