package com.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class HelpInfo extends JFrame {

	JLabel jLabel;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public HelpInfo(){
//		System.out.println("2222222222222222222");
		//得到本窗口的容器
		Container ct=this.getContentPane();
		jLabel = new JLabel("Sorry, there is no help",SwingConstants.CENTER);
		Font f1=new Font("宋体",Font.PLAIN, 20);
		jLabel.setFont(f1);
		jLabel.setBounds(80, 100, 100,160);  //30
		ct.add(jLabel);

		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
// 得到窗体的宽、高
		int windowsWidth = this.getWidth();
		int windowsHeight = this.getHeight();
//System.out.println(windowsWidth+","+windowsHeight);
		this.setBounds((width - windowsWidth-200)/2,(height - windowsHeight-200)/2, windowsWidth, windowsHeight);

		this.setSize(300,100);

		Image img=null;
		try {
			img= ImageIO.read(new File("images\\aixin.png"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.setIconImage(img); //图标

		this.setResizable(false); //无最大化，不可更改大小
		this.setTitle("Help");
		this.setVisible(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}
}
