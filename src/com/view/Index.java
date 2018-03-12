/**
 * 满汉楼餐饮系统加载界面
 */
package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.*;
import com.Tools.*;

public class Index extends JWindow implements Runnable{

	BackImage bgimg=new BackImage();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Index index=new Index();
		Thread t=new Thread(index);
		t.start();
	}
	//构造函数用于初始化
	public Index()
	{
		Thread t=new Thread(bgimg);
		t.start();
		Container ct=this.getContentPane();
		this.add(bgimg);
		this.setSize(600,390);
		this.setVisible(true);
		this.setLocation(Tools.width/2-300, Tools.height/2-185);
	}
	//创建一个内部类，来绘画加载界面的图案和进度条
	class BackImage extends JPanel implements Runnable {
		Image img = null;
		int i = 0;

		public BackImage() {
			try {
				img = ImageIO.read(new File("images\\index.jpg"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		int rate = 0;

		//覆盖绘画函数
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(img, 0, 0, this);
			g.setFont(new Font("楷体", Font.BOLD, 25));
			//g.drawString("正 在 加 载 请 稍 等 "+(int)(((i+1)*3.3+1))+"%", 120, 383);

			rate += Math.random() * 10;
			if (rate <= 100) {
				g.setColor(Color.green);
				g.fill3DRect(0, 360, 600 * rate / 100, 40, false);
				g.setColor(Color.black);
				g.drawString("正 在 加 载 请 稍 等 " + rate + "%", 120, 383);
			} else {
				g.setColor(Color.green);
				g.fill3DRect(0, 360, 600, 40, false);
				g.setColor(Color.black);
				g.drawString("正 在 加 载 请 稍 等 " + 100 + "%", 120, 383);

			}
		}


		public void run() {
			// TODO Auto-generated method stub
			//int j=0;
			while(rate<=100)
			{

				for(i=0;;i++)
				{
					//每隔169毫秒重新绘画一次进度条,实现进度条的动态前进
					this.repaint();
					//j++;
					try {
						Thread.sleep(169);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}
	}
	@Override
	public void run() {
		//控制加载界面的显示时间
		try {
			Thread.sleep(4400);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//关闭本窗口
		this.dispose();
		//创建一个登录界面跳转
		new Login();
	}
}