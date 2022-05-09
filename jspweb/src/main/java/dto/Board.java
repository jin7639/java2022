package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.MemberDao;

// DTO 
public class Board {

	private int bno;
	private String btitle;
	private String bcontent;
	private int mno;
	private int bview;
	private String bdate;
	private String bfile;
	private String mid; /*화면 표시용*/
	
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", mno=" + mno + ", bview="
				+ bview + ", bdate=" + bdate + ", bfile=" + bfile + ", mid=" + mid + "]";
	}

	public Board() {
		super();
	}

	public Board(int bno, String btitle, String bcontent, int mno, int bview, String bdate, String bfile, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
		this.bview = bview;
		
		
		
		// 작성일이 오늘이면 시간만 표시 // 아니면 날짜만 표시 
		// 현재 날짜 : LocalDate.now() 
		if( bdate != null ) { 
		
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 날짜 형식 변환 설정 
			String today = dateformat.format( LocalDate.now() ) ; // 오늘날짜를 문자열 변환
			String boardday = bdate.split(" ")[0];	// 날짜만 
			String boardtime = bdate.split(" ")[1]; // 시간만 
									// db에 저장된 게시물 등록날짜의 날짜 시간 중에 split 분리후 앞에 있는 날짜만 가져오기 
			// 현재날짜와 게시물등록날짜와 동일하면 
			if( today.equals(boardday) ) {
				this.bdate = boardtime;
			}
			// 동일하지 않으면 
			else { 
				this.bdate = boardday; 
			}
		
		}else { 
			this.bdate = bdate; 
		}
		
		//현재 날짜
//		Date today = new Date();
//		SimpleDateFormat sdfday = new SimpleDateFormat ("yyyy-MM-dd");
//		String now = sdfday.format(today);
//
//		//작성일 날짜/시간쪼개기
//		String writedate = board.getBdate().substring(0,10);
//		//오늘-작성일 비교
//		if (!now.equals(writedate)) {
//			//작성일 표시값 다시 넣기
//			writedate = board.getBdate().substring(0,10);
//		}else {
//			writedate = board.getBdate().substring(10);
//		}
		
		this.bfile = bfile;
		this.mid = MemberDao.getMemberDao().getmid(mno);
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

}