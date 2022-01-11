package org.pyr.controller;

import org.pyr.domain.SampleMemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// controller담당하고있는 클래스이다라는뜻
@Controller
@RequestMapping("sample")
public class SampleController {
	// system.println 과같은역활을하는 메서드
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	// index처럼 return을 안돌려도됨, 대신 return대신 void로바꿔야함, url주소와  다를경우에는 return써야함
	// @RequestMapping : value와똑같은것이 있으면 웹페이지에서 실행하겠다
	//@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("")      //축약가능
	public void basic(Model model) {
		logger.info("sample샐행됨");
		
		// aaaa문자열을 abcd변수에 저장하여 sample.jsp에 보내기
		model.addAttribute("abcd", "aaaa");
	}
	
	//@RequestMapping(value = "ex01", method = RequestMethod.GET)
	@GetMapping("ex01")
	public String basic1(Model model) {
		logger.info("sample/ex01샐행됨");
		
		// bbbb문자열을 zzzz변수에 저장하여 ex01.jsp에 보내기
		model.addAttribute("zzzz", "bbbb");
		return "ex01";
	}
	
	// sample을 빼고싶을때 return을 붙이고 sample을 뺀다, return이없으면 value값에 .jsp를붙이고 return이 있으면 return값에 .jsp를 붙인다
	//@RequestMapping(value = "ex02", method = RequestMethod.GET)
	@GetMapping("ex02")
	public String basic2() {
		logger.info("sample/ex02샐행됨");
		return "ex02";
	}
	
	// sample폴더만들지않고 실행되게함
	//@RequestMapping(value = "index", method = RequestMethod.GET)
	@GetMapping("index")
	public String index(Model model) {
		
		// cccc문자열을 yyyy변수에 저장하여 index.jsp에 보내기
		model.addAttribute("yyyy", "cccc");
		return "index";
	}
	
	//@RequestMapping(value = "member", method = RequestMethod.GET)
	@GetMapping("member")
	public String member(String id, String pw, String name, Model model) {
		System.out.println("id="+id);
		System.out.println("pw="+pw);
		System.out.println("name="+name);
		
		// id값을 id변수에 저장하여 member.jsp에 보내기
		// pw값을 pw변수에 저장하여 member.jsp에 보내기
		// name값을 name변수에 저장하여 member.jsp에 보내기
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		return "member";
	}
	
	//@RequestMapping(value = "memberDTO", method = RequestMethod.POST)
	@PostMapping("memberDTO")
	public String memberdto(SampleMemberDTO smd,Model model) {
		System.out.println("id="+smd.getId());
		System.out.println("pw="+smd.getPw());
		System.out.println("name="+smd.getName());
		
		// SampleMemberDTO값을 id변수에 저장하여 memberDTO.jsp에 보내기
		model.addAttribute("id", smd);
		//return "memberDTO";
		//return "redirect:/";              //다른 컨트롤러 이동가능
		return "redirect:/sample/member";   //같은 컨트롤러로 이동도 가능
	}
	
	
	
	
	
}
