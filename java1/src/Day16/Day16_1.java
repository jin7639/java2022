package Day16;

public class Day16_1 {

public static void main(String[] args) {
	
	//���׸�
	
	//p.656
	
	//1.Bow ��ü ����
	Box box = new Box();
	//2.��ü�� �޼ҵ� ȣ�� [�μ� : String] : Object ����
	box.set("ȫ�浿");	//�ڽ� ---->�θ� O
	//3.��ü�� �޼ҵ� ȣ�� [��ȯ : Object ]
	String name = box.get(); 	//�θ� ----->�ڽ� X
	
		//�ڽİ�ü -> �θ�ü [�ڵ�����ȯ]
		//�θ�ü -> �ڽİ�ü [�ڵ�X ����O]
	//4.
	box.set(new Apple()); //[ �μ� : Apple ]
	Apple apple = box.get();
	
}	
	
	
}//ce
