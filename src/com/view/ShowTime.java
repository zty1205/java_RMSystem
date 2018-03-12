package com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import com.Tools.Tools;

//显示时间类
public class ShowTime extends JPanel implements Runnable
{
	Date date;//定义系统时间对象
	public void paint(Graphics g)
	{
		super.paint(g);
		String nowTome=this.getNowTime();
		g.setColor(Color.black);
		g.setFont(new Font("宋体", Font.PLAIN, 15));
		g.drawString(nowTome, Tools.width-400, 20);
	}
	//获取当前的时间并返回所需的显示的字符串
	public String getNowTime()
	{
		date=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");//设置显示格式
		String nowDate=df.format(date);
		String[] time=nowDate.split(":");
		int year=Integer.parseInt(time[0]);
		int mon= Integer.parseInt(time[1]);
		int day= Integer.parseInt(time[2]);
		int hour=Integer.parseInt(time[3]);
		int min= Integer.parseInt(time[4]);
		int sec= Integer.parseInt(time[5]);
		String nowTime="当 前 时 间 ："+year+"年 "+mon+"月 "+day+"日 "+hour+"时 "+min+"分 "+sec+"秒";
		return nowTime;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				//每隔1000毫秒重新绘画
				Thread.sleep(1000);
				this.repaint();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
