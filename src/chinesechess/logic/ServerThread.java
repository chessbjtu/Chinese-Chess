package chinesechess.logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import chinesechess.model.Chess;
import chinesechess.view.ServerGUI;

/**
 * @author: 谢明霁
 * @date：2016年5月6日 下午6:16:31
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