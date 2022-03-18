package Day13;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Day13_2 {//cs
	public static void main(String[] args) {//ms
		
		//p.539
			//Date Ŭ���� (java.util) : �ý��� ��¥/�ð� 
		
		Date date = new Date(); 	//date ��ü����
		System.out.println("���� ��¥/�ð� : " + date);
		System.out.println("��ü���� �޼ҵ� : " + date.toString());
		
		//SimpleDateFormat Ŭ���� : ��¥/�ð� ����(����=�ٹ̱�) ��ȯ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm�� ss��");
		System.out.println("��¥���ĺ��� : " + sdf.format(date));
		
		//p.540
			//calendar Ŭ���� : �ü�� �ð����� ��¥/�ð��� ���� ����
		Calendar now = Calendar.getInstance();	//Ķ���� Ŭ���� �� ��ü ȣ��
			//�̹� Ķ���� Ŭ���� �� ��ü ����! = ������ ��ü ���� X
		System.out.println("���� : "+now.get(Calendar.YEAR));
		System.out.println("�� : "+(now.get(Calendar.MONTH)+1));
		System.out.println("�� : "+now.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("���� : "+ now.get(Calendar.DAY_OF_WEEK));
		
		//����[����] -> �ѱ� ��ȯ
		int week = now.get(Calendar.DAY_OF_WEEK);
		String ���� = null;	//�ѱ� ������ ������ ���� ����� ����
		switch (week) {
		case 1: ���� = "������"; break;
		case 2: ���� = "ȭ����"; break;
		case 3: ���� = "������"; break;
		case 4: ���� = "�����"; break;
		case 5: ���� = "�ݿ���"; break;
		case 6: ���� = "�����"; break;
		case 7: ���� = "�Ͽ���"; break;
		}
		System.out.println("���� : "+����);
		
		//����/����
		System.out.println("����/���� : " + now.get(Calendar.AM_PM));
		int ampm = now.get(Calendar.AM_PM);
		String �������� = null;
		if (ampm == 0) {
			�������� = "����";
		}else {
			�������� = "����";
		}
		System.out.println(��������);
		
		System.out.println(now.get(Calendar.HOUR)+"�� ");
		System.out.println(now.get(Calendar.MINUTE) +"�� ");
		System.out.println(now.get(Calendar.SECOND)+"�� ");
		
		//Zoned
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println(zonedDateTime);
		
		zonedDateTime = zonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println("���� �ð� : " + zonedDateTime);
		
		
		
		
		
		
		
	}//me

}//ce
