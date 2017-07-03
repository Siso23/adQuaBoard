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
	<form name="writeForm" method="post" action="${pageContext.request.contextPath }/board/writeForm.do" 
		  onsubmit="return formCheck()">
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
						<input type="password" name="password" placeholder="password"/>
					</td>
				</tr>
			</table> <br/>
			<input type="submit"  value="등록" />
			<button type="reset">취소</button>
			<a href="${ pageContext.request.contextPath }/board/boardList.do">목록</a>
	</form>
	
<!-- jQuery -->
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	function formCheck() {
		var form = document.writeForm;
		if (form.title.value == '') {
			alert('제목을 입력하세요.');
			form.title.focus();
			return false;
		} else if (form.writer.value == '') {
			alert('이름을 입력해주세요.');
			form.writer.focus();
			return false;
		} else if (form.contents.value == '') {
			alert('내용을 입력해주세요.');
			form.contents.focus();
			return false;
		} else if (form.password.value == '') {
			alert('비밀번호을를입력해주세요.');
			form.password.focus();
			return false;
		}
		return true;
	}
</script>
</body>
</html>