package chinesechess.logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import chinesechess.model.Chess;
import chinesechess.view.ServerGUI;

/**
 * @author: л����
 * @date��2016��5��6�� ����6:16:31
 * @version 1.0
 */

class ServerThread extends Thread {

	private Socket socket;
	private DataOutputStream out;
	private DataInputStream in;
	private ServerGUI serverGUI;
	private static boolean who = true;
	private static boolean click = false;
	private static Chess chess = null;

	public ServerThread() {
	}

	public ServerThread(Socket s, ServerGUI serverGUI) throws IOException {
		socket = s;
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
		this.serverGUI = serverGUI;
	}

	@Override
	public void run() {
	}
}