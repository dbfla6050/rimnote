package org.pyr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FilmlogController {
	// system.println 과같은역활을하는 메서드
	private static final Logger logger = LoggerFactory.getLogger(FilmlogController.class);
	
	@RequestMapping(value = "filmlog/board", method = RequestMethod.GET)
	public void board() {
		logger.info("filmlog/board실행됨");
	}
	
	@RequestMapping(value = "filmlog/boardIndex", method = RequestMethod.GET)
	public void boardIndex() {
		logger.info("filmlog/boardIndex실행됨");
	}
	
	@RequestMapping(value = "filmlog/writeIndex", method = RequestMethod.GET)
	public void writeIndex() {
		logger.info("filmlog/writeIndex실행됨");
	}
	
	@RequestMapping(value = "filmlog/memberIndex", method = RequestMethod.GET)
	public void memberIndex() {
		logger.info("filmlog/memberIndex실행됨");
	}
	
	@RequestMapping(value = "filmlog/login", method = RequestMethod.GET)
	public void login() {
		logger.info("filmlog/login실행됨");
	}
	
	
	
	
}
