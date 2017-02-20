import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class ServerThread implements Runnable {

	Socket socket;
	Queue<Documents> studentDoc = new LinkedList<Documents>();

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

			int i;
			String str;
			dout.writeUTF("If you're a student type 1 else type 2");
			i = Integer.parseInt(din.readUTF());
			if (i == 1) {
				dout.writeUTF("1. андидатствай за стипенди€ за успех");
				dout.writeUTF("2. андидатствай за специална стипенди€");
				i = Integer.parseInt(din.readUTF());
				dout.writeUTF("Write your name,grade, parent's income and faculty: ");
				str = din.readUTF();
				if (i == 1) {

					scholarship(str);
				} else if (i == 2) {
					specScholarship(str);
				}

			}
			//dout.writeUTF();;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void scholarship(String str) {
		String data = str;
		String[] parts = data.split(" ");
		for (int i = 0; i < parts.length; i++) {
			NormalScholarShip d = new NormalScholarShip(parts[(i * 5) + 1], parts[(i * 5) + 2], parts[(i * 5) + 3],
					parts[(i * 5) + 4]);

			studentDoc.offer(d);
		}

	}

	public void specScholarship(String str) {
		String data = str;
		String[] parts = data.split(" ");
		for (int i = 0; i < parts.length; i++) {
			Special d = new Special(parts[(i * 5) + 1], parts[(i * 5) + 2], parts[(i * 5) + 3], parts[(i * 5) + 4]);

			studentDoc.offer(d);
		}
	}

}
