/**
 * 执行对数据库的操作，无业务逻辑
 */
package com.db;

import java.sql.*;
import java.util.*;
public class SqlHelper {

	//定义数据库连接所需对象
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	//mysql连接所需的参数
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://127.0.0.1:3306/scott?characterEncoding=utf8";
	String user="root";
	String password="051159";

	//接收所需执行的语句以及条件
	String sql;
	Vector<String> parps;
	
	public SqlHelper()
	{
		try {
			//加载驱动
			Class.forName(driver);
			System.out.println("开始尝试数据库连接");
			ct=DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//执行查询操作
	public ResultSet queryExecute(String sql, Vector<String> parps)
	{
		this.sql=sql;
		this.parps=parps;
		try {
			ps=ct.prepareStatement(sql);
			for(int i=0;i<parps.size();i++)
			{
				ps.setString(i+1,this.parps.get(i));
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}

	//执行增删改操作
	public boolean updateExecute(String sql, Vector<String> parps)
	{
		this.sql=sql;
		this.parps=parps;
		try {
			ps=ct.prepareStatement(sql);
			for(int i=0;i<parps.size();i++)
			{
				ps.setString(i+1, parps.get(i));
			}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally
		{
			this.close();
		}
		return true;
	}
	//用于关闭打开的资源
	public void close()
	{
		try {
			//关闭顺序遵循先开后关
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(ct!=null)ct.close();
			System.out.println("数据库关闭成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
