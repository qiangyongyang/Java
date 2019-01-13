package tx.transfer;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:tx_xml.xml")
@ContextConfiguration("classpath:tx_annotations.xml")
public class SpringDemo1 {

	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void demo1(){
		accountService.transfer("王彬", "李兵", 1000d);
	}
}
