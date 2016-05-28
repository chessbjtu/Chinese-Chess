/** 
* @author: л����
* @date��2016��5��23�� ����12:24:36
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

public class Jiang extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5004111131337128396L;

	public Jiang(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {// �췽
			setImage(new ImageIcon("image/�콫.gif"));
		} else {// �ڷ�
			setImage(new ImageIcon("image/�ڽ�.gif"));
		}
	}

	/**
	 * �����ƶ���1.ֻ����"�Ź�"��ֱ���ƶ�,һ��ֻ����һ��2.�������������˧��ͬһ��ֱ����ʱ������ֱ�ӳԵ��Է��Ľ�/˧
	 */
	@Override
	public boolean move(Point destination, int[][] current_status) {
		Point start = getCoordinate();
		int index_x = destination.x - 1, index_y = destination.y - 1;
		// �ų�ԭ�ز��������
		if (start.equals(destination)) {
			return false;

		}

		// �ϡ��¼�����˧��һ��ֱ�ߵ����
		else if (destination.x == start.x) {
			// �ϡ���
			if (Math.abs(start.y - destination.y) == 1) {
				// �ж��յ㴦��������յ㴦�����������
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
			} else if (current_status[index_x][index_y] == 28 && isWho()) {
				for (int temp = getY() + 1; temp < destination.y; temp++) {
					if (current_status[index_x][temp] != 0)
						return false;
				}
				return true;
			} else if (current_status[index_x][destination.y] == 5 && !isWho()) {
				for (int temp = getY() - 1; temp > destination.y; temp--) {
					if (current_status[index_x][temp] != 0)
						return false;
				}
				return true;
			} else {
				return false;
			}
		}

		// �����
		else if (Math.abs(start.x - destination.x) == 1 && destination.y == start.y) {
			// �߼�ͬ��
			if (current_status[index_x][destination.y] == 0) {
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
