/** 
* @author: л����
* @date��2016��5��21�� ����4:54:24
* @version 1.0 
*/
package chinesechess.model;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Che extends Chess {
	public Che(boolean who, int x, int y) {
		super(who, null, x, y);
		if (who) {
			URL imgURL = getClass().getResource("chinesechess/resource/r-Che.jpg");
			setImage(new ImageIcon(imgURL));
		}else{
			URL imgURL = getClass().getResource("chinesechess/resource/b-Che.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	/**
	 * �����ƶ����ԣ����ȱ�ֱ֤���ƶ�
	 * ��Σ��ƶ�·���в�������������
	 * �յ��������Ϊ�з����ӣ��ƶ�ͬ���Ϸ�
	 */
	@Override
	public boolean move(int x, int y, int[][] current_status) {
		if(getX() == x){//�����ƶ�
			
			
		}else if(getY() == y){//�����ƶ�
			
		}else {//�Ƿ��ƶ�
			return false;
		}
		return false;
	}
	
	
}
