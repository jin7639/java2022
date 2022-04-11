package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.login.Login;
import dao.RoomDao;
import dto.Room;
import dto.Roomlive;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Chatting implements Initializable{

	

    @FXML
    private Button btnconnect;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btnsend;

    @FXML
    private TextField txtmsg;

    @FXML
    private TableView<Room> roomtable;

    @FXML
    private TextField txtroomname;

    @FXML
    private Button btnadd;

    @FXML
    private TextArea txtmidlist;

    @FXML
    private Label lblselect;
    //서버 소켓
    public Server server;
    public Room selectroom;
    
    public void show() {
    	ObservableList<Room>roomlist = RoomDao.roomDao.roomlist();
    	
    	TableColumn tc = roomtable.getColumns().get(0);
    	tc.setCellValueFactory( new PropertyValueFactory<>("ronum"));
		
		tc = roomtable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("roname"));
    
		tc = roomtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("mcount"));
    
		roomtable.setItems(roomlist);
		//해당 테이블뷰를 클릭했을 때
		roomtable.setOnMouseClicked(e -> {
			//클릭된 객체 가져오기
			selectroom = roomtable.getSelectionModel().getSelectedItem();
			//레이블에 표시
			lblselect.setText("현재 선택된 방 : " +selectroom.getRoname());
			//접속 버튼 활성화
			btnconnect.setDisable(false);
		});
    }
    
    
    @FXML
    void accadd(ActionEvent event) { //방 개설 버튼을 누르면
    	//1. 컨트롤에 입력된 방 이름 가져오기
    	String roomname = txtroomname.getText();
    	if (roomname.length() < 4) {
			Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("방이름은 5글자 이상");
				alert.showAndWait();
				return;
		}
    	//2. 방 객체
    	Room room = new Room ( 0, roomname, "127.0.0.1", 0);
    	//3. DB처리
    	RoomDao.roomDao.roomadd(room);
    	//4. 해당 방 서버 실행
    	server = new Server();
    	//서버 실행
    	server.serverstart(room.getRoip(), RoomDao.roomDao.getroomnum());
    	txtroomname.setText(""); // 개설 후 방이름 입력창 공백 처리
    	show();
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setHeaderText("방 개설이 완료 되었습니다. 방번호 : " + RoomDao.roomDao.getroomnum());
    	alert.showAndWait();
    }

    @FXML
    void accmsg(ActionEvent event) {
    	String msg = Login.member.getMid() + " : " + txtmsg.getText() + "\n";
    	send(msg);
    	txtmsg.setText("");
    	txtmsg.requestFocus();
    }

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtport;

    @FXML
    void accport(ActionEvent event) {

    }

    @FXML
    void accsend(ActionEvent event) { //전송 버튼을 눌렀을 때
    	String msg = txtmsg.getText()+"\n"; //보낼 메시진
    	send(msg);
    	txtmsg.setText(""); //보내기 후 메시지 입력창 지우기
    	txtmsg.requestFocus(); //보내기 후 메시지 입력창으로 커서 이동
    }
    
    //1. 클라이언트 소켓 선언
    Socket socket;
    
    //2.클라이언트 실행 메소드
    public void clientstart(String ip, int port) {
    	//멀티스레드
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
					socket = new Socket(ip, port); //서버 ip와 port 번호 넣기
					send(Login.member.getMid()+"님 입장했습니다.\n");
					receive(); //접속과 동시에 받기 메소드는 무한 루프
				} catch (Exception e) {System.out.println(e);}
    		};
    	}; // 멀티스레드 구현 끝
    	thread.start(); //멀티스레드 실행
    }
    
    //3.클라이언트 종료 메소드
    public void clientstop() {
    	try {
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    	
    }
    
    //4.서버에게 메시지 보내기 메소드
    public void send(String msg) {
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
					OutputStream outputStream = socket.getOutputStream(); //1. 출력 스트림
					outputStream.write(msg.getBytes());//2. 내보내기
					outputStream.flush(); //3. 스트림 초기화
				} catch (Exception e) {System.out.println(e);}
    		}
    	}; //멀티스레드 구현 끝
    	thread.start(); //멀티스레드 실행
    }
    
    //5.서버에게 메시지 받기 메소드
    public void receive() {
    	while(true) {
    		InputStream inputStream;
			try {
				inputStream = socket.getInputStream();
	    		byte[] bytes = new byte[1000];
	    		inputStream.read(bytes);
	    		String msg = new String(bytes);
	    		txtcontent.appendText(msg); //입력 받은 내용을 채팅창에 추가하기
			} catch (Exception e) {System.out.println(e);} //입력스트림
    	}
    }
    
    public void midshow() { // msg메소드:입력창에서 엔터 쳤을때 // send메소드 : 전송버튼 눌렀을때
    	// 1. 테이블뷰에서 선택된 방 번호의 접속된 회원명단 가져오기 
    	ArrayList<Roomlive> roomlivelist 
			= RoomDao.roomDao.getRoomlivelist( selectroom.getRonum() );
		txtmidlist.setText(""); // 2.명단 초기화
		int i = 1; 
		for( Roomlive temp : roomlivelist ) { // 3.리스트내 모든 객체를 하나씩 명단에 추가
			txtmidlist.appendText( i +"번 "+ temp.getMid() +"\n");
			i++;
		}
    }
    
    @FXML
    void accconnect(ActionEvent event) {
    	if (btnconnect.getText().equals("채팅방 입장")) {
    		
    		clientstart(selectroom.getRoip(), selectroom.getRonum());
    		//클라이언트 실행 메소드
    		txtcontent.appendText("---[채팅방 입장]---\n");
    		btnconnect.setText("채팅방 퇴장");
    		txtmsg.setEditable(true); 		//채팅입력창 수정 금지
    		txtcontent.setDisable(false); 	//채팅창 목록 사용금지
    		btnsend.setDisable(false); 		//전송버튼 사용 금지
    		txtmsg.requestFocus(); 			//채팅입력창으로 포커스[커서]이동
		}else {
			
			clientstop();
			txtcontent.appendText("---[채팅방 퇴장]---\n");
			btnconnect.setText("채팅방 입장");
			txtmsg.setEditable(false); //채팅입력창 수정 금지
			txtcontent.setDisable(true); //채팅창 목록 사용금지
			btnsend.setDisable(true); //전송버튼 사용 금지
		}
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//채팅fxml 열렸을 때 초기값 메소드
			//채팅방 입장 전엔 아래fxid 사용 금지
		txtmsg.setEditable(false); //채팅입력창 수정 금지
		txtcontent.setDisable(true); //채팅창 목록 사용금지
		btnsend.setDisable(true); //전송버튼 사용 금지
		btnconnect.setDisable(true); //입장버튼 사용금지
		txtmidlist.setDisable(true); //방접속회원 목록 사용금지
		
		
	}
}
