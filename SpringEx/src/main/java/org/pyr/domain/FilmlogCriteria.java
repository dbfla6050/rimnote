package org.pyr.domain;

//FilmlogboardDTO에 추가하게되면 테이블다시만들어야하는 불편함때문에 
//따로 모델클래스만들어서 관리
public class FilmlogCriteria {
	//페이지 번호
	private int pageNum;
	//한 페이지당 게시물갯수
	private int amount;
	//검색종류
	private String search;
	//검색 키워드
	private String keyword;
	
	
	//기본생성자
	FilmlogCriteria(){
		this(1,10);  //1페이지에 10개
	}
	//기본생성자에서 매개변수2개인 생성자에 값을 입력하여 pageNum과 amount에 저장시킴
	FilmlogCriteria(int pageNum, int amount){
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	@Override
	public String toString() {
		return "FilmlogCriteria [pageNum=" + pageNum + ", amount=" + amount + ", search=" + search + ", keyword="
				+ keyword + "]";
	}
	
	
	
}
