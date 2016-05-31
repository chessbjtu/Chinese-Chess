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
		Point destination = Board.praseCoordinate(e.getPoint());
		Iterator<Chess> iter = chesses.iterator();
		while (iter.hasNext()) {
			Chess temp = iter.next();
			if (temp.slected) {
				System.out.println("Destination: " + destination);
				System.out.println("Move:" + temp.move(destination, current_status) + "\n"
						+ current_status[destination.x][destination.x]);
				if (temp.move(destination, current_status)) {
					Point site = Board.praseSite(destination);
					Point start = temp.getCoordinate();
					temp.setBounds(site.x, site.y, 70, 70);

					current_status[destination.x - 1][destination.y - 1] = current_status[start.x - 1][start.y - 1];
					current_status[start.x - 1][start.y - 1] = 0;

					temp.setCoordinate(destination);
					temp.slected = !temp.slected;
				}
			}
		}
	}
}
