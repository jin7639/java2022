package dto;

public class City {
	
	private int cindex;
	private String cname;
	private int pland;
	private int phouse;
	private int pvilla;
	private int photel;
	private String cplayer;
	@Override
	public String toString() {
		return "City [cindex=" + cindex + ", cname=" + cname + ", pland=" + pland + ", phouse=" + phouse + ", pvilla="
				+ pvilla + ", photel=" + photel + ", cplayer=" + cplayer + "]";
	}
	
	public City() {
		super();
	}

	public City(int cindex, String cname, int pland) {
		super();
		this.cindex = cindex;
		this.cname = cname;
		this.pland = pland;
	}

	public City(int cindex, String cname, int pland, int phouse, int pvilla, int photel, String cplayer) {
		super();
		this.cindex = cindex;
		this.cname = cname;
		this.pland = pland;
		this.phouse = phouse;
		this.pvilla = pvilla;
		this.photel = photel;
		this.cplayer = cplayer;
	}
	public int getCindex() {
		return cindex;
	}
	public void setCindex(int cindex) {
		this.cindex = cindex;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPland() {
		return pland;
	}
	public void setPland(int pland) {
		this.pland = pland;
	}
	public int getPhouse() {
		return phouse;
	}
	public void setPhouse(int phouse) {
		this.phouse = phouse;
	}
	public int getPvilla() {
		return pvilla;
	}
	public void setPvilla(int pvilla) {
		this.pvilla = pvilla;
	}
	public int getPhotel() {
		return photel;
	}
	public void setPhotel(int photel) {
		this.photel = photel;
	}
	public String getCplayer() {
		return cplayer;
	}
	public void setCplayer(String cplayer) {
		this.cplayer = cplayer;
	}
	
	
	
}
