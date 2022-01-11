
package org.pyr.service;

import java.util.ArrayList;

import org.pyr.domain.FilmlogBoardDTO;

public interface FilmlogBoardService {
	//게시판 글쓰기 설계
	public void write(FilmlogBoardDTO board);
	
	//게시판 목록 리스트 설계
	//데이터베이스가  여러개 이동하기때문에 동적배열을 사용해서 이동
	public ArrayList<FilmlogBoardDTO> list();
	
	//게시판 목록리스트에서 제목을 클릭했을때 내용이 나오는 상세페이지
	//데이터를 컨트롤러로 반환시키기위해서 타입을 BoardDTO로바꿈
	public FilmlogBoardDTO detail(FilmlogBoardDTO board);
	
	//게시판 수정페이지
	//글수정버튼을 클릭하면 데이터가 데이터베이스로가서 업데이트된다
	public void modify(FilmlogBoardDTO board);
	
	//게시판 삭제페이지
	public void remove(FilmlogBoardDTO board);
	
} 
