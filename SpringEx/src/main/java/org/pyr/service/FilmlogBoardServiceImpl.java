package org.pyr.service;

import java.util.ArrayList;

import org.pyr.domain.Criteria;
import org.pyr.domain.FilmlogBoardDTO;
import org.pyr.domain.FilmlogCriteria;
import org.pyr.mapper.FilmlogBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilmlogBoardServiceImpl implements FilmlogBoardService{
	//객체 생성
	@Autowired
	private FilmlogBoardMapper bmapper;
	
	//게시판 글쓰기 설계된것을 구현
	public void write(FilmlogBoardDTO board) {
		//board에저장된 데이터를 bmapper으로 전달
		bmapper.write(board);
	}
	
	//게시판 목록리스트 설계된것을 구현
	//컨트롤러에서 service.list를 호출하면 bmapper.list()에있는 데이터를 반환한다
	public ArrayList<FilmlogBoardDTO> list(FilmlogCriteria cri){
		return bmapper.list(cri);
	}
	
	//게시판 목록리스트에서 제목을 클릭했을때 내용이 나으는 상세페이지 설계된것을 구현
	//데이터를 컨트롤러로 반환시키기위해서 타입을 BoardDTO로바꿈
	//조회수+1을 하려면 bno가 필요한데  detail에서 가지고올수있다 
	//@Transactional : 데이터베이스의 상태를 변경하는 작업 또는 한번에 수행되어야 하는 연산
	@Transactional
	public FilmlogBoardDTO detail(FilmlogBoardDTO board) {
		//board테이블에 조회수 속성에 +1
		bmapper.cntupdate(board);
		//상세페이지 select
		return bmapper.detail(board);
	}
	
	//게시판 글수정 설계된것을 구현
	//글수정버튼을 클릭하면 데이터가 데이터베이스로가서 업데이트된다
	public void modify(FilmlogBoardDTO board) {
		bmapper.modify(board);
	}
	
	//게시판 삭제 설계된것을 구현
	public void remove(FilmlogBoardDTO board) {
		//bno를 mapper로 넘기기
		bmapper.remove(board);
	}
	
	//게시판 페이징에 쓰일 데이터건수
	//return해서 데이터건수 받아와야함
	public int getTotalCount(FilmlogCriteria cri) {
		return bmapper.getTotalCount(cri);
	}
	
}
