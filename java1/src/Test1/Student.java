package Test1;

public class Student {
	
	private int number;
	private String name;
	private int korean;
	private int english;
	private int math;
	private double sum;
	private double avg;
	
	
	public Student(int number, String name, int korean, int english, int math, double sum, double avg) {
		super();
		this.number = number;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sum = sum;
		this.avg = avg;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKorean() {
		return korean;
	}


	public void setKorean(int korean) {
		this.korean = korean;
	}


	public int getEnglish() {
		return english;
	}


	public void setEnglish(int english) {
		this.english = english;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public double getSum() {
		return sum;
	}


	public void setSum(double sum) {
		this.sum = sum;
	}


	public double getAvg() {
		return avg;
	}


	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
	
	
	
	
}//ce
