package utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class SqlSessionFactoryUtils {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try {
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			sqlSessionFactory = ssfb.build(inputStream);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
