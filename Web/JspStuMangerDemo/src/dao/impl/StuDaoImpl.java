package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Util.JDBCUtil2;
import dao.StuDao;
import domain.Student;

public class StuDaoImpl implements StuDao{

	@Override
	public List<Student> findAll() {
		Connection con=null;
		ResultSet rs=null;
		java.sql.PreparedStatement ps=null;
		List<Student> list=new ArrayList<Student>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    con=JDBCUtil2.getConn();
			String sql="select *from t_stu";
			ps=con.prepareStatement(sql);
	
		    rs=ps.executeQuery();
			while(rs.next()){    
				Student stu=new Student();
				
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setAddress(rs.getString("address"));
				
				list.add(stu);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil2.release(con, ps);
		}
		return list;
	}
	
}
