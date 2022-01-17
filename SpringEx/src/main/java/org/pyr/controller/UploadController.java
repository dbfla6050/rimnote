package org.pyr.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {
	//폼태그로한것
	@GetMapping("upload")
	public void uploadForm() {
		System.out.println("파일 업로드 화면");
	}
	
	//그냥 div로만든것
	@GetMapping("uploadAjax")
	public void uploadAjaxForm() {
		System.out.println("파일 업로드 화면");
	}
	
	//upload.jsp에서 form태그를 이용해서 파일업로드
	@PostMapping("uploadAction")
	//MultipartFile : 파일에관련된 dto,이것은 라이브러리 다운받으면 자동적으로 생ㅇ성되기때문에 따로 생성할필요없음
	public void uploadAction(MultipartFile[] uploadFile) {
		
		//파일업로드 할 경로지정
		String uploadFolder="C:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {
			//사용자가 업로드 한 실제 파일이름
			System.out.println("업로드 파일이름="+multipartFile.getOriginalFilename());
			//사용자가 업로드 한 실제 파일크기
			System.out.println("업로드 파일 크기="+multipartFile.getSize()); 
			//사용자가 업로드 한 실제 파일형식
			System.out.println("업로드 파일 형식="+multipartFile.getContentType());   
			//uploadFolder에 저장되어있는 경로로 실제 파일명으로 저장
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());
			
			//실제로 파일을 만들어라
			//transferTo : 반드시 예외처리해서써라, 예외처리안하면 못쓴다
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
		}//for문 end
	}
	
	//uploadAjax.jsp에서 ajax를 이용해서 파일업로드
	@PostMapping("uploadAjaxAction")
	//MultipartFile : 파일에관련된 dto,이것은 라이브러리 다운받으면 자동적으로 생ㅇ성되기때문에 따로 생성할필요없음
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
		//파일업로드 할 경로지정
		String uploadFolder="C:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {
			//사용자가 업로드 한 실제 파일이름
			System.out.println("업로드 파일이름="+multipartFile.getOriginalFilename());
			//사용자가 업로드 한 실제 파일크기
			System.out.println("업로드 파일 크기="+multipartFile.getSize()); 
			//사용자가 업로드 한 실제 파일형식
			System.out.println("업로드 파일 형식="+multipartFile.getContentType());   
			//uploadFolder에 저장되어있는 경로로 실제 파일명으로 저장
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());
			
			//실제로 파일을 만들어라
			//transferTo : 반드시 예외처리해서써라, 예외처리안하면 못쓴다
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
		}//for문 end
	}
	
	
	
	
	
}
