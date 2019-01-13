package dao;

import java.sql.SQLException;
import java.util.List;

import Bean.Wordbean;

public interface WordsDao {
	List<Wordbean> findWords (String word) throws SQLException;
}
