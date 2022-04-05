package dto;

public class Reply {

	private int rnum;
	private String rcontent;
	private String rwriter;
	private String rdate;
	private int bnum;
	
	public Reply() {
		super();
	}

	public Reply(int rnum, String rcontent, String rwriter, String rdate, int bnum) {
		super();
		this.rnum = rnum;
		this.rcontent = rcontent;
		this.rwriter = rwriter;
		this.rdate = rdate;
		this.bnum = bnum;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRwriter() {
		return rwriter;
	}

	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	
}
