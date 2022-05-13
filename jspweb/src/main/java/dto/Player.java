package dto;

public class Player {
	private String cplayer;
	private int money;
	
	public Player() {
		super();
	}

	public Player(String cplayer, int money) {
		super();
		this.cplayer = cplayer;
		this.money = money;
	}

	public String getCplayer() {
		return cplayer;
	}

	public void setCplayer(String cplayer) {
		this.cplayer = cplayer;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
