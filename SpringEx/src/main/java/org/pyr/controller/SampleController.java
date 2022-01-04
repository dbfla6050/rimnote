package org.pyr.controller;

import org.pyr.domain.SampleMemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// controller담당하고있는 클래스이다라는뜻
@Controller
public class SampleController {
	// system.println 과같은역활을하는 메서드
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	// index처럼 return을 안돌려도됨, 대신 return대신 void로바꿔야함, url주소와  다를경우에는 return써야함
	// @RequestMapping : value와똑같은것이 있으면 웹페이지에서 실행하겠다
	@RequestMapping(value = "sample", method = RequestMethod.GET)
	public void basic() {
		logger.info("sample샐행됨");
	}
	
	@RequestMapping(value = "sample/ex01", method = RequestMethod.GET)
	public void basic1() {
		logger.info("sample/ex01샐행됨");
	}
	
	// sample을 빼고싶을때 return을 붙이고 sample을 뺀다, return이없으면 value값에 .jsp를붙이고 return이 있으면 return값에 .jsp를 붙인다
	@RequestMapping(value = "sample/ex02", method = RequestMethod.GET)
	public String basic2() {
		logger.info("sample/ex02샐행됨");
		return "ex02";
	}
	
	// sample폴더만들지않고 실행되게함
	@RequestMapping(value = "sample/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "sample/member", method = RequestMethod.GET)
	public void member(String id, String pw, String name) {
		System.out.println("id="+id);
		System.out.println("pw="+pw);
		System.out.println("name="+name);
	}
	
	@RequestMapping(value = "sample/memberDTO", method = RequestMethod.GET)
	public void memberdto(SampleMemberDTO smd) {
		System.out.println("id="+smd.getId());
		System.out.println("pw="+smd.getPw());
		System.out.println("name="+smd.getName());
	}
	
	
	
	
	
}
