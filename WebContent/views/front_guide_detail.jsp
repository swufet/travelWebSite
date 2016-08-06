<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="static/css/mystyle.css"/>
</head>
<body>
	<div  class="one-worker-img-detail" style="background-image: url(${guide.coverImgPath});"></div>
	<div class="guide-name-con">
		<p>导游姓名：<span class="yellow">${guide.trueName}</span></p>
		<p>导游艺名：<span class="yellow">${guide.alias}</span></p>
	</div>
	<div>
		${guide.introduction}
	</div>
</body>
</html>