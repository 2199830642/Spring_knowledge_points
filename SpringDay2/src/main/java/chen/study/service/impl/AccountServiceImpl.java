package chen.study.service.impl;

import chen.study.dao.AccountDao;
import chen.study.dao.impl.AccountDaoImpl;
import chen.study.domain.Account;
import chen.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

/**
 * 账户的业务层实现类
 */
@Component("accountService")
//@Scope("prototype")
public class AccountServiceImpl implements AccountService {

//    @Autowired
//    @Qualifier("accountDao2")
    @Resource(name = "accountDao1")
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }
    @PostConstruct
    public void init() {
        System.out.println("初始化方式执行了");;
    }
    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法执行了");;
    }
}
