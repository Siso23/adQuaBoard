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
	<form name="writeForm" method="post" 
		  action="${pageContext.request.contextPath }/board/update.do">
		  	
		<table width="100%" border="1">
			<tr>
		   	  	 <th>제목</th>
		   	  	 <th>작성자</th>
		   	  	 <th>등록일</th>
		   	  	 <th>조회수</th>
		   	  	 <th>내용</th>
		   	</tr>
		   	<tr>
			     <td>
			     	<input type="text" name="title" placeholder="title" value="${board.title}"/>
				 </td>
			     <td>
			     	<input type="text" name="writer" placeholder="writer" value="${board.writer}"/>
				 </td>
				 <td>
				 	${board.regDate}
				 </td>
				 <td>
				 	${board.viewCount}
				 </td>
				 <td>
				 	<textarea rows=5 cols=50 name="contents" placeholder="contents">${board.contents}</textarea>
				 </td>
				 <td>
				 	<input type="password" name="password" placeholder="password" />
				 </td>
				 <td>
				 	<input type="hidden" name="boardNo" value="${board.boardNo}" />
				 </td>
			</tr>
		</table> <br/>			
			<button type="submit">수정</button>
			<a href="${ pageContext.request.contextPath }/board/boardList.do">목록</a>
	</form>
</body>
</html>