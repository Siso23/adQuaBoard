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
		  action="${pageContext.request.contextPath }/board/update.do" onsubmit="return pwCheck()">
		  	
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
				 	<input type="password" name="password" id="password" placeholder="password" />
				 </td>
				 <td>
				 	<input type="hidden" name="boardNo" value="${board.boardNo}" />
				 </td>
			</tr>
		</table> <br/>			
			<button type="submit">수정</button>
			<a href="${ pageContext.request.contextPath }/board/boardList.do">목록</a>
	</form>
	
<!-- jQuery -->
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	/* 비밀번호 입력이 안될시 alert 창 띄우기*/
	function pwCheck() {

		var form = document.writeForm;

		if (form.password.value == '') {
			alert('비밀번호를 입력하세요.');
			form.password.focus();
			return false;
		}
		
		return true;
	}
	
	var result= "<%=request.getParameter("result")%>"; 
	
	if(result != "null"){
		if (result == "1"){
			alert("업데이트에 성공하셨습니다.");
			location.href = "${ pageContext.request.contextPath }/board/boardList.do";
		}
		else{
			alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			
		}
	}

	
	
</script>

</body>
</html>