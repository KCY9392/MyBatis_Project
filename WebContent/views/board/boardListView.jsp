<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

<style>
	
	#search-area{
		text-align:right;
		margin-right:28%;
	}
	
	#list-area{
		border:1px solid pink;
		text-align:center;
	}

</style>

</head>
<body>

	<jsp:include page="../common/menubar.jsp"/>

	<div class="outer" align="center">
		
		<br>
		
		<h1 align="center">게시판</h1>
		
		<br>
		
		<!-- 검색창 -->
		
		<div id="search-area">
			<form action="search.bo" method="get">
				<input type="hidden" name="currentPage" value="1">
				
				<select name="category">
				<!-- 방법 1. el태그 -->
<%-- 				<option value="writer" <c:out value='${category eq "writer" ? "selected": "" }'/>>작성자</option> --%>
<%-- 				<option value="title"  <c:out value='${category eq "title" ? "selected": "" }'/>>제목</option> --%>
<%-- 				<option value="content"<c:out value='${category eq "content" ? "selected": "" }'/>>내용</option> --%>
				
				<!-- 방법 2. javascript -> 환경에 맞게 코드를 바꿔줘야하는 단점이 있음. -->
					<option value="writer">작성자</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				  <c:if test="${not empty category}">
				  	<script>
				  		let category = document.querySelector("#search-area select option[value=${category}]");
				  		category.selected = true;
 				  	</script> 
				  </c:if>
				  
				 <!-- 방법 3. jQuery 해보기 !!! -->
<!-- 				  	<option value="writer">작성자</option> -->
<!-- 					<option value="title">제목</option> -->
<!-- 					<option value="content">내용</option> -->
					
				</select>
				
				
				
				<!-- 
					1. 검색한 기록이 남아있을 수 있도록
					2. 검색한 셀렉트박스 옵션이 선택되어 있도록
					3. 페이지 이동시, 내가 검색한 내용이 유지되도록 추가 
				-->
				<input type="text" name="keyword" value="<c:out value='${keyword}'/>">
				<button type="submit">검색</button>
			</form>
		</div>
		
		
		<br><br>
		
		
		<!-- 게시판 목록 -->
		
		<table id="list-area">
			<thead>
				<tr>
					<th>글번호</th>
					<th width="400">제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>			
			</thead>
			<tbody>
				<c:if test="${!empty list}">
					<c:forEach items="${list}" var="b">
						<tr>
							<td>${b.boardNo}</td>
							<td><a href="detail.bo?boardNo=${b.boardNo}">${b.boardTitle}</a></td> <!-- 내부적으로 getter메소드로 값을 가져오고있음 -->
							<td>${b.boardWriter}</td>
							<td>${b.count}</td>
							<td>${b.createDate}</td>
						</tr>
					</c:forEach>
				</c:if>
				
			</tbody>
		</table>
		
		
		
		<br>
		
		<!-- 페이징 버튼 바 -->
		
		<div id="paging-area">
			<!-- 즉, 지금 요청페이지가 첫페이지가 아니라면, [이전]버튼 생기게 -->
			
			<c:if test="${ not empty category}">
			
				<c:if test="${!empty pi}">
				
					<c:if test="${pi.currentPage ne 1 }"> 
						<a href="list.bo?currentPage=${pi.currentPage - 1}">[이전]</a>
					</c:if>
					
					
					<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}" step="1"> <!-- step default => 1 -->
						<a href="list.bo?currentPage=${p}">[${p}]</a>
					</c:forEach>
					
					
					<!-- 즉, 지금 요청페이지가 마지막페이지가 아니라면, [다음]버튼 생기게  -->
					<c:if test="${pi.currentPage ne pi.maxPage}">
						<a href="list.bo?currentPage=${pi.currentPage + 1}">[다음]</a>
					</c:if>
				
				</c:if>
				
				
				
				<c:if test="${!empty spi}">
					
					<c:if test="${spi.currentPage ne 1}"> 
						<a href="search.bo?currentPage=${spi.currentPage - 1}&category=${category}&keyword=${keyword}">[이전]</a>
					</c:if>
					
					
					<c:forEach var="p" begin="${spi.startPage}" end="${spi.endPage}" step="1"> <!-- step default => 1 -->
						<a href="search.bo?currentPage=${p}&category=${category}&keyword=${keyword}">[${p}]</a>
					</c:forEach>
					
					
					<!-- 즉, 지금 요청페이지가 마지막페이지가 아니라면, [다음]버튼 생기게  -->
					<c:if test="${spi.currentPage ne spi.maxPage}">
						<a href="search.bo?currentPage=${spi.currentPage + 1}&category=${category}&keyword=${keyword}">[다음]</a>
					</c:if>
				
				</c:if>
				
			</c:if>
		</div>
		
		
		
	</div>

</body>
</html>