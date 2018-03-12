/**
 * 通用添加对话面板。 输入添加字段的向量,返回填写字段的内容
 */
package com.view;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import com.Tools.*;
import com.model.*;

public class AddDialog extends JDialog implements ActionListener {
	
	//获取字段向量，sql语句
	Vector<String> field;
	String sql;
	//交给表模型的向量
	Vector<String> paras;
	int width;
	int height;
	int field_size;
	JButton jb1,jcancel;
	//获得创建JPanel的向量
	Vector<JPanel> jps;
	//获得创建JTextField的向量
	Vector<JTextField> jtfs;
	//创建JPanel布局
	JPanel jp;
	JPanel jp_button;
	EmpModel em;
	JPanel parent;
	String title;
	public AddDialog(String sql, Vector<String> field, JPanel parent ,String title )
	{
		this.parent=parent;
		this.field=field;
		this.sql=sql;
		this.title=title;
		
		//初始化面板
		this.initDialog();
		
		
		this.add(jp);
		this.setSize(width,height);
		this.setTitle(title);
		this.setIconImage(new ImageIcon("images/title.gif").getImage());
		this.setLocation(Tools.width/2-width/2, Tools.height/2-height/2);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public void initDialog()
	{
		this.width=400;
		this.height=100+25*this.field.size();
		this.field_size=field.size();
		//创建组件
		jb1 = new JButton("添加");
		jcancel = new JButton("取消");
		jp_button = new JPanel();
		jp_button.add(jb1);
		jp_button.add(jcancel);
		jps=new Vector<JPanel>();
		jtfs=new Vector<JTextField>();
		//注册监听
		jb1.addActionListener(this);
		jcancel.addActionListener(this);
		
		
		for(int i=0;i<field_size;i++)
		{
			JLabel jl=new JLabel(field.get(i));
			jl.setFont(Tools.f_14);
			JTextField jtf=new JTextField(15);
			JPanel p1=new JPanel();
			p1.add(jl);
			p1.add(jtf);
			jtfs.add(jtf);
			jps.add(p1);
		}
		
		jp = new JPanel(new GridLayout(field_size+1, 1));
		for(int i=0;i<field_size;i++)
		{
			jp.add(jps.get(i));
		}
		jp.add(jp_button);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jcancel)
		{
			this.dispose();
		}else if(e.getSource()==this.jb1)
		{
			paras=new Vector<String>();
			for(int i=0;i<this.field_size;i++)
			{
				paras.add(this.jtfs.get(i).getText().trim());
			}
			em = new EmpModel();
			boolean res=em.updateInfo(sql, paras);
			if(res)
			{
				JOptionPane.showMessageDialog(this, "     添加成功");
				if(this.parent.getName().equals("人事管理"))
				{
					((EmpInfo)this.parent).refresh();
				}else if(this.parent.getName().equals("登陆管理"))
				{
					((LoginInfo)this.parent).refresh();
				}else if(this.parent.getName().equals("菜谱管理"))
				{
					((DishesInfo)this.parent).refresh();
				}
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "     添加失败");
			}
		}
	}
}
