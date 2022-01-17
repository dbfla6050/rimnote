package org.pyr.controller;

import org.pyr.domain.RestSampleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	//ResponseEntity타입 반환
	@GetMapping(value="check")
	public ResponseEntity<RestSampleDTO> check(int mno, String firstName, String lastName){
		//사용자로부터 RestSampleDTO안에있는 매니저번호(mno)를 받아서 body로 던진다
		RestSampleDTO rsdto= new RestSampleDTO(mno, firstName, lastName);
		ResponseEntity<RestSampleDTO> result=null;
		
		if(mno<150) { //매니저번호가 150미만이면
			//비정상으로 처리(ResponseEntity) - status가 502 : BAD_GATEWAY일때 나오는 숫자
			result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(rsdto);
		}else {    //그렇지 않으면
			//정상적으로 처리(ResponseEntity) - status가 200 : OK일때 나오는 숫자
			result=ResponseEntity.status(HttpStatus.OK).body(rsdto);
		}
		return result;
	}
	
	//메소드의 매개변수
	//객체타입을 매개변수로 지정해야 되는 경우에는 @RequestBody를 사용해야 됨
	@PostMapping(value="mno")
	public RestSampleDTO mno(@RequestBody RestSampleDTO rsdto) {
		
		return rsdto;
	}
	
	
	
	
	
	
}
