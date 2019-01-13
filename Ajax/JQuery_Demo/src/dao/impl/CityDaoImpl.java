package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.CityDao;
import Bean.CityBean;
import Util.JDBCUtil2;

public class CityDaoImpl implements CityDao {

	@Override
	public List<CityBean> findCity(int pid) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		String sql = "select * from city where pid = ?";
		return runner.query(sql, new BeanListHandler<CityBean>(CityBean.class) , pid);
		
		
	}

}
