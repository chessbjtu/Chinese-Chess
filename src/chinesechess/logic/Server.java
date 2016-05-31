/** 
* @author: 谢明霁
* @date：2016年5月31日 上午8:56:09
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
			JOptionPane.showMessageDialog(new Frame(), "端口已被占用，创建服务器失败！");
			System.exit(0);
		}
	}
}
