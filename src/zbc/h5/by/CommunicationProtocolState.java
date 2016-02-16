package zbc.h5.by;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;

public interface CommunicationProtocolState {
	public void send(BufferedOutputStream out);
	
	public void receive(BufferedReader in);

}
