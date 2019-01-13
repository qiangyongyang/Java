package service.impl;

import java.sql.SQLException;
import java.util.List;

import Bean.PageBean;
import Bean.Student;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import service.StudentService;

public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student stu) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		dao.insert(stu); 
	}

	@Override
	public void delete(int sid) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		dao.delete(sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	@Override
	public void update(Student stu) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		dao.update(stu);
		
	}

	
	
	/*@Override
	public PageBean<Student> searchStudent(Integer currPage, Integer pageSize, String sname, String gender) throws Exception {
		StudentDao dao=new StudentDaoImpl();
		PageBean<Student> pageBean = new PageBean<Student>();
		// 封装当前页数:
		pageBean.setCurrentPage(currPage);
		// 封装每页显示记录数:
		pageBean.setPageSize(pageSize);
		// 封装总记录数:
		// 调用DAO:
		Integer totalCount  = dao.findCount(sname,gender);
		pageBean.setTotalSize(totalCount);
		// 封装总页数:
		Double tc = totalCount.doubleValue();
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示数据的集合
		Integer begin = (currPage - 1) * pageSize;
		List<Student> list = dao.findByPage(sname,gender,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}*/
	
	
	
	
	
	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		PageBean<Student> pagebean=new PageBean<Student>();
		int page=StudentDao.Page_size;
		
		pagebean.setCurrentPage(currentPage);
		pagebean.setPageSize(page);
		
		StudentDao dao=new StudentDaoImpl();
		List<Student> list=dao.findStudentByPage(currentPage);
		pagebean.setList(list);//设置当前页的学生数据
		
		//总的记录数
		int count=dao.findCount();
		pagebean.setTotalSize(count);
		
		pagebean.setTotalPage(count%page==0 ? count/page:(count/page)+1);
		return pagebean;
	}

	@Override
	public List<Student> searchStudent(String sname, String gender) throws Exception {
		StudentDao dao=new StudentDaoImpl();
		return dao.searchStudent(sname,gender);
	}

	

	

}



























