package Day15;

import java.time.LocalDate;
import java.time.LocalTime;

public class Car {

	private LocalDate carInDate;
	private String carNum;
	private LocalTime carInTime;
	private LocalTime �����ð� ;
	private int �ݾ�;
	
	//������
		//1.�������
	public Car() {}

	
		//���� ��Ͻ�
	public Car(LocalDate carInDate, String carNum, LocalTime carInTime) {
		super();
		this.carInDate = carInDate;
		this.carNum = carNum;
		this.carInTime = carInTime;
	}


		//Ǯ������
	public Car(LocalDate carInDate, String carNum, LocalTime carInTime, LocalTime �����ð�, int �ݾ�) {
		super();
		this.carInDate = carInDate;
		this.carNum = carNum;
		this.carInTime = carInTime;
		this.�����ð� = �����ð�;
		this.�ݾ� = �ݾ�;
	}

	//�޼ҵ�
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

	public LocalTime get�����ð�() {
		return �����ð�;
	}

	public void set�����ð�(LocalTime �����ð�) {
		this.�����ð� = �����ð�;
	}

	public int get�ݾ�() {
		return �ݾ�;
	}

	public void set�ݾ�(int �ݾ�) {
		this.�ݾ� = �ݾ�;
	}
	
	
	
}//ce
