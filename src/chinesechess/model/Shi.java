/** 
* @author: 谢明霁
* @date：2016年5月21日 下午9:09:42
* @version 1.0 
*/
package chinesechess.model;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

public class Shi extends Chess {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6554989220838368463L;

	public Shi(boolean who, int x, int y) {
		super(who, x, y);
		if (who) {//红方
			setImage(new ImageIcon("image/红士.gif"));
		} else {//黑方
			setImage(new ImageIcon("image/黑士.gif"));
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean move(Point destination, int[][] current_status) {
		return false;
	}

}
