package kr.co.adqua.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.adqua.bean.BoardVO;
import kr.co.adqua.bean.SearchVO;
import kr.co.adqua.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	/*게시판 리스트 호출 & 검색 */ 
	@RequestMapping(value="/board/boardList.do", method=RequestMethod.GET)
	public String selectBoard (Model model) throws Exception {
			
		List<BoardVO> boardList = service.boardList();
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	@RequestMapping(value="/board/boardList.do", method=RequestMethod.POST)
	public String searchList(SearchVO searchVO, Model model) throws Exception{
		List<BoardVO> boardList = service.searchList(searchVO);
		
		/*if(boardList.size() > 0) {
			System.out.println(boardList.get(0).getTitle());
		} else {
			System.out.println("없음");
		}*/
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	/*게시판 총 게시글 수 확인 for ajax*/
	@ResponseBody
	@RequestMapping(value="/board/countBoardList.do")
	public int countBoardList (SearchVO searchVO) throws Exception{
		
		int boardCnt = service.countBoardList(searchVO);
		//System.out.println("controller boardCnt : " + boardCnt);
		
		return boardCnt;
	}
	
	/*게시판 작성 */
	@RequestMapping(value="/board/writeForm.do", method=RequestMethod.GET)
	public String writeForm() throws Exception{
		
		return "board/writeForm";
	}
	
	@RequestMapping(value="/board/writeForm.do", method=RequestMethod.POST)
	public String write(BoardVO boardVO, Model model) throws Exception{
		//System.out.println(boardVO);
		
		service.insertContents(boardVO);
		//model.addAttribute("boardVO", boardVO);
		
		return "redirect:/board/boardList.do" ;
	}
	
	/* 게시판 Detail 페이지 연동  & IP 가져오기*/
	@RequestMapping(value="/board/detailPage.do")
	public String detail(@RequestParam("no") int no, @RequestParam(value="msg", required=false) String msg, Model model) throws Exception{
		
		BoardVO board = service.detail(no);
		model.addAttribute("board", board);
		model.addAttribute("msg", msg);
		
		/* IP 가져오기*/ 	
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = req.getRemoteAddr();
		    
		//System.out.println(ip);
		model.addAttribute("clientIP", ip);
		
		return "board/detailPage";
	}
	
	/*게시판 수정화면 호출*/
	@RequestMapping(value="/board/updateView.do", method=RequestMethod.GET)
	public String updateForm(@RequestParam("no") int no, @RequestParam(value="msg", required=false) String msg, Model model) throws Exception{
		
		BoardVO board = service.detail(no);
		model.addAttribute("board", board);
		model.addAttribute("msg", msg);

		return "board/updateForm";
	}
	
	/*게시판 정보 업데이트*/
	@RequestMapping(value="/board/update.do", method=RequestMethod.POST)
	public String update(BoardVO board, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		int updateTrue = service.updateContents(board);
		String destination;

		if (updateTrue == 1) {
			redirectAttributes.addAttribute("msg", "업데이트에 성공하셨습니다.");
			destination = "redirect:/board/detailPage.do?no=" + board.getBoardNo();
		} else {
			redirectAttributes.addAttribute("msg", "비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			destination = "redirect:/board/updateView.do?no=" + board.getBoardNo();
		}
		return destination;
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
	public String delete(HttpServletRequest request, @RequestParam("boardNo") int boardNo) throws Exception{
	      
       //System.out.println(boardNo);
      
       service.boardDelete(boardNo);
      
       return "redirect:/board/boardList.do";
   }	
}
