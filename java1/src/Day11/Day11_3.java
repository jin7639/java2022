package Day11;

public class Day11_3 {

	//422 ���� ������
		//���� : ��� �޼ҵ忡�� try {} catch(){} ���� �ڵ� ������ -> �� ������ ���� �̵�
	
	public static void main(String[] args) {
		try {findclass();} 
		catch (Exception e) {}
		
		try {
			withdraw(30000);
		} catch (Exception e) {
			System.out.println( e );
		}
		
	}
//	1.try~catch
//	public static void findclass() {
//		try {//���ܰ� �߻��� �� ���� �ڵ� (���࿹��) Ȥ�� �Ϲݿ���[������]
//			Class clazz = Class.forName("java.lang.String2");
//		}catch (Exception e) {//���ܰ� �߻��ϸ� ����Ǵ� �ڵ�
//				//��� ���� ���尡��
//			System.out.println(e);
//		}
//	}
	
//	2.���� ������ [�޼ҵ��() throws ���� Ŭ������]
	public static void findclass() throws Exception{
		Class clazz = Class.forName("java.lang.String2");
		
	}
	
	
	//444~445 : ���� �����
	public static void withdraw (int money) throws Exception{
		if (20000 < money) {
			throw new Exception("�ܰ����");
		}
	}
	
	
	
}
