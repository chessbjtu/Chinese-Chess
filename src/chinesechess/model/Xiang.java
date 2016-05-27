/** 
* @author: л����
* @date��2016��5��21�� ����9:06:51
* @version 1.0 
*/
package chinesechess.model;

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
	public boolean move(int x, int y, int[][] current_status) {
		// �ֱ��ж��ĸ�����

		// ����
		if (Math.abs(getX() - x) == 2 && Math.abs(getY() - y) == 2) {
			// �м�ĸ���������
			if (current_status[(getX() + x) / 2][(getY() + y) / 2] != 0)
				return false;

			// �м�û���������յ�������
			else if (current_status[x][y] != 0) {

				if (isWho()) {// �췽
					if (current_status[x][y] > 16)// �з�����
						return true;
					else
						return false;
				} else {// �ڷ�
					if (current_status[x][y] <= 16)// �з�����
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
