package dao;

import java.util.List;

import Pojo.User;

public interface UserDao {
	User getUserById(Integer id);
	List<User> getUserByName(String username);
	void insert(User user);
}
