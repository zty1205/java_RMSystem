package com.Tools;
/*
	加载一张图片作为背景
 */
import java.awt.*;
import javax.swing.*;
public class ImagePanel extends JPanel{

	Image image;
	public ImagePanel(Image img)
	{
		this.image=img;
	}
	public void paintComponent(Graphics g)
	{
		//清屏
		super.paintComponent(g);
		//画出背景
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
