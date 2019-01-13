package JDBCDao.impl;


import java.sql.*;

import JDBCDao.UserDao;
import JDBCUtil.JDBCUtil2;

public class UserDaoImpl implements UserDao{

	@Override
	public void find(int id) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
			try {
				con=JDBCUtil2.getConn();
				String sql="select * from t_user where id=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				rs=ps.executeQuery();
				if(rs.next()) {
					String admit=rs.getString("username");
					String passwd=rs.getString("password");
					System.out.println("user="+admit+"    password"+passwd+"根据id查询");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				//释放资源   省略
			}
	}

	@Override
	public void findAll() {
		// TODO Auto-generated method stub
		Connection con=null;
		ResultSet  rs=null;
		Statement st=null;
		try {
			con=JDBCUtil2.getConn();
			st=con.createStatement();
			String sql="select *from t_user";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				String admit=rs.getString("username");
				String passwd=rs.getString("password");
				System.out.println("user="+admit+"    password"+passwd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, st, rs);
		}
		
	}

	/*@Override   初级：Statement有安全隐患
    public void login(String username, String password) {
		Connection con=null;
		ResultSet  rs=null;
		Statement st=null;
		try {
			con=JDBCUtil2.getConn();
			st=con.createStatement();
			String sql="select * from t_user where username='"+ username +"' and password='"+ password +"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				System.out.println("登陆成功");
			}else {
				System.out.println("登录失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, st, rs);
		}
	}*/
	
	//升级版  prepareStatement
	@Override
	public void login(String username, String password) {
		Connection con=null;
		ResultSet  rs=null;
		Statement st=null;
		PreparedStatement ps=null;
		try {
			con=JDBCUtil2.getConn();
			String sql="select * from t_user where username=? and password=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();

			if(rs.next()) {
				System.out.println("登陆成功");
			}else {
				System.out.println("登录失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, st, rs);
		}
	}

	@Override
	public void insert(String username, String password) {
		// TODO Auto-generated method stub
			Connection con=null;
			ResultSet  rs=null;
			PreparedStatement ps=null;
			
			try {
				con=JDBCUtil2.getConn();
				String sql="insert into t_user values(null,?,?)";
				ps=con.prepareStatement(sql);
				
				ps.setString(1, username);
				ps.setString(2, password);
				
				int ans=ps.executeUpdate();
				if(ans>0) {
					System.out.println("添加成功");
				}else {
					System.out.println("添加失败");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtil2.release(con, ps );
			}
		}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection con=null;
		ResultSet  rs=null;
		PreparedStatement ps=null;
		
		try {
			con=JDBCUtil2.getConn();
			String sql="delete from t_user where id=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			int ans=ps.executeUpdate();
			if(ans>0) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, ps );
		}
	}

	@Override
	public void update(int id, String username) {
		Connection con=null;
		ResultSet  rs=null;
		PreparedStatement ps=null;
		
		try {
			con=JDBCUtil2.getConn();
			String sql="update t_user set username=? where id=?";
			ps=con.prepareStatement(sql);
			
			 ps.setString(1, username);;
			 ps.setInt(2, id);
			
			int ans=ps.executeUpdate();
			if(ans>0) {
				System.out.println("更新成功");
			}else {
				System.out.println("更新失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, ps );
		}
	}
	
	
}
	
	
	
	

