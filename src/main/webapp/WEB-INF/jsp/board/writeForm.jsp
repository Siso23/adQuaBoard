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
		  action="${pageContext.request.contextPath }/board/writeForm.do">
		  
			<table width="100%" border="1">
				<tr>
					<th width="23%">제목</th>
					<td>
						<input type="text" name="title" placeholder="title" />
					</td>
				</tr>
				<tr>
					<th width="23%">작성자</th>
					<td>
						<input type="text" name="writer" placeholder="writer" />
					</td>
				</tr>
				<tr>
					<th width="23%">내용</th>
			        <td>
			        	<textarea rows=5 cols=50 name="contents" placeholder="contents"></textarea>
					</td>
				</tr>
				<tr>
					<th width="23%">비밀번호</th>
					<td>
						<input type="password" name="password" placeholder="password" />
					</td>
				</tr>
			</table> <br/>
			<button type="submit">등록</button>
			<button type="reset">취소</button>
			<a href="${ pageContext.request.contextPath }/board/boardList.do">목록</a>
	</form>
</body>
</html>