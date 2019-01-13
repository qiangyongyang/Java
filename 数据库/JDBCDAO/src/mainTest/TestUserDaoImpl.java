package mainTest;

import org.junit.Test;

import JDBCDao.UserDao;
import JDBCDao.impl.UserDaoImpl;

public class TestUserDaoImpl {
	@Test
	public void testFindAll() {
		UserDao dao=new UserDaoImpl();
		dao.findAll();
	}
	
	@Test
	public void testfind() {
		UserDao dao=new UserDaoImpl();
		dao.find(2);
	}
	
	@Test
	public void testlogin() {
		UserDao dao=new UserDaoImpl();
		dao.login("yd", "10086");
	}
	@Test
	public void testinsert() {
		UserDao dao=new UserDaoImpl();
		dao.insert("guanyu", "366");
	}
	
	@Test
	public void testdelete() {
		UserDao dao=new UserDaoImpl();
		dao.delete(4);
	}
	
	@Test
	public void testupdate() {
		UserDao dao=new UserDaoImpl();
		dao.update(2, "zf");
	}
}
