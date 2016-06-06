/** 
* @author: л����
* @date��2016��5��31�� ����6:42:43
* @version 1.0 
*/
package chinesechess.logic;

import java.awt.Point;

import chinesechess.model.Chess;
import chinesechess.view.Board;

public class MainController {
	// ��Ǹ��ķ�����
	private static boolean who = true;
	// �ж��Ƿ񱻵����
	private static boolean click = false;
	// Ҫ���ƶ�������
	private static Chess selectedChess = null;
	// ���̵�����
	private static Board chessboard;

	/**
	 * ���걻���
	 * 
	 * @param site
	 */
	public static void Clicked(Point destination) {
		// �������ӱ�ѡ��
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
				System.out.println("�ƶ��ɹ���������" + who + "������");
			}
		}
	}

	/**
	 * ���ӱ����
	 * 
	 * @param chessman
	 */
	public static void Clicked(Chess chess) {
		if (!click) {
			if (chess.isWho() == who) {
				chess.slected = true;
				selectedChess = chess;
				chessboard.setHint(chess.getCoordinate(), false);
				System.out.println(chess.getClass().getName() + " �ѱ�ѡ��");
				click = true;
			}
		} else {
			if (chess.isWho() == who) {
				chess.slected = true;
				selectedChess = chess;
				chessboard.setHint(chess.getCoordinate(), false);
				System.out.println(chess.getClass().getName() + " �ѱ�ѡ��");
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
					System.out.println("���ӳɹ���������" + who + "������");
				}
			}
		}
	}

	public static void Controller(Board _chessboard) {
		chessboard = _chessboard;
	}
}
