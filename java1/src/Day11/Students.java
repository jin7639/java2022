package Day11;

public class Students {

	private int no;	//번호
	private String name;//이름
	private int korea;	//국어점수
	private int english;//영어점수
	private int math;	//수학점수
	private int sum;	//총점
	private double avg;	//평균

	//생성자
	
	public Students() {}

	public Students(int no, String name, int korea, int english, int math, int sum, double avg) {
		super();
		this.no = no;
		this.name = name;
		this.korea = korea;
		this.english = english;
		this.math = math;
		this.sum = sum;
		this.avg = avg;
	}

	//메소드
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorea() {
		return korea;
	}

	public void setKorea(int korea) {
		this.korea = korea;
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
	
	
	
	
}//ce	
	
