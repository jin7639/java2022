package controller.board;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//url 매핑
//@WebServlet("클래스내로 들어오는 경로 정의");
//@SeverEndpoint("서버소켓 클래스로 들어오는 경로 정의");

@ServerEndpoint("/chatting/{mid}") //{변수명} : url 에 변수 가능
public class Chatting {
	
	//0. 접속자 명단
	public static Map<Session, String> clients = new Hashtable<>(); //동기화[한 명씩 처리]
	
	//1. 소켓 열기
	@OnOpen
	public void onOpen(Session session , @PathParam("mid")String mid ){
		clients.put(session, mid);
		try {
			// 접속된 아이디를 JSON형으로 변환
			JSONArray array = new JSONArray();
			for( Session s : clients.keySet() ) {
				JSONObject object = new JSONObject();
					object.put("type", "2" );
					object.put("mid",clients.get(s));
					array.put(object);
			}
			
			// 전송
			for( Session s : clients.keySet() ) {
				s.getBasicRemote().sendText( array.toString());
			}
		} catch (Exception e) {
			System.out.println("소켓 오류 : " + e);
		}
	}
	//2. 소켓 닫기	
	@OnClose
	public void onClose(Session session) throws IOException {
		clients.remove(session); //해당 세션 제거
		try {
			JSONArray array = new JSONArray();
			for( Session s : clients.keySet() ) {
				JSONObject object = new JSONObject();
					object.put("type", "2" );
					object.put("mid",clients.get(s));
					array.put(object);
			}
			// 전송
			for( Session s : clients.keySet() ) {
				s.getBasicRemote().sendText( array.toString() );
			}
		} catch (JSONException e) {
			System.out.println(e);
		}
	}
	//3. 소켓 메세지 보내기
	@OnMessage
	public void onMessage(String msg, Session session)throws Exception {
		
		for(Session s : clients.keySet()) {
						//map객체.keySet() 모든 키 호출
			s.getBasicRemote().sendText(msg);
		}
	}
}
