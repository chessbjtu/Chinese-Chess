/** 
* @author: л����
* @date��2016��5��21�� ����9:12:01
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

public class Pao extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4388807141617701084L;

	public Pao(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {// �췽
			setImage(new ImageIcon("image/����.gif"));
		} else {// �ڷ�
			setImage(new ImageIcon("image/����.gif"));
		}
	}

	/**
	 * �ڵ��ƶ��� 1.ֱ���ƶ�������·�ϲ������������� 2. �ڶ����ӽ��й���ʱ������Ҳ��ֱ�ߣ��м�������ֻ�ܸ�һ�����ӣ���Ŀ�����ӱ����ǶԷ�������
	 */
	@Override
	public boolean move(Point destination, int[][] current_status) {
		Point start = getCoordinate();
		int index_x = destination.x - 1, index_y = destination.y - 1;
		// �����ƶ�·�����ϰ�������������
		int j = 0;

		// ������ƶ�����������һ��
		if (start.equals(destination)) {
			return false;
		}
		// ��ֱ�ƶ�
		else if (start.x == destination.x && start.y != destination.y) {
			// �ж�������յ�֮��ĸ��ӣ������ƶ�·�����ϰ���������
			for (int temp = start.y; temp < destination.y; temp++) {
				if (current_status[index_x][temp - 1] != 0) {
					j++;
				}
			}

			// �ڵ�������յ�֮��ĸ���û�����ӣ������յ㣩����ʱ�ƶ�����ͳ�����
			if (j == 0) {
				// ��Ŀ��λ��û������ʱ���ƶ��ɹ�
				if (current_status[index_x][index_y] == 0) {
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
					if (current_status[index_x][index_y] > 16)// �з�����
						return true;
					else
						return false;
				} else if (!isWho()) {// �ڷ�
					if (current_status[index_x][index_y] <= 16)// �з�����
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
		else if (start.x != destination.x && start.y == destination.y) {
			for (int temp = start.x; temp < destination.x; temp++) {
				if (current_status[temp - 1][index_y] != 0) {
					j++;
				}
			}

			if (j == 0) {
				if (current_status[index_x][index_y] == 0) {
					return true;
				} else
					return false;
			} else if (j == 1) {
				if (isWho()) {
					if (current_status[index_x][index_y] > 16)
						return true;
					else
						return false;
				} else if (!isWho()) {
					if (current_status[index_x][index_y] <= 16)
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
