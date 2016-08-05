<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>欢迎登陆</title>
		<link rel="stylesheet" type="text/css" href="static/css/mystyle.css"/>
	</head>
	<body class="full-bg bg-gray">
		<form class="login-con" method="post" action="login.do">
			<h1>后台管理界面</h1>
			<table>
				<tr>
					<td><label>用户名:</label></td>
					<td><input type="text" placeholder="请输入用户名" required="required" name="username"></td>
				</tr>
				<tr>
					<td><label>密码:</label></td>
					<td><input type="password" placeholder="请输入密码" required="required" name="password"></td>
				</tr>
					<tr>
						<td colspan="2" style="padding:0;height:21px;">
							
							<div class="login-info">
								<c:if test="${loginSuccess == false}">
								登录失败，请检查用户名和密码！
								</c:if>
							</div>
						</td>
					</tr>
				<tr>
					<td></td>
					<td><input type="submit" class="mybtn" id="loginbtn" value="登录" onclick="login()"></input></td>
				</tr>
			</table>
		</form>
	</body>
	<script src="static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
</html>
