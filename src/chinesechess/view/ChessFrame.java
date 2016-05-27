/** 
* @author: л����
* @date��2016��5��21�� ����3:54:03
* @version 1.0 
*/
package chinesechess.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ChessFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 11061916430458101L;
	private Point loc = null;
    private Point tmp = null;
    private boolean isDragged = false;
    private JFrame jFrame = this;

	public ChessFrame() {
		this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		removable();
	}

	/**
	 * �ô�����ƶ�
	 */
	private void removable() {
		// �����ƶ������л������ʽ
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
			}
		});
		// ʵ�ִ����ƶ�
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(jFrame.getLocation().x + e.getX() - tmp.x,
							jFrame.getLocation().y + e.getY() - tmp.y);
					jFrame.setLocation(loc);
				}
			}
		});
	}

	/**
	 * �ô������
	 */
	public void locationCenter() {
		// �������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 3);
	}
}
