/** 
* @author: л����
* @date��2016��5��21�� ����4:54:24
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Che extends Chess {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3008215849044329804L;

	public Che(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {// �췽
			setImage(new ImageIcon("image/�쳵.gif"));
		} else {// �ڷ�
			setImage(new ImageIcon("image/�ڳ�.gif"));
		}
	}

	/**
	 * �����ƶ����ԣ����ȱ�ֱ֤���ƶ� ��Σ��ƶ�·���в������������� �յ��������Ϊ�з����ӣ��ƶ�ͬ���Ϸ�
	 */
	@Override
	public boolean move(Point destination, int[][] current_status) {
		Point start = getCoordinate();
		int index_x = destination.x - 1, index_y = destination.y - 1;
		// �ų�ԭ�ز��������
		if (start.equals(destination)) {
			return false;

		}
		// �����ƶ�
		else if (start.x == destination.x && start.y != destination.y) {

			// �ж�������յ�֮��ĸ��ӣ������������ӣ��򷵻�false
			for (int temp = start.y; temp < destination.y; temp++) {
				if (current_status[index_x][temp-1] != 0) {
					return false;
				}
			}

			// ���������յ�֮��ĸ���û�����ӣ����ж��յ㴦��������յ㴦�����������
			// 1.û�����ӣ��ƶ��Ϸ�������true
			// 2.�ез����ӣ��ƶ��Ϸ�������true
			// 3.�м������ӣ��ƶ��Ƿ�������false
			if (current_status[index_x][index_y] == 0) {
				return true;
			} else if (isWho()) {// �췽
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
		// �����ƶ�
		else if (start.x != destination.x && start.y == destination.y) {
			// �ⲿ���߼�ͬ�����ƶ�
			for (int temp = start.x; temp < destination.x; temp++) {
				if (current_status[temp-1][index_y] == 0) {
					return true;
				}
			}
			if (current_status[index_x][index_y] == 0) {
				return true;
			} else if (isWho()) {// �췽
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
		// �Ƿ��ƶ�
		else {
			return false;
		}
	}

}
