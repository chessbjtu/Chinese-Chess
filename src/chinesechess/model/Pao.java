/** 
* @author: л����
* @date��2016��5��21�� ����9:12:01
* @version 1.0 
*/
package chinesechess.model;

import java.net.URL;

import javax.swing.ImageIcon;

public class Pao extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4388807141617701084L;

	public Pao(boolean who, ImageIcon image, int x, int y) {
		super(who, null, x, y);
		if (who) {// �췽
			URL imgURL = getClass().getResource("chinesechess/resource/r_Pao.jpg");
			setImage(new ImageIcon(imgURL));
		} else {// �ڷ�
			URL imgURL = getClass().getResource("chinesechess/resource/b_Pao.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	/**
	 * �ڵ��ƶ��� 1.ֱ���ƶ�������·�ϲ������������� 2. �ڶ����ӽ��й���ʱ������Ҳ��ֱ�ߣ��м�������ֻ�ܸ�һ�����ӣ���Ŀ�����ӱ����ǶԷ�������
	 */
	@Override
	public boolean move(int x, int y, int[][] current_status) {
		// TODO Auto-generated method stub
		// �����ƶ�·�����ϰ�������������
		int j = 0;

		// ������ƶ�����������һ��
		if (getX() == x && getY() == y) {
			return false;
		}
		// ��ֱ�ƶ�
		else if (getX() == x && getY() != y) {
			// �ж�������յ�֮��ĸ��ӣ������ƶ�·�����ϰ���������
			for (int temp = getY(); temp < y; temp++) {
				if (current_status[x][temp] != 0) {
					j++;
				}
			}

			// �ڵ�������յ�֮��ĸ���û�����ӣ������յ㣩����ʱ�ƶ�����ͳ�����
			if (j == 0) {
				// ��Ŀ��λ��û������ʱ���ƶ��ɹ�
				if (current_status[x][y] == 0) {
					return true;
				}

				// ���������ʧ��
				else
					return false;
			}

			// �ڵ�������յ�֮��ĸ���ֻ��һ�����ӣ������յ㣩
			else if (j == 1) {
				// ��Ŀ��λ�����жԷ�����ʱ���ƶ��ɹ�
				if (isWho()) {// �췽
					if (current_status[x][y] > 16)// �з�����
						return true;
					else
						return false;
				} else if (!isWho()) {// �ڷ�
					if (current_status[x][y] <= 16)// �з�����
						return true;
					else
						return false;
				}

				// ���������ʧ��
				else
					return false;
			}

			// �ڵ�������յ�֮��ĸ������кܶ����ӣ������յ㣩����ʱ������
			else {
				return false;
			}
		}

		// ˮƽ�ƶ�,�߼�ͬ��
		else if (getX() != x && getY() == y) {
			for (int temp = getX(); temp < x; temp++) {
				if (current_status[temp][y] != 0) {
					j++;
				}
			}

			if (j == 0) {
				if (current_status[x][y] == 0) {
					return true;
				} else
					return false;
			} else if (j == 1) {
				if (isWho()) {
					if (current_status[x][y] > 16)
						return true;
					else
						return false;
				} else if (!isWho()) {
					if (current_status[x][y] <= 16)
						return true;
					else
						return false;
				} else
					return false;
			} else {
				return false;
			}
		} else
			return false;
	}

}
