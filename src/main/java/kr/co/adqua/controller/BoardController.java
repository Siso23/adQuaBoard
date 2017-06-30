package kr.co.adqua.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.adqua.bean.BoardVO;
import kr.co.adqua.bean.SearchVO;
import kr.co.adqua.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	/*게시판 리스트 호출   */ 
	@RequestMapping(value="/board/boardList.do", method=RequestMethod.GET)
	public String selectBoard (Model model) {

		List<BoardVO> boardList = service.boardList();
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	/*게시글 검색 */
	/*@RequestMapping(value="/board/boardList.do", method=RequestMethod.POST)
	public ModelAndView boardList(@RequestParam(defaultValue="title") String searchOption,
	                        @RequestParam(defaultValue="") String keyword) throws Exception{
	    
	     
		List<BoardVO> boardList = service.searchList(searchOption, keyword);
	   
	    // ModelAndView - 모델과 뷰
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("list", list); // 데이터를 저장
	    mav.addObject("searchOption", searchOption);
	    mav.addObject("keyword", keyword);
	    // 데이터를 맵에 저장
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("boardList", boardList); // boardList
	    map.put("searchOption", searchOption); // 검색옵션
	    map.put("keyword", keyword); // 검색키워드
	    //System.out.println(keyword);
	   
	    mav.addObject("boardList", map); // 맵에 저장된 데이터를 mav에 저장
	    System.out.println(map);	    
	    mav.setViewName("board/boardList"); // 뷰를 boardList.jsp로 설정
	    return mav; // boardList.jsp로 boardList가 전달된다.
	}*/
	
	@RequestMapping(value="/board/boardList.do", method=RequestMethod.POST)
	public String searchList(SearchVO searchVO, Model model){
		List<BoardVO> searchList = service.searchList(searchVO);
		
		if(searchList.size() > 0) {
			System.out.println(searchList.get(0).getTitle());
		} else {
			System.out.println("없음");
		}
		model.addAttribute("boardList", searchList);
		
		return "board/boardList";
	}
	
	/*게시글 갯수별 보기*/
	
	
	/*게시판 총 게시글 수 확인 for ajax*/
	@ResponseBody
	@RequestMapping(value="/board/countBoardList.do")
	public int countBoardList () {
		
		int boardCnt = service.countBoardList();
		//System.out.println("controller boardCnt : " + boardCnt);
		
		return boardCnt;
	}
	
	/*게시판 작성 */
	@RequestMapping(value="/board/writeForm.do", method=RequestMethod.GET)
	public String writeForm() {
		
		return "board/writeForm";
	}
	
	@RequestMapping(value="/board/writeForm.do", method=RequestMethod.POST)
	public String write(BoardVO boardVO, Model model) {
		//System.out.println(boardVO);
		
		service.insertContents(boardVO);
		//model.addAttribute("boardVO", boardVO);
		
		return "redirect:/board/boardList.do" ;
	}
	
	/* 게시판 Detail 페이지 연동 */
	@RequestMapping(value="/board/detailPage.do")
	public String detail(@RequestParam("no") int no, Model model) {
		
		BoardVO board = service.detail(no);
		model.addAttribute("board", board);
		
		return "board/detailPage";
	}
	
	/*게시판 수정화면 호출*/
	@RequestMapping(value="/board/updateView.do", method=RequestMethod.GET)
	public String updateForm(@RequestParam("no") int no, Model model) {
		
		BoardVO board = service.detail(no);
		model.addAttribute("board", board);

		return "board/updateForm";
	}
	
	/*게시판 정보 업데이트*/
	@RequestMapping(value="/board/update.do", method=RequestMethod.POST)
	public String update(BoardVO board, Model model) {
	      
	   service.updateContents(board);
      
      return "redirect:/board/detailPage.do?no=" + board.getBoardNo();
	}
	
	/*	@RequestMapping(value="/board/update.do", method=RequestMethod.POST)
	public String update(@RequestParam("no") int no, BoardVO board, Model model) {
	      
	   board.setBoardNo(no);
	   System.out.println(no);
	   service.updateContents(board);
      
      return "redirect:/board/detailPage.do?no=" + no;
	}*/
	
	/*게시판 삭제*/
	@RequestMapping("/board/delete.do")
	public String delete(HttpServletRequest request, @RequestParam("boardNo") int boardNo) {
	      
       System.out.println(boardNo);
      
       BoardVO board = new BoardVO();
       board.setBoardNo(boardNo);
      
       service.boardDelete(boardNo);
      
       return "redirect:/board/boardList.do";

   }	  
}
