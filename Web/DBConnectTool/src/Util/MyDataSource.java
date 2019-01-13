package Util;


import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

import javax.sql.DataSource;


/*
 * ����һ�����ݿ����ӳأ�
 * 1.һ��ʼ�����������10������
 * 
 * 2.���ĳ���ͨ��getConnectionhuoqulianjie
 * 
 * 3.����֮��ʹ��addBack�����黹
 * 
 * 4.����
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
	//����ŵ��Ǹ����ӳض��⹫���Ļ�ȡ���ӵķ���
	@Override
	public Connection getConnection() throws SQLException {
		//���õ�ʱ���ȿ�����������û�У�
		if(list.size()==0){
			for (int i = 0; i < 5; i++) {
				Connection con=JDBCUtil2.getConn();
				list.add(con);
			}
		}
		
		//remove(0)��ָ�Ƴ���һ���������Զ�����
		Connection con=list.remove(0);
		return con;
	}
	
	
	/*
	 * ����֮��Ҫ���ص�������
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
