package com.view;

import java.util.*;
import javax.swing.*;

import com.Tools.Tools;
import com.db.SqlHelper;
import com.model.EmpModel;
import com.model.OrderModel;
import com.model.ReserveModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ShowOrderDishesDialog extends JDialog implements ActionListener,MouseListener{

	Hashtable<String,Vector<Integer>> ht;
	//获取构造函数的值
	String sql;
	Vector<String> paras;
	SqlHelper sh;
	OrderModel om;
	
	Vector<String> colName;
	Vector<String> colValue;
	Vector<JPanel> jps;
	//获得创建JTextField的向量
	Vector<JTextField> jtextfs1,jtextfs2;
	Vector<String> dishnames;
	//创建JPanel布局
	JPanel jp;
	JPanel jp_button;
	JButton  jb1,jb2,jcancel;
	
	//创建本窗口的大小
	int width;
	int height;
	int field_size;
	JLabel lab_sum; //订单的总价格
	JTextField menuid;
	String title;
	String insertSql;//执行更新的sql语句
	int sum;//下单的总金额
	JFrame parent;
	Vector<Vector<String>> BatchUpdate;
	
	public ShowOrderDishesDialog(String sql,Hashtable<String,Vector<Integer>> ht,JFrame parent)
	{
		this.parent=parent;
		this.width=500;
		this.sql=sql;
		this.ht=ht;
		int j=0;
		field_size = ht.size();
		jtextfs1 = new Vector<JTextField>();
		jtextfs2 = new Vector<JTextField>();
		dishnames = new Vector<String>();
		jps = new Vector<JPanel>();
		JPanel jp2 = new JPanel();
		menuid = new JTextField(28);
		menuid.setText("若没有单号，下单后自动生成");
		menuid.setEditable(false);
		menuid.setFont(Tools.f_12);
		menuid.addMouseListener(this);
		JLabel lab_id = new JLabel("订单号");
		lab_id.setFont(Tools.f_14);
		JPanel jp_id=new JPanel();
		jp_id.add(lab_id);
		jp_id.add(menuid);
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		jp2.add(new JLabel("菜名"));
		jp2.add(new JLabel("单价"));
		jp2.add(new JLabel("数量"));
		
		jps.add(jp_id);
		jps.add(jp2);
		for(Iterator it = ht.keySet().iterator(); it.hasNext();){   
	        //从ht中取  
	        String dishname = (String)it.next();
	        dishnames.add(dishname);
			JLabel colJlab=new JLabel(dishname);
			JTextField jtField1 = new JTextField(10);
			jtField1.setText(ht.get(dishname).get(0).toString());
			jtField1.setEditable(false);
			JTextField jtField2 = new JTextField(10);
			jtField2.setText(ht.get(dishname).get(1).toString());
			jtextfs1.add(jtField1);
			jtextfs2.add(jtField2);
			JPanel p1=new JPanel();
			p1.add(colJlab);
			p1.add(jtField1);
			p1.add(jtField2);
//			JLabel lab_cancel = new JLabel(new ImageIcon("images/cancel.png"));
//			lab_cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
//			lab_cancel.addMouseListener(this);
//			lab_cancel.setName((j++)+"");
//			
//			p1.add(lab_cancel);
			jps.add(p1);
		}
		jp = new JPanel(new GridLayout(field_size+4, 1)); //列名一格  按钮一个  总价一格
		for(int i=0;i<jps.size();i++)
		{
			jp.add(jps.get(i));
		}
		JPanel jp_sum = new JPanel();
		lab_sum = new JLabel();
		jp_sum.add(lab_sum);
		jp.add(jp_sum);
		jp_button =new JPanel();
		jb2 = new JButton("查看总金额");
		jb2.setFont(Tools.f_14);
		jb2.addActionListener(this);
		jb1 = new JButton("下单");
		jb1.setEnabled(false);
		jb1.setFont(Tools.f_14);
		jb1.addActionListener(this);
		jcancel = new JButton("继续下单");
		jcancel.setFont(Tools.f_14);
		jcancel.addActionListener(this);
		jp_button.add(jb2);
		jp_button.add(jb1);
		jp_button.add(jcancel);
		jp.add(jp_button);
		
		this.height=100+25*jp.getComponentCount();
		
		this.add(jp);
		this.setSize(this.width,this.height);
		this.setTitle(title);
		this.setIconImage(new ImageIcon("images/title.gif").getImage());
		this.setLocation(Tools.width/2-width/2, Tools.height/2-height/2);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jcancel)
			{
				this.dispose();
			}else if(e.getSource()==jb1)
			{
				String sql1 = "update dishes set dishpop=dishpop+? where dishname like ?";
				String sql2 = "insert into menu (dishnumber,dishname,dishprice,menuid) values(?,?,?,?)";
				om = new OrderModel();
				String reservenum_seq="";
				Boolean isInsert=false;
				for(int i=0;i<jtextfs2.size();i++)
				{
					Vector<String> paras = new Vector<String>();
					//获得下单菜的各个菜的数量
					paras.add(jtextfs2.get(i).getText());
					//获得下单菜的各个菜的名字
					paras.add(dishnames.get(i));
					//执行更新菜品人气
					om.updateInfo(sql1, paras);
					//获得下单菜的各个菜的价格
					paras.add(jtextfs1.get(i).getText());
					if(menuid.getText().trim().equals("")||menuid.getText().equals("若没有单号，下单后自动生成"))
					{
						if(reservenum_seq.equals(""))
						{
							//自动生成一个订单号
//							String getID = "select reservenumber_seq.nextval from dual where 1=?";
							String getID = "select max(reservenumber)+1 from reserve where 1=?";
							Vector<String> resid = new Vector<String>();
							resid.add("1");
							OrderModel getIdOM = new OrderModel();
							getIdOM.selectInfo(getID, resid);
							reservenum_seq=(String) getIdOM.getValueAt(0, 0);
							paras.add(reservenum_seq);
						}else{
							paras.add(reservenum_seq);
						}
					}else{
						//获得订单号
						reservenum_seq=menuid.getText().trim();
						paras.add(reservenum_seq);
						
					}
					//执行插入'点菜单'
					isInsert = om.updateInfo(sql2, paras);
				}
				
				if(!isInsert)
				{
					JOptionPane.showMessageDialog(this, "   下单失败");
				}
				else{
					JOptionPane.showMessageDialog(this, "下单成功,订单号为"+reservenum_seq+"号");
					this.dispose();
					parent.dispose();
				}
			}
			else if(e.getSource()==jb2)
			{
				sum=0;
				for(int i=0;i<jtextfs1.size();i++)
				{
					sum+=Integer.parseInt(jtextfs1.get(i).getText())*Integer.parseInt(jtextfs2.get(i).getText());
				}
				lab_sum.setText("订单的总价格为："+sum+"元");
				jb1.setEnabled(true);
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==menuid)
			{
				menuid.setEditable(true);
				menuid.setText("");
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