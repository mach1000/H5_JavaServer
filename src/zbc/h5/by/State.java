package zbc.h5.by;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;

public abstract class State implements CommunicationProtocolState {
	
	CommunicationProtocol localProtocol;
	
	public State(CommunicationProtocol protocol) {
		this.localProtocol = protocol;
	}
	
	protected CommunicationProtocol getProtocol() {
		return localProtocol;
	}
	
	public void send(BufferedOutputStream out, String message) {
		try {
			out.flush();
			out.write(message.getBytes());
			out.flush();
			System.out.println("get into send");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String read(BufferedReader in) {
		String line = null;
        try {
			while((line = in.readLine()) != null) {
				System.out.println(line);
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return line;
	}
}
