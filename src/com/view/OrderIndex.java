/**
 *餐桌使用情况，收款界面
 */

package com.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import com.Tools.*;
import com.Tools.Tools;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;


public class OrderIndex extends JFrame implements MouseListener,ActionListener {
	
	//定义组件
	Container ct;//JFrame的容器
	JPanel jp_left,jp_right;
	ImagePanel jp_left_bg,jp_right_bg; //主界面的背景JPanel
	JMenuBar jmb;
	JMenu jm1,jm2,jm3;
	JMenuItem jmi1,jmi2,jmi3;
	JToolBar jtb;
	JButton jb1,jb2,jb3; //工具栏按钮
	JSplitPane jsp;//左右面板分割
	JPanel jbottom;//底部状态栏容器Jpanel
	ShowTime st;//状态栏面板
	Image jp_left_bgImg,jp_right_bgImg;
	
	Cursor mycursor ;
	
	//右边界面的元素
	JButton jp_right_jb1,jp_right_jb2,jp_right_jb3,jp_right_jb4;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JPanel jp2,jp3,jp8,jp9;
	
	//左边界面的元素
	JPanel jp_disk;
	JPanel jp_disk_1,jp_disk_2,jp_disk_3,jp_disk_4,jp_disk_5;
	JLabel jl1_1,jl1_2,jl1_3,jl1_4,jl1_5;
	JLabel jl2_1,jl2_2,jl2_3,jl2_4,jl2_5;
	JLabel jl3_1,jl3_2,jl3_3,jl3_4,jl3_5;
	JLabel jl4_1,jl4_2,jl4_3,jl4_4,jl4_5;
	JLabel jl5_1,jl5_2,jl5_3,jl5_4,jl5_5;
	JPanel jp_left_1,jp_left_2;
	
