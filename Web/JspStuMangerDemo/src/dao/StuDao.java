package dao;

import java.util.List;

import domain.Student;

public interface StuDao {
	/*
	 * 查询出来所有学生信息
	 * @return List集合
	 */
	List<Student> findAll();
}
