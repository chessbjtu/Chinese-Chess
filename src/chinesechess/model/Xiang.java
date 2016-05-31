/** 
* @author: л����
* @date��2016��5��21�� ����9:06:51
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

public class Xiang extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8443336074937616571L;

	public Xiang(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {// �췽
			setImage(new ImageIcon("image/����.gif"));
		} else {// �ڷ�
			setImage(new ImageIcon("image/����.gif"));
		}
	}

	/**
	 * ����ƶ���1.��б���ƶ���ÿ������2.�м䲻�����κ�����
	 */
	@Override
	public boolean move(Point destination, int[][] current_status) {
		Point start = getCoordinate();
		int index_x = destination.x - 1, index_y = destination.y - 1;
		// �ж��ĸ�����
		if (Math.abs(start.x - destination.x) == 2 && Math.abs(start.y - destination.y) == 2) {
			// �м�ĸ���������
			if (current_status[((start.x + destination.x) / 2) - 1][((start.y + destination.y) / 2) - 1] != 0)
				return false;

			// �м�û���������յ�������
			else if (current_status[index_x][index_y] != 0) {

				if (isWho()) {// �췽
					if (current_status[index_x][index_y] > 16)// �з�����
						return true;
					else
						return false;
				} else {// �ڷ�
					if (current_status[index_x][index_y] <= 16)// �з�����
						return true;
					else
						return false;
				}
			}

			// �յ�û������
			else
				return true;
		} else
			return false;
	}
}
