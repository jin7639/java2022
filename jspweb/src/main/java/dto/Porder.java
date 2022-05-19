package dto;

public class Porder {

	private int orderno;
	private String orderdate;
	private String ordername;
	private String orderphone;
	private String orderaddress;
	private int ordertotalpay;
	private int orderactivepay;
	private String orderrequest;
	private int orderdeliveryno;
	private int mno;
	
	@Override
	public String toString() {
		return "Porder [orderno=" + orderno + ", orderdate=" + orderdate + ", ordername=" + ordername + ", orderphone="
				+ orderphone + ", orderaddress=" + orderaddress + ", ordertotalpay=" + ordertotalpay
				+ ", orderactivepay=" + orderactivepay + ", orderrequest=" + orderrequest + ", orderdeliveryno="
				+ orderdeliveryno + ", mno=" + mno + "]";
	}

	public Porder() {
		super();
	}

	public Porder(int orderno, String orderdate, String ordername, String orderphone, String orderaddress,
			int ordertotalpay, int orderactivepay, String orderrequest, int orderdeliveryno, int mno) {
		super();
		this.orderno = orderno;
		this.orderdate = orderdate;
		this.ordername = ordername;
		this.orderphone = orderphone;
		this.orderaddress = orderaddress;
		this.ordertotalpay = ordertotalpay;
		this.orderactivepay = orderactivepay;
		this.orderrequest = orderrequest;
		this.orderdeliveryno = orderdeliveryno;
		this.mno = mno;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getOrderphone() {
		return orderphone;
	}

	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}

	public String getOrderaddress() {
		return orderaddress;
	}

	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}

	public int getOrdertotalpay() {
		return ordertotalpay;
	}

	public void setOrdertotalpay(int ordertotalpay) {
		this.ordertotalpay = ordertotalpay;
	}

	public int getOrderactivepay() {
		return orderactivepay;
	}

	public void setOrderactivepay(int orderactivepay) {
		this.orderactivepay = orderactivepay;
	}

	public String getOrderrequest() {
		return orderrequest;
	}

	public void setOrderrequest(String orderrequest) {
		this.orderrequest = orderrequest;
	}

	public int getOrderdeliveryno() {
		return orderdeliveryno;
	}

	public void setOrderdeliveryno(int orderdeliveryno) {
		this.orderdeliveryno = orderdeliveryno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}
	
}
