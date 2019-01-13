package dao;

import java.sql.SQLException;
import java.util.List;

import Bean.CityBean;

public interface CityDao {
	List<CityBean>findCity(int pid)throws SQLException;
}
