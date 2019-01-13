package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Util;

import Util.JDBCUtil2;
import dao.UserDao;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean login(String username,String password) {
		Connection con=null;
		ResultSet rs=null;
		java.sql.PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    con=JDBCUtil2.getConn();
			String sql="select *from t_user where username=? and password=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
		    rs=ps.executeQuery();
			return rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil2.release(con, ps);
		}
		
		return false;
	}

}
