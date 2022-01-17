package org.pyr.controller;

import org.pyr.domain.FilmlogBoardDTO;
import org.pyr.domain.FilmlogCriteria;
import org.pyr.domain.FilmlogPageDTO;
import org.pyr.domain.PageDTO;
import org.pyr.service.FilmlogBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("filmlog/board")
public class FilmlogController {
	//객체 생성
	// FilmlogBoardService service = new FilmlogBoardService();
	//@Autowired는 주입하려고 하는 객체의 타입이 일치하는 객체를 자동으로 주입한다.
	@Autowired
	private FilmlogBoardService service;
	
	// 글쓰기 화면으로 이동
	@GetMapping("write")
	public void write() {
		System.out.println("filmlog/board/write");
	}
	
	// 글을 적고 글쓰기 버튼을 클릭하면 database로 저징된다
	@PostMapping("write")
	public String writePost(FilmlogBoardDTO board) {
		System.out.println("write post...."+ board);
		//FilmlogBoardService의 write()호출해서 연결하고 데이터를 넘김
		//board에저장된 데이터를 service으로 전달
		service.write(board);
		//글을 다쓰면 게시판리스트로 돌아온다
		return "redirect:/filmlog/board/list";
	}
	
	//게시판 목록리스트(데이터베이스에서 데이터들을 들고와서 게시판목록에 뿌린다)
	@GetMapping("list")
	public void list(FilmlogCriteria cri, Model model) {
		System.out.println("filmlog/board/list="+service.list(cri));
		//컨트롤러에서 service.list()를 호출하면 bmapper.list()에있는 데이터를 반환한다
		//model함수를 써서 데이터베이스를 화면에 뿌린다
		//                  변수이름     데이터
		model.addAttribute("list", service.list(cri));
		//게시판 페이징에 쓰일 데이터건수
		int total=service.getTotalCount(cri);
		//PageDTO의 데이터를 jsp에 뿌린다
		model.addAttribute("pageMaker",new FilmlogPageDTO(cri,total));
	}
	
	//게시판 목록리스트에서 제목을 클릭하면 상세페이로 이동
	//상세페이지이동할때 게시판번호를 기준으로 데이터를 가지고와서 상세페이지에 제목과 내용을 뿌린다
	@GetMapping("detail")
	public void detail(FilmlogBoardDTO board, Model model) {
		System.out.println("filmlog/board/detail");
		//board에 데이터베이스를 들고와서 화면에 뿌린다
		model.addAttribute("detail", service.detail(board));
	}

	//detail화면에서 글수정버튼을 눌렀을때 글수정 화면으로 이동 
	//detail에 있던 데이터가 똑같이 들어간다
	@GetMapping("modify")
	public void modify(FilmlogBoardDTO board, Model model) {
		System.out.println("board/modify");
		//detail에 있던 데이터가 똑같이 들어간다
		model.addAttribute("detail", service.detail(board));
	}
	
	//글수정 버튼을 클릭하면 데이터베이스가 업데이트되서 수정되고 디테일페이지로 이동
	@PostMapping("modify")
	public String modifyPost(FilmlogBoardDTO board, RedirectAttributes rttr) {
		//board를 통해 수정된 데이터 확인
		System.out.println(board);
		//board에저장된 업데이트될 데이터를 service으로 전달
		service.modify(board);
		
		//디테일페이지로 이동하는데 뒤에 게시판넘버가없어서 페이지안뜰때 RedirectAttributes사용
		//?자동으로 붙고                bno  =  board안에있는 bno번호를 나타냄(FilmlogBoardDTO클래스안의 getBno()함수사용)
		rttr.addAttribute("bno", board.getBno());
		//디테일페이지로 이동(디테일 컨트롤러를 통해서)
		return "redirect:/filmlog/board/detail";
	}
	
	//글삭제 버튼을 클릭하면 그 글의 게시판번호를 board에 저장해 데이터베이스로 가져가 삭제
	@GetMapping("remove")
	public String remove(FilmlogBoardDTO board) {
		//여기서 board는 bno를 들고온다
		System.out.println(board);
		//bno를 서비스로 넘기기
		service.remove(board);
		return "redirect:/filmlog/board/list";
	}
	
	
	
	
	
}
