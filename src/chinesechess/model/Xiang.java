/** 
* @author: 谢明霁
* @date：2016年5月21日 下午9:06:51
* @version 1.0 
*/
package chinesechess.model;

import java.net.URL;

import javax.swing.ImageIcon;

public class Xiang extends Chess{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8443336074937616571L;

	public Xiang(boolean who, ImageIcon image, int x, int y) {
		super(who, null, x, y);
		if (who) {//红方
			URL imgURL = getClass().getResource("chinesechess/resource/r_Xiang.jpg");
			setImage(new ImageIcon(imgURL));
		} else {//黑方
			URL imgURL = getClass().getResource("chinesechess/resource/b_Xiang.jpg");
			setImage(new ImageIcon(imgURL));
		}
	}

	@Override
	public boolean move(int x, int y, int[][] current_status) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
