package Day15;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				
				//1. ��� ���� ǥ ���
					//
						//�迭�̳� ����Ʈ �� ��� ��ü ȣ�� �ݺ���
					//	
				System.out.println("-------------���� ��Ȳ ǥ--------------");
				System.out.println("\t��¥\t������ȣ\t\t�����ð�\t�����ð�\t�ݾ�");
				int i = 0;		
				for (Car car : Controller.carlist) {
					if (car.getcarNum() == null) {
						
					}else if (car.get�����ð�() == null) {
						System.out.printf("%s\t%s\t\t%s\t%s\t%s \n", 
								car.getcarInDate(), car.getcarNum(),car.getcarInTime(),"���� ��", "���� ��");
					}else
						System.out.printf("%s\t%s\t\t%s\t%s\t%d \n", 
								car.getcarInDate(), car.getcarNum(),car.getcarInTime(),car.get�����ð�(), car.get�ݾ�());
				
				}
				
				System.out.println("------------------------------------");
				
				System.out.println("\t\t1.���� \t 2.����  :");
				int ch = scanner.nextInt();
				if (ch == 1) {
					
					//1. ������ȣ�� �Է¹޴´�.
					System.out.println("������ȣ : ");
						//�Է�
					String carNum = scanner.next();
					//2.�Է¹��� ������ȣ�� ��Ʈ�ѳ� �޼ҵ忡�� �ѱ��.
					Controller.carIn(carNum) ; //�μ�����
					//3.�޼ҵ����� ���� ���
					boolean ��� = Controller.carIn(null);
					
				}else if (ch == 2 ) {
					//1. ������ȣ�� �Է¹޴´�.
					System.out.println("������ȣ : ");
						//�Է�
					String carNum = scanner.next();
					//2.�Է¹��� ������ȣ�� ��Ʈ�ѳ� �޼ҵ忡�� �ѱ��.
					Controller.carOut(carNum) ; //�μ�����
					//3.�޼ҵ����� ���� ���
					boolean ��� = Controller.carOut(null);
				}
				
				
			} catch (Exception e) {
				System.out.println("����� �� ���� �Է��Դϴ�.");
				scanner = new Scanner(System.in);
			}
			
		} //while end
	}//me
}//ce
