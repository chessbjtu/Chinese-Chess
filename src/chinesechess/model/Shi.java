/** 
* @author: 谢明霁
* @date：2016年5月21日 下午9:09:42
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

public class Shi extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6554989220838368463L;

	public Shi(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {// 红方
			setImage(new ImageIcon("image/红士.gif"));
		} else {// 黑方
			setImage(new ImageIcon("image/黑士.gif"));
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean move(Point destination, int[][] current_status) {
		Point start = getCoordinate();
		int index_x = destination.x - 1, index_y = destination.y - 1;
		if (Math.abs(destination.y - start.y) == 1 && Math.abs(destination.x - start.x) == 1) {
			if (isWho()) {// 红方
				if (current_status[index_x][index_y] <= 16) {
					return true;
				} else {
					return false;
				}
			} else {// 黑方
				if (current_status[index_x][index_y] > 16 || current_status[index_x][index_y] == 0) {
					return true;
				} else {
					return false;
				}
			}
		} else
			return false;
	}

}
