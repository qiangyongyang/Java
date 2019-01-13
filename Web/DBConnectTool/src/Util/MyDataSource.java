package Util;


import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

import javax.sql.DataSource;


/*
 * 这是一个数据库连接池：
 * 1.一开始先往池子里放10个连接
 * 
 * 2.来的程序通过getConnectionhuoqulianjie
 * 
 * 3.用完之后，使用addBack方法归还
 * 
 * 4.扩容
 * 
 */
public class MyDataSource implements DataSource{
	
	List<Connection> list=new ArrayList<Connection>();
	public MyDataSource() {
		for (int i = 0; i < 10; i++) {
			Connection con=JDBCUtil2.getConn();
			list.add(con);
		}
	}
	//这里放的是该连接池对外公布的获取连接的方法
	@Override
	public Connection getConnection() throws SQLException {
		//来拿的时候，先看看池子里有没有？
		if(list.size()==0){
			for (int i = 0; i < 5; i++) {
				Connection con=JDBCUtil2.getConn();
				list.add(con);
			}
		}
		
		//remove(0)是指移除第一个，后面自动补上
		Connection con=list.remove(0);
		return con;
	}
	
	
	/*
	 * 用完之后，要还回到池子里
	 */
	public void addBack(Connection con){
		list.add(con);
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
