/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesechess.view;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class BackGroundPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon icon = new ImageIcon("image/main.gif");

	public BackGroundPanel() {
		this.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		this.setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, icon.getIconWidth(), icon.getIconHeight(), this);
	}

}
