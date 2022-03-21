package towerparking;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] tower = { "[    ]","[    ]","[    ]","[    ]",
	 			"[    ]","[    ]","[    ]","[    ]",
	 			"[    ]","[    ]","[    ]","[    ]"};
		
		while(true) {
			try {
				for(int i = 0; i < tower.length; i++) {
					 System.out.print(tower[i]);
					 if(i%4==3) {
						 if(i==3) {
							 System.out.println("1층");
						 }
						 if(i==7) {
							 System.out.println("2층");
						 }
						 if(i==11) {
							 System.out.println("3층");
						 }
					 }
				 }
				System.out.println("-----------------------------");
				System.out.println("1.입차 2.출차 3.매출확인 4.차량확인");
				int ch =  scanner.nextInt();
				
				if (ch == 1) {//입차
					System.out.println("입차할 차량번호 4자리 : ");
					int carNum = scanner.nextInt();
					for (int i = 0; i < tower.length; i++) {
						if (tower[i].equals("[    ]")) {
							tower[i] = "["+carNum+"]";
							
							break;
						}
					}
					
				}else if (ch == 2) {//출차
					
					System.out.println("출차할 차량번호 4자리 : ");
					int outCarNum = scanner.nextInt();
					for (int i = 0; i < tower.length; i++) {
						if (tower[i].equals("["+outCarNum+"]")) {
							tower[i] = "[    ]";
							break;
						}
					}
				}else if (ch == 3) {//매출확인
					
				}else if (ch ==4) {//차량확인
					
				}else {
					System.out.println("알 수 없는 입력입니다.");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}//catch end
		}//while end
		
	}//me
}//ce
