/** 
* @author: л����
* @date��2016��5��21�� ����9:04:52
* @version 1.0 
*/
package chinesechess.model;

import java.net.URL;

import javax.swing.ImageIcon;

public class Ma extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6306713258821114291L;

	public Ma(boolean who, ImageIcon image, int x, int y) {
		super(who, null, x, y);
		if (who) {//�췽
			URL imgURL = getClass().getResource("chinesechess/resource/r_Ma.jpg");
			setImage(new ImageIcon(imgURL));
		} else {//�ڷ�
			URL imgURL = getClass().getResource("chinesechess/resource/b_Ma.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	@Override
	public boolean move(int x, int y, int[][] current_status) {
		// TODO Auto-generated method stub
		return false;
	}

}
