/**
 * 绘画底边状态栏  有登录的用户和当前时间
 */
package com.Tools;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class StatusPanel extends JPanel{
	Image image,image2;
	String info;
	public StatusPanel(Image img)
	{
		this.image=img;
		info = Tools.name+"/"+Tools.position;
		try {
			image2=ImageIO.read(new File("images/rentou.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.drawImage(image2, 20, 0, 50, 41, this);
		g.drawString(info, 60, 24);
	}
}
