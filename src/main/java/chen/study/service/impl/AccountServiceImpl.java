package chen.study.service.impl;

import chen.study.dao.AccountDao;
import chen.study.dao.impl.AccountDaoImpl;
import chen.study.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();



    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
