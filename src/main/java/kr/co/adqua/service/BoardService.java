package kr.co.adqua.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.adqua.bean.BoardVO;
import kr.co.adqua.bean.SearchVO;
import kr.co.adqua.dao.BoardDAO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	/*게시판 리스트 호출 */ 
	public List<BoardVO> boardList () throws Exception{
		
		List<BoardVO> boardList = dao.boardList();
		
		return boardList;
	}
	
	/*게시글 검색 */
	public List<BoardVO> searchList(SearchVO searchVO) throws Exception{
		System.out.println("serviceIN" + searchVO);
		List<BoardVO> boardList = dao.searchList(searchVO);
		System.out.println("service" + boardList.size());
		return boardList;
	}
	
	/*게시판 총 게시글 수*/
	public int countBoardList (SearchVO searchVO) throws Exception{
		
		int boardCnt = dao.countBoardList(searchVO);
		return boardCnt;
	}
	
	/*게시판 작성 */
	public void insertContents(BoardVO boardVO) throws Exception{
		dao.insertContents(boardVO);
	}
	
	/* 게시판 Detail 페이지 연동 */
	public BoardVO detail(int no) throws Exception{
		BoardVO board = dao.detail(no);
		return board;
	}

	/*게시판 정보 업데이트*/
	public int updateContents(BoardVO board) throws Exception{
		
		int updateTrue = dao.updateContents(board);
		return updateTrue;
	}
	
	/*업데이트 시 비밀번호 확인 for ajax*/
/*	public int pwCheckforUpdate(BoardVO board) {
		String pw = dao.pwCheckforUpdate(board);
		return pw;
	}*/
	
	/*게시판 삭제*/
	public void boardDelete(int boardNo) throws Exception{
		dao.boardDelete(boardNo);
	}
}
