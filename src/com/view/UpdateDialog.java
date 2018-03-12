/**
 * 修改用户窗口
 */
package com.view;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.sql.*;
import javax.swing.*;
import com.Tools.*;
import com.model.*;
import com.db.*;
public class UpdateDialog extends JDialog implements ActionListener{

	//获取构造函数的值
	String sql;
	Vector<String> paras;
	SqlHelper sh;
	EmpModel em;
	
	Vector<String> colName;
	Vector<String> colValue;
	Vector<JPanel> jps;
	//获得创建JTextField的向量
	Vector<JTextField> jtextfs;
	//创建JPanel布局
	JPanel jp;
	JPanel jp_button;
	JButton  jb1,jcancel;
	
	//创建本窗口的大小
	int width;
	int height;
	int field_size;
	//获得父亲窗口
	JPanel parent;
	String title;
	String falg;//用于判别父亲类型
	String insertSql;//执行更新的sql语句
	public UpdateDialog(String sql,Vector<String> paras ,JPanel parent,String title)
	{
		this.parent=parent;
		this.sureParent();
		this.title=title;
		this.width=400;
		this.sql=sql;
		this.paras=paras;
		sh = new SqlHelper();
		jtextfs = new Vector<JTextField>();
		jps = new Vector<JPanel>();
		colName = new Vector<String>();
		colValue = new Vector<String>();
		ResultSet rs=sh.queryExecute(sql, paras);
		try {
			while(rs.next())
			{
				ResultSetMetaData rsmd=rs.getMetaData();
				
				for(int i=0;i<rsmd.getColumnCount();i++)
				{
					colName.add(rsmd.getColumnName(i+1));
					colValue.add(rs.getString(i+1));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sh.close();
		}
		this.field_size=colName.size();
		this.height=100+25*this.field_size;
		for(int i=0;i<colName.size();i++)
		{
			JLabel colJlab=new JLabel(colName.get(i));
			JTextField jtField = new JTextField(15);
			jtField.setText(colValue.get(i));
			if(i==0)
			{
				jtField.setEditable(false);
			}	
			jtextfs.add(jtField);
			JPanel p1=new JPanel();
			p1.add(colJlab);
			p1.add(jtField);
			jps.add(p1);
		}
		jp = new JPanel(new GridLayout(field_size+1, 1));
		for(int i=0;i<field_size;i++)
		{
			jp.add(jps.get(i));
		}
		jp_button =new JPanel();
		jb1 = new JButton("修改");
		jb1.addActionListener(this);
		jcancel = new JButton("取消");
		jcancel.addActionListener(this);
		jp_button.add(jb1);
		jp_button.add(jcancel);
		jp.add(jp_button);
		
		this.add(jp);
		this.setSize(this.width,this.height);
		this.setTitle(title);
		this.setIconImage(new ImageIcon("images/title.gif").getImage());
		this.setLocation(Tools.width/2-width/2, Tools.height/2-height/2);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public void sureParent()
	{
		if(this.parent.getName().equals("人事管理"))
		{
			falg="人事管理";
			insertSql= "update users set userid=?,username=?,usersex=?,userage=?,userpassword=?,userposition=? where userid=?";
		}else if(this.parent.getName().equals("登陆管理"))
		{
			falg="登陆管理";
			insertSql= "update login set userid=?,username=?,userpassword=?,userposition=? where userid=?";
		}else if(this.parent.getName().equals("菜谱管理"))
		{
			falg="菜谱管理";
			insertSql= "update dishes set dishid=?,dishname=?,dishprice=?,dishpop=?,dishclass=? where dishid=?";
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			paras=new Vector<String>();
			for(int i=0;i<this.field_size;i++)
			{
				paras.add(this.jtextfs.get(i).getText().trim());
			}
			paras.add(this.jtextfs.get(0).getText().trim());
			em = new EmpModel();
			boolean res=em.updateInfo(insertSql, paras);
			if(res)
			{
				JOptionPane.showMessageDialog(this, "     修改成功");
				if(falg.equals("人事管理"))
				{
					((EmpInfo)this.parent).refresh();
				}else if(falg.equals("登陆管理"))
				{
					((LoginInfo)this.parent).refresh();
				}else if(falg.equals("菜谱管理"))
				{
					((DishesInfo)this.parent).refresh();
				}
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "     修改失败");
			}
		}else if(e.getSource()==jcancel)
		{
			this.dispose();
		}
		
	}
}
