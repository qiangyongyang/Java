package tx.transfer;

public interface AccountDao {
	public void outMoney(String from ,Double money);
	public void inMoney(String to ,Double money);
}

