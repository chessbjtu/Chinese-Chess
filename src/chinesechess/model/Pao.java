/** 
* @author: 谢明霁
* @date：2016年5月21日 下午9:12:01
* @version 1.0 
*/
package chinesechess.model;

import java.net.URL;

import javax.swing.ImageIcon;

public class Pao extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4388807141617701084L;

	public Pao(boolean who, ImageIcon image, int x, int y) {
		super(who, null, x, y);
		if (who) {// 红方
			URL imgURL = getClass().getResource("chinesechess/resource/r_Pao.jpg");
			setImage(new ImageIcon(imgURL));
		} else {// 黑方
			URL imgURL = getClass().getResource("chinesechess/resource/b_Pao.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	/**
	 * 炮的移动： 1.直线移动，他的路上不能有其他棋子 2. 炮对棋子进行攻击时，攻击也是直线，中间必须隔且只能隔一个棋子，且目标棋子必须是对方的棋子
	 */
	@Override
	public boolean move(int x, int y, int[][] current_status) {
		// TODO Auto-generated method stub
		// 对炮移动路径中障碍棋子数量计数
		int j = 0;

		// 如果不移动，就再让下一次
		if (getX() == x && getY() == y) {
			return false;
		}
		// 竖直移动
		else if (getX() == x && getY() != y) {
			// 判断起点与终点之间的格子，计算移动路径中障碍棋子数量
			for (int temp = getY(); temp < y; temp++) {
				if (current_status[x][temp] != 0) {
					j++;
				}
			}

			// 炮的起点与终点之间的格子没有棋子（不含终点），此时移动法则和车类似
			if (j == 0) {
				// 当目标位置没有棋子时，移动成功
				if (current_status[x][y] == 0) {
					return true;
				}

				// 其他情况，失败
				else
					return false;
			}

			// 炮的起点与终点之间的格子只有一个棋子（不含终点）
			else if (j == 1) {
				// 当目标位置上有对方棋子时，移动成功
				if (isWho()) {// 红方
					if (current_status[x][y] > 16)// 敌方棋子
						return true;
					else
						return false;
				} else if (!isWho()) {// 黑方
					if (current_status[x][y] <= 16)// 敌方棋子
						return true;
					else
						return false;
				}

				// 其他情况，失败
				else
					return false;
			}

			// 炮的起点与终点之间的格子中有很多棋子（不含终点），此时不能走
			else {
				return false;
			}
		}

		// 水平移动,逻辑同上
		else if (getX() != x && getY() == y) {
			for (int temp = getX(); temp < x; temp++) {
				if (current_status[temp][y] != 0) {
					j++;
				}
			}

			if (j == 0) {
				if (current_status[x][y] == 0) {
					return true;
				} else
					return false;
			} else if (j == 1) {
				if (isWho()) {
					if (current_status[x][y] > 16)
						return true;
					else
						return false;
				} else if (!isWho()) {
					if (current_status[x][y] <= 16)
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
