package Day08;

import Day08.Bankbook;
import Day08.Day08_Bank;

public class Member {//cs

	//1.�ʵ�
	String name; 		//�̸�
	String id;			//���̵�
	String password;	//��й�ȣ
	String phone;		//����ó
	//2.������
		//1.�� ������
	public Member() {}
	//2.��� �ʵ� ������
	public Member(String name, String id, String password, String phone) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.phone = phone;
	}
	
	//3.�޼ҵ�
	 	//1.ȸ������ 
	boolean ȸ������() {
		System.out.println("--------------ȸ������ ������--------------");
		//1.�Է¹޴´� [ id, pw, name, phone]
		System.out.println("���̵� �Է����ּ���."); String id = Day08_Bank.scanner.next();
		//���̵� �ߺ�üũ
		for(Member temp : Day08_Bank.members) {
			if (temp !=null && temp.id.equals(id)) {
				//���࿡ ������ �ƴϸ鼭 �迭�� id�� �Է¹��� id�� �����ϸ�
				System.out.println("���� ������� ���̵��Դϴ�.");
				return false; //�Լ����� --->���̵��ߺ����� ȸ������ ����
			}
		}
		
		System.out.println("��й�ȣ�� �Է����ּ���."); String password = Day08_Bank.scanner.next();
		System.out.println("�̸��� �Է����ּ���."); String name =  Day08_Bank.scanner.next();
		System.out.println("����ó�� �Է����ּ���."); String phone =  Day08_Bank.scanner.next(); 
			
		//2.4������ ->��üȭ ->1��
		Member member = new Member( name, id,password, phone);
		
		//3.�迭�� ������� ã�Ƽ� ���ο� ȸ��[��ü]�ֱ�
		int i = 0;
		for (Member temp :  Day08_Bank.members) {
			if ( temp == null ) {//������̸�
				 Day08_Bank.members[i] = member;//���ε����� ���ο� ȸ������
				return true; //ȸ������ �޼ҵ� ���� [��ȯ : true]
			}
			i++; //i����
		}
		//4.���� ������ true ��ȯ ���н� false ��ȯ
		return false; //ȸ������ �޼ҵ� ���� 
	}
		//2.�α��� 
	String �α��� () {
		//1.�Է¹ޱ�
		System.out.println("--------------�α��� ������--------------");
		System.out.println("���̵� �Է����ּ���."); String id = Day08_Bank.scanner.next();
		System.out.println("��й�ȣ�� �Է����ּ���."); String password = Day08_Bank.scanner.next();

		//2.�迭 �� ��ü id�� pw�� �Է°��� �����ϸ�
		for(Member temp : Day08_Bank.members) {
			if (temp != null&& temp.id.equals(id) && temp.password.equals(password)) {
				//������ �ƴϸ鼭 id�� password�� �����ϸ�
				return temp.id; //������ id ��ȯ
			}
		}
		//3. �α��� ������ �Է��� id ��ȯ / ���н� null
		return null;
	}
//		3
	
		//3.���̵� ã�� 
	void ���̵�ã��() {
		System.out.println("--------------���̵� ã��--------------");
		System.out.println("�̸��� �Է����ּ���."); String name = Day08_Bank.scanner.next();
		System.out.println("����ó�� �Է����ּ���."); String phone = Day08_Bank.scanner.next();
		
		for(Member temp :Day08_Bank.members) {
			if (temp != null && temp.name.equals(name) && temp.phone.equals(phone) ) {
				//������ �ƴϸ鼭 �ش� ��ü �� name, phone�� �Է¹��� ���� �����ϸ�
				System.out.println("ȸ������ ���̵� : " + temp.id);
				return; //ã�� ������ id ��ȯ ->����
			}
		}
		//�� ã������ ã�� id ����ϰ� �� ã������ �˸� ���
		System.out.println("��ġ�ϴ� ȸ�������� �����ϴ�.");
	}
	
		//4.��й�ȣ ã��
	void ��й�ȣã��() {
		System.out.println("--------------��й�ȣ ã��--------------");
		System.out.println("���̵��� �Է����ּ���."); String id = Day08_Bank.scanner.next();
		System.out.println("����ó�� �Է����ּ���."); String phone = Day08_Bank.scanner.next();
		
		for(Member temp : Day08_Bank.members) {
			if (temp != null && temp.id.equals(id) && temp.phone.equals(phone) ) {
				//������ �ƴϸ鼭 �ش� ��ü �� name, phone�� �Է¹��� ���� �����ϸ�
				System.out.println("ȸ������ ��й�ȣ : " + temp.password);
				return; //ã�� ������ id ��ȯ ->����
			}
		}
		System.out.println("��ġ�ϴ� ȸ�������� �����ϴ�.");
	}
	
	
}//ce
