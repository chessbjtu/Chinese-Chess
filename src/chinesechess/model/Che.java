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
	public Che(boolean who, int x, int y) {
		super(who, null, x, y);
		if (who) {//�췽
			URL imgURL = getClass().getResource("chinesechess/resource/r_Che.jpg");
			setImage(new ImageIcon(imgURL));
		} else {//�ڷ�
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
			for (int temp : current_status[x]) {
				if (current_status[x][temp] == 0) {
					return true;
				}
			}

		} else if (getY() == y) {// �����ƶ�
			for (int temp : current_status[x]) {
				if (current_status[temp][temp] == 0) {
					return true;
				}
			}
		} else {// �Ƿ��ƶ�
			return false;
		}
		return false;
	}

}
