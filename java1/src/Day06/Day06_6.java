package Day06;

import java.util.Scanner;

public class Day06_6 {//cs
	
	//��ȸ���� �Խ��� [Ŭ���� ����]
	
		//0.�Խù� ���� -> Ŭ���� ����
			//�ʵ� : ����, ����, �ۼ���, ��й�ȣ
			//������ : ������� ����
	
		//1.ùȭ�� [��� �Խù� (��ȣ, �ۼ���, ����) ���]
		//2.�޴� [1.�۾��� 2.�ۺ���]
			//1.�۾��� [����, ����, �ۼ���, ��й�ȣ ->4�� ���� -> ��üȭ]
			//2.�ۺ��� [�ش� �� ��ȣ�� �Է¹޾� �ش� �� �������� (��ȣ, �ۼ���, ����, ����) ǥ�� ]
				//�۹�ȣ�� �迭�� ����Ǵ� ���� [�ε���]
				//�ۺ��� �޴�
			//3.�ۺ��� �޴� [1.��Ϻ��� 2.���� 3.����]
				//1.������ : ��й�ȣ �Է¹޾� �����ϸ� ����
				//2.������ : ��й�ȣ �Է¹޾� �����ϸ� ����� ���븸 ����
	
	public static void main(String[] args) {//ms
		
		//�غ� [��� {}�ȿ��� ���Ǵ� ���� ����]
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100];
			//Board ��ü�� 100���� ������ �� �ִ� 1���� �迭 ����
		
		//���α׷� ����
		while(true) {//���α׷� ���� ���ѷ���
			System.out.println("-------Ŀ�´�Ƽ---------");
			//////////////////////////////��� �Խù� ��ȸ/////////////////////////////////
			System.out.println("��ȣ\t�ۼ���\t����");
				//�迭�� ��� ��ü(�Խù�) ��� �ݸ�
			int index =0;
			for ( Board board : boardlist  ) {
				if(board != null) {
					System.out.printf("%3d\t%5s\t%5s \n", index , board.writer, board.title);
				}
				index++; //�ε�������
			}
			////////////////////////////////////////////////////////////////////////	
			System.out.println("1.�۾��� 2.�ۺ���");
			int ch = scanner.nextInt();			
			if (ch == 1) {//�۾���
				///////////////////////�۾���/////////////////////////////////////////
				System.out.println("------�۾���������------");
				//1.4�� ������ �Է¹޴´�.
				System.out.println("title : "); String title =  scanner.next();
				System.out.println("content : "); String content =  scanner.next();
				System.out.println("writer : "); String writer =  scanner.next();
				System.out.println("password : "); String password =  scanner.next();
				//2.4�� ������ ��üȭ [��ü�� ���� 4�������� ��ü�� �ʵ忡 ����]
				Board board = new Board(title, content, writer, password);
					//4�� �ʵ带 ���� ������ ���
				//3. �迭�� ������� ã�Ƽ� ������� ��ü ����
				int i =0;
				for ( Board temp :  boardlist) {
					if (temp == null) {//�� ���� ã������
						boardlist[i] = board;//�ش� �ε����� ���ο� ��ü ����
						break; //�ѹ� ���������� �� 
					}
					i++;
				}
				
				
			}else if (ch ==2) {//�۸�� -> �ۺ���
				//�ش� �� ��ȣ�� �Է¹޾� �ش� �� �������� (��ȣ, �ۼ���, ����, ����) ǥ��
				//�۹�ȣ�� �迭�� ����Ǵ� ���� [�ε���]
				//�ۺ��� �޴�
				System.out.println("�� ��ȣ : "); int bno = scanner.nextInt(); //�� �Խù��� �ε��� ��ȣ
				
				//�ݺ� X -> ����� ��ġ�� �Է¹޾ұ� ������ �ݺ� �� �ص� ��
				System.out.printf("�ۼ��� : %s    ���� : %s  \n",boardlist[bno].writer, boardlist[bno].title);
				System.out.printf("���� : %s \n", boardlist[bno].content);
				
				System.out.println("------------------------");
				System.out.println("1.��Ϻ��� 2.�ۻ��� 3.�ۼ���");
				int ch2 = scanner.nextInt();
				
				if ( ch2 ==1 ) {//��Ϻ��� (�ڷΰ���)
					//�ݺ��� ������ ������ ������
					//�˾Ƽ� �ڵ� ������ ����
				} else if (ch2 == 2) {
					////////////////////////////�ۻ���//////////////////////////////////////////
					System.out.println("���� �Խù� ��й�ȣ : "); String password = scanner.next();
					//�ݺ���X - >�̹� ������ �������� ������ �ִ� ���� (�ε��� ��ȣ �Է¹���)
					if(boardlist[bno].password.equals(password)) {
						System.out.println("���� �Ǿ����ϴ�."); ///�ش� �Խù� null�� ����
						boardlist[bno] = null;
						//���� �Ŀ� ������ �ε��� �ڷ� ��ĭ�� ������ �̵�
						//���� �ش� �ڵ尡 ���� ��� �迭 �� ���̻��̿� ���� �߻�
						for (int i =bno;  i<=boardlist.length ; i++) {
							//�˻��� �Խù��� �ε��� ���� ������ �ε��� ���� 1������
							boardlist[bno] = boardlist[bno+1]; //������ �Խù� ���� �Խù�
							
							
							if (i == boardlist.length-1 ) {
								boardlist[boardlist.length-1] = null;
							}
						}
					} else {
						System.out.println("��й�ȣ�� �ٸ��ϴ�.");
					}
				} else if (ch2 == 3) {
					///////////////////////////�ۼ���//////////////////////////////////
				System.out.println("���� �Խù� ��й�ȣ : "); String password = scanner.next();
				
					if (boardlist[bno].password.equals(password)) {
						System.out.println("������ ���� : ");	boardlist[bno].title = scanner.next();
						System.out.println("������ ���� : ");	boardlist[bno].content = scanner.next();
						
					}else {
						System.out.println("��й�ȣ�� �ٸ��ϴ�.");
					}
					
				} else {//�׿�
					System.err.println("�� �� ���� ��ȣ�Դϴ�.");
				}
				
			} else {
				System.err.println("�� �� ���� ��ȣ�Դϴ�.");
			}
			
		}//���α׷� ���� while end
		
		
		
		
		
	}//me
}//ce
