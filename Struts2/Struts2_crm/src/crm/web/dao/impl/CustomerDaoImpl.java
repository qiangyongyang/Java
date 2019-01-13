package crm.web.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import crm.web.Bean.Customer;
import crm.web.dao.CustomerDao;
import crm.web.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao{
	
	//查询客户
	@Override
	public List<Customer> find() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		
		tx.commit();
		return list;
	}

	//保存客户
	@Override
	public void save(Customer customer) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(customer);
		
		tx.commit();
	}

}

















































