/** 
* @author: л����
* @date��2016��5��21�� ����4:16:26
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import chinesechess.logic.ChessListener;

/**
 * ����
 * 
 * @author ASUS
 */
public abstract class Chess extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ������Ӫ,trueΪ�췽,falseΪ�ڷ�
	private boolean who;
	// ��������
	private Point coordinate;

	// �Ƿ�ѡ��
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
	 * ���ӵ��ƶ����ԣ��������ӱ���ʵ��������� ע�⣺���ӵ��ƶ����±�����ҲΪ���Ϸ�
	 * 
	 * @param x
	 * @param y
	 *            �յ�����
	 * @param current_status
	 *            ��ǰ����
	 * @return �ƶ��Ƿ񸴺Ϲ���
	 */
	public abstract boolean move(Point destination, int current_status[][]);

	/**
	 * �յ������Ƿ���Ϸ�Χ����Ҫ��д������
	 */
	public boolean IsBeyond(int x, int y) {
		return true;
	}

}
