package Day07;

import java.util.Scanner;

public class Member {//cs
	//1.�ʵ�
//		ȸ����ȣ(�ڵ���ȣ, �ߺ��Ұ�)
	int mno;	
//		���̵�(�ߺ��Ұ�)
	String id;
//		��й�ȣ
	String password;
//		�̸�
	String name;
//		����ó
	String phone;
	
	//2.������ [�����ڸ� == Ŭ������]
		//1. �������[�⺻������] : �޼ҵ� ȣ��� ��ü ������
	public Member () {}
	
		//2. ��� �ʵ带 �޴� ������ : ȸ�����Կ� ��ü ������
	public Member(int mno, String id, String password, String name, String phone) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	//3.�޼ҵ�
//		1. ȸ������ �޼ҵ� [�μ�x��ȯo : ���Լ��� true ���Խ��� false]
	boolean ȸ������() {
		System.out.println("--------------ȸ������ ������--------------");
		//1.�Է¹޴´� [ id, pw, name, phone]
		System.out.println("���̵� �Է����ּ���."); String id = Day07_5_BookApplication.scanner.next(); 
		//���̵� �ߺ�üũ
		for(Member temp : Day07_5_BookApplication.members) {
			if (temp !=null && temp.id.equals(id)) {
				//���࿡ ������ �ƴϸ鼭 �迭�� id�� �Է¹��� id�� �����ϸ�
				System.out.println("���� ������� ���̵��Դϴ�.");
				return false; //�Լ����� --->���̵��ߺ����� ȸ������ ����
			}
		}
		System.out.println("��й�ȣ�� �Է����ּ���."); String password =  Day07_5_BookApplication.scanner.next();
		System.out.println("�̸��� �Է����ּ���."); String name =  Day07_5_BookApplication.scanner.next(); 
		System.out.println("����ó�� �Է����ּ���."); String phone =  Day07_5_BookApplication.scanner.next(); 
			//scanner ��ü�� �ٸ� Ŭ������ static����Ǿ�����
			
			//ȸ����ȣ �ڵ����� [������ ȸ����ȣ +1]
		int bno = 0; //ȸ����ȣ �����ϴ� ����
		int j = 0; //�ݺ�Ƚ�� [�ε���]
		for(Member temp : Day07_5_BookApplication.members) {
			if (temp == null ) { //null ã�� [null ã������ null-1�ϸ� ������ ȸ��
				if ( j == 0 ) {
					bno =1; //ù��° �ε���[0�� �ε���]�� null ->ùȸ�� ->ùȸ�� ��ȣ = 1�ο�
					break;
				}else {
					bno = Day07_5_BookApplication.members[j-1].mno + 1;
							//null �� [������ ȸ��]��ȣ�� +1
					break;
				}
			}
			j++;//�ε��� ����
		}
		//2.4������ ->��üȭ ->1��
		Member member = new Member(bno, id , password, name, phone);
		
		//3.�迭�� ������� ã�Ƽ� ���ο� ȸ��[��ü]�ֱ�
		int i = 0;
		for (Member temp : Day07_5_BookApplication.members) {
			if ( temp == null ) {//������̸�
				Day07_5_BookApplication.members[i] = member;//���ε����� ���ο� ȸ������
				return true; //ȸ������ �޼ҵ� ���� [��ȯ : true]
			}
			i++; //i����
		}
		
		//4.���� ������ true ��ȯ ���н� false ��ȯ
		
		return false; //ȸ������ �޼ҵ� ���� 
	}
//		2. �α��� �޼ҵ� [�μ� x ��ȯ o : �α��� ������ ������ ���̵� ��ȯ / ���н� null�� ��ȯ]
	String �α��� () {
		//1.�Է¹ޱ�
		System.out.println("--------------�α��� ������--------------");
		System.out.println("���̵� �Է����ּ���."); String id = Day07_5_BookApplication.scanner.next(); 
		System.out.println("��й�ȣ�� �Է����ּ���."); String password =  Day07_5_BookApplication.scanner.next();

		//2.�迭 �� ��ü id�� pw�� �Է°��� �����ϸ�
		for(Member temp : Day07_5_BookApplication.members) {
			if (temp != null&& temp.id.equals(id) && temp.password.equals(password)) {
				//������ �ƴϸ鼭 id�� password�� �����ϸ�
				return temp.id; //������ id ��ȯ
			}
		}
		//3. �α��� ������ �Է��� id ��ȯ / ���н� null
		return null;
	}
//		3. ���̵�ã�� �޼ҵ� [�μ� x ��ȯ x ] :�̸�, ����ó
	void ���̵�ã��() {
		System.out.println("--------------���̵� ã��--------------");
		System.out.println("�̸��� �Է����ּ���."); String name = Day07_5_BookApplication.scanner.next(); 
		System.out.println("����ó�� �Է����ּ���."); String phone =  Day07_5_BookApplication.scanner.next();
		
		for(Member temp : Day07_5_BookApplication.members) {
			if (temp != null && temp.name.equals(name) && temp.phone.equals(phone) ) {
				//������ �ƴϸ鼭 �ش� ��ü �� name, phone�� �Է¹��� ���� �����ϸ�
				System.out.println("ȸ������ ���̵� : " + temp.id);
				return; //ã�� ������ id ��ȯ ->����
			}
		}
		//�� ã������ ã�� id ����ϰ� �� ã������ �˸� ���
		System.out.println("��ġ�ϴ� ȸ�������� �����ϴ�.");
		
		
	}
	
//		4. ��й�ȣ �޼ҵ�[�μ� x ��ȯ x ] : ���̵�, ����ó
	void ��й�ȣã��() {
		System.out.println("--------------��й�ȣ ã��--------------");
		System.out.println("���̵��� �Է����ּ���."); String id = Day07_5_BookApplication.scanner.next(); 
		System.out.println("����ó�� �Է����ּ���."); String phone =  Day07_5_BookApplication.scanner.next();
		
		for(Member temp : Day07_5_BookApplication.members) {
			if (temp != null && temp.id.equals(id) && temp.phone.equals(phone) ) {
				//������ �ƴϸ鼭 �ش� ��ü �� name, phone�� �Է¹��� ���� �����ϸ�
				System.out.println("ȸ������ ��й�ȣ : " + temp.password);
				return; //ã�� ������ id ��ȯ ->����
			}
		}
		System.out.println("��ġ�ϴ� ȸ�������� �����ϴ�.");
	}
	
//		5. ȸ��Ż�� �޼ҵ�
	
	
	
}//ce
