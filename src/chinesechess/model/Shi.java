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
		if (who) {// �췽
			setImage(new ImageIcon("image/��ʿ.gif"));
		} else {// �ڷ�
			setImage(new ImageIcon("image/��ʿ.gif"));
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean move(Point destination, int[][] current_status) {
		Point start = getCoordinate();
		int index_x = destination.x - 1, index_y = destination.y - 1;
		if (Math.abs(destination.y - start.y) == 1 && Math.abs(destination.x - start.x) == 1) {
			if (isWho()) {// �췽
				if (current_status[index_x][index_y] <= 16) {
					return true;
				} else {
					return false;
				}
			} else {// �ڷ�
				if (current_status[index_x][index_y] > 16 || current_status[index_x][index_y] == 0) {
					return true;
				} else {
					return false;
				}
			}
		} else
			return false;
	}

}
