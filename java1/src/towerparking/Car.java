package towerparking;

public class Car {

	private int carNum;
	private int carParking;
	private int carParkingTime;
	
	public void car() {}

	public Car(int carNum, int carParking, int carParkingTime) {
		super();
		this.carNum = carNum;
		this.carParking = carParking;
		this.carParkingTime = carParkingTime;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public int getCarParking() {
		return carParking;
	}

	public void setCarParking(int carParking) {
		this.carParking = carParking;
	}

	public int getCarParkingTime() {
		return carParkingTime;
	}

	public void setCarParkingTime(int carParkingTime) {
		this.carParkingTime = carParkingTime;
	}
	
	
	
}
