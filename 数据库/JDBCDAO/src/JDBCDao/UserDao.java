package JDBCDao;
/*
 * ����������ݿ�ķ���
 * 
 */
public interface UserDao {
	void findAll();
	void find(int id);    //��һ���ı�׼��ѯ    
	void login(String username,String password);
	void insert(String username,String password);
	void delete(int id);  //���԰���ͬ��׼ɾ��
	
	//����һ������ʲô����   ������������ʲô
	void update(int id,String username );
}
