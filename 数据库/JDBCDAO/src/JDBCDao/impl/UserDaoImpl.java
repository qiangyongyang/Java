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
					System.out.println("user="+admit+"    password"+passwd+"����id��ѯ");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				//�ͷ���Դ   ʡ��
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

	/*@Override   ������Statement�а�ȫ����
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
				System.out.println("��½�ɹ�");
			}else {
				System.out.println("��¼ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, st, rs);
		}
	}*/
	
	//������  prepareStatement
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
				System.out.println("��½�ɹ�");
			}else {
				System.out.println("��¼ʧ��");
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
					System.out.println("��ӳɹ�");
				}else {
					System.out.println("���ʧ��");
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
				System.out.println("ɾ���ɹ�");
			}else {
				System.out.println("ɾ��ʧ��");
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
				System.out.println("���³ɹ�");
			}else {
				System.out.println("����ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.release(con, ps );
		}
	}
	
	
}
	
	
	
	

