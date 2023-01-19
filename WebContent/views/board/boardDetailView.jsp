<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세보기</title>
</head>
<body>

	<jsp:include page="../common/menubar.jsp"></jsp:include>
	
	<div class="outer" align="center">
		
		<br>
		
		<h1 align="center">게시판 상세조회</h1>
		
		<br>
		
		<div class="detail-area">
		
		<!-- BOARD_TITLE,
			USER_ID,
			COUNT,
			CREATE_DATE,
			BOARD_CONTENT -->
			
			<table align="center" border="1">
				<tr>
					<td width="100">글번호</td>
					<td width="500">${b.boardNo}</td>
				</tr>
				
				<tr>
					<td>제목</td>
					<td>${b.boardTitle}</td>
				</tr>
				
				<tr>
					<td>작성자</td>
					<td>${b.boardWriter}</td>
				</tr>
				
				<tr>
					<td>조회수</td>
					<td>${b.count}</td>
				</tr>
				
				<tr>
					<td>작성일</td>
					<td>${b.createDate}</td>
				</tr>
				
				<tr>
					<td>글내용</td>
					<td height="100">${b.boardContent}</td>
				</tr>
			</table>
		
		
			<!-- 댓글달기 table -->
			<table align="center" border="1">
				<tr>
				   <form action="insert.re?boardNo=${b.boardNo}" method="post">
						<td width="100">댓글작성</td>
						<td width="400"><textarea name="replyText"></textarea></td>
						<td width="100"><button>등록</button></td>
				   </form>
				</tr>
				
				<!-- 등록되어있는 댓글 보여주기 -->
				<tr>
					<td colspan="3"><b>댓글(${b.list.size()})</b></td>
				</tr>
				
				<c:forEach items="${b.list}" var="r">
				<tr>
					<td>${r.replyWriter}</td>
					<td>${r.replyContent}</td>
					<td>${r.createDate}</td>
				</tr>
				</c:forEach>
			</table>
		
		</div>
		
		
		<br><br><br><br><br>
		
	</div>
	
</body>
</html>