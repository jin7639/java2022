package Test2;

public class Car {

//	날짜 차량번호 입차시간 출차시간 금액
	private String carInDate;
	private String carNum;
	private String carInTime;
	private String carOutTime;
	private int parkingFee;
	
	public Car () {}



	public Car(String carInDate, String carNum, String carInTime, String carOutTime, int parkingFee) {
		super();
		this.carInDate = carInDate;
		this.carNum = carNum;
		this.carInTime = carInTime;
		this.carOutTime = carOutTime;
		this.parkingFee = parkingFee;
	}

	public String getCarInDate() {
		return carInDate;
	}

	public void setCarInDate(String carInDate) {
		this.carInDate = carInDate;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCarInTime() {
		return carInTime;
	}

	public void setCarInTime(String carInTime) {
		this.carInTime = carInTime;
	}

	public String getCarOutTime() {
		return carOutTime;
	}

	public void setCarOutTime(String carOutTime) {
		this.carOutTime = carOutTime;
	}

	public int getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(int parkingFee) {
		this.parkingFee = parkingFee;
	}
	
	
	
	
}//ce
