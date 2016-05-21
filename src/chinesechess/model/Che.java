/** 
* @author: 谢明霁
* @date：2016年5月21日 下午4:54:24
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
	 * 车的移动策略，首先保证直线移动
	 * 其次，移动路径中不能有其他棋子
	 * 终点坐标如果为敌方棋子，移动同样合法
	 */
	@Override
	public boolean move(int x, int y, int[][] current_status) {
		if(getX() == x){//纵向移动
			
			
		}else if(getY() == y){//横向移动
			
		}else {//非法移动
			return false;
		}
		return false;
	}
	
	
}
