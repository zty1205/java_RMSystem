/**
 * 用户登录界面。
 */

package com.view;

import java.awt.*;
import com.Tools.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import com.model.UserModel;
import java.sql.*;
import java.util.*;

//登录界面.继承JDialog
public class Login extends JFrame implements ActionListener {
	
	public static void main(String []args)
	{
		Login l=new Login();
	}
	//定义组件
	JLabel jl1,jl2,jl3;
	JTextField jname;
	JPasswordField jpasswd;
	JButton jcon,jcancel;
	
	//构造函数
	public Login()
	{
		//本窗口不设置布局
		this.setLayout(null);
		//得到本窗口的容器
		Container ct=this.getContentPane();
		
		BackImg bimg=new BackImg();
		bimg.setBounds(0, 0, 500, 500);
		
		//创建组件
		jl1 = new JLabel("请输入用户名：");
		Font f1=new Font("楷体",Font.PLAIN, 20);
		jl1.setFont(f1);
		jl1.setBounds(90, 260, 160,30);  //30
		
		jl2 = new JLabel("或者员工号");
		jl2.setFont(new Font("楷体" ,Font.PLAIN,14));
		jl2.setForeground(Color.red);
		jl2.setBounds(150, 290, 80,15); //60
		
		jl3 = new JLabel("请输入密码：");
		jl3.setFont(f1);
		jl3.setBounds(90, 330, 160,30); //100
		
		jname = new JTextField(10);
		jname.setBounds(235, 265, 160,30); //35
		
		jpasswd = new JPasswordField(10);
		jpasswd.setBounds(235, 330, 160,30); //100
		
		jcon = new JButton("登录");
		jcon.setActionCommand("登录");
		jcon.setBounds(140, 400, 80, 35);
		
		jcancel = new JButton("取消");
		jcancel.setActionCommand("取消");
		jcancel.setBounds(280, 400, 80, 35);
		
		//添加组件
		ct.add(jl1);
		ct.add(jl2);
		ct.add(jl3);
		ct.add(jname);
		ct.add(jpasswd);
		ct.add(jcon);
		ct.add(jcancel);
		ct.add(bimg);

		//注册组件
		jcon.addActionListener(this);
		jcancel.addActionListener(this);
		this.setSize(500,500);
		this.setLocation(Tools.width/2-250,Tools.height/2-250);
		this.setUndecorated(false); //禁用此 frame 的装饰
		this.setResizable(false); //无最大化，不可更改大小
		this.setTitle("登录界面");

		Image img=null;
		try {
			img=ImageIO.read(new File("images\\icon.jpg"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.setIconImage(img);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

	}
	//内部类，显示背景图片
	class BackImg extends JPanel
	{
		Image img=null;
		public BackImg()
		{
			try {
				img=ImageIO.read(new File("images\\login.png"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		public void paint(Graphics g)
		{
			g.drawImage(img, 0,0,500,500,this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("登录"))
		{
			String name = this.jname.getText().trim();  //获得登录的名 删除开头和结尾的空格
			String password = new String(jpasswd.getPassword()); //getPassword返回的是数组
			UserModel um=new UserModel();
			String[] info =um.checkUser(name,password);
			if(info!=null&&(info[0].equals("经理")||info[0].equals("主管")))
			{
				Tools.name=info[1];
				Tools.position=info[0];
				new Window1();
				this.dispose();
			}else if(info==null){
				JOptionPane.showMessageDialog(this, "     用户不存在或密码错误");
				return;
			}else if(info!=null&&(info[0].equals("收银员")))
			{
				new OrderIndex();
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "     系统错误，请联系管理员");
				return;
			}
			
		}else if(e.getActionCommand().equals("取消"))
		{
			//this.dispose(); 关闭当前线程
			System.exit(0); //关闭所有线程
		}

	}
}
