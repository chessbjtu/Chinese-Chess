/** 
* @author: 谢明霁
* @date：2016年5月24日 下午3:49:08
* @version 1.0 
*/
package chinesechess.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import chinesechess.logic.BoardListener;
import chinesechess.logic.MainController;
import chinesechess.model.*;

public class Board extends ChessDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2156538120526170067L;
	private BackGroundPanel main = new BackGroundPanel();
	private ArrayList<Chess> chesses = new ArrayList<>();
	public int[][] current_status = { { 1, 0, 0, 12, 0, 0, 17, 0, 0, 24 }, { 2, 0, 10, 0, 0, 0, 0, 22, 0, 25 },
			{ 3, 0, 0, 13, 0, 0, 18, 0, 0, 26 }, { 4, 0, 0, 0, 0, 0, 0, 0, 0, 27 }, { 5, 0, 0, 14, 0, 0, 19, 0, 0, 28 },
			{ 6, 0, 0, 0, 0, 0, 0, 0, 0, 29 }, { 7, 0, 0, 15, 0, 0, 20, 0, 0, 30 }, { 8, 0, 11, 0, 0, 0, 0, 23, 0, 31 },
			{ 9, 0, 0, 16, 0, 0, 21, 0, 0, 32 } };
	private Hint[] hints = new Hint[3];

	public Board() {
		initHint();
		initChess();
		initBoard();

	}

	private void initBoard() {
		this.setContentPane(main);
		// 设置窗口的默认属性
		this.setSize(main.getWidth(), main.getHeight());
		this.setTitle("中国象棋");
		// 棋盘居中
		this.locationCenter();
		this.addMouseListener(new BoardListener(chesses, current_status));
		// 添加hint
		for (Hint hint : hints) {
			main.add(hint);
		}

	}

	public void initChess() {
		boolean who = true;
		for (int i = 0; i < 2; i++) {
			// 添加车
			for (int x = 0, y = (who ? 9 : 0); x <= 8; x = x + 8) {
				Chess che = new Che(who, x, y);
				main.add(che);
				chesses.add(che);
			}
			// 添加马
			for (int x = 1, y = (who ? 9 : 0); x <= 7; x = x + 6) {
				Chess ma = new Ma(who, x, y);
				main.add(ma);
				chesses.add(ma);
			}
			// 添加象
			for (int x = 2, y = (who ? 9 : 0); x <= 6; x = x + 4) {
				Chess xiang = new Xiang(who, x, y);
				main.add(xiang);
				chesses.add(xiang);
			}
			// 添加士
			for (int x = 3, y = (who ? 9 : 0); x <= 5; x = x + 2) {
				Chess shi = new Shi(who, x, y);
				main.add(shi);
				chesses.add(shi);
			}
			// 添加将
			for (int x = 4, y = (who ? 9 : 0); x <= 4; x++) {
				Chess jiang = new Jiang(who, x, y);
				main.add(jiang);
				chesses.add(jiang);
			}
			// 添加炮
			for (int x = 1, y = (who ? 7 : 2); x <= 7; x = x + 6) {
				Chess pao = new Pao(who, x, y);
				main.add(pao);
				chesses.add(pao);
			}
			// 添加卒
			for (int x = 0, y = (who ? 6 : 3); x <= 8; x = x + 2) {
				Chess zu = new Zu(who, x, y);
				main.add(zu);
				chesses.add(zu);
			}
			// 添加红色棋子
			who = !who;
		}

	}

	public static Point praseCoordinate(Point p) {
		for (int x = 0; x < 9; x++) {
			if (Math.abs(x * 57 + 52 - p.x) <= 25) {
				for (int y = 0; y < 10; y++) {
					if (Math.abs(y * 57 + 52 - p.y) <= 20) {
						p = new Point(x + 1, y + 1);
						return p;
					}
				}
			}
		}
		return null;
	}

	public static Point praseSite(Point p) {
		Point point = new Point((p.x - 1) * 57 + 27, (p.y - 1) * 57 + 27);
		return point;
	}

	/**
	 * 初始化hint
	 */
	private void initHint() {
		hints[0] = new Hint(new ImageIcon("image/bluehint.png"));
		hints[1] = new Hint(new ImageIcon("image/redhint.png"));
		hints[2] = new Hint(new ImageIcon("image/redhint.png"));
		for (Hint hint : hints) {
			hint.setVisible(false);
		}
	}

	/**
	 * 修改棋盘上的Hint
	 * 
	 * @param site
	 *            目标位置
	 * @param type
	 *            修改的hint类型,true移动性修改，false选择性修改
	 */
	public void setHint(Point site, boolean type) {
		// 修改为移动性Hint
		if (type) {
			hints[0].setVisible(false);
			hints[1].setSite(hints[0].getSite());
			hints[1].setVisible(true);
			hints[2].setSite(site);
			hints[2].setVisible(true);
		} else {// 修改为选择性Hint
			hints[0].setSite(site);
			hints[0].setVisible(true);
			hints[1].setVisible(false);
			hints[2].setVisible(false);
		}
	}

	public static void main(String[] args) {
		Board chessboard = new Board();
		// 将棋盘交由总控控制
		MainController.Controller(chessboard);
	}
}
