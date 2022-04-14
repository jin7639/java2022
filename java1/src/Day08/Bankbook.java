package Day08;

import java.util.Scanner;

import Day08.Day08_Bank;
import Day08.Member;

public class Bankbook {//cs
	
	//1.필드
	String account; //계좌번호
	String name;	//예금주
	int balance; 	//계좌잔액
	//2.생성자
		//1.빈 생성자 : 메소드 호출용
	public Bankbook() {}
	
		//2.모든 필드 생성자
	public Bankbook(String account, String name, int balance) {
		this.account = account;
		this.name = name;
		this.balance = balance;
	}
	
	//3.메소드 
		//1.계좌생성 
	
		//2.입금 
			void 입금() {
				System.out.println("입금할 계좌 번호 : "); String depositaccount = Day08_Bank.scanner.next();
				for(Bankbook temp : Day08_Bank.bankbook) {
					if (temp != null && temp.account.equals(depositaccount)) {
						System.out.println("입금할 금액 : ");	int amount = Day08_Bank.scanner.nextInt();
						temp.balance += amount;
						System.out.println("입금이 완료되었습니다. 잔액 : "+ temp.balance);
						return;
					}
				} System.out.println("존재하지 않는 계좌입니다.");
			}//입금 end
	
		//3.출금 
			void 출금() {
				System.out.println("출금할 계좌 번호 : "); String withdrawaccount = Day08_Bank.scanner.next();
				for(Bankbook temp : Day08_Bank.bankbook) {
					if (temp != null && temp.account.equals(withdrawaccount)) {
						System.out.println("현재 잔액 : " + temp.balance);
						System.out.println("출금할 금액 : ");	int amount = Day08_Bank.scanner.nextInt();
						if (temp.balance >= amount) {
							
							System.out.println("출금이 완료되었습니다.");
							//계좌 잔액 변동
							temp.balance -= amount;
							System.out.println("현재 잔액 : " + temp.balance);
							return;
							
						}else {
							System.out.println("잔액이 부족합니다.");
						}
						return; //종료
					}
				} System.out.println("존재하지 않는 계좌입니다.");
			}
	
		//4.이체 
	//	출금계좌 금액 받는사람 은행 계좌번호 보내는 사람 계좌비밀번호
			
			void 이체() {
				System.out.println("출금할 계좌 번호 : "); 	String sendaccount = Day08_Bank.scanner.next();
				//계좌 잔액 불러오기
				for(Bankbook temp : Day08_Bank.bankbook) {
					if (temp != null && temp.account.equals(sendaccount)) {
						//공백이 아니면서 동일한 계좌번호를 찾음
						System.out.println("현재 잔액 : " + temp.balance);
						return; //종료
					}else {//못 찾았으면 찾은 id 출력하고 못 찾았으면 알림 출력
						System.out.println("존재하지 않는 계좌입니다.");
						return;
					}
				}
				
				System.out.println("보내실 금액 : ");		int sendamount = Day08_Bank.scanner.nextInt();
				if (temp.balance >= sendamount) {
					System.out.println("입금하실 은행 : "); 		String depositbank = Day08_Bank.scanner.next();
					System.out.println("입금하실 계좌 번호 : "); 		String depositaccount = Day08_Bank.scanner.next();
//
//					System.out.println("이체 완료하였습니다.");
//					//계좌 잔액 변동
//					temp.balance -= sendamount;
//					System.out.println("현재 잔액 : " + temp.balance);
//					return;
//					
				}else {
					System.out.println("잔액이 부족합니다.");
				}
			}//이체 end
	
		//5.대출 
			
			
		//6.계좌목록
	

}//ce
