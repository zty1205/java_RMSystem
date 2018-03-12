/**
 * 主界面1 
 */
package com.view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.*;
import com.Tools.*;
import com.model.*;

//人事管理窗口
public class Window1 extends JFrame implements ActionListener, MouseListener {
	
	//定义组件
	JMenuBar jmb;
	JToolBar jtb;
	Image jp1_bgimg;
	ImageIcon jtitle;
	JPanel jp1,jp2,jp3,jp4;//卡片布局所需的面板
	JPanel jbottom;
	JPanel jp3_rs,jp3_login,jp3_dishes,jp3_chart,jp3_cost; //各个主页面
	JLabel jp1_lab1,jp1_lab2,jp1_lab3,jp1_lab4,jp1_lab5,jp1_lab6;
	JLabel jp2_lab1,jp2_lab2;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5;
	ImageIcon jmi1_icon,jmi2_icon,jmi3_icon,jmi4_icon,jmi5_icon;//二级菜单图标
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7; //定义工具栏按钮
	JSplitPane jsp1;
	Cursor mycursor;//鼠标移动后的鼠标样式--手型
	Image cursorImg;
	
	Vector<JLabel> jp1_labs; //装载主面板的label
	
	//jp3内容的定义
	CardLayout cl;
	ImagePanel jp3_bg;
	
	
	ShowTime st;
	//用于 调试
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window1 w1=new Window1();
	}
	//初始化菜单
	public void initMenu()
	{
		//获取二级菜单的图片
		jmi1_icon=new ImageIcon("images\\jm1_icon1.jpg");
		jmi2_icon=new ImageIcon("images\\jm1_icon2.jpg");
		jmi3_icon=new ImageIcon("images\\jm1_icon3.png");
		jmi4_icon=new ImageIcon("images\\jm1_icon4.png");
		jmi5_icon=new ImageIcon("images\\jm1_icon5.jpg");
		
		//获取窗口的图标
		jtitle=new ImageIcon("images\\title.gif");
		//创建组件
		jmb=new JMenuBar();
		//一级菜单
		jm1=new JMenu("系统管理");
		jm1.setFont(Tools.mainFont);
		//二级菜单
		jmi1=new JMenuItem("切换用户",jmi1_icon);
		jmi2=new JMenuItem("切换到收款界面",jmi2_icon);
		jmi3=new JMenuItem("重启系统",jmi3_icon);
		jmi4=new JMenuItem("万年历",jmi4_icon);
		jmi5=new JMenuItem("退出",jmi5_icon);
		
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jmi4.addActionListener(this);
		jmi5.addActionListener(this);
		
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jm1.add(jmi5);
		
		jm2=new JMenu("人事管理");
		jm2.setFont(Tools.mainFont);
		jm3=new JMenu("菜单服务");
		jm3.setFont(Tools.mainFont);
		jm4=new JMenu("报表统计");
		jm4.setFont(Tools.mainFont);
		jm5=new JMenu("成本及库房");
		jm5.setFont(Tools.mainFont);
		jm6=new JMenu("帮助");
		jm6.setFont(Tools.mainFont);
		
		//添加组件
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		this.setJMenuBar(jmb);
	}
	
	//初始化工具栏
	public void initToolBar()
	{
		//创建工具栏
		jtb=new JToolBar();
		jtb.setFloatable(false);
		jb1=new JButton(new ImageIcon("images\\jb1.png"));
		jb2=new JButton(new ImageIcon("images\\jb2.png"));
		jb3=new JButton(new ImageIcon("images\\jb3.png"));
		jb4=new JButton(new ImageIcon("images\\jb4.png"));
		jb5=new JButton(new ImageIcon("images\\jb5.png"));
		jb6=new JButton(new ImageIcon("images\\jb6.png"));
		jb7=new JButton(new ImageIcon("images\\jb7.png"));

		jb1.setBorderPainted(false);
		jb2.setBorderPainted(false);
		jb3.setBorderPainted(false);
		jb4.setBorderPainted(false);
		jb5.setBorderPainted(false);
		jb6.setBorderPainted(false);
		jb7.setBorderPainted(false);
		
		jb1.setFocusPainted(false);
		jb2.setFocusPainted(false);
		jb3.setFocusPainted(false);
		jb4.setFocusPainted(false);
		jb5.setFocusPainted(false);
		jb6.setFocusPainted(false);
		jb7.setFocusPainted(false);
		
		jb1.setToolTipText("切换到收款界面");
		jb2.setToolTipText("切换用户");
		jb3.setToolTipText("登陆管理");
		jb4.setToolTipText("人事管理");
		jb5.setToolTipText("报表统计");
		jb6.setToolTipText("菜谱价格");
		jb7.setToolTipText("成本及库房");
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		jb7.addActionListener(this);
		
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
	}
	
	//窗体的显示内容
	public void initMainPane()
	{
		//主体面板
		jp1=new JPanel(new BorderLayout());
		try {
			jp1_bgimg=ImageIO.read(new File("images/jp1_bg.jpg"));
			cursorImg = ImageIO.read(new File("images/chazi.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImagePanel ip1_bgPanel=new ImagePanel(jp1_bgimg);
		ip1_bgPanel.setLayout(new GridLayout(6, 1));  //网格布局
		mycursor=Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(30,30),"dynamite stick") ;
		
		jp1_labs = new Vector<JLabel>();
		//horizontalalignment 表示水平居中
		jp1_lab1=new JLabel(new ImageIcon("images/mhl.png"), 0);
		jp1_lab2=new JLabel("人 事 管 理", new ImageIcon("images/jm1_icon4.png"), 0);
		jp1_lab3=new JLabel("登 陆 管 理", new ImageIcon("images/jm1_icon3.png"), 0);
		jp1_lab4=new JLabel("菜 谱 价 格", new ImageIcon("images/label_4.png"), 0);
		jp1_lab5=new JLabel("报 表 统 计", new ImageIcon("images/label_5.png"), 0);
		jp1_lab6=new JLabel("成本及库房  ", new ImageIcon("images/label_6.png"), 0);

		
		//设置JLabel的字体
		jp1_lab2.setFont(Tools.f_14);
		jp1_lab3.setFont(Tools.f_14);
		jp1_lab4.setFont(Tools.f_14);
		jp1_lab5.setFont(Tools.f_14);
		jp1_lab6.setFont(Tools.f_14);
		
		//设置JLabel为禁用
		jp1_lab2.setEnabled(false);
		jp1_lab3.setEnabled(false);
		jp1_lab4.setEnabled(false);
		jp1_lab5.setEnabled(false);
		jp1_lab6.setEnabled(false);
		
		//设置移动懂JLabel上时鼠标显示为手型
		jp1_lab2.setCursor(mycursor);
		jp1_lab3.setCursor(mycursor);
		jp1_lab4.setCursor(mycursor);
		jp1_lab5.setCursor(mycursor);
		jp1_lab6.setCursor(mycursor);
		
		//添加监听
		jp1_lab2.addMouseListener(this);
		jp1_lab3.addMouseListener(this);
		jp1_lab4.addMouseListener(this);
		jp1_lab5.addMouseListener(this);
		jp1_lab6.addMouseListener(this);
		
		//装载JLabel
		jp1_labs.add(jp1_lab2);
		jp1_labs.add(jp1_lab3);
		jp1_labs.add(jp1_lab4);
		jp1_labs.add(jp1_lab5);
		jp1_labs.add(jp1_lab6);
		
		ip1_bgPanel.add(jp1_lab1);
		ip1_bgPanel.add(jp1_lab2);
		ip1_bgPanel.add(jp1_lab3);
		ip1_bgPanel.add(jp1_lab4);
		ip1_bgPanel.add(jp1_lab5);
		ip1_bgPanel.add(jp1_lab6);
		jp1.add(ip1_bgPanel);
		
		//卡片布局
		cl=new CardLayout();
		jp2=new JPanel(new CardLayout());
		jp2.setPreferredSize(new Dimension(30, Tools.height));
		jp2_lab1=new JLabel(new ImageIcon("images/jp2_right.jpg"));
		jp2_lab2=new JLabel(new ImageIcon("images/jp2_left.jpg"));
		jp2_lab1.addMouseListener(this);
		jp2_lab2.addMouseListener(this);
		jp2_lab1.setCursor(mycursor);
		jp2_lab2.setCursor(mycursor);
		// constraints 约束 相当于主键
		jp2.add(jp2_lab1,"0");
		jp2.add(jp2_lab2,"1");
		
		//jp3的背景图片
		jp3=new JPanel(cl);
		try {
			jp3_bg=new ImagePanel(ImageIO.read(new File("images/split_main.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//人事管理界面创建
		jp3_rs = new EmpInfo();
		//登陆管理界面创建
		jp3_login = new LoginInfo();
		//菜谱价格界面创建
		jp3_dishes = new DishesInfo();
		//报表统计界面的创建
		jp3_chart = new ChartInfo();
		//成本及库房界面的创建
		jp3_cost = new CostInfo();

		jp3.add(jp3_bg     ,"0");
		jp3.add(jp3_rs     ,"1");
		jp3.add(jp3_login  ,"2");
		jp3.add(jp3_dishes ,"3");
		jp3.add(jp3_chart  ,"4");
		jp3.add(jp3_cost   ,"5");

		
		//拆分的右窗口
		jp4=new JPanel(new BorderLayout());
//		jp2.setPreferredSize(new Dimension(200,Tools.height));
		jp4.add(jp2,BorderLayout.WEST);
		jp4.add(jp3,BorderLayout.CENTER);
		
		//拆分窗口
		// 第一个参数表示横向
		jsp1=new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, false, jp1, jp4);
		// 点击后 左边布局占多大   Tools.width=屏幕的大小
		jsp1.setDividerLocation(Tools.width);
		//边界线大小设为0
		jsp1.setDividerSize(0);
	}
	
	//构造函数
	public Window1()
	{
		Container ct=this.getContentPane();
		
		//调用初始化菜单函数
		this.initMenu();
		//调用初始化工具栏函数
		this.initToolBar();
		//调用初始化内容函数
		this.initMainPane();
		
		//底边状态栏
		jbottom = new JPanel(new BorderLayout());  //边界布局 分东南西北中
		st=new ShowTime();
		st.setLayout(new BorderLayout());
		StatusPanel st_bg=null;
		try {
			st_bg=new StatusPanel(ImageIO.read(new File("images/time_bg.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st.add(st_bg);
		jbottom.add(st);
		jbottom.setPreferredSize(new Dimension(Tools.width,30));
		Thread t=new Thread(st);
		t.start();
		//设置布局
		ct.add(jsp1,BorderLayout.CENTER);
		ct.add(jbottom, BorderLayout.SOUTH);
		ct.add(jtb, BorderLayout.NORTH);

		
		//设置窗体
		this.setTitle("大碗兄弟餐饮管理系统");
		this.setIconImage(jtitle.getImage());
		this.setSize(Tools.width,Tools.height-35);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//用于点击当前JLabel给其他jp1中的没有鼠标监听事件的JLabel的添加鼠标监听事件
	public void getNoMouseListenerLabel(JLabel nowLabel)
	{
		for(int i=0;i<jp1_labs.size();i++)
		{
			if(jp1_labs.get(i)!=nowLabel)
			{
				if(jp1_labs.get(i).getMouseListeners().length==0)
				{
					jp1_labs.get(i).addMouseListener(this);
					//让该label不可用
					jp1_labs.get(i).setEnabled(false);
				}
			}
		}
	}
	public void showPanel(JLabel label)
	{
		label.setEnabled(true);
		jsp1.setDividerLocation(220);
		label.removeMouseListener(this);
		this.getNoMouseListenerLabel(label);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//展示卡片
		if(e.getSource()==this.jp1_lab2)
		{
			//jp1的人事管理
			cl.show(jp3, "1"); //在jb3上显示名叫 0 的卡片
			this.showPanel(jp1_lab2);
		}else if(e.getSource()==jp1_lab3)
		{
			//jp1的登陆管理
			cl.show(jp3, "2");
			this.showPanel(jp1_lab3);
		}else if(e.getSource()==jp1_lab4)
		{
			//jp1的菜谱价格
			cl.show(jp3, "3");
			this.showPanel(jp1_lab4);
		}else if(e.getSource()==jp1_lab5)
		{
			//jp1的报表统计
			cl.show(jp3, "4");
			this.showPanel(jp1_lab5);
		}else if(e.getSource()==jp1_lab6)
		{
			//jp1的成本及库房
			cl.show(jp3, "5");
			this.showPanel(jp1_lab6);
		}else if(e.getSource()==jp2_lab1)
		{
			//jp2的左右缩放按钮
			jsp1.setDividerLocation(Tools.width);
			this.getNoMouseListenerLabel(null);
		}else if(e.getSource()==jp2_lab2)
		{
			//jp2的左右缩放按钮
			jsp1.setDividerLocation(220);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//选中了 就高亮
		if(e.getSource()==jp1_lab2)
		{
			jp1_lab2.setEnabled(true);
		}else if(e.getSource()==jp1_lab3)
		{
			jp1_lab3.setEnabled(true);
		}else if(e.getSource()==jp1_lab4)
		{
			jp1_lab4.setEnabled(true);
		}else if(e.getSource()==jp1_lab5)
		{
			jp1_lab5.setEnabled(true);
		}else if(e.getSource()==jp1_lab6)
		{
			jp1_lab6.setEnabled(true);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//鼠标移开  就不高亮
		if(e.getSource()==jp1_lab2)
		{
			jp1_lab2.setEnabled(false);
			
		}else if(e.getSource()==jp1_lab3)
		{
			jp1_lab3.setEnabled(false);
		}else if(e.getSource()==jp1_lab4)
		{
			jp1_lab4.setEnabled(false);
		}else if(e.getSource()==jp1_lab5)
		{
			jp1_lab5.setEnabled(false);
		}else if(e.getSource()==jp1_lab6)
		{
			jp1_lab6.setEnabled(false);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jmi1||e.getSource()==jb2)
		{
			//切换用户
			this.dispose();
			new Login();
			
		}else if(e.getSource()==jmi2||e.getSource()==jb1)
		{
			//切换到收款界面
			this.dispose();
			OrderIndex oi = new OrderIndex();
			
		}else if(e.getSource()==jmi3)
		{
			//重新启动
			this.dispose();
			Thread t=new Thread(new Index());
			t.start();
		}else if(e.getSource()==jmi4)
		{
			//万年历
			Thread Wc=new Thread(new WindowCalendar("万年历"));
		}
		else if(e.getSource()==jmi5)
		{
			//退出系统
			System.exit(0);
		}else if(e.getSource()==jb4)
		{
			//jp1的人事管理
			cl.show(jp3, "1");
			this.showPanel(jp1_lab2);
		}else if(e.getSource()==jb3)
		{
			//jp1的登陆管理
			cl.show(jp3, "2");
			this.showPanel(jp1_lab3);
		}else if(e.getSource()==jb6)
		{
			//jp1的菜谱价格
			cl.show(jp3, "3");
			this.showPanel(jp1_lab4);
		}else if(e.getSource()==jb5)
		{
			//jp1的报表统计
			cl.show(jp3, "4");
			this.showPanel(jp1_lab5);
		}
	}
}
