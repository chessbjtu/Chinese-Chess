/** 
* @author: л����
* @date��2016��5��21�� ����9:09:42
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

public class Shi extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6554989220838368463L;

	public Shi(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {//�췽
			setImage(new ImageIcon("image/��ʿ.gif"));
		} else {//�ڷ�
			setImage(new ImageIcon("image/��ʿ.gif"));
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean move(Point destination, int[][] current_status) {
		return false;
	}

}
