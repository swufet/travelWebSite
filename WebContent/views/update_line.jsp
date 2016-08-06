<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>更新线路--${line.title}的信息</title>
		<link rel="stylesheet" type="text/css" href="static/ueditor/themes/default/css/umeditor.css"/>
		<link rel="stylesheet" type="text/css" href="static/css/mystyle.css"/>
	</head>
	<body class="bg-gray">
		<jsp:include page="header.jsp"></jsp:include>
		<form class="left-content" action="save_line_${line.id}.do" method="post">
			<label>请输入资料标题：</label><br />
			<input id="line-title" type="text" placeholder="请输入路线标题" name="title" value="${line.title }"/><br />
			<label>选择该资料的封面图片：</label>
			<input type="file" value="s" name="file" id="upfile"/>
			<a class="uploadImg mybtn" id="uploadbtn">上传图片并预览</a>
			<c:if test="${line.coverImgPath ne null}">
			<input type="hidden" id="coverImgPath" name="coverImgPath" value="${line.coverImgPath }" >
			</c:if>
			<c:if test="${line.coverImgPath eq null}">
			<input type="hidden" id="coverImgPath" name="coverImgPath" value="static/img/linebg.jpg" >
			</c:if>
			<br>
			<label>资料正文内容：</label><br />
			<textarea class="text-content" id="intr-editor" name="lineContent">
			${line.lineContent }
			</textarea>
			<input type="submit" value="提交修改" class="mybtn"/>
		</form>
		<div class="right-content">
			<div class="title-preview-con">
				<h4>封面效果预览</h4>
				<div class="iphone title-preview">
					<c:if test="${line.coverImgPath ne null}">
					<div id="title-preview-img" class="title-preview-img" style="background-image: url(${line.coverImgPath})"></div>
					</c:if>
					<c:if test="${line.coverImgPath eq null}">
					<div id="title-preview-img" class="title-preview-img" style="background-image: url(static/img/linebg.jpg)"></div>
					</c:if>
					<div id="title-preview-text" class="title-preview-text">${line.title }</div>
				</div>
				<hr />
			</div>
			<div class="content-preview-con">
				<h4>正文效果预览</h4>
				<div class="iphone content-preview">
					${line.lineContent }
				</div>
			</div>
		</div>
	</body>
	<script src="static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/ueditor/umeditor.config.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/ueditor/umeditor.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/js/jquery.jsonrpc.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/js/ajaxfileupload.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/js/travelLine.js" type="text/javascript" charset="utf-8"></script>
</html>