	//处理预定
	ReserveDialog od;
	//用于调试
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderIndex oi=new OrderIndex();
	}
	//初始化菜单
	public void initMenu()
	{
		jmb = new JMenuBar();
		jm1 = new JMenu("系统");
		jm2 = new JMenu("服务");
		jm3 = new JMenu("帮助");
		jm1.setFont(Tools.f_14);
		jm2.setFont(Tools.f_14);
		jm3.setFont(Tools.f_14);
		
		jmi1 = new JMenuItem("切换用户");
		jmi2 = new JMenuItem("重新登录");
		jmi3 = new JMenuItem("退出系统");
		jmi1.setFont(Tools.f_14);
		jmi2.setFont(Tools.f_14);
		jmi3.setFont(Tools.f_14);
		
		jmi1.addActionListener(this);
		jmi3.addActionListener(this);
		jmi2.addActionListener(this);
		
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
	}
	//初始化工具栏
	public void initToolBar()
	{
		jtb = new JToolBar();
		jtb.setFloatable(false);
		jb1 = new JButton(new ImageIcon("images/jb1.png"));
		jb2 = new JButton(new ImageIcon("images/jb2.png"));
		jb3 = new JButton(new ImageIcon("images/aixin.png"));
		
		jb1.setToolTipText("切换到管理界面");
		jb2.setToolTipText("切换用户");
		jb3.setToolTipText("帮助");
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jb1.setFocusPainted(false);
		jb2.setFocusPainted(false);
		jb3.setFocusPainted(false);
		
		jb1.setBorderPainted(false);
		jb2.setBorderPainted(false);
		jb3.setBorderPainted(false);
		
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
	}
	
	public void initSplitPane()
	{
		//获取背景图
		try {
			jp_left_bgImg = ImageIO.read(new File("images/orderIndex.gif"));
			jp_right_bgImg = ImageIO.read(new File("images/manage.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//创建组件
		jp_left = new JPanel(new BorderLayout());
		jp_right = new JPanel();
		jp_right.setLayout(new BorderLayout());
		mycursor = new Cursor(Cursor.HAND_CURSOR);
		
		jp_left_bg = new ImagePanel(jp_left_bgImg);
		jp_right_bg = new ImagePanel(jp_right_bgImg);
		
		//处理右边面板
		jp_right_jb1 = new JButton(" 预 定 ");
		jp_right_jb2 = new JButton(" 退 订 ");
		jp_right_jb3 = new JButton(" 点 菜");
		jp_right_jb4 = new JButton(" 结 账 ");
		
		jp_right_jb1.setFont(Tools.f_14);
		jp_right_jb2.setFont(Tools.f_14);
		jp_right_jb3.setFont(Tools.f_14);
		jp_right_jb4.setFont(Tools.f_14);
		
		jp_right_jb1.addActionListener(this);
		jp_right_jb2.addActionListener(this);
		jp_right_jb3.addActionListener(this);
		jp_right_jb4.addActionListener(this);
		
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp8 = new JPanel();
		jp9 = new JPanel();
		
		//设置为透明
		jp2.setOpaque(false);
		jp3.setOpaque(false);
		jp8.setOpaque(false);
		jp9.setOpaque(false);
		
		jp8.setLayout(new FlowLayout(FlowLayout.CENTER,80,30));
		jp9.setLayout(new FlowLayout(FlowLayout.CENTER,80,30));
		
		jl1 = new JLabel(new ImageIcon("images/mhl.gif"));
		jl2 = new JLabel("当 前 用 户："+Tools.name);
		jl2.setFont(Tools.f_14);
		jl3 = new JLabel("    职 位："+Tools.position);
		jl3.setFont(Tools.f_14);
		jl4 = new JLabel();
		jl5 = new JLabel();
		jl6 = new JLabel();
		jl7 = new JLabel();
		jp2.add(jl2);
		jp3.add(jl3);
		jp8.add(jp_right_jb1);
		jp8.add(jp_right_jb2);
		jp9.add(jp_right_jb3);
		jp9.add(jp_right_jb4);
		
		jp_right_bg.setLayout(new GridLayout(9,1));  // row=9
		
		jp_right_bg.add(jl1);
		jp_right_bg.add(jl4);
		jp_right_bg.add(jp2);
		jp_right_bg.add(jp3);
		jp_right_bg.add(jl5);
		jp_right_bg.add(jl6);
		jp_right_bg.add(jl7);
		jp_right_bg.add(jp8);
		jp_right_bg.add(jp9);
		
		//处理左边面板
		jp_disk = new JPanel(new GridLayout(9,1));  // row=9
		jp_disk.setOpaque(false);
		
		jp_disk_1 = new JPanel(new FlowLayout(FlowLayout.CENTER,60,10));
		jp_disk_2 = new JPanel(new FlowLayout(FlowLayout.CENTER,60,10));
		jp_disk_3 = new JPanel(new FlowLayout(FlowLayout.CENTER,60,10));
		jp_disk_4 = new JPanel(new FlowLayout(FlowLayout.CENTER,60,10));
		jp_disk_5 = new JPanel(new FlowLayout(FlowLayout.CENTER,60,10));
		
		jp_disk_1.setOpaque(false);
		jp_disk_2.setOpaque(false);
		jp_disk_3.setOpaque(false);
		jp_disk_4.setOpaque(false);
		jp_disk_5.setOpaque(false);
		
		jl1_1 = new JLabel(new ImageIcon("images/1.png"));
		jl1_2 = new JLabel(new ImageIcon("images/2.png"));
		jl1_3 = new JLabel(new ImageIcon("images/3.png"));
		jl1_4 = new JLabel(new ImageIcon("images/4.png"));
		jl1_5 = new JLabel(new ImageIcon("images/5.png"));
		jl2_1 = new JLabel(new ImageIcon("images/6.png"));
		jl2_2 = new JLabel(new ImageIcon("images/7.png"));
		jl2_3 = new JLabel(new ImageIcon("images/8.png"));
		jl2_4 = new JLabel(new ImageIcon("images/9.png"));
		jl2_5 = new JLabel(new ImageIcon("images/10.png"));
		jl3_1 = new JLabel(new ImageIcon("images/11.png"));
		jl3_2 = new JLabel(new ImageIcon("images/12.png"));
		jl3_3 = new JLabel(new ImageIcon("images/13.png"));
		jl3_4 = new JLabel(new ImageIcon("images/14.png"));
		jl3_5 = new JLabel(new ImageIcon("images/15.png"));
		jl4_1 = new JLabel(new ImageIcon("images/16.png"));
		jl4_2 = new JLabel(new ImageIcon("images/17.png"));
		jl4_3 = new JLabel(new ImageIcon("images/18.png"));
		jl4_4 = new JLabel(new ImageIcon("images/19.png"));
		jl4_5 = new JLabel(new ImageIcon("images/20.png"));
		jl5_1 = new JLabel(new ImageIcon("images/21.png"));
		jl5_2 = new JLabel(new ImageIcon("images/22.png"));
		jl5_3 = new JLabel(new ImageIcon("images/23.png"));
		jl5_4 = new JLabel(new ImageIcon("images/24.png"));
		jl5_5 = new JLabel(new ImageIcon("images/25.png"));
		
		jl1_1.addMouseListener(this);
		jl1_2.addMouseListener(this);
		jl1_3.addMouseListener(this);
		jl1_4.addMouseListener(this);
		jl1_5.addMouseListener(this);
		
		jl2_1.addMouseListener(this);
		jl2_2.addMouseListener(this);
		jl2_3.addMouseListener(this);
		jl2_4.addMouseListener(this);
		jl2_5.addMouseListener(this);
		
		jl3_1.addMouseListener(this);
		jl3_2.addMouseListener(this);
		jl3_3.addMouseListener(this);
		jl3_4.addMouseListener(this);
		jl3_5.addMouseListener(this);
		
		jl4_1.addMouseListener(this);
		jl4_2.addMouseListener(this);
		jl4_3.addMouseListener(this);
		jl4_4.addMouseListener(this);
		jl4_5.addMouseListener(this);
		
		jl5_1.addMouseListener(this);
		jl5_2.addMouseListener(this);
		jl5_3.addMouseListener(this);
		jl5_4.addMouseListener(this);
		jl5_5.addMouseListener(this);
		
		jl1_1.setCursor(mycursor);
		jl1_2.setCursor(mycursor);
		jl1_3.setCursor(mycursor);
		jl1_4.setCursor(mycursor);
		jl1_5.setCursor(mycursor);
		
		jl2_1.setCursor(mycursor);
		jl2_2.setCursor(mycursor);
		jl2_3.setCursor(mycursor);
		jl2_4.setCursor(mycursor);
		jl2_5.setCursor(mycursor);
		
		jl3_1.setCursor(mycursor);
		jl3_2.setCursor(mycursor);
		jl3_3.setCursor(mycursor);
		jl3_4.setCursor(mycursor);
		jl3_5.setCursor(mycursor);
		
		jl4_1.setCursor(mycursor);
		jl4_2.setCursor(mycursor);
		jl4_3.setCursor(mycursor);
		jl4_4.setCursor(mycursor);
		jl4_5.setCursor(mycursor);
		
		jl5_1.setCursor(mycursor);
		jl5_2.setCursor(mycursor);
		jl5_3.setCursor(mycursor);
		jl5_4.setCursor(mycursor);
		jl5_5.setCursor(mycursor);
		
		jp_disk_1.add(jl1_1);
		jp_disk_1.add(jl1_2);
		jp_disk_1.add(jl1_3);
		jp_disk_1.add(jl1_4);
		jp_disk_1.add(jl1_5);
		
		jp_disk_2.add(jl2_1);
		jp_disk_2.add(jl2_2);
		jp_disk_2.add(jl2_3);
		jp_disk_2.add(jl2_4);
		jp_disk_2.add(jl2_5);
		
		jp_disk_3.add(jl3_1);
		jp_disk_3.add(jl3_2);
		jp_disk_3.add(jl3_3);
		jp_disk_3.add(jl3_4);
		jp_disk_3.add(jl3_5);
		
		jp_disk_4.add(jl4_1);
		jp_disk_4.add(jl4_2);
		jp_disk_4.add(jl4_3);
		jp_disk_4.add(jl4_4);
		jp_disk_4.add(jl4_5);
		
		jp_disk_5.add(jl5_1);
		jp_disk_5.add(jl5_2);
		jp_disk_5.add(jl5_3);
		jp_disk_5.add(jl5_4);
		jp_disk_5.add(jl5_5);
		
		
		jp_disk.add(new JLabel(""));
		jp_disk.add(new JLabel(""));
		jp_disk.add(new JLabel(""));
		jp_disk.add(jp_disk_1);
		jp_disk.add(jp_disk_2);
		jp_disk.add(jp_disk_3);
		jp_disk.add(jp_disk_4);
		jp_disk.add(jp_disk_5);
		jp_disk.add(new JLabel(""));
		
		jp_left_1 = new JPanel();
		jp_left_2 = new JPanel();
		
		jp_left_bg.setLayout(new BorderLayout());
		jp_left_bg.add(jp_disk,BorderLayout.EAST);

		jp_right.add(jp_right_bg);
		
		jsp=new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, false, jp_left_bg, jp_right_bg);
		jsp.setDividerLocation(Tools.width*7/10);
		jsp.setDividerSize(0);
	}
	public OrderIndex()
	{
		ct = this.getContentPane();
		//调养初始化菜单函数
		this.initMenu();
		//调养初始化工具栏函数
		this.initToolBar();
		//调养初始化主窗口函数
		this.initSplitPane();
		
		//初始化底部状态栏
		jbottom = new JPanel(new BorderLayout());
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
		this.setLayout(new BorderLayout());
		
		//添加组件
		this.setJMenuBar(jmb);
		ct.add(jtb,	 BorderLayout.NORTH);
		ct.add(jsp,	 BorderLayout.CENTER);
		ct.add(jbottom,BorderLayout.SOUTH);

		//设置窗体
		this.setTitle("传承饮食文化,传播特色美味!");
		this.setIconImage(new ImageIcon("images/title.gif").getImage());
		this.setSize(Tools.width, Tools.height-35);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jl1_1)
		{
			
		}else if(e.getSource()==jl1_2)
		{
			
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
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jp_right_jb1)
		{
			//预定
			//处理预定
			String sql = "insert into reserve (reservenumber,diskid,custname,custphone) values(?,?,?,?)";
			Vector<String> field = new Vector<String>();
			field.add("订单编号");
			field.add("餐 桌 号");
			field.add("顾客名字");
			field.add("顾客电话");
			od = new ReserveDialog(sql, field, this, "预约订餐");
		}else if(e.getSource()==jp_right_jb2)
		{
			//退订
			String sql = "delete from reserve where reservenumber=?";
			Vector<String> field = new Vector<String>();
			field.add("请输入订单编号");
			UnsubscribeDialog od = new UnsubscribeDialog(sql,field,this,"退 订 界 面");
			
		}else if(e.getSource()==jp_right_jb3)
		{
			//点餐
			new OrderDishDialog();
			
		}else if(e.getSource()==jp_right_jb4)
		{
			//结账
			new CheckoutDialog();
			
		}else if(e.getSource()==jmi1||e.getSource()==jb2)
		{
			//切换用户
			this.dispose();
			new Login();
		}else if(e.getSource()==jmi2)
		{
			//重新登录
			this.dispose();
			new Login();
		}else if(e.getSource()==jmi3)
		{
			//退出系统
			System.exit(0);
		}else if(e.getSource()==jb1)
		{
			
			if((Tools.position.equals("经理")||Tools.position.equals("主管")||Tools.position.equals("系统管理员")))
			{
				this.dispose();
				new Window1();
			}else {
				JOptionPane.showMessageDialog(this, "     用户权限不够");
				return;
			}
		}else if(e.getSource()==jb3)
		{
			//帮助
			new HelpInfo();
			
		}
	}
}
