package Test2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Car {
	
	private String carNum;
	private LocalDate carInDate;
	private LocalTime carInTime;
	private LocalTime carOutTime;
	private int parkingFee;
	
	public Car() {}

	
	
	public Car(String carNum, LocalDate carInDate, LocalTime carInTime) {
		super();
		this.carNum = carNum;
		this.carInDate = carInDate;
		this.carInTime = carInTime;
	}



	public Car(String carNum, LocalDate carInDate, LocalTime carInTime, LocalTime carOutTime, int parkingFee) {
		super();
		this.carNum = carNum;
		this.carInDate = carInDate;
		this.carInTime = carInTime;
		this.carOutTime = carOutTime;
		this.parkingFee = parkingFee;
	}

	

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public LocalDate getCarInDate() {
		return carInDate;
	}

	public void setCarInDate(LocalDate carInDate) {
		this.carInDate = carInDate;
	}

	public LocalTime getCarInTime() {
		return carInTime;
	}

	public void setCarInTime(LocalTime carInTime) {
		this.carInTime = carInTime;
	}

	public LocalTime getCarOutTime() {
		return carOutTime;
	}

	public void setCarOutTime(LocalTime carOutTime) {
		this.carOutTime = carOutTime;
	}

	public int getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(int parkingFee) {
		this.parkingFee = parkingFee;
	}
	
	
	
	
}//ce
