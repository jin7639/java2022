package Day07;

public class Day07_2 {//cs
	
	public static void main(String[] args) {//ms
		
		//p.223~224 : ���ϰ��� ���� �޼ҵ�
		
		//1.��ü����[�������=�⺻������]
		Car mycar = new Car()	;
		//2.�޼ҵ� ȣ�� [�μ�1�� = 5]
		mycar.setGas(5);
		
		//3.�޼ҵ� ȣ��
			if(mycar.isLeftGas() ) {
				System.out.println("����մϴ�.");
				mycar.run();
			}
		//5.�޼ҵ� ȣ��
			if (mycar.isLeftGas()) {
				System.out.println("��������");
			}else {
				System.out.println("��������");
			}
		
	}//me

}//ce
