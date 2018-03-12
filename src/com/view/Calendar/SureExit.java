package com.view.Calendar;

/**
 * Created by zty on 2017/12/26.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SureExit extends Dialog implements ActionListener{

    static final int YES=1,NO=0;
    int message=-1;
    Button buttonYes,buttonNo;
    Panel panelButton,panelLabel;
    Label label=new Label("确定退出？",Label.CENTER);
    ImageIcon jtitle;
    SureExit(Frame f,String s,boolean b)
    {
        super(f,s,b);
        buttonYes=new Button("Yes");
        buttonNo=new Button("No");
        panelButton=new Panel();
        panelLabel=new Panel();

        panelLabel.add(label);
        panelButton.add(buttonYes);
        panelButton.add(buttonNo);
        add(panelLabel);
        add(panelButton);
        buttonYes.addActionListener(this);
        buttonNo.addActionListener(this);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                setVisible(false);
            }
        });
        setLocation(250,200);
        setSize(140,120);
        setLayout(new FlowLayout());
        jtitle=new ImageIcon("images\\title.gif");
        this.setIconImage(jtitle.getImage());
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==buttonYes)
        {
            message=YES;
            //System.exit(0);
            this.dispose();
            setVisible(false);
        }
        else if(e.getSource()==buttonNo)
        {
            message=NO;
            setVisible(false);
        }
    }
    public int getMessage()
    {
        return message;
    }
}

