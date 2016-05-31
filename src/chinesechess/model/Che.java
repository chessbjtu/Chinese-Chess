/** 
* @author: 谢明霁
* @date：2016年5月21日 下午4:54:24
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
		if (who) {// 红方
			setImage(new ImageIcon("image/红车.gif"));
		} else {// 黑方
			setImage(new ImageIcon("image/黑车.gif"));
		}
	}

	/**
	 * 车的移动策略，首先保证直线移动 其次，移动路径中不能有其他棋子 终点坐标如果为敌方棋子，移动同样合法
	 */
	@Override
	public boolean move(Point destination, int[][] current_status) {
		Point start = getCoordinate();
		int index_x = destination.x - 1, index_y = destination.y - 1;
		// 排除原地不动的情况
		if (start.equals(destination)) {
			return false;

		}
		// 纵向移动
		else if (start.x == destination.x && start.y != destination.y) {

			// 判断起点与终点之间的格子，如果如果有棋子，则返回false
			for (int temp = start.y; temp < destination.y; temp++) {
				if (current_status[index_x][temp-1] != 0) {
					return false;
				}
			}

			// 如果起点与终点之间的格子没有棋子，则判断终点处的情况，终点处有以下情况：
			// 1.没有棋子，移动合法，返回true
			// 2.有敌方棋子，移动合法，返回true
			// 3.有己方棋子，移动非法，返回false
			if (current_status[index_x][index_y] == 0) {
				return true;
			} else if (isWho()) {// 红方
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
		// 横向移动
		else if (start.x != destination.x && start.y == destination.y) {
			// 这部分逻辑同纵向移动
			for (int temp = start.x; temp < destination.x; temp++) {
				if (current_status[temp-1][index_y] == 0) {
					return true;
				}
			}
			if (current_status[index_x][index_y] == 0) {
				return true;
			} else if (isWho()) {// 红方
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
		// 非法移动
		else {
			return false;
		}
	}

}
