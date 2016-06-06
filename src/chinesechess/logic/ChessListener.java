/** 
* @author: л����
* @date��2016��5��27�� ����2:50:35
* @version 1.0 
*/
package chinesechess.logic;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import chinesechess.model.Chess;

public class ChessListener extends MouseAdapter {
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof Chess) {
			Chess source = (Chess) e.getSource();
			MainController.Clicked(source);
//			source.slected = !source.slected;
//			System.out.println("Slected: " + source.slected);
//			if (source.slected) {
//				System.out.println("Start: " + source.getCoordinate());
//			}
		}
	}
}
