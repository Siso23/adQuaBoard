<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>writeForm</title>
</head>
<body>
		<table width="100%" border="1">
			<tr>
		   	  	 <th>제목</th>
		   	  	 <th>작성자</th>
		   	  	 <th>조회수</th>
		   	  	 <th>등록일</th>
		   	  	 <th>IP-ADDR</th>
		   	</tr>
		   	<tr> 
		   		 <td>${board.title}</td>
			     <td>${board.writer}</td>
			     <td>${board.viewCount}</td>
			     <td>${board.regDate}</td>
			     <td>${clientIP}</td>
			     <td>${board.contents}</td>
			</tr>
		</table> <br/>
		<a href="${ pageContext.request.contextPath }/board/boardList.do">목록</a>
		<a href="${ pageContext.request.contextPath }/board/updateView.do?no=${board.boardNo}">수정</a>
		<a href="${ pageContext.request.contextPath }/board/delete.do?boardNo=${board.boardNo}">삭제</a>
		
		
	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		
		var msg= "<c:out value='${msg}'/>";  
		console.log(msg);
		
		if(msg != ""){
			alert(msg);
		}
	</script>
</body>
</html>