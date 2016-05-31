/** 
* @author: л����
* @date��2016��5��21�� ����9:12:52
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

public class Zu extends Chess {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6198652456049799687L;

	public Zu(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {// �췽
			setImage(new ImageIcon("image/����.gif"));
		} else {// �ڷ�
			setImage(new ImageIcon("image/����.gif"));
		}
	}

	@Override
	public boolean move(Point destination, int[][] current_status) {
		Point start = getCoordinate();
		int index_x = destination.x - 1, index_y = destination.y - 1;
		if (isWho()) {// �췽
			if (start.y < 5 && destination.y == start.y + 1 && destination.x == getX()) {// ����ǰֻ��ǰ��
				if (current_status[index_x][index_y] > 0 && current_status[index_x][index_y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else if (start.y >= 5 && destination.y == start.y + 1 && destination.x == getX()) {// ���Ӻ���ǰ��
				if (current_status[index_x][index_y] > 0 && current_status[index_x][index_y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else if (start.y >= 5 && Math.abs(destination.x - getX()) == 1 && destination.y == start.y) {// ���Ӻ��������ƶ�
				if (current_status[index_x][index_y] > 0 && current_status[index_x][index_y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {// �ڷ�
			if (start.y >= 5 && destination.y == start.y - 1 && destination.x == getX()) {// ����ǰֻ��ǰ��
				if (current_status[index_x][index_y] > 0 && current_status[index_x][index_y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else if (start.y < 5 && destination.y == start.y - 1 && destination.x == getX()) {// ���Ӻ���ǰ��
				if (current_status[index_x][index_y] > 0 && current_status[index_x][index_y] <= 16) {
					return false;
				} else {
					return true;
				}
			} else if (start.y < 5 && Math.abs(destination.x - getX()) == 1 && destination.y == start.y) {// ���Ӻ��������ƶ�
				if (current_status[index_x][index_y] > 0 && current_status[index_x][index_y] <= 16) {
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
