package org.pyr.service;

import java.util.ArrayList;

import org.pyr.domain.BoardDTO;
import org.pyr.domain.Criteria;
import org.pyr.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardMapper bmapper;
	
	//게시판 글쓰기 설계된것을 구현
	public void write(BoardDTO board) {
		bmapper.write(board);
	}
	//게시판 목록리스트 설계된것을 구현
	//컨트롤러에서 service.list를 호출하면 bmapper.list()에있는 데이터를 반환한다
	public ArrayList<BoardDTO> list(Criteria cri) {
		return bmapper.list(cri);
	}
	
	//게시판 목록리스트에서 제목을 클릭했을때 내용이 나으는 상세페이지 설계된것을 구현
	//데이터를 컨트롤러로 반환시키기위해서 타입을 BoardDTO로바꿈
	@Transactional
	public BoardDTO detail(BoardDTO board) {
		//board테이블에 조회수 속성에 +1
		bmapper.cntupdate(board);
		//상세페이지 select
		return bmapper.detail(board);
	}
	//게시판 글수정 설계된것을 구현
	//글수정버튼을 클릭하면 데이터가 데이터베이스로가서 업데이트된다
	public void modify(BoardDTO board) {
		bmapper.modify(board);
	}
	//게시판 삭제 설계된것을 구현
	public void remove(BoardDTO board) {
		bmapper.remove(board);
	}
	
	//게시판 페이징에 쓰일 데이터건수
	//Criteria cri을 통해 keyword를 mapper.xml로 보내 처리
	public int getTotalCount(Criteria cri) {
		return bmapper.getTotalCount(cri);
	}
	
}
