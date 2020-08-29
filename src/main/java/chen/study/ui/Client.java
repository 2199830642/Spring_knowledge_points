package chen.study.ui;

import chen.study.factory.BeanFactory;
import chen.study.service.AccountService;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //AccountService as = new AccountServiceImpl();
        for(int i = 0 ;i < 5;i++) {
            AccountService as = (AccountService) BeanFactory.getBean("AccountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
