package chen.study.test;

import chen.study.domain.Account;
import chen.study.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 */
public class AccountServiceTest {
    private ApplicationContext ac;
    private AccountService as;
    @Before
    public void init(){
        //获取容器
        ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        as = ac.getBean("accountService",AccountService.class);
    }
    @Test
    public void findAllTest(){
        //3.执行方法
        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }
    @Test
    public void findOneTest(){
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void findSaveTest(){
        Account a = new Account();
        a.setName("test");
        a.setMoney(1000f);
        as.saveAccount(a);
    }
    @Test
    public void findUpdateTest(){
        Account account = as.findAccountById(1);
        account.setMoney(123456f);
        as.updateAccount(account);
    }
    @Test
    public void findDeleteTest(){
        as.deleteAccount(2);
    }
}
