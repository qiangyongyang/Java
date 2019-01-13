package dao;

import java.sql.SQLException;

import Bean.UserBean;

public interface UserDao {
	 UserBean login(UserBean user)throws SQLException;
}
