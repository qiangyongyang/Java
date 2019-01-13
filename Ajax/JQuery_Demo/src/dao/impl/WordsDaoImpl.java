package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Bean.Wordbean;
import Util.JDBCUtil2;
import dao.WordsDao;

public class WordsDaoImpl implements WordsDao{

	@Override
	public List<Wordbean> findWords(String word) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil2.getDataSource());
		String sql = "select * from words where words like ?  limit ?";
		return qr.query(sql, new BeanListHandler<Wordbean>(Wordbean.class) , "%"+word+"%" , 15);
	}

}
