package Day14;

import java.util.ArrayList;

public class �Խ��� {

	//1. �ʵ�
		private String title;
		private String contents;
		private String writer;
		private int point;
		private �Խ��� �Խ��� = new �Խ���();
		private ArrayList<String> list = new ArrayList<>();
		private �Խ���[] �Խù���� = new �Խ���[100];	
		//�����ϴ� ��� [��ü ������ �ʱⰪ = ó����]
			//1. �������
		public �Խ���() {}
			//2. ����ʵ� ������
		public �Խ���(String title, String contents, String writer, int point, �Խ��� �Խ���, ArrayList<String> list,
				�Խ���[] �Խù����) {
			super();
			this.title = title;
			this.contents = contents;
			this.writer = writer;
			this.point = point;
			this.�Խ��� = �Խ���;
			this.list = list;
			this.�Խù���� = �Խù����;
		}
		
		
		
		

}//ce
