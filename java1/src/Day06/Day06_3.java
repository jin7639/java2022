package Day06;

import java.util.Scanner;

public class Day06_3 {//cs
	//ȸ���� �湮�� ���α׷� [Ŭ����]
	
		//0. ȸ�� ���� -> ȸ�� Ŭ���� �����
			//1. �ʵ�
				//1. ���̵� 2. ��й�ȣ 3. �̸� 4. ��ȭ��ȣ
	
		//1. �ʱ�޴� [1. ȸ������ 2. �α��� 3.���̵�ã�� 4.��й�ȣã��]
			//1. ȸ�����Խ� �Է¹޾� ����
			//2. �α��ν� ���̵�� ��й�ȣ�� �����ϸ� �α���ó��
			//3. ���̵�ã��� �̸��� ��ȭ��ȣ�� �����ϸ� ���̵� ���
			//4. ��й�ȣ ã��� ���̵�� ��ȭ��ȣ�� �����ϸ� ��й�ȣ ���
	public static void main(String[] args) {//ms
		
		//���� �����ϴ� ���� : main �޼ҵ� ��� ������ ����ϱ� ���ؼ�(��������)
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];
		//Member Ŭ������ ������� ��ü(id, pw, name, phone) 100�� ������ �� �ִ� �迭 ����
		
		
		//Ŭ������ �����ٸ�
			//String[][] memberlist = new Member[100][4];
		
		while(true) {//���α׷� ���� while ���ѷ��� [�������� X]
			
			System.out.println("------ȸ����[Ŭ��������]-------");
			System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��");
			System.out.println("���� : "); int ch = scanner.nextInt();
			
			if ( ch == 1) { //ȸ������
				//1. id, pw, name, phone �Է¹ޱ� -> ���� 4��
				System.out.println("----------ȸ������ ������-----------");
				System.out.println("���̵� : "); String id = scanner.next();
				System.out.println("��й�ȣ : "); String pw = scanner.next();
				System.out.println("�̸� : "); String name = scanner.next();
				System.out.println("��ȭ��ȣ : "); String phone = scanner.next();
			
				//2. ��ü ����
				Member member = new Member();
			
				//3. �Է¹��� ���� 4���� ��ü �� �ʵ忡 ����
					//��ü �� �ʵ� = �Է¹��� ��
				member.id = id;
				member.pw = pw;
				member.name = name;
				member.phone = phone;
				
				//���̵� �ߺ�üũ
					//1.�迭�� ��ü �� �Է��� ���̵�� ������ ���̵� ã��
				boolean idcheck = false;
				for( Member temp : memberlist ) {
					// memberlist �迭 �� ��ü���� �ϳ��� temp�� ���� �ݺ�
					if(temp !=null && temp.id.equals(id)) {
						//���࿡ �ش� ��ü �� id�� �Է¹��� id�� ������
						System.out.println("������� ���̵� �Դϴ�.");
						idcheck = true; //�ߺ��̸� true
						break;
					}
				}
					if ( idcheck ==false) {//���̵� �ߺ��� ���� ��� ����
						
						//4. ������ ��ü�� �����ϴ� �迭�� ����
						//1. ���� �ε��� ã�Ƽ� [ ���� �ƴ� ���� �����ϸ� ���� ���� �����]
						int i = 0; //�ε��� ��ġ ����;
						for( Member temp : memberlist ) {
							//memberlist �迭 �� member ��ü �ϳ��� �����ͼ� temp ���� �ݺ�
							//2. ���� �ε����� ��ü ����
							if ( temp == null ) {//���� �ش� ��ü�� �����̸�
								memberlist[i] = member; //�ش� �ε����� ���� ������� ��ü ����
								System.out.println("ȸ������ ����");
								break;//for ������ [�� ������ ��� ���鿡 ������ ��ü ����Ǳ� ������
							}
							i++; //�ε��� ����
						}//for end
					} 
				}else if (ch == 2) {//�α���
				
				//1. �Է¹ޱ�
				System.out.println("----------�α��� ������-----------");
				System.out.println("���̵� : "); String loginid = scanner.next();
				System.out.println("��й�ȣ : "); String loginpw = scanner.next();
				
				//2. ���� �迭[ȸ������Ʈ] �� �Է¹��� ���� ��
				boolean logincheck = false; //true �α��� ����
				for( Member temp : memberlist ) {
					//memberlist �� 0�� �ε������� �� �ε��� ���� �ϳ��� temp�� ����
					if ( temp !=null && temp.id.equals(loginid) && temp.pw.equals(loginpw)) {
						//��ü�� null�϶��� equals �Ұ� [null �ƴҶ��� equals ����]
						System.out.println("�α��� ����");
						logincheck = true;
					}//if end
				}//for end
				//�α��� ���� ����
				if (logincheck == false) {
					System.err.println("�������� �ʴ� ȸ�������Դϴ�.");
				}
				
			}//�α��� end
			else if (ch == 3) {//���̵�ã��
				//1.�̸��� ����ó�� �Է¹޴´�.
				System.out.println("---------���̵�ã�� ������----------");
				System.out.println("�̸� : "); String name = scanner.next();
				System.out.println("����ó : "); String phone = scanner.next();
				
				//2.�迭�� ������ �̸��� ����ó�� �ִ��� Ȯ���Ѵ�.
				boolean findcheck = false;
				for ( Member temp : memberlist) {
					
					if( temp !=null && temp.name.equals(name) && temp.phone.equals(phone) ) {
						//3.������ ��ü�� ������ �ش� ���̵� ���
						System.out.println("���̵�ã�� ����");
						System.out.println("ȸ�� ID : " + temp.id);
						findcheck = true; // ���̵� ã�Ҵٴ� ���
						break;
					}
				}
				//4.������ ���ٰ� ���
				if( findcheck == false){
					System.out.println("��ġ�ϴ� ȸ�������� �����ϴ�.");
				}
			} else if (ch == 4) {//��й�ȣã��
				System.out.println("���̵� : "); String id = scanner.next();
				System.out.println("��ȭ��ȣ : "); String phone = scanner.next();
				
				boolean findcheck = false;
				for (Member temp : memberlist) {
					if(temp != null && temp.id.equals(id) && temp.id.equals(phone)) {
						System.out.println("��й�ȣ ã�� ����");
						System.out.println("ȸ�� ��й�ȣ : " + temp.pw);
						findcheck =true;
						break;
					}
				}
				if ( findcheck == false ) {
					System.out.println("������ ȸ�������� �����ϴ�.");
				}
				
			} else {//�� ��
				System.err.println("�� �� ���� ��ȣ�Դϴ�.");
			}
			
			
		}//���α׷� ���� while end
		
	}//me
	
}//ce
