package Day09;

/**
 * @author 504
 *
 */
public class Cellphone {
//	1.�ʵ�
	String model;
	String color;
	//2.������
	//3.�޼ҵ� [void : ��ȯŸ�Ծ��� (return ��������)]
	void powerOn()	{System.out.println("������ ŵ�ϴ�.");}
	//��ȯ ���� �޼ҵ��(�μ�X) {�����ڵ�}
	void powerOff() {System.out.println("������ ���ϴ�.");}
	void bell() {System.out.println("���� �︳�ϴ�.");}
	//��ȯX �μ�O
	void sendVoice(String message) { System.out.println("����: " + message);}
	void recieveVoice(String message) { System.out.println("����: " + message);}
	
	
	
}
