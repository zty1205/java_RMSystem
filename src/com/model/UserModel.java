/**
 * 采用Model2模式，处理业务逻辑 用户的操作：登录，删除，验证等
 */
package com.model;

import com.db.*;
import java.util.*;
import javax.swing.table.*;
import java.sql.*;

import com.db.SqlHelper;
//用户登录表模型
public class UserModel extends AbstractTableModel {

	//定义SqlHelper对象
	SqlHelper sh;
	
	Vector<String> columnNames;
	Vector<Vector> rowData;
	String sql;
	Vector<String> paras;
	ResultSet rs;
	//构造函数,创建SqlHelper
	public UserModel()
	{
		columnNames = new Vector<String>();
		rowData = new Vector<Vector>();
		paras=new Vector<String>();
		sh = new SqlHelper();
	}
	//用于检查登录是否合法,返回职位名称(userposition) 如果查询不到则返回null
	public String[] checkUser(String name,String password)
	{
		//处理业务逻辑
		paras=new Vector<String>();
		String[] info=new String[2];
		paras.add(name);
		paras.add(name);
		paras.add(password);
		String sql="Select userposition,username from login where (userid=? or username=?) and userpassword=?";
		//执行查询,获得查询结果
		ResultSet rs=sh.queryExecute(sql,paras);
		try {
			while(rs.next())
			{
				info[0]=rs.getString(1);
				info[1]=rs.getString(2);
				return info;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}finally
		{
			sh.close();
		}
		return null;
	}
	
	//执行查询操作
	public void selectInfo(String sql,Vector<String> paras)
	{
		this.sql=sql;
		this.paras=paras;
		rs=sh.queryExecute(sql, paras);
		try {
			//rsmd可以获得结果有多少列，并且能知道列名
			ResultSetMetaData rsmd=rs.getMetaData();
			for(int i=0;i<rsmd.getColumnCount();i++)
			{
				this.columnNames.add(rsmd.getColumnName(i+1));
			}
			this.columnNames.add("密码");
			while(rs.next())
			{
				Vector<String> hang = new Vector<String>();
				for(int i=0;i<rsmd.getColumnCount();i++)
				{
					hang.add(rs.getString(i+1));
				}
				hang.add("已注册");
				rowData.add(hang);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sh.close();
		}
	}
		
	//执行增删改操作
	public boolean updateInfo(String sql,Vector<String> paras)
	{
		this.sql=sql;
		this.paras=paras;
		boolean result=false;
		if(this.paras.size()>0)
		{
			result =sh.updateExecute(sql, paras);
		}
		return result;
	}
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return rowData.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.size();
		}
		
		@Override
		public String getColumnName(int columnIndex) {
			// TODO Auto-generated method stub
			return  this.columnNames.get(columnIndex);
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return rowData.get(rowIndex).get(columnIndex);
		}
	}

