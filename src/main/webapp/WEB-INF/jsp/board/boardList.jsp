<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   
   <div>총 <span id="boardCnt"></span> 개의 게시글이 있습니다.</div> <br/>
   <c:if test="${ empty boardList }">검색한 내용과 일치하는 저장된 글이 없습니다.</c:if>
    <!-- <span>
    	<select id="listSize">
			<option selected value="15">15개씩 보기</option>
			<option value="20">20개씩 보기</option>
			<option value="25">25개씩 보기</option>
			<option value="30">30개씩 보기</option>
			<option value="40">40개씩 보기</option>
			<option value="50">50개씩 보기</option>
		</select>
    </span> -->
    
    <form name="searchForm" method="post" action="${ pageContext.request.contextPath }/board/boardList.do">
        <select id="selectBox" name="searchOption">
            <!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
            <option value="" disabled selected>검색옵션</option>
            <option value="title">제목</option>
            <option value="contents">내용</option>
            <option value="writer">작성자</option>
        </select>
        <input type="text" id="searchKeyword" name="keyword">
        <input type="submit" onclick="return search();" value="검색">
    </form>
   
   <table border="1">
   	  <tr>
   	  	 <th>번호</th>
   	  	 <th>제목</th>
   	  	 <th>작성자</th>
   	  	 <th>조회수</th>
   	  	 <th>등록일</th>
   	  </tr>
   <c:forEach var="board" items="${boardList}" varStatus="loop">
      <tr>
         <td>${board.rownum}</td>
         <td><a href="${ pageContext.request.contextPath }/board/detailPage.do?no=${board.boardNo}">${board.title}</a></td>
         <td>${board.writer}</td>
         <td>${board.viewCount}</td>
         <td>${board.regDate}</td>
      </tr>
   </c:forEach>
   </table>
   <div>
      <a href="${ pageContext.request.contextPath }/board/writeForm.do">글쓰기</a>
      <a href="${ pageContext.request.contextPath }/board/boardList.do">처음으로</a>
   </div>

<!-- jQuery -->
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>

<script>
	/*게시판 총 게시글 수 확인*/
	   $.ajax({
         url: "${ pageContext.request.contextPath }/board/countBoardList.do",
         type : 'get',
         data : {
        	 	"searchOption":'${searchVO.searchOption}',
        	 	 "keyword" : '${searchVO.keyword}'
         		},
         contentType : "application/json",
         success: function(result){
               $("#boardCnt").text(result);
               console.log(result);  
           }});
</script>
<script>
	function search() {
	var form = document.searchForm;
		if (form.selectBox.value == '') {
			alert('검색옵션을 선택하세요.');
			form.selectBox.focus();
			return false;
		} else if (form.searchKeyword.value == '') {
			alert('검색어를 입력하세요.');
			form.searchKeyword.focus();
			return false;
		}
		return true;
	}

</script>
</body>
</html>