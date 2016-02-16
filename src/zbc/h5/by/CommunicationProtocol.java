package zbc.h5.by;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CommunicationProtocol implements Runnable, CommunicationProtocolState{

	private WaitingNameState waitNameState = new WaitingNameState(this);
	CommunicationProtocolState state = getWaitNameState();
	private WaitingMethodsState waitingMethodState = new WaitingMethodsState(this);
	Socket client;
	public CommunicationProtocol(Socket client) {
		this.client = client;
	}
	@Override
	public void run() {
		while(true) {
			try {
				send(new BufferedOutputStream(client.getOutputStream()));
				receive(new BufferedReader(new InputStreamReader(client.getInputStream())));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void send(BufferedOutputStream output) {
		state.send(output);
	}

	public void receive(BufferedReader input) {
		state.receive(input);
	}
	
	CommunicationProtocolState getState() {
		return state;
	}
	void setState(CommunicationProtocolState state) {
		this.state = state;
	}
	WaitingNameState getWaitNameState() {
		return waitNameState;
	}
	WaitingMethodsState getWaitingMethodState() {
		return waitingMethodState;
	}

}
