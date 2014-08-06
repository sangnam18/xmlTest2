import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerTest {

	public static void main(String[] args) throws IOException {

		//포트번호 2014번을 사용하는 서버 소켓
		ServerSocket ss = new ServerSocket(2014);
		System.out.println("서버 : 클라이언트의 접속을 기다립니다.");
		
		//클라이언트의 접속을 기다린다.
		Socket ssoc = ss.accept(); //클라이언트와 연결될때까지 여기서 대기
		System.out.println("서버 : "+ssoc.getInetAddress()+"클라이언트와 "+ssoc.getLocalPort()
				+"포트로 연결이 되었음");
		
		//서버에서 클라이언트의 메세지를 받기위해 스트림을 구성
		BufferedReader sbr = new BufferedReader(new InputStreamReader(ssoc.getInputStream() ));
		//서버에서 클라이언트 입력 받아들입
		
		//서버에서 클라이언트로 받은 내용 출력 시킴
		PrintWriter spw = new PrintWriter(ssoc.getOutputStream(),true);
		String reading = sbr.readLine(); //클라이언트에게서 받은 메세지를 읽어 들임;
		System.out.println("서버(수신) :"+reading);
		
		spw.println(reading); //서버에서 클라이언트로 받은 메세지 보냄
		System.out.println("서버(송신) :"+reading);
		
		spw.close(); //출력 스트림 닫기
		sbr.close(); //입력 스트림 닫기
		ssoc.close(); //소켓 닫기
		ss.close(); //서버 소켓 닫기
	}

}