<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to MyBatis World</title>

<style>
	.login-area a{
		text-decoration : none;
		color : black;
		font-size : 12px;
	}
	
	.nav-area{
		background-color : #F6CED8;
		color : white;
		height : 50px;
	}

	.menu{
		display : table-cell;
		width : 200px;
		height : 50px;
		vertical-align : middle;
		font-size : 20px;
		font-weight : bold;
	}
	
	.menu:hover{
		background-color:#F5A9BC;
		cursor : pointer;
	}
	
	<!-- include된 페이지에서 사용할 공통 css 적용 -->
	.outer{
		width:900px;
		background-color : #F6CED8;
		color : white;
		margin : auto;
		margin-top : 50px;
	}
</style>

</head>
<body>

	<h1 align="center">Welcome to MyBatis World</h1>
	
	<br>
	
	<div class="login-area" align="right">
		
		<c:choose>	
			
			<c:when test="${empty loginUser}">
				<!-- CASE1. 로그인 전 화면 -->
				<form action="login.me" method="post">
					<table>
						<tr>
							<td>ID</td>
							<td><input type="text" name="userId" required></td>
							<td rowspan="2"><button type="submit" style="height:50px; background-color : #F6CED8;
								border:2px solid #F6CED8;">Login</button></td>
						</tr>
						<tr>
							<td>PW</td>
							<td><input type="password" name="userPwd" required></td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="enrollForm.me">Join</a> |
								<a href="">find ID/PW</a>
							</td>
						</tr>
					</table>
				</form>
			</c:when>
			
			
			<c:otherwise>
				<!-- CASE2. 로그인 후 화면 -->
				<div>
					<table>
						<tr>
							<td colspan="2">
								<h3>${loginUser.userName} Welcome</h3>
							</td>
						</tr>
						<tr>
							<td><a href="">MyPage</a></td>
							<td><a href="">LogOut</a></td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>	
	</div>
	
	<br>
	
	<div class="nav-area" align="center">
		<div class="menu">HOME</div>
		<div class="menu">공지사항</div>
		<div class="menu" onclick="location.href='list.bo?currentPage=1';">게시판</div>
		<div class="menu">ETC</div>		
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>