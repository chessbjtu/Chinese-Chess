/** 
* @author: л����
* @date��2016��5��23�� ����12:24:36
* @version 1.0 
*/
package chinesechess.model;

import java.net.URL;

import javax.swing.ImageIcon;

public class Jiang extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5004111131337128396L;

	public Jiang(boolean who, ImageIcon image, int x, int y) {
		super(who, null, x, y);
		if (who) {// �췽
			URL imgURL = getClass().getResource("chinesechess/resource/r_Jiang.jpg");
			setImage(new ImageIcon(imgURL));
		} else {// �ڷ�
			URL imgURL = getClass().getResource("chinesechess/resource/b_Jiang.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	/**
	 * �����ƶ���1.ֻ����"�Ź�"��ֱ���ƶ�,һ��ֻ����һ��2.�������������˧��ͬһ��ֱ����ʱ������ֱ�ӳԵ��Է��Ľ�/˧
	 */
	@Override
	public boolean move(int x, int y, int[][] current_status) {
		// �ų�ԭ�ز��������
		if (getX() == x && getY() == y) {
			return false;

		}

		// �ϡ��¼�����˧��һ��ֱ�ߵ����
		else if (x == getX()) {
			// ��
			if (y == getY() + 1) {
				// �ж��յ㴦��������յ㴦�����������
				// 1.û�����ӣ��ƶ��Ϸ�������true
				// 2.�ез����ӣ��ƶ��Ϸ�������true
				// 3.�м������ӣ��ƶ��Ƿ�������false
				if (current_status[x][y] == 0) {
					return true;
				} else if (isWho()) {// �췽
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

			// ��
			else if (y == getY() - 1) {
				if (current_status[x][y] == 0) {
					return true;
				} else if (isWho()) {// �췽
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
			} else if (current_status[x][y] == 28 && isWho()) {
				return true;
			} else if (current_status[x][y] == 5 && !isWho()) {
				return true;
			} else {
				return false;
			}
		}

		// ��
		else if (x == getX() - 1 && y == getY()) {
			// �߼�ͬ��
			if (current_status[x][y] == 0) {
				return true;
			} else if (isWho()) {// �췽
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
		// ��
		else if (x == getX() + 1 && y == getY()) {
			// �߼�ͬ��
			if (current_status[x][y] == 0) {
				return true;
			} else if (isWho()) {// �췽
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
		// �Ƿ��ƶ�
		else {
			return false;
		}

	}

}
