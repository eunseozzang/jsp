package kr.or.ddit.board.model;

public class BoardVO {
	
	private int boardNo;
	private String title;
	private String content;
	
	
	// 인자가 있는 생성자가 있으니 기본생성자도 하나 만들어준다.
	public BoardVO() {
		
		
	}
	
	
	public BoardVO(int boardNo, String title, String content) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}
	
}
