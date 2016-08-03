<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>setTravelLine</title>
		<link rel="stylesheet" type="text/css" href="static/css/mystyle.css"/>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<form class="left-content" action="addLine" method="post">
			<label>请输入路线标题：</label><br />
			<input type="text" placeholder="请输入路线标题" name="title"/><br />
			<hr />
			<label>选择该路线的封面图片：</label><br />
			<input type="file" value="s" width="500" name="uploadfile"/><br />
			<a class="uploadImg mybtn" href="#">上传图片</a>
			<hr />
			<label>路线正文内容：</label><br />
			<textarea class="text-content" id="intr-editor" name="content">
			</textarea>
			<input type="submit" value="提交修改" class="mybtn"/>
		</form>
		<div class="right-content">
			<div class="title-preview-con">
				<h4>封面效果预览</h4>
				<div class="iphone title-preview">
					<div class="title-preview-img" style="background-image: url(static/img/jip.jpg);"></div>
					<div class="title-preview-text">泰国清迈三日游</div>
				</div>
				<hr />
			</div>
			<div class="content-preview-con">
				<h4>正文效果预览</h4>
				<div class="iphone content-preview">
					
				</div>
				<hr />
			</div>
		</div>
	</body>
	<script src="static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/js/travelLine.js" type="text/javascript" charset="utf-8"></script>
</html>
