package Day11;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Board {//cs
	
	//1.�ʵ�
	private String title;
	private String contents;
	private String password;
	private String writer;
	private int viewcount;
	private String date;
	private ArrayList<Reply> replylist
					= new ArrayList<>();
	
	//2.������
		//1.�������
	public Board() {}
		//2.��Ͻ� ���Ǵ� ������ [��¥ �ڵ�����]
	public Board(String title, String contents, String password, String writer) {
		super();
		this.title = title;
		this.contents = contents;
		this.password = password;
		this.writer = writer;
			//��¥ Ŭ���� -> Date Ŭ����(java.util)
		Date date = new Date();	//��¥ ��ü ����
			//��¥ ���� Ŭ���� : SimpleDateFormat
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		this.date = format.format(date);
				//��ü��.format(��¥); //�ش� ��¥�� format ������ �������� ��ȯ
	}
	//3.Ǯ������
	public Board(String title, String contents, String password, String writer, int viewcount, String date,
			ArrayList<Reply> replylist) {
		super();
		this.title = title;
		this.contents = contents;
		this.password = password;
		this.writer = writer;
		this.viewcount = viewcount;
		this.date = date;
		this.replylist = replylist;
	}
	
	//3.�޼ҵ� 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<Reply> getReplylist() {
		return replylist;
	}
	public void setReplylist(ArrayList<Reply> replylist) {
		this.replylist = replylist;
	}

}//ce