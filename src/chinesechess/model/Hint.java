/** 
* @author: л����
* @date��2016��6��6�� ����1:43:16
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import chinesechess.view.Board;

public class Hint extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//hint������
	private Point site;
	//hint�ĳߴ�
	private static Dimension dimension = new Dimension(50,50);
	
	public Hint(ImageIcon image) {
		super(image);
	}

	/**
	 * ��ȡhint������
	 * @return
	 */
	public Point getSite() {
		return site;
	}

	/**
	 * ����hint������
	 * @param site
	 */
	public void setSite(Point site) {
		this.site = site;
		Point p = Board.praseSite(site);
		this.setBounds(p.x, p.y, dimension.width, dimension.height);
	}
}
