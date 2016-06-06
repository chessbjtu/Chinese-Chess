/** 
* @author: л����
* @date��2016��5��21�� ����9:04:52
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

public class Ma extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6306713258821114291L;

	public Ma(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {// �췽
			setImage(new ImageIcon("image/����.gif"));
		} else {// �ڷ�s
			setImage(new ImageIcon("image/����.gif"));
		}
	}

	@Override
	public boolean move(Point destination, int[][] current_status) {
		Point start = getCoordinate();
		int index_x = destination.x - 1, index_y = destination.y - 1;
		if (Math.abs(destination.y - start.y) == 2 && Math.abs(destination.x - start.x) == 1) {// �ݷ������ƶ�����
			if (current_status[start.x-1][((destination.y + start.y) / 2)-1] != 0) {// �ж��Ƿ�����
				if (isWho()) {// �췽
					if (current_status[index_x][index_y] <= 16) {
						return true;
					} else {
						return false;
					}
				} else {// �ڷ�
					if (current_status[index_x][index_y] > 16) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				return true;
			}
		} else if (Math.abs(destination.y - start.y) == 1 && Math.abs(destination.x - start.x) == 2) {// �᷽�����ƶ�����
			if (current_status[((destination.x + start.x) / 2)-1][start.y-1] != 0) {// �ж��Ƿ�����
				if (isWho()) {// �췽
					if (current_status[index_x][index_y] <= 16) {
						return true;
					} else {
						return false;
					}
				} else {// �ڷ�
					if (current_status[index_x][index_y] > 16) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

}
