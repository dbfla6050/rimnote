package org.pyr.controller;

import org.pyr.domain.BoardDTO;
import org.pyr.domain.Criteria;
import org.pyr.domain.PageDTO;
import org.pyr.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	// BoardService service = new BoardService();
	private BoardService service;
	
	// 글쓰기 화면으로...
	@GetMapping("write")
	public void write() {
		System.out.println("board/write");
	}
	// 글쓰기 버튼을 클릭하면
	@PostMapping("write")  //post인지 get인지 다르기때문에 value값이 같아도 상관없음
	public String writePost(BoardDTO board) {
		//board에저장된 데이터를 service으로 전달
		service.write(board);
		System.out.println("write post...."+ board);
		return "redirect:/board/list";
	}
	// 게시판 목록 리스트(데이터베이스에서 데이터들을 들고와서 게시판목록에 뿌린다)
	@GetMapping("list")
	public void list(Criteria cri, Model model) {
		// service.list();
		System.out.println("board/list="+service.list(cri));
		model.addAttribute("list",service.list(cri));
		//PageDTO의 데이터를 jsp에 뿌린다
		int total=service.getTotalCount(cri);
		model.addAttribute("pageMaker",new PageDTO(cri,total));
	}
	// 게시ㅣ판 목록 리스트에서 제목을 클릭하면
	@GetMapping("detail")
	public void detail(BoardDTO board, Model model) {
		System.out.println("board/detail");
		model.addAttribute("detail",service.detail(board));
	}
	//글수정 화면으로
	@GetMapping("modify")
	public void modify(BoardDTO board, Model model) {
		System.out.println("board/modify");
		model.addAttribute("detail",service.detail(board));
	}
	//글수정 버튼을 클릭하면
	@PostMapping("modify")
	public String modifyPost(BoardDTO board,RedirectAttributes rttr) {
		System.out.println(board);
		//update
		service.modify(board);
		//?자동으로 붙고                bno  =  board안에있는 bno번호를 나타냄, 디테일페이지로 이동하는데 뒤에 게시판넘버가없어서 페이지안뜰때 사용
		rttr.addAttribute("bno", board.getBno());
		//디테일페이지로 이동(디테일 컨트롤러를 통해서)
		return "redirect:/board/detail";
	}
	//글삭제 버튼을 클릭하면
	@GetMapping("remove")
	public String remove(BoardDTO board) {
		//여기서 board는 bno를 들고온다
		System.out.println(board);
		//bno를 서비스로 넘기기
		service.remove(board);
		return "redirect:/board/list";
	}
	
	
	
	
}
