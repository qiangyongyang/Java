package JDBCDao;
/*
 * 定义操作数据库的方法
 * 
 */
public interface UserDao {
	void findAll();
	void find(int id);    //按一定的标准查询    
	void login(String username,String password);
	void insert(String username,String password);
	void delete(int id);  //可以按不同标准删除
	
	//参数一：根据什么跟新   参数二：更新什么
	void update(int id,String username );
}
