package com.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.Tools.*;
import com.model.*;

public class LoginInfo extends JPanel implements ActionListener,MouseListener {

	JTable jt2;
	UserModel um;
	JScrollPane jsp;
	JPanel jp3_2_top,jp3_2_bottom;
	JLabel jp3_2_top_jl,jp3_2_bottom_jl;
	JTextField jp3_2_top_jtf;
	JButton jp3_2_top_jb,jp3_2_bottom_jb1,jp3_2_bottom_jb2,jp3_2_bottom_jb3,jp3_2_bottom_jb4;
	String sql;
	Vector<String> paras;
	AddDialog addDialog;//添加面板
	UpdateDialog ud;//修改面板
	public LoginInfo()
	{
		//登陆管理面板
		jp3_2_top = new JPanel();
		jp3_2_top.setPreferredSize(new Dimension(Tools.width, 40));
		jp3_2_top_jl = new JLabel("请输入姓名(员工号或者职位): ");
		jp3_2_top_jl.setFont(Tools.f_14);
		jp3_2_top_jtf = new JTextField(15);
		jp3_2_top_jb = new JButton("刷新");
		jp3_2_top_jb.addActionListener(this);
		jp3_2_top_jb.setFont(Tools.f_12);
		jp3_2_top.add(jp3_2_top_jl);
		jp3_2_top.add(jp3_2_top_jtf);
		jp3_2_top.add(jp3_2_top_jb);
		
		jp3_2_bottom = new JPanel(new BorderLayout());
		jp3_2_bottom.setPreferredSize(new Dimension(Tools.width, 40));
		jp3_2_bottom_jl = new JLabel(" 共 有 0 条 记 录 ");
		jp3_2_bottom_jl.setFont(Tools.f_14);
		JPanel jp3_2_bottom_east =  new JPanel();
		jp3_2_bottom_jb1 = new JButton("详细信息");
		jp3_2_bottom_jb1.setEnabled(false);
		jp3_2_bottom_jb1.addActionListener(this);
		jp3_2_bottom_jb1.setFont(Tools.f_12);
		jp3_2_bottom_jb2 = new JButton("添加");
		jp3_2_bottom_jb2.addActionListener(this);
		jp3_2_bottom_jb2.setFont(Tools.f_12);
		jp3_2_bottom_jb3 = new JButton("修改");
		jp3_2_bottom_jb3.setEnabled(false);
		jp3_2_bottom_jb3.addActionListener(this);
		jp3_2_bottom_jb3.setFont(Tools.f_12);
		jp3_2_bottom_jb4 = new JButton("删除");
		jp3_2_bottom_jb4.setEnabled(false);
		jp3_2_bottom_jb4.addActionListener(this);
		jp3_2_bottom_jb4.setFont(Tools.f_12);
		jp3_2_bottom_east.add(jp3_2_bottom_jb1);
		jp3_2_bottom_east.add(jp3_2_bottom_jb2);
		jp3_2_bottom_east.add(jp3_2_bottom_jb3);
		jp3_2_bottom_east.add(jp3_2_bottom_jb4);
		jp3_2_bottom.add(jp3_2_bottom_jl,BorderLayout.WEST);
		jp3_2_bottom.add(jp3_2_bottom_east,BorderLayout.EAST);
	
		jt2=new JTable(um);
		this.refresh();
		jt2.setRowHeight(22);
		jt2.addMouseListener(this);
		jsp = new JScrollPane(jt2);
		jsp.setBorder(BorderFactory.createTitledBorder(Tools.getTitleBorder("登 陆 管 理")));
		jp3_2_bottom_jl.setText(" 共 有 "+um.getRowCount()+" 条 记 录 ");
		
		this.setLayout(new BorderLayout());
		this.add(jp3_2_top,BorderLayout.NORTH);
		this.add(jp3_2_bottom,BorderLayout.SOUTH);
		this.add(jsp,BorderLayout.CENTER);
		this.setName("登陆管理");
		this.setVisible(true);
	}
	
	//刷新model
	public void refresh()
	{
		um = new  UserModel();
		sql = "select userid 员工号 ,username 姓名,userposition 职位 from login where 1=?  ";
		paras = new Vector<String>();
		paras.add("1");
		um.selectInfo(sql,paras);
		jt2.setModel(um);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//刷新按钮的监听处理
		if(e.getSource()==this.jp3_2_top_jb)
		{
			String id=this.jp3_2_top_jtf.getText().trim();
			if(id.length()>0)
			{
				sql = "select userid 员工号 ,username 姓名,userposition 职位 from login where userid=? or username like ? or userposition like ?";
				paras = new Vector<String>();
				paras.add(id);
				paras.add(id);
				paras.add(id);
				um=new UserModel();
				um.selectInfo(sql , paras);
				jt2.setModel(um);
				jp3_2_top_jtf.setText("");
			}else{
				this.refresh();
			}
			jp3_2_bottom_jl.setText(" 共 有 "+um.getRowCount()+" 条 记 录 ");
		}else if(e.getSource()==this.jp3_2_bottom_jb2)
		{
			//添加按钮的监听处理
			sql = "insert into login values (?,?,?,?)";
			paras = new Vector<String>();
			paras.add("员工号");
			paras.add("姓 名");
			paras.add("密 码");
			paras.add("职位");

			addDialog=new AddDialog(sql, paras,this,"添 加 用 户");
			return;
		}else if(e.getSource()==this.jp3_2_bottom_jb4)
		{
			//删除按钮的监听处理
			int selectIndex=this.jt2.getSelectedRow();
			paras = new Vector<String>();
			paras.add((String) this.jt2.getModel().getValueAt(selectIndex, 0));
			sql = "delete from login where dishname like ?";
			um=new UserModel();
			um.updateInfo(sql, paras);
		}else if(e.getSource()==this.jp3_2_bottom_jb3)
		{
			//修改按钮的监听处理
			int selectIndex=this.jt2.getSelectedRow();
			if(selectIndex>-1)
			{
				String id = (String) this.jt2.getModel().getValueAt(selectIndex, 0);
				sql = "select userid 员工号 ,username 姓名,userpassword 密码,userposition 职位 from login where userid=? ";
				paras = new Vector<String>();
				paras.add(id);
				ud = new UpdateDialog(sql,paras,this,"修 改 用 户");
			}else if (selectIndex==-1)
			{
				JOptionPane.showMessageDialog(this, "请选中需要修改的用户");
			}
		}else if(e.getSource()==this.jp3_2_bottom_jb1)
		{
			//详细信息按钮的监听处理
			int selectIndex=this.jt2.getSelectedRow();
			if(selectIndex>-1)
			{
				String id = (String) this.jt2.getModel().getValueAt(selectIndex, 0);
				sql = "select userid 员工号 ,username 姓名,userpassword 密码,userposition 职位 from login where userid=?";
				paras = new Vector<String>();
				paras.add(id);
				showAllInfo sa = new showAllInfo(sql,paras,this,"用 户 详 细 信 息");
			}else if (selectIndex==-1)
			{
				JOptionPane.showMessageDialog(this, "请选中需要显示的用户");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jt2)
		{
			jp3_2_bottom_jb1.setEnabled(true);
			jp3_2_bottom_jb3.setEnabled(true);
			jp3_2_bottom_jb4.setEnabled(true);
			/**
			 * 获取当前点击的行数
			 */
//					System.out.println(jt2.getSelectedRow());
//					System.out.println(jt2.getModel().getValueAt(jt2.getSelectedRow(), 0));
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
