package zbc.h5.by;

import java.net.ServerSocket;
import java.net.Socket;

public class Program {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(1337);
			while(true) {
				Socket client = serverSocket.accept();
				Thread thread = new Thread(new CommunicationProtocol(client));
				thread.start();
			}
		} catch(Exception ex) {
			System.err.println(ex);
		}

	}

}
