package dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import Bean.UserBean;
import Util.JDBCUtil2;
import dao.UserDao;

public class UserDaoimpl implements UserDao {

	@Override
	public UserBean login(UserBean user) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		String sql = "select * from t_user where username = ? and password = ?";
		UserBean query = runner.query(sql, new BeanHandler<UserBean>(UserBean.class) , user.getUsername() , user.getPassword());
		return query;
	}

}
