package Day15;

import java.time.LocalDate;
import java.time.LocalTime;

public class Car {

	private LocalDate carInDate;
	private String carNum;
	private LocalTime carInTime;
	private LocalTime 출차시간 ;
	private int 금액;
	
	//생성자
		//1.빈생성자
	public Car() {}

	
		//차량 등록시
	public Car(LocalDate carInDate, String carNum, LocalTime carInTime) {
		super();
		this.carInDate = carInDate;
		this.carNum = carNum;
		this.carInTime = carInTime;
	}


		//풀생성자
	public Car(LocalDate carInDate, String carNum, LocalTime carInTime, LocalTime 출차시간, int 금액) {
		super();
		this.carInDate = carInDate;
		this.carNum = carNum;
		this.carInTime = carInTime;
		this.출차시간 = 출차시간;
		this.금액 = 금액;
	}

	//메소드
	public LocalDate getcarInDate() {
		return carInDate;
	}

	public void setcarInDate(LocalDate carInDate) {
		this.carInDate = carInDate;
	}

	public String getcarNum() {
		return carNum;
	}

	public void setcarNum(String carNum) {
		this.carNum = carNum;
	}

	public LocalTime getcarInTime() {
		return carInTime;
	}

	public void setcarInTime(LocalTime carInTime) {
		this.carInTime = carInTime;
	}

	public LocalTime get출차시간() {
		return 출차시간;
	}

	public void set출차시간(LocalTime 출차시간) {
		this.출차시간 = 출차시간;
	}

	public int get금액() {
		return 금액;
	}

	public void set금액(int 금액) {
		this.금액 = 금액;
	}
	
	
	
}//ce
