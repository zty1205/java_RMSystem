package com.view;

import javax.swing.*;

import com.Tools.Tools;
import com.model.CheckOutModel;
import com.model.OrderModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CheckoutDialog extends JDialog implements ActionListener{

	//三个位置的JPanel
	JPanel jtop,jmiddle,jbottom;
	
	JLabel lab_1;
	JTextField jtf;
	JButton jselect;

	JTable jt;
	JScrollPane jsp;
	JLabel lab_sum;
	JPanel jp_sum;
	int sum;
	
	JButton jcon,jcancel;
	
	//数据库操作所需的创建
	String menuid;
	CheckOutModel com;
	Vector<String> paras;
	
	//本窗口的大小
	int width=600,height;
	//用于调试
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		CheckoutDialog cd = new CheckoutDialog();
//	}
	public void init()
	{
		//顶部搜索栏创建
		jtop = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		lab_1 = new JLabel("输入订单号(预定号)");
		lab_1.setFont(Tools.f_14);
		jtf = new JTextField(12);
		jselect = new JButton("查询");
		jselect.addActionListener(this);
		jselect.setFont(Tools.f_14);
		jtop.add(lab_1);
		jtop.add(jtf);
		jtop.add(jselect);
		
		//中间点菜单创建
		jmiddle = new JPanel(new BorderLayout());
		jt = new JTable();
		jt.setRowHeight(25);
		jsp = new JScrollPane(jt);
		jsp.setBorder(BorderFactory.createTitledBorder(Tools.getTitleBorder("点 菜 单")));
		lab_sum = new JLabel();
		lab_sum.setFont(Tools.heightLight);
		jp_sum = new JPanel();
		jp_sum.add(lab_sum);
		jmiddle.add(jsp,"Center");
		
		//底部状态栏创建
		jbottom = new JPanel(new FlowLayout(FlowLayout.CENTER,30,10));
		jcon = new JButton("结账");
		jcon.setFont(Tools.f_14);
		jcon.addActionListener(this);
		jcancel  = new JButton("取消付款");
		jcancel.setFont(Tools.f_14);
		jcancel.addActionListener(this);
		jbottom.add(jcon);
		jbottom.add(jcancel);
	}
	public CheckoutDialog()
	{
		//初始化组件
		this.init();
		
		//设置布局
		this.setLayout(new BorderLayout());
		//添加组件
		this.add(jtop,"North");

		this.add(jbottom,"South");
		
		//设置窗体
		height = 100+20*2;
		this.setVisible(true);
		this.setTitle("付款界面");
		this.setSize(width, height);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("images/title.gif").getImage());
		this.setLocation(Tools.width/2-width/2, Tools.height/2-height/2);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jselect)
		{
			//查询订单号  显示点菜单
			menuid = jtf.getText().trim();
			//如果没有输入订单号
			if(menuid.length()==0)
			{
				JOptionPane.showMessageDialog(this, "请先输入订单号");
			}else if(menuid.length()>0)
			{
				String sql = "select dishname 菜名,dishprice 价格,dishnumber 数量 from menu where menuid = ?";
				paras = new Vector<String>();
				paras.add(menuid);
				com = new CheckOutModel();
				com.selectInfo(sql, paras);
				if(com.getRowCount()>0)
				{
					//订单号存在 
					//显示订单并修改窗口大小
					jt.setModel(com);
					this.add(jmiddle,"Center");
					if(com.getColumnCount()>8)
					{
						height = 140+20*com.getColumnCount();
					}else if(com.getColumnCount()<=8)
					{
						height = 500;
					}
					//计算总金额
					String p;
					for(int i=0;i<com.getRowCount();i++)
					{
						p=com.getValueAt(i, 3).toString();
						sum+=Integer.parseInt(p.substring(0,p.length()-1));
					}
					lab_sum.setText("总价为"+sum+"元");
					jmiddle.add(jp_sum,"South");
					
					this.setSize(width, height);
					jsp.setPreferredSize(new Dimension(width-80, height-200));
					this.setLocation(Tools.width/2-width/2, Tools.height/2-height/2);
				}else {
					JOptionPane.showMessageDialog(this, "订单号"+menuid+"不存在，请重新输入");
					jtf.setText("");
					jtf.setFocusable(true);
				}
			}
		}
		else if(e.getSource()==jcon)
		{

			Boolean isInsert = false;
			//订单总金额插入流水表 用于报表统计
			String sql = "insert into turnover (money) values(?)";
			paras = new Vector<String>();
			paras.add(sum+"");
			isInsert = com.updateInfo(sql, paras);
			if(isInsert)
			{
				JOptionPane.showMessageDialog(this, "付款成功,欢迎下次光临");
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "付款失败,请再次确认");
			}
		}else if(e.getSource()==jcancel)
		{
			this.dispose();
		}
	}
	

}
