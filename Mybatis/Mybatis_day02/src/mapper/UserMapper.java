package mapper;

import java.util.List;

import Pojo.QueryVo;
import Pojo.User;

public interface UserMapper {
	User getUserById(Integer id);
	List<User> getUserByName(String username);
	void insert(User user);
	
	
	/*---------------第二天---------------------*/
	List<User> getUserByQueryVo(QueryVo vo);
	
	Integer getUserCount();
	
	
	List<User> getUserByPojo(User user);
	
	List<User> getUserByIds(QueryVo vo);	
}
