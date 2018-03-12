package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.Tools.*;
import com.model.*;

public class DishesInfo extends JPanel implements ActionListener,MouseListener {
	JTable jt3;
	DishModel dm;
	JScrollPane jsp;
	JPanel jp3_3_top,jp3_3_bottom;
	JLabel jp3_3_top_jl,jp3_3_bottom_jl;
	JTextField jp3_3_top_jtf;
	JButton jp3_3_top_jb,jp3_3_bottom_jb1,jp3_3_bottom_jb2,jp3_3_bottom_jb3,jp3_3_bottom_jb4;
	String sql;
	Vector<String> paras;
	AddDialog addDialog;//添加菜品面板
	UpdateDialog ud;//修改菜品面板
	public DishesInfo()
	{
		//菜谱管理面板
		jp3_3_top = new JPanel();
		jp3_3_top.setPreferredSize(new Dimension(Tools.width, 40));
		jp3_3_top_jl = new JLabel("请输入菜名(菜品编号或者菜品类别): ");
		jp3_3_top_jl.setFont(Tools.f_14);
		jp3_3_top_jtf = new JTextField(15);
		jp3_3_top_jb = new JButton("刷新");
		jp3_3_top_jb.addActionListener(this);
		jp3_3_top_jb.setFont(Tools.f_12);
		jp3_3_top.add(jp3_3_top_jl);
		jp3_3_top.add(jp3_3_top_jtf);
		jp3_3_top.add(jp3_3_top_jb);
		
		jp3_3_bottom = new JPanel(new BorderLayout());
		jp3_3_bottom.setPreferredSize(new Dimension(Tools.width, 40));
		jp3_3_bottom_jl = new JLabel(" 共 有 0 条 记 录 ");
		jp3_3_bottom_jl.setFont(Tools.f_14);
		JPanel jp3_3_bottom_east =  new JPanel();
		jp3_3_bottom_jb1 = new JButton("详细信息");
		jp3_3_bottom_jb1.setEnabled(false);
		jp3_3_bottom_jb1.addActionListener(this);
		jp3_3_bottom_jb1.setFont(Tools.f_12);
		jp3_3_bottom_jb2 = new JButton("添加");
		jp3_3_bottom_jb2.addActionListener(this);
		jp3_3_bottom_jb2.setFont(Tools.f_12);
		jp3_3_bottom_jb3 = new JButton("修改");
		jp3_3_bottom_jb3.setEnabled(false);
		jp3_3_bottom_jb3.addActionListener(this);
		jp3_3_bottom_jb3.setFont(Tools.f_12);
		jp3_3_bottom_jb4 = new JButton("删除");
		jp3_3_bottom_jb4.setEnabled(false);
		jp3_3_bottom_jb4.addActionListener(this);
		jp3_3_bottom_jb4.setFont(Tools.f_12);
		jp3_3_bottom_east.add(jp3_3_bottom_jb1);
		jp3_3_bottom_east.add(jp3_3_bottom_jb2);
		jp3_3_bottom_east.add(jp3_3_bottom_jb3);
		jp3_3_bottom_east.add(jp3_3_bottom_jb4);
		jp3_3_bottom.add(jp3_3_bottom_jl,BorderLayout.WEST);
		jp3_3_bottom.add(jp3_3_bottom_east,BorderLayout.EAST);
	
		jt3=new JTable(dm);
		this.refresh();
		jt3.setRowHeight(22);
		jt3.addMouseListener(this);
		jsp = new JScrollPane(jt3);
		jsp.setBorder(BorderFactory.createTitledBorder(Tools.getTitleBorder("菜 谱 管 理")));
		jp3_3_bottom_jl.setText(" 共 有 "+dm.getRowCount()+" 条 记 录 ");
		
		this.setLayout(new BorderLayout());
		this.add(jp3_3_top,BorderLayout.NORTH);
		this.add(jp3_3_bottom,BorderLayout.SOUTH);
		this.add(jsp,BorderLayout.CENTER);
		this.setName("菜谱管理");
		this.setVisible(true);
	}
	
