package kr.co.adqua.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.adqua.bean.BoardVO;
import kr.co.adqua.bean.SearchVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/*게시판 리스트 호출 */ 
	public List<BoardVO> boardList() {
		List<BoardVO> boardList = sqlSessionTemplate.selectList("kr.co.adqua.dao.BoardDAO.selectBoardList");
	
		return boardList;
	}
	
	/*게시글 검색 => 검색옵션, 키워드 매개변수 추가 */
	/*public List<BoardVO> searchList(String searchOption, String keyword) throws Exception {
		// 검색옵션, 키워드 맵에 저장
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSessionTemplate.selectList("kr.co.adqua.dao.BoardDAO.searchList", map);
	}*/
	
	public List<BoardVO> searchList(SearchVO searchVO) {
		System.out.println("DAOIN" + searchVO);
		List<BoardVO> searchList = sqlSessionTemplate.selectList("kr.co.adqua.dao.BoardDAO.selectSearchList", searchVO);
		System.out.println("DAO" + searchList.size());
		return searchList;
	}
	
	/*게시판 총 게시글 수*/
	public int countBoardList() {
		int boardCnt = sqlSessionTemplate.selectOne("kr.co.adqua.dao.BoardDAO.countBoardList");
		
		return boardCnt;
	}
	
	/*게시판 작성 */
	public void insertContents(BoardVO boardVO) {
		sqlSessionTemplate.insert("kr.co.adqua.dao.BoardDAO.insertContents", boardVO);
	}
	
	/* 게시판 Detail 페이지 연동 */
	public BoardVO detail(int no) {
		
		BoardVO board = sqlSessionTemplate.selectOne("kr.co.adqua.dao.BoardDAO.selectNo", no);
		return board;
	}
	
	/*게시판 정보 업데이트*/
	public void updateContents(BoardVO board) {
		sqlSessionTemplate.update("kr.co.adqua.dao.BoardDAO.updateContents", board);
		
	}
	
	/*게시판 삭제*/
	public void boardDelete(int boardNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("kr.co.adqua.dao.BoardDAO.deleteContents", boardNo);
	}

	

}
