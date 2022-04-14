package Day13;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Day13_4 {
	public static void main(String[] args) throws InterruptedException {
	
		//p.544 DecimalFormat Ŭ���� : ���� �����͸� ���ϴ� �������� ǥ��
			//���� ����
				//0 : �ڸ��� [�� �ڸ��� 0���� ä��]
				//# : �ڸ��� [�� �ڸ��� ä���]
		double num = 1234567.89;
		
		DecimalFormat df = new DecimalFormat("0");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("0.0");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("0000000000.000000"); //������ 0���� ä��
		System.out.println(df.format(num));

		df = new DecimalFormat("#");
		System.out.println(df.format(num));

		df = new DecimalFormat("#.#");
		System.out.println(df.format(num));

		df = new DecimalFormat("#############.######");	//���� ä���� X
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#.0");
		System.out.println(df.format(num));

		df = new DecimalFormat("-#.0");
		System.out.println(df.format(num));

		//õ���� ���� ��ǥ
		df = new DecimalFormat("#,##0��");
		System.out.println(df.format(0));

		df = new DecimalFormat("0.0E0"); 	//E: ��������
		System.out.println(df.format(num));

		//df = new DecimalFormat("[��]+#,###; [��]=#,###;");
		System.out.println(df.format(num));
		
		////��ǻ�ʹ� ����� X
		df = new DecimalFormat("#,#%");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("\u00A4 #,###");
		System.out.println(df.format(num));
		
		//p.547
		
		String id = "java";
		String name = "�ſ��";
		String tel = "010-123-5678";
		
		String text = "ȸ�� ID : {0} \nȸ�� �̸� : {1} \nȸ�� ��ȭ : {2}";
		String result1 =MessageFormat.format(text, id, name, tel);
		System.out.println( result1 );
		System.out.println();
		
		String sql = "insert info member value {0}, {1}, {2}";
		Object[] �迭 = {id, name, tel};
		
		//JAVA 7���� �������� Date, ���Ŀ��� �������� ��¥ API �߰���
		LocalDate currDate = LocalDate.now(); //new[X] static �޼ҵ� now()
		System.out.println("���� ��¥ : " + currDate);
		
		LocalTime currTime = LocalTime.now();
		System.out.println("���� �ð�  : " + currTime);
		
		//Date ���糯¥ / �ð� [������ �ȵǰų� �񱳱�� �����]
		//vs
		//LocalDate : ���� ��¥ 	LocalTime : ����ð�
		
		LocalDateTime currDateTime = LocalDateTime.now();
		System.out.println("���� ��¥/�ð� : " + currDateTime);
		
		//*** �ð� ���
		Instant instant1 = Instant.now();
		Thread.sleep(1000); //1�� ��� [�ڵ� �帧 1�ʰ� ����]
		Instant instant2 = Instant.now();
		
		if (instant1.isBefore(instant2)) {
			System.out.println("instant1�� �� ����");
		}else if (instant1.isAfter(instant2)) {
			System.out.println("instaunt2�� �� �ʽ��ϴ�.");
		}else {
			System.out.println("������ �ð��Դϴ�.");
		}
		System.out.println("�ð� �� : " + instant1.until(instant2, ChronoUnit.NANOS));
				//�и��� = 1000/��	����ũ���� = 1000000/��	������ = 1000000000/��
		
	}
}//ce
