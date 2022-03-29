package Team_Theater;

public class Movie {

	private String title;
	private String intime;
	private String runtime;
	private int money;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	

	public Movie(String title, String intime, String runtime) {
		super();
		this.title = title;
		this.intime = intime;
		this.runtime = runtime;
	}



	public Movie(String title, String intime, String runtime, int money) {
		super();
		this.title = title;
		this.intime = intime;
		this.runtime = runtime;
		this.money = money;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getIntime() {
		return intime;
	}



	public void setIntime(String intime) {
		this.intime = intime;
	}



	public String getRuntime() {
		return runtime;
	}



	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}



	public int getMoney() {
		return money;
	}



	public void setMoney(int money) {
		this.money = money;
	}


	
	
	
	
	
}
