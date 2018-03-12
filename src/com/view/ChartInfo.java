package com.view;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.Tools.Tools;

public class ChartInfo extends JPanel implements ActionListener {

	int charWidth,charHeight;

	int dayCount=31;
	Vector<Integer> values;
	Vector<Integer> xPoints;
	Vector<Integer> yPoints;
	Boolean flag=true;
	String year = "2016";
	String mon = "1";
	String type ="折线图";
	String unit ="元";
	int maxday;
	int minday;
	int max;
	int min;
	int sum;
	String mon_b="";
	String mon_f="";
	double avg;
	int Ratio=20;   //折线图和柱形图绘图数据的比例因子
	Demo demo=new Demo();

	//底部选择和信息显示栏
	JPanel jbottom;
	JButton jb1;
//	JRadioButton jrb1,jrb2,jrb3;
//	ButtonGroup BG;
	JComboBox<String> jcb1,jcb2,jcb3,jcb4,jcb5;
	JLabel lab_1,lab_2;
	JButton jcon,jcon2,jcon3;
	JPanel jp_left;
	JPanel jcard;
	CardLayout cl;
	JPanel jp1,jp2,jp3,jtop;
	JButton jb2,jb3,jb4;
	
	JPanel jmid;
	JLabel jmid_1,jmid_2,jmid_3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ChartInfo()
	{
//		values = new Vector<Integer>();
//		for(int i=0;i<31;i++)
//		{
//			this.values.add((int)Math.ceil((Math.random()*50)));
//		}
		Vector<String> myTemp = new Vector<String>();
		this.mon_b=this.year+"-"+this.mon+"-"+"01";
		this.mon_f=this.year+"-"+this.mon+"-"+String.valueOf(dayCount);
//		myTemp.add("2016-01-01");
//		myTemp.add("2016-01-31");
		myTemp.add(this.mon_b);
		myTemp.add(this.mon_f);
//		System.out.println(mon_b);
//		System.out.println(mon_f);
		values = demo.getTurnover("select MONEY from turnover where dates between ? and ? group by DATES",myTemp);

		jbottom = new JPanel();
		jbottom.setLayout(null);
//		jbottom.setBackground(Color.GRAY);
		jbottom.setPreferredSize(new Dimension(this.getWidth()-50,170));

		this.setLayout(new BorderLayout());
		jb1 = new JButton("转换为柱状图");
		jb1.setBounds(880, 30, 200, 80);
		jb1.setFont(Tools.f_14);
		jb1.setFocusPainted(false);
		jb1.addActionListener(this);

		
//		BG = new ButtonGroup();
//		
//		jrb1 = new JRadioButton("2009");
//		jrb2 = new JRadioButton("2010");
//		jrb3 = new JRadioButton("2011");
//		
//		BG.add(jrb1);
//		BG.add(jrb2);
//		BG.add(jrb3);

//		jbottom.add(jrb1);
//		jbottom.add(jrb2);
//		jbottom.add(jrb3);
		jp_left = new JPanel(new BorderLayout());
		jp_left.setBorder(BorderFactory.createLineBorder(new Color(85,105,225), 2, true));
		jtop = new JPanel();
		jtop.setPreferredSize(new Dimension(450, 70));
		jb2 = new JButton("月份销售额");
		jb2.addActionListener(this);
		jb3 = new JButton("年份销售额");
		jb3.addActionListener(this);
		jb4 = new JButton("历年销售额");
		jb4.addActionListener(this);
		jtop.add(jb2);
		jtop.add(jb3);
		jtop.add(jb4);
		
		
		cl = new CardLayout();
		jcard = new JPanel(cl);
		
		jp1 = new JPanel();
		jp1.setOpaque(false);
		jp_left.setOpaque(false);
		String str1[] = {" 2016 "," 2017 "," 2018 "," 2019 "};
		String str2[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		jcb1 = new JComboBox<String>(str1);
		jcb1.setSelectedIndex(0);
		jcb2 = new JComboBox<String>(str2);
		jcb2.setSelectedIndex(0);
		jcon = new JButton(" 确定 ");
		jcon.setFont(Tools.f_14);
		jcon.setFocusPainted(false);
		jcon.addActionListener(this);
		
		jp1.add(jcb1);
		jp1.add(new JLabel("年"));
		jp1.add(jcb2);
		jp1.add(new JLabel("月"));
		jp1.add(new JLabel(""));
		jp1.add(new JLabel(""));
		jp1.add(jcon);
		
		jp2 = new JPanel();
		jp2.setOpaque(false);
		
		jcb3 = new JComboBox<String>(str1);
		jcb3.setSelectedIndex(0);
		jcon2 = new JButton(" 确定 ");
		jcon2.setFont(Tools.f_14);
		jcon2.setFocusPainted(false);
		jcon2.addActionListener(this);
		
		jp2.add(jcb3);
		jp2.add(new JLabel("年"));
		jp2.add(new JLabel(""));
		jp2.add(new JLabel(""));
		jp2.add(jcon2);
		
		jp3 = new JPanel();
		jp3.setOpaque(false);
		
		jcb4 = new JComboBox<String>(str1);
		jcb4.setSelectedIndex(0);
		jcb5 = new JComboBox<String>(str1);
		jcb5.setSelectedIndex(3);
		jcon3 = new JButton(" 确定 ");
		jcon3.setFont(Tools.f_14);
		jcon3.setFocusPainted(false);
		jcon3.addActionListener(this);
		
		jp3.add(jcb4);
		jp3.add(new JLabel("年"));
		jp3.add(new JLabel(""));
		jp3.add(new JLabel("到"));
		jp3.add(new JLabel(""));
		jp3.add(jcb5);
		jp3.add(new JLabel(""));
		jp3.add(jcon3);
		
		jcard.add(jp1, "1");
		jcard.add(jp2, "2");
		jcard.add(jp3, "3");
		
		
		jp_left.add(jtop, "North");
		jp_left.add(jcard, "Center");
		jp_left.setBounds(50, 30, 400, 120);
		
		//中间显示
		jmid = new JPanel(new GridLayout(3, 1));
		jmid.setBounds(jp_left.getWidth()+60,30,400,120);
		jmid.setBackground(new Color(88,179,252));
		jmid_1 = new JLabel(year+"年"+mon+"最大销售额("+maxday+"日):"+max+unit);
		jmid_1.setFont(Tools.heightLight);
		jmid_2 = new JLabel(year+"年"+mon+"最小销售额("+minday+"日):"+min+unit);
		jmid_2.setFont(Tools.heightLight);
		jmid_3 = new JLabel(year+"年"+mon+"月平均销售额:"+avg +unit);
		jmid_3.setFont(Tools.heightLight);

		JPanel jmin1 = new JPanel();
		jmin1.setOpaque(false);
		JPanel jmin2 = new JPanel();
		jmin2.setOpaque(false);
		JPanel jmin3 = new JPanel();
		jmin3.setOpaque(false);
		jmin1.add(jmid_1);
		jmin2.add(jmid_2);
		jmin3.add(jmid_3);
		
		jmid.add(jmin1);
		jmid.add(jmin2);
		jmid.add(jmin3);

		//添加日期选择
		jbottom.add(jp_left);
		jbottom.add(jb1);
		jbottom.add(jmid);
		
		this.add(jbottom,"South");
		//设置大小
		this.setSize(this.getWidth(), this.getHeight());
		this.setVisible(true);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		xPoints = new Vector<Integer>();
		yPoints = new Vector<Integer>();
		charWidth = this.getWidth()-10;
		charHeight = this.getHeight()-180;
		//背景从0，0点开始绘画
		g.fill3DRect(5, 5, charWidth, charHeight, true);
		g.setColor(new Color(56,94,15));
		//绘制网格坐标系
		for(int i=0;i<charHeight/10;i++)
		{
			g.drawLine(5, (i+1)*10, charWidth, (i+1)*10);
		}
		for(int i=0;i<charWidth/10;i++)
		{
			g.drawLine((i+1)*10, 5, (i+1)*10, charHeight);
		}
		
		//绘画标题
		g.setFont(new Font("宋体", Font.PLAIN, 30));
		g.setColor(Color.white);
		g.drawString(year+"年"+mon+"月销售额"+type+"：(单位:"+unit+")", charWidth/2-270, 30);
		
		//绘画坐标
		g.setFont(Tools.f_14);
		g.setColor(Color.white);
		int x=70;
		int y=charHeight/2-40;
		int width = charWidth-250;	 //width=839 px
		int height = charHeight/2-110;	//height=96 px

		//上半月的销售额
		g.drawLine(x, y, x, y-height);
		g.drawLine(x, y, x+width, y);
		//绘画Y轴坐标系
		for(int i=0,j=0;i<height;i+=height/6,j=j+200)
		{
			//绘画各个时间点
			g.drawLine(x, y-i, x+3, y-i);
			g.drawString(j+"", x-40, y-i+3);
		}
		//绘画X轴坐标系
		for(int i=width/15,j=1;i<width;i+=width/15,j++)
		{
			//绘画各个时间点
			g.drawLine(x+i, y, x+i, y-3);
			g.drawString(j+"日", x+i-10, y+16);
			//绘画各个销售额
			g.drawString(values.get(j-1)+".0", x+i-10, y-(values.get(j-1)/Ratio)*height/50-10);
			g.drawLine(x+i, y-(values.get(j-1)/Ratio)*height/50, x+i, y-(values.get(j-1)/Ratio)*height/50+1);
			this.xPoints.add(x+i);
			this.yPoints.add(y-(values.get(j-1)/Ratio)*height/50);
		}
//		System.out.println(xPoints.size());
		//下半月的销售额
		int y2=charHeight-60;
		g.drawLine(x, y2, x, y2-height);
		g.drawLine(x, y2, x+width, y2);
		//绘画Y轴坐标系
		for(int i=0,j=0;i<height;i+=height/6,j+=200)
		{
			//绘画各个时间点
			g.drawLine(x, y2-i, x+3, y2-i);
			g.drawString(j+"", x-40, y2-i+3);
		}
		//绘画X轴坐标系
		for(int i=width/(dayCount-15),j=16;i<width;i+=width/(dayCount-15),j++)
		{
			//绘画各个时间点
			g.drawLine(x+i, y2, x+i, y2-3);
			g.drawString(j+"日", x+i-10, y2+16);
			//绘画各个销售额
			g.drawString(values.get(j-1)+".0", x+i-10, y2-(values.get(j-1)/Ratio)*height/50-10);
			g.drawLine(x+i, y2-(values.get(j-1)/Ratio)*height/50, x+i, y2-(values.get(j-1)/Ratio)*height/50-1);
			this.xPoints.add(x+i);
			this.yPoints.add(y2-(values.get(j-1)/Ratio)*height/50-1);
		}
//		System.out.println(xPoints.size());
		for(int i=0;i<xPoints.size();i++)
		{
//			xPoint = new int[xPoints.size()];
//			xPoint[0]=this.xPoints.get(i);
//			yPoint = new int[yPoints.size()];
//			yPoint[0]=this.yPoints.get(i);
			if(flag){
				if(i!=14&&i!=xPoints.size()-1)
					g.drawLine(xPoints.get(i), yPoints.get(i), xPoints.get(i+1), yPoints.get(i+1));
			}
			else{
//				画柱形图
//				System.out.println(xPoints.size()+"aaaa"+values.size());
//				System.out.println(values.get(i));
				g.fill3DRect(xPoints.get(i)-20, yPoints.get(i), 40, (values.get(i)/Ratio)*height/50+2, true);
				
			}

		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
//			for(int i=0;i<31;i++)
//			{
//				this.values.add(1);
//			}
			if(flag)
			{
				flag=false;
				jb1.setText("转换为折线图");
				type = "柱状图";
			}else{
				flag=true;
				jb1.setText("转换为柱状图");
				type = "折线图";
			}
			
			this.repaint();
		}else if(e.getSource()==jcon)
		{
//			System.out.println("1111111111111111111111");
			
			this.year=this.jcb1.getSelectedItem().toString().replace(" ", "");
			this.mon=this.jcb2.getSelectedItem().toString().replace(" ", "");
			int MM=Integer.parseInt(mon.trim());
			if(MM==1||MM==3||MM==5||MM==7||MM==8||MM==10||MM==12)
			{
				dayCount = 31;
			}else if(MM==4||MM==6||MM==9||MM==11)
			{
				dayCount = 30;
			}else if(MM==2)
			{
				if(Integer.parseInt(year)%4==0)
				{
					dayCount = 29;
				}else{
					dayCount = 28;
				}
			}
			//重新从数据库获得数据
			Vector<Integer> Temp_values = new Vector<Integer>();
			Demo Temp_demo=new Demo();
			Vector<String> myTemp = new Vector<String>();
			//还原每次的值
			maxday=0;
			minday=0;
			max=0;
			min=0;
			sum=0;
			this.mon_b=this.year+"-"+this.mon+"-"+"01";
			this.mon_f=this.year+"-"+this.mon+"-"+String.valueOf(dayCount);
			myTemp.add(this.mon_b);
			myTemp.add(this.mon_f);
//			System.out.println(mon_b);
//			System.out.println(mon_f);
			Temp_values = Temp_demo.getTurnover("select MONEY from turnover where dates between ? and ? group by DATES",myTemp);
			for(int i=0;i<dayCount;i++)
			{
//				int temp = (int)Math.ceil((Math.random()*500));
//				sum=sum+temp;
//				System.out.println(i);
				int temp=Temp_values.get(i);
//				System.out.println(temp);
				sum=sum+temp;

				if(temp>max)
				{
					max = temp;
					maxday = i+1;
				}
				if(i==0)
				{
					min = temp;
				}else if(i>0&&temp<min)
				{
					min = temp;
					minday = i+1;
				}
				
//				this.values.add(temp);
			}
			jmid_1.setText(year+"年"+mon+"最大销售额("+maxday+"日):"+max+unit);
			jmid_2.setText(year+"年"+mon+"最小销售额("+minday+"日):"+min+unit);
			avg=sum/dayCount;
			jmid_3.setText(year+"年"+mon+"月平均销售额:"+avg+unit);
			this.repaint();
		}else if(e.getSource()==jb2)
		{
			//月份销售额
			cl.show(jcard, "1");
		}else if(e.getSource()==jb3)
		{
			//年份销售额
			cl.show(jcard, "2");
			
		}else if(e.getSource()==jb4)
		{
			//历年销售额
			cl.show(jcard, "3");
		}
	}

}
