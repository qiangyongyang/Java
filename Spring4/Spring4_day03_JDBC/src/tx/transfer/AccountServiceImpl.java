package tx.transfer;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;




@Transactional  //在业务层添加事务管理的注解
public class AccountServiceImpl implements AccountService {

	// 注入DAO:
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	

	@Override
	public void transfer(String from, String to, Double money) {
		accountDao.outMoney(from, money);
		//int i=10/0;
		accountDao.inMoney(to, money);
	}

}



































































































