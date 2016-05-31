/** 
* @author: 谢明霁
* @date：2016年5月21日 下午9:06:51
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

public class Xiang extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8443336074937616571L;

	public Xiang(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {// 红方
			setImage(new ImageIcon("image/红象.gif"));
		} else {// 黑方
			setImage(new ImageIcon("image/黑象.gif"));
		}
	}

	/**
	 * 象的移动：1.沿斜线移动，每次两格。2.中间不能有任何棋子
	 */
	@Override
	public boolean move(Point destination, int[][] current_status) {
		Point start = getCoordinate();
		int index_x = destination.x - 1, index_y = destination.y - 1;
		// 判断四个方向
		if (Math.abs(start.x - destination.x) == 2 && Math.abs(start.y - destination.y) == 2) {
			// 中间的格不能有棋子
			if (current_status[((start.x + destination.x) / 2) - 1][((start.y + destination.y) / 2) - 1] != 0)
				return false;

			// 中间没有棋子且终点有棋子
			else if (current_status[index_x][index_y] != 0) {

				if (isWho()) {// 红方
					if (current_status[index_x][index_y] > 16)// 敌方棋子
						return true;
					else
						return false;
				} else {// 黑方
					if (current_status[index_x][index_y] <= 16)// 敌方棋子
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
