/** 
* @author: 谢明霁
* @date：2016年5月21日 下午4:16:26
* @version 1.0 
*/
package chinesechess.model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 棋子
 * 
 * @author ASUS
 */
public abstract class Chess extends JLabel {
	// 棋子阵营,true为红方,false为黑方
	private boolean who;
	// 棋子图片
	private ImageIcon image;
	// 棋子坐标
	private int x, y;

	public Chess(boolean who, ImageIcon image, int x, int y) {
		this.who = who;
		this.image = image;
		this.x = x;
		this.y = y;
	}

	public boolean isWho() {
		return who;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 棋子的移动策略，所有棋子必须实现这个方法
	 * 注意：棋子的移动导致被将军也为不合法
	 * 
	 * @param x 
	 * @param y 终点坐标
	 * @param current_status 当前棋面
	 * @return 移动是否复合规则
	 */
	public abstract boolean move(int x,int y,int current_status[][]);
}
