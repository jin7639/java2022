package Day14;

public class Sound extends Thread{

	static boolean stop = true;	//���� ���� [true ���� false ����]
	
	public void soundstop (boolean stop) {
		this.stop = stop;
		if (this.stop) {
			System.out.println("�Ҹ� ��� ����~~~");
		}else {
			System.out.println("�Ҹ� ����!!");
		}
	}
	
	
	@Override
	public void run() {
	
		while(stop) { // stop ������ true�̸� ���ѷ��� [ �������� : stop ������ false ]
			System.out.println("�Ҹ� �����~~~~~");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	
}
