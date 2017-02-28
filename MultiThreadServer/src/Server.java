import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
            Runnable thread=new ServerThread(s);
			
			new Thread(thread).start();
			ss.close(); 
		} catch (Exception e) {
			System.out.println(e);
		}
	} 	
}