	//刷新model
	public void refresh()
	{
		dm = new  DishModel();
		sql = "select dishid 菜品编号 ,dishname 菜品名字,dishprice 菜品价格,dishpop 菜品人气,dishclass 菜品类别 from dishes where 1=? ";
		paras = new Vector<String>();
		paras.add("1");
		dm.selectInfo(sql,paras);
		jt3.setModel(dm);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//刷新按钮的监听处理
		if(e.getSource()==this.jp3_3_top_jb)
		{
			String id=this.jp3_3_top_jtf.getText().trim();
			if(id.length()>0)
			{
				sql = "select dishid 菜品编号 ,dishname 菜品名字,dishprice 菜品价格,dishpop 菜品人气,dishclass 菜品类别 from dishes where  dishid=? or dishname like ? or dishclass like ?";
				paras = new Vector<String>();
				paras.add(id);
				paras.add(id);
				paras.add(id);
				dm=new DishModel();
				dm.selectInfo(sql , paras);
				jt3.setModel(dm);
				jp3_3_top_jtf.setText("");
			}else{
				this.refresh();
			}
			jp3_3_bottom_jl.setText(" 共 有 "+dm.getRowCount()+" 条 记 录 ");
		}else if(e.getSource()==this.jp3_3_bottom_jb2)
		{
			//添加按钮的监听处理
			sql = "insert into users values (?,?,?,?,?)";
			paras = new Vector<String>();
			paras.add("菜品编号");
			paras.add("菜品名字");
			paras.add("菜品价格");
			paras.add("菜品人气");
			paras.add("菜品类别");

			addDialog=new AddDialog(sql, paras,this,"添 加 菜 品");
			return;
		}else if(e.getSource()==this.jp3_3_bottom_jb4)
		{
			//删除按钮的监听处理
			int selectIndex=this.jt3.getSelectedRow();
			paras = new Vector<String>();
			paras.add((String) this.jt3.getModel().getValueAt(selectIndex, 1));
			sql = "delete from dishes where dishname like ?";
			dm=new DishModel();
			dm.updateInfo(sql, paras);
		}else if(e.getSource()==this.jp3_3_bottom_jb3)
		{
			//修改按钮的监听处理
			int selectIndex=this.jt3.getSelectedRow();
			if(selectIndex>-1)
			{
				String name = (String) this.jt3.getModel().getValueAt(selectIndex, 1);
				sql = "select dishid 菜品编号 ,dishname 菜品名字,dishprice 菜品价格,dishpop 菜品人气,dishclass 菜品类别 from dishes where  dishname=?";
				paras = new Vector<String>();
				paras.add(name);
				ud = new UpdateDialog(sql,paras,this,"修 改 菜 品");
			}else if (selectIndex==-1)
			{
				JOptionPane.showMessageDialog(this, "请选中需要修改的菜品");
			}
		}else if(e.getSource()==this.jp3_3_bottom_jb1)
		{
			//详细信息按钮的监听处理
			int selectIndex=this.jt3.getSelectedRow();
			if(selectIndex>-1)
			{
				String name = (String) this.jt3.getModel().getValueAt(selectIndex, 1);
				sql = "select dishid 菜品编号 ,dishname 菜品名字,dishprice 菜品价格,dishpop 菜品人气,dishclass 菜品类别 from dishes where  dishname=?";
				paras = new Vector<String>();
				paras.add(name);
				showAllInfo sa = new showAllInfo(sql,paras,this,"菜 品 详 细 信 息");
			}else if (selectIndex==-1)
			{
				JOptionPane.showMessageDialog(this, "请选中需要显示的菜品");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jt3)
		{
			jp3_3_bottom_jb1.setEnabled(true);
			jp3_3_bottom_jb3.setEnabled(true);
			jp3_3_bottom_jb4.setEnabled(true);
			/**
			 * 获取当前点击的行数
			 */
//					System.out.println(jt3.getSelectedRow());
//					System.out.println(jt3.getModel().getValueAt(jt3.getSelectedRow(), 0));
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
}
