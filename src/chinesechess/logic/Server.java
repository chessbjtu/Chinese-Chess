/** 
* @author: л����
* @date��2016��5��31�� ����8:56:09
* @version 1.0 
*/
package chinesechess.logic;

import java.awt.Frame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import chinesechess.view.ServerGUI;

public class Server {
	public ServerSocket socket;
	private Socket connectionToClient;

	public Server(ServerGUI serverGUI) {
		try {
			socket = new ServerSocket(8500);
			while (true) {
				connectionToClient = socket.accept();
				if (connectionToClient != null)
					new ServerThread(connectionToClient, serverGUI).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new Frame(), "�˿��ѱ�ռ�ã�����������ʧ�ܣ�");
			System.exit(0);
		}
	}
}
