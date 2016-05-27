/** 
* @author: 谢明霁
* @date：2016年5月23日 下午12:24:36
* @version 1.0 
*/
package chinesechess.model;

import java.net.URL;

import javax.swing.ImageIcon;

public class Jiang extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5004111131337128396L;

	public Jiang(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {// 红方
			setImage(new ImageIcon("image/红将.gif"));
		} else {// 黑方
			setImage(new ImageIcon("image/黑将.gif"));
		}
	}

	/**
	 * 将的移动：1.只能在"九宫"内直线移动,一次只能走一格。2.特殊情况：将和帅在同一条直线上时，可以直接吃掉对方的将/帅
	 */
	@Override
	public boolean move(int x, int y, int[][] current_status) {
		// 排除原地不动的情况
		if (getX() == x && getY() == y) {
			return false;

		}

		// 上、下及将和帅在一条直线的情况
		else if (x == getX()) {
			// 上、下
			if (Math.abs(getY() - y) == 1) {
				// 判断终点处的情况，终点处有以下情况：
				// 1.没有棋子，移动合法，返回true
				// 2.有敌方棋子，移动合法，返回true
				// 3.有己方棋子，移动非法，返回false
				if (current_status[x][y] == 0) {
					return true;
				} else if (isWho()) {// 红方
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
			} else if (current_status[x][y] == 28 && isWho()) {
				for (int temp = getY() + 1; temp < y; temp++) {
					if (current_status[x][temp] != 0)
						return false;
				}
				return true;
			} else if (current_status[x][y] == 5 && !isWho()) {
				for (int temp = getY() - 1; temp > y; temp--) {
					if (current_status[x][temp] != 0)
						return false;
				}
				return true;
			} else {
				return false;
			}
		}

		// 左和右
		else if (Math.abs(getX() - x) == 1 && y == getY()) {
			// 逻辑同上
			if (current_status[x][y] == 0) {
				return true;
			} else if (isWho()) {// 红方
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
		// 非法移动
		else {
			return false;
		}

	}

}
