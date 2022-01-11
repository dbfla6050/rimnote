package org.pyr.mapper;

import java.util.ArrayList;

import org.pyr.domain.BoardDTO;
import org.pyr.domain.Criteria;

public interface BoardMapper {
	//게시판 글쓰기와 관련이 되어있는 DB작업에 설계
	public void write(BoardDTO board);
	
	//게시판 목록리스트와 관련이 되어있는 DB작업에 설계
	//데이터베이스가 한개만 이동하는 것이아니라 여러개 이동하기때문에 동적배열을 사용
	public ArrayList<BoardDTO> list(Criteria cri);
	
	//게시판 목록리스트에서 제목을 클릭했을때 내용이 나오는 상세페이지와 관련이 되어있는 DB작업에 설계
	//리턴시키기위해서 타입을 BoardDTO로바꿈
	public BoardDTO detail(BoardDTO board);
	
	//게시판 목록리스트에서 제목을 클릭했을때 조회수+1
	public void cntupdate(BoardDTO board);
	
	//게시판 글수정과 관련이 되어있는 DB작업에 설계
	//글수정버튼을 클릭하면 데이터가 데이터베이스로가서 업데이트된다
	public void modify(BoardDTO board);
	
	//게시판 삭제와 관련이 되어있는 DB작업에 설계
	public void remove(BoardDTO board);
	
	//게시판 페이징에 쓰일 전체건수
	public int getTotalCount(Criteria cri);
	
	
}
