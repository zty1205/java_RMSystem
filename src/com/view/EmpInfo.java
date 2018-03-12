/**
 * 这是用于人事管理的界面
 */
package com.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.Tools.*;
import com.model.*;

public class EmpInfo extends JPanel implements ActionListener,MouseListener{
	JTable jt1;
	EmpModel em;
	JScrollPane jsp;
	JPanel jp3_1_top,jp3_1_bottom;
	JLabel jp3_1_top_jl,jp3_1_bottom_jl;
	JTextField jp3_1_top_jtf;
	JButton jp3_1_top_jb,jp3_1_bottom_jb1,jp3_1_bottom_jb2,jp3_1_bottom_jb3,jp3_1_bottom_jb4;
	String sql;
	Vector<String> paras;
	AddDialog addDialog;//添加面板
	UpdateDialog ud;//修改面板
	public  EmpInfo()
	{
		//人事登记面板
		jp3_1_top = new JPanel();
		jp3_1_top.setPreferredSize(new Dimension(Tools.width, 40));
		jp3_1_top_jl = new JLabel("请输入姓名(员工号或者职位): ");
		jp3_1_top_jl.setFont(Tools.f_14);
		jp3_1_top_jtf = new JTextField(15);
		jp3_1_top_jb = new JButton("刷新");
		jp3_1_top_jb.addActionListener(this);
		jp3_1_top_jb.setFont(Tools.f_12);
		jp3_1_top.add(jp3_1_top_jl);
		jp3_1_top.add(jp3_1_top_jtf);
		jp3_1_top.add(jp3_1_top_jb);
		
		jp3_1_bottom = new JPanel(new BorderLayout());
		jp3_1_bottom.setPreferredSize(new Dimension(Tools.width, 40));
		jp3_1_bottom_jl = new JLabel(" 共 有 0 条 记 录 ");
		jp3_1_bottom_jl.setFont(Tools.f_14);
		JPanel jp3_1_bottom_east =  new JPanel();
		jp3_1_bottom_jb1 = new JButton("详细信息");
		jp3_1_bottom_jb1.setEnabled(false);
		jp3_1_bottom_jb1.addActionListener(this);
		jp3_1_bottom_jb1.setFont(Tools.f_12);
		jp3_1_bottom_jb2 = new JButton("添加");
		jp3_1_bottom_jb2.addActionListener(this);
		jp3_1_bottom_jb2.setFont(Tools.f_12);
		jp3_1_bottom_jb3 = new JButton("修改");
		jp3_1_bottom_jb3.setEnabled(false);
		jp3_1_bottom_jb3.addActionListener(this);
		jp3_1_bottom_jb3.setFont(Tools.f_12);
		jp3_1_bottom_jb4 = new JButton("删除");
		jp3_1_bottom_jb4.setEnabled(false);
		jp3_1_bottom_jb4.addActionListener(this);
		jp3_1_bottom_jb4.setFont(Tools.f_12);
		jp3_1_bottom_east.add(jp3_1_bottom_jb1);
		jp3_1_bottom_east.add(jp3_1_bottom_jb2);
		jp3_1_bottom_east.add(jp3_1_bottom_jb3);
		jp3_1_bottom_east.add(jp3_1_bottom_jb4);
		jp3_1_bottom.add(jp3_1_bottom_jl,BorderLayout.WEST);
		jp3_1_bottom.add(jp3_1_bottom_east,BorderLayout.EAST);
	
		jt1=new JTable(em);
		this.refresh();
		jt1.setRowHeight(22);
		jt1.addMouseListener(this);
		jsp = new JScrollPane(jt1);
		jsp.setBorder(BorderFactory.createTitledBorder(Tools.getTitleBorder("人 事 管 理")));
		jp3_1_bottom_jl.setText(" 共 有 "+em.getRowCount()+" 条 记 录 ");
		
		this.setLayout(new BorderLayout());
		this.add(jp3_1_top,BorderLayout.NORTH);
		this.add(jp3_1_bottom,BorderLayout.SOUTH);
		this.add(jsp,BorderLayout.CENTER);
		this.setName("人事管理");
		this.setVisible(true);
	}
	
	//刷新model
	public void refresh()
	{
		em = new  EmpModel();
		sql = "select userid 员工号 ,username 姓名,usersex 性别,userposition 职位 from users where 1=? ";
		paras = new Vector<String>();
		paras.add("1");
		em.selectInfo(sql,paras);
		jt1.setModel(em);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//刷新按钮的监听处理
		if(e.getSource()==this.jp3_1_top_jb)
		{
			String id=this.jp3_1_top_jtf.getText().trim();
			if(id.length()>0)
			{
				sql = "select userid 员工号 ,username 姓名,usersex 性别,userposition 职位 from users where userid=? or username like ? or userposition like ?";
				paras = new Vector<String>();
				paras.add(id);
				paras.add(id);
				paras.add(id);
				em=new EmpModel();
				em.selectInfo(sql , paras);
				jt1.setModel(em);
				jp3_1_top_jtf.setText("");
			}else{
				this.refresh();
			}
			jp3_1_bottom_jl.setText(" 共 有 "+em.getRowCount()+" 条 记 录 ");
		}else if(e.getSource()==this.jp3_1_bottom_jb2)
		{
			//添加按钮的监听处理
			sql = "insert into users values (?,?,?,?,?,?)";
			paras = new Vector<String>();
			paras.add("员工号");
			paras.add("姓  名");
			paras.add("性  别");
			paras.add("年  龄");
			paras.add("密  码");
			paras.add("职  位");
			addDialog=new AddDialog(sql, paras,this,"添 加 用 户");
			return;
		}else if(e.getSource()==this.jp3_1_bottom_jb4)
		{
			//删除按钮的监听处理
			int selectIndex=this.jt1.getSelectedRow();
			paras = new Vector<String>();
			paras.add((String) this.jt1.getModel().getValueAt(selectIndex, 0));
			sql = "delete from users where userid=?";
			em=new EmpModel();
			em.updateInfo(sql, paras);
			this.refresh();
		}else if(e.getSource()==this.jp3_1_bottom_jb3)
		{
			//修改按钮的监听处理
			int selectIndex=this.jt1.getSelectedRow();
			if(selectIndex>-1)
			{
				String id = (String) this.jt1.getModel().getValueAt(selectIndex, 0);
				sql = "select userid 员工号 ,username 姓名,usersex 性别,userage 年龄,userpassword 密码,userposition 职位 from users where userid=?";
				paras = new Vector<String>();
				paras.add(id);
				ud = new UpdateDialog(sql,paras,this,"修 改 用 户");
			}else if (selectIndex==-1)
			{
				JOptionPane.showMessageDialog(this, "请选中需要修改的用户");
			}
		}else if(e.getSource()==this.jp3_1_bottom_jb1)
		{
			//详细信息按钮的监听处理
			int selectIndex=this.jt1.getSelectedRow();
			if(selectIndex>-1)
			{
				String id = (String) this.jt1.getModel().getValueAt(selectIndex, 0);
				sql = "select userid 员工号 ,username 姓名,usersex 性别,userage 年龄,userpassword 密码,userposition 职位 from users where userid=?";
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
		if(e.getSource()==this.jt1)
		{
			jp3_1_bottom_jb1.setEnabled(true);
			jp3_1_bottom_jb3.setEnabled(true);
			jp3_1_bottom_jb4.setEnabled(true);
			/**
			 * 获取当前点击的行数
			 */
//			System.out.println(jt1.getSelectedRow());
//			System.out.println(jt1.getModel().getValueAt(jt1.getSelectedRow(), 0));
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
