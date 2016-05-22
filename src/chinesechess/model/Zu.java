/** 
* @author: л����
* @date��2016��5��21�� ����9:12:52
* @version 1.0 
*/
package chinesechess.model;

import java.net.URL;

import javax.swing.ImageIcon;

public class Zu extends Chess {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6198652456049799687L;

	public Zu(boolean who, ImageIcon image, int x, int y) {
		super(who, null, x, y);
		if (who) {// �췽
			URL imgURL = getClass().getResource("chinesechess/resource/r_Xiang.jpg");
			setImage(new ImageIcon(imgURL));
		} else {// �ڷ�
			URL imgURL = getClass().getResource("chinesechess/resource/b_Xiang.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	@Override
	public boolean move(int x, int y, int[][] current_status) {
		// TODO Auto-generated method stub
		return false;
	}

}
