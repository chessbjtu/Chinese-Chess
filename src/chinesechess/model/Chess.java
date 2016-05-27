/** 
* @author: л����
* @date��2016��5��21�� ����4:16:26
* @version 1.0 
*/
package chinesechess.model;

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
	private static final long serialVersionUID = 3172086585879537618L;
	// ������Ӫ,trueΪ�췽,falseΪ�ڷ�
	private boolean who;
	// ��������
	private int x, y;
	// �Ƿ�ѡ��
	public boolean slected = false;

	public Chess(boolean who, int x, int y) {
		super();
		this.who = who;
		setBounds(x * 57 + 27, y * 57 + 27, 70, 70);
		setFocusable(true);
	}

	public boolean isWho() {
		return who;
	}

	public void setImage(ImageIcon image) {
		this.setIcon(image);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
	public abstract boolean move(int x, int y, int current_status[][]);

	/**
	 * �յ������Ƿ���Ϸ�Χ����Ҫ��д������
	 */
	public boolean IsBeyond(int x, int y) {
		return true;
	}
}
