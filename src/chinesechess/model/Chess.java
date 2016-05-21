/** 
* @author: л����
* @date��2016��5��21�� ����4:16:26
* @version 1.0 
*/
package chinesechess.model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * ����
 * 
 * @author ASUS
 */
public abstract class Chess extends JLabel {
	// ������Ӫ,trueΪ�췽,falseΪ�ڷ�
	private boolean who;
	// ����ͼƬ
	private ImageIcon image;
	// ��������
	private int x, y;

	public Chess(boolean who, ImageIcon image, int x, int y) {
		this.who = who;
		this.image = image;
		this.x = x;
		this.y = y;
	}

	public boolean isWho() {
		return who;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
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
	 * ���ӵ��ƶ����ԣ��������ӱ���ʵ���������
	 * ע�⣺���ӵ��ƶ����±�����ҲΪ���Ϸ�
	 * 
	 * @param x 
	 * @param y �յ�����
	 * @param current_status ��ǰ����
	 * @return �ƶ��Ƿ񸴺Ϲ���
	 */
	public abstract boolean move(int x,int y,int current_status[][]);
}
