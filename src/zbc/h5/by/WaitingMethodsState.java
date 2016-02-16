package zbc.h5.by;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;

public class WaitingMethodsState extends State{

	public WaitingMethodsState(CommunicationProtocol protocol) {
		super(protocol);
	}

	@Override
	public void send(BufferedOutputStream out) {
		send(out, "What methods?\n");
	}

	@Override
	public void receive(BufferedReader in) {
		// TODO Auto-generated method stub
		
	}

}
