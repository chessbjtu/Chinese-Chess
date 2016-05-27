/** 
* @author: 谢明霁
* @date：2016年5月27日 上午10:19:38
* @version 1.0 
*/
package chinesechess.logic;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import chinesechess.model.Chess;
import chinesechess.view.Board;

public class BoardListener extends MouseAdapter {
	private ArrayList<Chess> chesses;
	private int[][] current_status;

	public BoardListener(ArrayList<Chess> chesses, int[][] current_status) {
		this.chesses = chesses;
		this.current_status = current_status;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(Board.praseSite(e.getPoint()));
		System.out.println(e.getPoint());
		Point destination = Board.praseSite(e.getPoint());
		Iterator<Chess> iter = chesses.iterator();
		while (iter.hasNext()) {
			Chess temp = iter.next();
			if (temp.slected) {
				System.out.println(destination.x+","+destination.y);
				System.out.println(temp.move(destination.x, destination.y, current_status));
				//if (temp.move(destination.x, destination.y, current_status)) {
					temp.setBounds(e.getY(), e.getY(), 70, 70);
					temp.setX(e.getX());
					temp.setY(e.getY());
//					current_status[destination.x][destination.x] = current_status[temp.getX()][temp.getY()];
//					current_status[temp.getX()][temp.getY()] = 0;
//				}
			}
		}
	}
}
