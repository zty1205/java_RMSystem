package com.view;

/**
 * Created by zty on 2017/12/26.
 */
import com.view.Calendar.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class WindowCalendar extends JFrame implements ItemListener,MouseListener,Runnable
{
    int monthes,year,day;
    Thread threadTime;
    DataTime dateTime;
    NowDate nowDate=new NowDate();
    //SureExit sureExit;
    Choice choiceMonth;
    List   yearList;
    TextArea text;
    TextField textTime,textNowDate;
    Panel panelDate,panelNorth,panelTime,panelNowDate;
    Label label=new Label("日期和时间");
    Label labelTime=new Label("时间         ");
    Label labelNowDate=new Label("当前日期 ");
    String month[]={"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
    String monthDays[];
    String nowMonthDays[];
    ImageIcon jtitle;

    WindowCalendar(String s)
    {
        super(s);
        threadTime=new Thread(this);
        choiceMonth=new Choice();
        yearList=new List(3,false);
        text=new TextArea(7,22);
        textTime=new TextField(15);
        textNowDate=new TextField(15);
        panelDate=new Panel();
        panelNorth=new Panel();
        panelTime=new Panel();
        panelNowDate=new Panel();
        //sureExit=new SureExit(this,"关闭",false);
        for(int i=0;i<12;i++)
            choiceMonth.add(" "+month[i]);
        for(int i=1900;i<=2100;i++)
            yearList.add(""+i);
        panelDate.add(label);
        panelNowDate.add(labelNowDate);
        panelNowDate.add(textNowDate);
        add(panelDate);
        panelNorth.add(yearList);
        panelNorth.add(choiceMonth);
        add(panelNorth);
        add(text);
        add(panelNowDate);
        add(labelTime);
        add(textTime);

        choiceMonth.addItemListener(this);
        yearList.addItemListener(this);
        textTime.addMouseListener(this);
//        addWindowListener(new WindowAdapter()
//        {
//            public void windowClosing(WindowEvent e)
//            {
//
//                sureExit.setVisible(true);
//            }
//        });
        Font font=new Font("黑体",Font.PLAIN,15);
        text.setFont(font);
        //text.setBackground(Color.cyan);
        //text.setForeground(Color.red);
        Font f=new Font("宋体",Font.BOLD,15);
        label.setFont(f);
        labelTime.setFont(f);
        labelNowDate.setFont(f);
        labelNowDate.setForeground(Color.blue);
        //label.setForeground(Color.blue);
        labelTime.setForeground(Color.blue);
        //labelTime.setBackground(Color.orange);
        //labelNowDate.setBackground(Color.orange);
        //label.setBackground(Color.orange);

        text.setEditable(false);
        textTime.setEditable(false);
        textTime.setForeground(Color.red);
        textTime.setFont(f);
        textTime.setBackground(Color.green);
        textNowDate.setEditable(false);
        textNowDate.setForeground(Color.red);
        textNowDate.setBackground(Color.green);
        textNowDate.setFont(f);

        choiceMonth.select(nowDate.getMonth()-1);
        int y=nowDate.getYear()-1900;
        yearList.select(y);
        day=nowDate.getDay();
        int m=nowDate.getMonth();
        y=y+1900;
        textNowDate.setText(""+y+"年"+m+"月"+day+"日");
        setMonthDays();

        setLayout(new FlowLayout());
        setBounds(200,150,300,400);
        jtitle=new ImageIcon("images\\title.gif");
        this.setIconImage(jtitle.getImage());
        setVisible(true);
        validate();
        threadTime.start();
    }
    public void run()
    {
        while(true)
        {
            java.util.Date date=new java.util.Date();
            Dates dates=new Dates();
            String time=date.toString().substring(11,19);
            textNowDate.setText(dates.getYear()+"年"+dates.getMonth()+"月"+dates.getDay()+"日");
            textTime.setText(time+" 星期"+dates.getWeek());
            try
            {
                threadTime.sleep(1000);
            }
            catch (InterruptedException e)
            {
            }
        }
    }
    public void mouseEntered(MouseEvent e)
    {
        TextField text1=(TextField)e.getSource();
        text1.setBackground(Color.cyan);
    }
    public void mouseExited(MouseEvent e)
    {
        TextField textField=(TextField)e.getSource();
        textField.setBackground(Color.green);
    }
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void setMonthDays()
    {
        text.setText("日 一 二 三 四 五 六");

        nowMonthDays=nowDate.getMonthDays();
        for(int i=0;i<nowMonthDays.length;i++)
        {
            if(i%7==0)
                text.append("\n");
            text.append(""+nowMonthDays[i]+" ");
        }
    }
    public void itemStateChanged(ItemEvent e)
    {
        monthes=choiceMonth.getSelectedIndex()+1;
        year=1900+yearList.getSelectedIndex();
        dateTime=new DataTime(year,monthes);
        monthDays=dateTime.getMonthDays();

        text.setText("日 一 二 三 四 五 六");
        for(int i=0;i<monthDays.length;i++)
        {
            if(i%7==0)
                text.append("\n");
            text.append(""+monthDays[i]+" ");
        }
    }
}



