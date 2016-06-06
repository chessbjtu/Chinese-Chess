/** 
* @author: 谢明霁
* @date：2016年5月31日 下午6:42:43
* @version 1.0 
*/
package chinesechess.logic;

import java.awt.Point;

import chinesechess.model.Chess;
import chinesechess.view.Board;

public class MainController {
	// 标记该哪方出棋
	private static boolean who = true;
	// 判断是否被点击过
	private static boolean click = false;
	// 要被移动的棋子
	private static Chess selectedChess = null;
	// 棋盘的引用
	private static Board chessboard;

	/**
	 * 坐标被点击
	 * 
	 * @param site
	 */
	public static void Clicked(Point destination) {
		// 已有棋子被选定
		if (click) {
			if (selectedChess.move(destination, chessboard.current_status)) {
				Point site = Board.praseSite(destination);
				Point start = selectedChess.getCoordinate();

				selectedChess.setBounds(site.x, site.y, 50, 50);
				chessboard.current_status[destination.x - 1][destination.y
						- 1] = chessboard.current_status[start.x - 1][start.y - 1];
				chessboard.current_status[start.x - 1][start.y - 1] = 0;

				selectedChess.setCoordinate(destination);

				who = !who;
				click = false;
				selectedChess = null;
				
				chessboard.setHint(destination, true);
				System.out.println("移动成功！现在是" + who + "方下棋");
			}
		}
	}

	/**
	 * 棋子被点击
	 * 
	 * @param chessman
	 */
	public static void Clicked(Chess chess) {
		if (!click) {
			if (chess.isWho() == who) {
				chess.slected = true;
				selectedChess = chess;
				chessboard.setHint(chess.getCoordinate(), false);
				System.out.println(chess.getClass().getName() + " 已被选定");
				click = true;
			}
		} else {
			if (chess.isWho() == who) {
				chess.slected = true;
				selectedChess = chess;
				chessboard.setHint(chess.getCoordinate(), false);
				System.out.println(chess.getClass().getName() + " 已被选定");
				click = true;
			} else if (chess.isWho() != who) {
				Point destination = chess.getCoordinate();
				Point site = Board.praseSite(destination);
				Point start = selectedChess.getCoordinate();
				if (selectedChess.move(destination, chessboard.current_status)) {
					selectedChess.setBounds(site.x, site.y, 50, 50);
					chessboard.remove(chess);
					chessboard.current_status[destination.x - 1][destination.y
							- 1] = chessboard.current_status[start.x - 1][start.y - 1];
					chessboard.current_status[start.x - 1][start.y - 1] = 0;

					selectedChess.setCoordinate(destination);

					who = !who;
					click = false;
					selectedChess = null;
					
					chessboard.setHint(chess.getCoordinate(), true);
					System.out.println("吃子成功！现在是" + who + "方下棋");
				}
			}
		}
	}

	public static void Controller(Board _chessboard) {
		chessboard = _chessboard;
	}
}
