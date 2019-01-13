package mapper;

import java.util.List;

import Pojo.User;

public interface UserMapper {
	User getUserById(Integer id);
	List<User> getUserByName(String username);
	void insert(User user);
}
