package Day07;

public class Calculator2 {//cs

//	/*
//	 * 1. �ʵ�
//	 * 2.������
//	 * 3.�޼ҵ�
//	 * 		1. ����޼ҵ� 
	 void execute() {//�μ����� ��ȯ����
		 double result = avg(7,10);
		 println("������ : " + result );
	 }
//	 * 		2. ��ո޼ҵ�
	 double avg(int x, int y) {//�μ����� ��ȯ����
		double sum = plus(x,y);
		double result = sum / 2;
		return result;
	 }
//	 * 		3. ���ϱ�޼ҵ�
	 int plus( int x , int y ) {//�μ����� ��ȯ����
		 int result = x+y; return result;
	 }
//	 * 		4. �����¸޼ҵ�
	 void println(String message) { //�μ����� ��ȯ����
		 System.out.println(message);
	 }
//	 */
	
	
	
}//ce
