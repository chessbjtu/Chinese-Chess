/** 
* @author: 谢明霁
* @date：2016年6月6日 下午1:43:16
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
	//hint的坐标
	private Point site;
	//hint的尺寸
	private static Dimension dimension = new Dimension(50,50);
	
	public Hint(ImageIcon image) {
		super(image);
	}

	/**
	 * 获取hint的坐标
	 * @return
	 */
	public Point getSite() {
		return site;
	}

	/**
	 * 设置hint的坐标
	 * @param site
	 */
	public void setSite(Point site) {
		this.site = site;
		Point p = Board.praseSite(site);
		this.setBounds(p.x, p.y, dimension.width, dimension.height);
	}
}
