package com.view;
/**
 *退订
 */
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.Tools.Tools;
import com.model.ReserveModel;

public class UnsubscribeDialog extends JDialog implements ActionListener {
	
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
	JPanel jp,jp_top;
	JPanel jp_button;
	ReserveModel om;
	JFrame parent;
	String title;
	
	//查询编号
	JButton jbSelectInfo;
	JPanel jp_isexist;
	JLabel jl_isexist;
	public UnsubscribeDialog(String sql, Vector<String> field, JFrame parent ,String title )
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
		this.width=450;
		this.height=100+25*this.field.size();
		this.field_size=field.size();
		//创建组件
		jb1 = new JButton("确定取消");
		jb1.setFont(Tools.f_14);
		jb1.setEnabled(false);
		jcancel = new JButton("退出");
		jcancel.setFont(Tools.f_14);
		jbSelectInfo = new JButton("查询");
		jp_isexist = new JPanel();
		jbSelectInfo.setFont(Tools.f_14);
		jl_isexist = new JLabel("");
		jl_isexist.setFont(Tools.f_14);
		jp_button = new JPanel();
		jp_button.add(jb1);
		jp_button.add(jcancel);
		jps=new Vector<JPanel>();
		jtfs=new Vector<JTextField>();
		//注册监听
		jb1.addActionListener(this);
		jcancel.addActionListener(this);
		jbSelectInfo.addActionListener(this);
		
		jp_top = new JPanel();
		JLabel jp_top_j1 = new JLabel(field.get(0));
		jp_top_j1.setFont(Tools.f_14);
		JTextField jp_top_jtf = new JTextField(15);
		jtfs.add(jp_top_jtf);
		
		//添加组件
		jp_isexist.add(jl_isexist);
		jp_top.add(jp_top_j1);
		jp_top.add(jp_top_jtf);
		jp_top.add(jbSelectInfo);
		jp = new JPanel(new GridLayout(field_size+2, 1));
		
		jp.add(jp_top);
		jp.add(jp_isexist);
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
			om = new ReserveModel();
			boolean res=om.updateInfo(sql, paras);
			if(res)
			{
				JOptionPane.showMessageDialog(this, "     取消成功");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "     取消失败");
			}
		}else if(e.getSource()==this.jbSelectInfo)
		{
			String sql = "select reservenumber from reserve where reservenumber=?";
			Vector<String> paras = new Vector<String>();
			paras.add(this.jtfs.get(0).getText().trim());
			om = new ReserveModel();
			om.selectInfo(sql, paras);
			if(om.getRowCount()>0)
			{
				this.jl_isexist.setText("编号存在，可以删除");
				jb1.setEnabled(true);
			}else {
				this.jl_isexist.setText("编号不存在");
			}
		}
	}
}
