package dao;

import java.util.List;

import domain.Student;

public interface StuDao {
	/*
	 * ��ѯ��������ѧ����Ϣ
	 * @return List����
	 */
	List<Student> findAll();
}
