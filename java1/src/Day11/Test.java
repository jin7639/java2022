package Day11;

import java.util.Scanner;

public class Test {//cs


	public static void main(String[] args) {//ms
		
		Scanner scanner = new Scanner(System.in);
		Students[] students = new Students[100];
		
		while (true) {//while start
			try {

				System.out.println("---------------------------------------------------------------");
				System.out.println("                         성     적      표                       ");
				System.out.println("---------------------------------------------------------------");
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s \n","번호","이름","국어","영어","수학","총점","평균","석차");
				for(int i = 0 ; i < students.length ; i++) {
					if(students[i] != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d \n", 
								students[i].getNo(), students[i].getName(), students[i].getKorea(), 
								students[i].getEnglish(), students[i].getMath(),students[i].getSum(),students[i].getAvg(),i+1);
					}else {
						break;
					}
					
				}	
				
				System.out.println("---------------------------------------------------------------");
				System.out.println("1.학생점수 등록 2.학생점수 삭제");
				int ch = scanner.nextInt();
				
				
				if (ch == 1) {
					//1. 번호 이름 국어 영어 수학 
					System.out.println("----------학생점수 등록-----------");
					System.out.println("번호 : "); int no = scanner.nextInt();
					System.out.println("이름 : "); String name = scanner.next();
					System.out.println("국어점수 : "); int korea = scanner.nextInt();
					System.out.println("영어점수 : "); int english = scanner.nextInt();
					System.out.println("수학점수 : "); int math = scanner.nextInt();
					
					int sum = korea + english + math;
					double avg = (double)sum / 3 ;
					
					//2. 객체 생성
					Students students1 = new Students(no, name, korea, english, math, sum, avg);
					
					//3. 저장
					for (int i = 0; i < students.length; i++) {
						if (students[i] == null) {
							students[i] = students1;
							break;
						}
					}
					//석차
					if (students[1] != null) {
						for (int i = 0; i < students.length; i++) {
							
							for (int j = i + 1; j < students.length; j++) {
								if (students[i].getSum() < students[j].getSum()) {
									System.out.println(students[i].getSum()+ " , "+ students[j].getSum());
									Students temp = students[i];
									students[i] = students[j];
									students[j] = temp;
								}
							}
						}
					}
					
				}else if (ch == 2) {
					System.out.println("삭제할 학생 번호: ");
					int st_del = scanner.nextInt();
					boolean delete = false;
					for (int i = 0 ; i < students.length; i++) {
						if(students[i].getNo() == st_del) {
							students[i] = null;
							for (int j = i; j < students.length; j++) {
								students[j] = students[j+1];
							}
							
							System.out.println("삭제하였습니다.");
							delete = true;
							break;
						}
					}
					if (delete == false) {
						System.out.println("일치하는 학생이 없습니다.");
					}
					
				}else {
					System.out.println("알 수 없는 번호입니다.");
					
				}
				
				
			}//try end
			catch (Exception e) {
				System.out.println("사용할 수 없는 입력입니다.");
				scanner = new Scanner(System.in);
			}//catch end
			
		}//while end
		
	}//me

}//ce
