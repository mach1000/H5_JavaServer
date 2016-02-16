package zbc.h5.by;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;

public class WaitingNameState extends State{

	
	
	
	public WaitingNameState(CommunicationProtocol protocol) {
		super(protocol);
	}

	public void send(BufferedOutputStream out) {
		send(out, "who are you?\n");
	}

	public void receive(BufferedReader in) {
		String text = read(in);
		getProtocol().setState(getProtocol().getWaitingMethodState());
	}

}
