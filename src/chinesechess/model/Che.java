/** 
* @author: л����
* @date��2016��5��21�� ����4:54:24
* @version 1.0 
*/
package chinesechess.model;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Che extends Chess {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3008215849044329804L;

	public Che(boolean who, int x, int y) {
		super(who, null, x, y);
		if (who) {// �췽
			URL imgURL = getClass().getResource("chinesechess/resource/r_Che.jpg");
			setImage(new ImageIcon(imgURL));
		} else {// �ڷ�
			URL imgURL = getClass().getResource("chinesechess/resource/b_Che.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	/**
	 * �����ƶ����ԣ����ȱ�ֱ֤���ƶ� ��Σ��ƶ�·���в������������� �յ��������Ϊ�з����ӣ��ƶ�ͬ���Ϸ�
	 */
	@Override
	public boolean move(int x, int y, int[][] current_status) {
		if (getX() == x) {// �����ƶ�

			// �ж�������յ�֮��ĸ��ӣ������������ӣ��򷵻�false
			for (int temp = getY(); temp < y; temp++) {
				if (current_status[x][temp] != 0) {
					return false;
				}
			}

			// ���������յ�֮��ĸ���û�����ӣ����ж��յ㴦��������յ㴦�����������
			// 1.û�����ӣ��ƶ��Ϸ�������true
			// 2.�ез����ӣ��ƶ��Ϸ�������true
			// 3.�м������ӣ��ƶ��Ƿ�������false
			if (current_status[x][y] == 0) {
				return true;
			} else if (current_status[x][y] > 15) {
				return true;
			} else {
				return false;
			}

		} else if (getY() == y) {// �����ƶ�

			// �ⲿ���߼�ͬ�����ƶ�
			for (int temp = getX(); temp < x; temp++) {
				if (current_status[temp][y] == 0) {
					return true;
				}
			}

			if (current_status[x][y] == 0) {
				return true;
			} else if (current_status[x][y] > 15) {
				return true;
			} else {
				return false;
			}
		} else {// �Ƿ��ƶ�
			return false;
		}
	}

}
