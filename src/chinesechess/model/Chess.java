/** 
* @author: 谢明霁
* @date：2016年5月21日 下午4:16:26
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import chinesechess.logic.ChessListener;

/**
 * 棋子
 * 
 * @author ASUS
 */
public abstract class Chess extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 棋子阵营,true为红方,false为黑方
	private boolean who;
	// 棋子坐标
	private Point coordinate;

	// 是否被选定
	public boolean slected = false;

	public Chess(boolean who, int x, int y) {
		super();
		this.who = who;
		coordinate = new Point(x+1, y+1);
		setBounds(x * 57 + 27, y * 57 + 27, 50, 50);
		setFocusable(true);
		addMouseListener(new ChessListener());
	}

	public boolean isWho() {
		return who;
	}

	public void setImage(ImageIcon image) {
		this.setIcon(image);
	}

	public Point getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * 棋子的移动策略，所有棋子必须实现这个方法 注意：棋子的移动导致被将军也为不合法
	 * 
	 * @param x
	 * @param y
	 *            终点坐标
	 * @param current_status
	 *            当前棋面
	 * @return 移动是否复合规则
	 */
	public abstract boolean move(Point destination, int current_status[][]);

	/**
	 * 终点坐标是否符合范围，需要重写的子类
	 */
	public boolean IsBeyond(int x, int y) {
		return true;
	}

}
