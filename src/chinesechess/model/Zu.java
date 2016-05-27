/** 
* @author: 谢明霁
* @date：2016年5月21日 下午9:12:52
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

	public Zu(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {// 红方
			setImage(new ImageIcon("image/红卒.gif"));
		} else {// 黑方
			setImage(new ImageIcon("image/黑卒.gif"));
		}
	}

	@Override
	public boolean move(int x, int y, int[][] current_status) {
		if (isWho()) {// 红方
			if (getY() < 5 && y == getY() + 1 && x == getX()) {// 过河前只能前进
				if (current_status[x][y] > 0 && current_status[x][y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else if (getY() >= 5 && y == getY() + 1 && x == getX()) {// 过河后向前进
				if (current_status[x][y] > 0 && current_status[x][y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else if (getY() >= 5 && Math.abs(x - getX()) == 1 && y == getY()) {// 过河后向左右移动
				if (current_status[x][y] > 0 && current_status[x][y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {// 黑方
			if (getY() >= 5 && y == getY() - 1 && x == getX()) {// 过河前只能前进
				if (current_status[x][y] > 0 && current_status[x][y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else if (getY() < 5 && y == getY() - 1 && x == getX()) {// 过河后向前进
				if (current_status[x][y] > 0 && current_status[x][y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else if (getY() < 5 && Math.abs(x - getX()) == 1 && y == getY()) {// 过河后向左右移动
				if (current_status[x][y] > 0 && current_status[x][y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else {
				return false;
			}
		}
	}

}
