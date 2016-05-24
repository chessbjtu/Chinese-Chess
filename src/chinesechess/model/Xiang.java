/** 
* @author: 谢明霁
* @date：2016年5月21日 下午9:06:51
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
		if (who) {// 红方
			URL imgURL = getClass().getResource("chinesechess/resource/r_Xiang.jpg");
			setImage(new ImageIcon(imgURL));
		} else {// 黑方
			URL imgURL = getClass().getResource("chinesechess/resource/b_Xiang.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	/**
	 * 象的移动：1.沿斜线移动，每次两格。2.中间不能有任何棋子
	 */
	@Override
	public boolean move(int x, int y, int[][] current_status) {
		// 分别判断四个方向

		// 左下
		if (Math.abs(getX() - x) == 2 && Math.abs(getY() - y) == 2) {
			// 中间的格不能有棋子
			if (current_status[(getX() + x) / 2][(getY() + y) / 2] != 0)
				return false;

			// 中间没有棋子且终点有棋子
			else if (current_status[x][y] != 0) {

				if (isWho()) {// 红方
					if (current_status[x][y] > 16)// 敌方棋子
						return true;
					else
						return false;
				} else {// 黑方
					if (current_status[x][y] <= 16)// 敌方棋子
						return true;
					else
						return false;
				}
			}

			// 终点没有棋子
			else
				return true;
		} else
			return false;
	}
}
