/** 
* @author: л����
* @date��2016��5��21�� ����9:04:52
* @version 1.0 
*/
package chinesechess.model;

import java.net.URL;

import javax.swing.ImageIcon;

public class Ma extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6306713258821114291L;

	public Ma(boolean who, ImageIcon image, int x, int y) {
		super(who, null, x, y);
		if (who) {// �췽
			URL imgURL = getClass().getResource("chinesechess/resource/r_Ma.jpg");
			setImage(new ImageIcon(imgURL));
		} else {// �ڷ�
			URL imgURL = getClass().getResource("chinesechess/resource/b_Ma.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	@Override
	public boolean move(int x, int y, int[][] current_status) {
		if (Math.abs(y - getY()) == 2 && Math.abs(x - getX()) == 1) {// �ݷ������ƶ�����
			if (current_status[getX()][(y + getY()) / 2] == 0) {// �ж��Ƿ�����
				if (isWho()) {// �췽
					if (current_status[x][y] > 16) {
						return true;
					} else {
						return false;
					}
				} else {// �ڷ�
					if (current_status[x][y] <= 16) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		} else if (Math.abs(y - getY()) == 1 && Math.abs(x - getX()) == 2) {// �᷽�����ƶ�����
			if (current_status[(x + getX()) / 2][getY()] == 0) {// �ж��Ƿ�����
				if (isWho()) {// �췽
					if (current_status[x][y] > 16) {
						return true;
					} else {
						return false;
					}
				} else {// �ڷ�
					if (current_status[x][y] <= 16) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
