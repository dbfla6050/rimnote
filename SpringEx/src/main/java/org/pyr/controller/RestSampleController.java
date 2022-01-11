package org.pyr.controller;

import org.pyr.domain.RestSampleDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//비동기식으로 처리해라
@RestController
@RequestMapping("sample")
public class RestSampleController {
	//단순 문자열 반환
	@GetMapping(value="getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		return "안녕하세요";
	}
	
	//객체 반환
	//JSON타입과 xml타입으로 볼수있다
	@GetMapping(value="getSample", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RestSampleDTO getSample() {
		//RestSampleDTOn rs= new RestSampleDTO(100,"박","자바");
		//return rs; 와같은것
		return new RestSampleDTO(100,"박","자바");
	}
	
	
	
}
