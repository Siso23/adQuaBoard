package kr.co.adqua.bean;

public class BoardVO {

	private int rownum ;
	private int boardNo ;
	private String title ;
	private String writer ;
	private String contents ;
	private int viewCount ;
	private String regDate ;
	private String password;  
	private int cnt;
	
	
	
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BoardVO [rownum=" + rownum + ", boardNo=" + boardNo + ", title=" + title + ", writer=" + writer
				+ ", contents=" + contents + ", viewCount=" + viewCount + ", regDate=" + regDate + ", password="
				+ password + ", cnt=" + cnt + "]";
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	

}
