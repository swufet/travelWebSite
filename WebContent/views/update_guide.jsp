<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>设置导游--${guide.trueName}的信息</title>
		<link rel="stylesheet" type="text/css" href="static/css/mystyle.css"/>
	</head>
	<body class="bg-gray">
		<jsp:include page="header_guides.jsp"></jsp:include>
		<form class="left-content" action="save_guide_${guide.id}.do" method="post">
			<label>请输入导游真实姓名：</label><br />
			<input id="guide-trueName" type="text" placeholder="真实姓名" name="trueName" value="${guide.trueName }"/><br />
			<hr />
			<label>请输入导游艺名：</label><br />
			<input id="guide-alias" type="text" placeholder="艺名" name="alias" value="${guide.alias }"/><br />
			<hr />
			<label>选择该导游的头像：</label><br />
			<input type="file" value="s" width="500" name="file" id="upfile"/><br />
			<a class="uploadImg mybtn" id="uploadbtn">上传并预览</a>
			<c:if test="${guide.coverImgPath ne null}">
			<input type="hidden" id="coverImgPath" name="coverImgPath" value="${guide.coverImgPath }" >
			</c:if>
			<c:if test="${guide.coverImgPath eq null}">
			<input type="hidden" id="coverImgPath" name="coverImgPath" value="static/img/guidebg.jpg" >
			</c:if>
			<hr />
			<label>导游介绍：</label><br />
			<textarea class="text-content" id="intr-editor" name="introduction">
			${guide.introduction }
			</textarea>
			<input type="submit" value="提交修改" class="mybtn"/>
			<a class="mybtn" href="javascript:deleteGuide(${guide.id})">删除此导游</a>
		</form>
		<div class="right-content">
			<div class="title-preview-con">
				<h4>封面效果预览</h4>
				<div class="iphone guide-preview">
					<c:if test="${guide.coverImgPath ne null}">
					<div id="title-preview-img" class="one-worker-img" style="background-image: url(${guide.coverImgPath})"></div>
					</c:if>
					<c:if test="${guide.coverImgPath eq null}">
					<div id="title-preview-img" class="one-worker-img"  style="background-image: url(static/img/guidebg.jpg)"></div>
					</c:if>
					<div id="title-preview-text" class="title-preview-text">${guide.trueName }</div>
				</div>
				<hr />
			</div>
			<div class="content-preview-con">
				<h4>导游介绍效果预览</h4>
				<div class="iphone content-preview">
					<c:if test="${guide.coverImgPath ne null}">
						<div  class="one-worker-img-detail" style="background-image: url(${guide.coverImgPath});"></div>
					</c:if>
					<c:if test="${guide.coverImgPath eq null}">
						<div  class="one-worker-img-detail" style="background-image: url(static/img/guidebg.jpg)"></div>
					</c:if>
					<div class="guide-name-con">
						<p>导游姓名：<span class="yellow">${guide.trueName}</span></p>
						<p>导游艺名：<span class="yellow">${guide.alias}</span></p>
					</div>
					<div>
						${guide.introduction}
					</div>
				</div>
				<hr />
			</div>
		</div>
	</body>
	<script src="static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/ueditor/ueditor.all.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/js/jquery.jsonrpc.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/js/ajaxfileupload.js" type="text/javascript" charset="utf-8"></script>
	<script src="static/js/guide.js" type="text/javascript" charset="utf-8"></script>
</html>
