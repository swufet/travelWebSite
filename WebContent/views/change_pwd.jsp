<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>修改密码</title>
		<link rel="stylesheet" type="text/css" href="static/css/mystyle.css"/>
	</head>
	<body class="bg-gray">
		<jsp:include page="header_guides.jsp"></jsp:include>
		<style>
			.item-active {
			    background-color: #0066FF;
			}
		</style>
		<form class="login-con" method="post" action="save_change_pwd.do">
			<h1>修改密码</h1>
			<table>
				<tr>
					<td><label>原密码:</label></td>
					<td><input type="text" placeholder="请输入原密码" required="required" name="oldPwd"></td>
				</tr>
				<tr>
					<td><label>新密码:</label></td>
					<td><input type="password" placeholder="请输入新密码" required="required" name="newPwd"></td>
				</tr>
				<tr>
					<td><label>确认新密码:</label></td>
					<td><input type="password" placeholder="请再次输入新密码" required="required" name="newPwd2"></td>
				</tr>
					<tr>
						<td colspan="2" style="padding:0;height:21px;">
							
							<div class="login-info">
								${message }
							</div>
						</td>
					</tr>
				<tr>
					<td></td>
					<td><input type="submit" class="mybtn" id="loginbtn" value="提交更改"></input></td>
				</tr>
			</table>
		</form>
	</body>
	<script src="static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
</html>
