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
	public List<BoardVO> boardList () {
		
		List<BoardVO> boardList = dao.boardList();
		
		return boardList;
	}
	
	/*게시글 검색 */
	public List<BoardVO> searchList(SearchVO searchVO) {
		System.out.println("serviceIN" + searchVO);
		List<BoardVO> searchList = dao.searchList(searchVO);
		System.out.println("service" + searchList.size());
		return searchList;
	}
	
	/*게시판 총 게시글 수*/
	public int countBoardList () {
		
		int boardCnt = dao.countBoardList();
		return boardCnt;
	}
	
	/*게시판 작성 */
	public void insertContents(BoardVO boardVO) {
		dao.insertContents(boardVO);
	}
	
	/* 게시판 Detail 페이지 연동 */
	public BoardVO detail(int no) {
		BoardVO board = dao.detail(no);
		return board;
	}

	/*게시판 정보 업데이트*/
	public void updateContents(BoardVO board) {
		dao.updateContents(board);
	}
	
	/*게시판 삭제*/
	public void boardDelete(int boardNo) {
		dao.boardDelete(boardNo);
	}
	
}
