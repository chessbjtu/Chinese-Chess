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

	public Xiang(boolean who, ImageIcon image, int x, int y) {
		super(who, null, x, y);
		if (who) {// �췽
			URL imgURL = getClass().getResource("chinesechess/resource/r_Xiang.jpg");
			setImage(new ImageIcon(imgURL));
		} else {// �ڷ�
			URL imgURL = getClass().getResource("chinesechess/resource/b_Xiang.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	/**
	 * ����ƶ���1.��б���ƶ���ÿ������2.�м䲻�����κ�����
	 */
	@Override
	public boolean move(int x, int y, int[][] current_status) {
		// �ֱ��ж��ĸ�����

		// ����
		if (x == (getX() - 2) && y == (getY() - 2)) {
			// �м�ĸ���������
			if (current_status[getX() - 1][getY() - 1] != 0)
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
		}

		// ����
		else if (x == (getX() + 2) && y == (getY() - 2)) {
			// �߼�ͬ��
			if (current_status[getX() + 1][getY() - 1] != 0)
				return false;
			else if (current_status[x][y] != 0) {

				if (isWho()) {
					if (current_status[x][y] > 16)
						return true;
					else
						return false;
				} else {
					if (current_status[x][y] <= 16)
						return true;
					else
						return false;
				}
			} else
				return true;
		}

		// ����
		else if (x == (getX() + 2) && y == (getY() + 2)) {
			// �߼�ͬ��
			if (current_status[getX() + 1][getY() + 1] != 0)
				return false;
			else if (current_status[x][y] != 0) {

				if (isWho()) {
					if (current_status[x][y] > 16)
						return true;
					else
						return false;
				} else {
					if (current_status[x][y] <= 16)
						return true;
					else
						return false;
				}
			} else
				return true;
		}

		// ����
		else if (x == (getX() - 2) && y == (getY() + 2)) {
			// �߼�ͬ��
			if (current_status[getX() - 1][getY() - 1] != 0)
				return false;
			else if (current_status[x][y] != 0) {

				if (isWho()) {
					if (current_status[x][y] > 16)
						return true;
					else
						return false;
				} else {
					if (current_status[x][y] <= 16)
						return true;
					else
						return false;
				}
			} else
				return true;
		}
		return false;
	}

}
