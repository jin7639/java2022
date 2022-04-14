package Day11;

import java.util.Scanner;

public class Day11_4_BoardApp {

	//�Խ���/��� ���α׷� [ ����ó�� , ����ó�� , ����Ʈ ]
		//[m]�Խù� Ŭ����
			//��ȣ=�ε���, ����, ����, �ۼ���, �ۼ���, ��ȸ��
			//��۸���Ʈ
		//[m]��� Ŭ����
			//����, �ۼ���, �ۼ���
		//[c]��Ʈ�ѷ� Ŭ����
			//1.��� 2.���� 3.���� 4.���� 5.���� 6.��۾���
			//7.�Խù����� 8.�Խù��ҷ����� 9.������� 10.����
		//[v]Day11_4_BoardApp Ŭ����
			//����� [ �Է¹޾� ��Ʈ�ѷ����� �Է¹��� �� ���� ]
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	Controller.load(); // 2. ����[ ��� �Խù�] �ҷ����� 
	while(true) {
		try {//���ܹ߻�
			//��� �Խù� ���
			System.out.printf("%s\t%s\t%s\t%s\t   %s\t \n","��ȣ","����","�ۼ���","�ۼ���","��ȸ��");
				
			int i = 0; //����Ʈ�� �ε���
			for(Board board : Controller.boardlist) {
				System.out.printf("%s\t%s\t%s\t%s     %s\t \n", i, board.getTitle(),
						board.getWriter(),board.getDate(),board.getViewcount());
				i++;
			}
			
			System.out.print("1.���� 2.���� ���� : ");
			int ch = scanner.nextInt();
			
			if (ch == 1) {
				System.out.println("*** �Խù� ��� ***"); scanner.nextLine();
				//nextLine() : ���� ���� �Է°���
				//nextLine �տ� next ������� �ϳ��� ���
				//���̿� NextLine �߰����ָ��(�и�����. �ǹ� X)
				System.out.print("���� : ");	String ���� = scanner.nextLine();
				System.out.print("���� : "); String ���� = scanner.nextLine();
				System.out.print("�ۼ��� : "); String �ۼ��� = scanner.next();
				System.out.print("��й�ȣ[����/������] : ");  String ��й�ȣ = scanner.next();
				Controller.write(����, ����, �ۼ���, ��й�ȣ); //�μ�����
			}else if (ch == 2) {
				//�ش� �Խù� ��ȣ[�ε���]�� �Է¹޾� �Խù����� ��� ���
				System.out.println("�Խù� ��ȣ : "); int index = scanner.nextInt();
				Board temp = Controller.boardlist.get(index);	//�ش� �ε����� ��ü�� �ӽ� ��ü�� ��� [�ڵ� ���̱�]
				System.out.println("���� : "+ temp.getTitle());
				System.out.println("�ۼ��� : " + temp.getWriter()+
						" �ۼ��� : " + temp.getDate()+ " ��ȸ�� : "+ temp.getViewcount());
				System.out.println("���� : "+ temp.getContents());
				
				
				//�޴�
				System.out.println("1.�ڷΰ��� 2.���� 3.���� 4.��۾��� ����: ");
				int ch2 = scanner.nextInt();
				if (ch2 == 1) {
					
				}else if (ch2 == 2) {//������ �ε��� ��ȣ, ��й�ȣ Ȯ��, ������ ����, ������ ���� -> �μ�
					System.out.println("���� �Խù� ��й�ȣ : "); String password = scanner.next();
					scanner.nextLine();
					System.out.println("������ ���� : "); String title = scanner.nextLine();
					System.out.println("������ ���� : "); String content = scanner.nextLine();
					boolean result = Controller.update(index, password, title, content);	
					if (result) {
						System.err.println("���� ����");
					}else {
						System.err.println("���� ����");
					}
					
					
				}else if (ch2 == 3) {//������ �ε��� ��ȣ, ��й�ȣ -> �μ�
					System.out.println("���� �Խù� ��й�ȣ : "); String password = scanner.next();
					Boolean result = Controller.delete(index, password);
					if (result) {
						System.out.println("���� ����");
					}else {
						System.out.println("��й�ȣ�� �ٽ� Ȯ�����ּ���");
					}
					
				}else if (ch2 == 4) {//�ε��� ��ȣ, ��� ���� , ��� ��й�ȣ, ��� �ۼ���
					Controller.replywriter();
				}else {
					
				}
			}else {
				
			}
		}catch (Exception e) {
			System.out.println("����� �� ���� �Է��Դϴ�.");
			scanner = new Scanner(System.in);
		}
		
	}//while end
		
		
		
	}//me
	
}//ce
