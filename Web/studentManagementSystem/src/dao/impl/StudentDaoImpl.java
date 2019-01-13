package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import Bean.Student;
import Util.JDBCUtil2;
import Util.textUtils;
import dao.StudentDao;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil2.getDataSource());
		List<Student> list = qr.query("select *from stu", new BeanListHandler<Student>(Student.class));
		return list;
	}

	@Override
	public void insert(Student stu) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil2.getDataSource());
		qr.update("insert into stu values(null,?,?,?,?,?,?)", stu.getSname(), stu.getGender(), stu.getPhone(),
				stu.getBirthday(), stu.getHobby(), stu.getInfo());

	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil2.getDataSource());
		qr.update("delete from stu where sid=?", sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil2.getDataSource());
		return qr.query("select *from stu where sid=?", new BeanHandler<Student>(Student.class), sid);

	}

	@Override
	public void update(Student stu) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil2.getDataSource());
		qr.update("update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?", stu.getSname(),
				stu.getGender(), stu.getPhone(), stu.getBirthday(), stu.getHobby(), stu.getInfo(), stu.getSid());
	}

	/*@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		QueryRunner qr=new QueryRunner(JDBCUtil2.getDataSource());
		String sql="select *from stu where 1=1";
		List<String> list=new ArrayList<String>();
		
		
		//判断有没有姓名，有就拼接到sql语句
		if( ! textUtils.isEmpty(sname)){
			sql+=" and sname like ?";
			list.add("%"+sname+"%");
		}
		//判断有没有性别，有就拼接到sql语句
		if( ! textUtils.isEmpty(sgender)){
			sql+=" and gender=?";
			list.add(sgender);
		}
		return qr.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
	}*/

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner qr=new QueryRunner(JDBCUtil2.getDataSource());
		//第一个问号代表一页返回多少记录，
		//第二个问号代表跳过前面多少记录
		//5  0 ----第一页(1-1）*5
		//5  5 ----第二页（2-1）*5
		//5  10 ---第三页
		return qr.query("select *from stu limit ? offset ?", new BeanListHandler<Student>(Student.class),Page_size,(currentPage-1)*Page_size);                                              
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner qr=new QueryRunner(JDBCUtil2.getDataSource());
		//用于处理平均值，总的个数
		Long result=(long)qr.query("select count(*) from stu", new ScalarHandler());
		return result.intValue();
	}

	@Override
	public Integer findCount(String sname, String gender) throws Exception {
		QueryRunner qr=new QueryRunner(JDBCUtil2.getDataSource());
		//用于处理平均值，总的个数
		Long result=(long)qr.query("select count(*) from stu where sname like ? or gender=?", new ScalarHandler(),"%"+sname+"%",gender);
		System.out.println(result.intValue());
		return result.intValue();
	}

	@Override
	public List<Student> searchStudent(String sname, String gender) throws SQLException, Exception {
		QueryRunner qr=new QueryRunner(JDBCUtil2.getDataSource());
		String sql="select *from stu where 1=1";
		List<String> list=new ArrayList<String>();
		
		if( ! textUtils.isEmpty(sname)){
			sql+=" and sname like ?";
			list.add("%"+sname+"%");
		}
		//判断有没有性别，有就拼接到sql语句
		if( ! textUtils.isEmpty(gender)){
			sql+=" and gender=?";
			list.add(gender);
		}
		return qr.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
	}


}
