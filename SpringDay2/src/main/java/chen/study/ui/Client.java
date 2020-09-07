package chen.study.ui;

import chen.study.dao.AccountDao;
import chen.study.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        AccountService as = (AccountService)ac.getBean("accountService");
//        System.out.println(as);
//        AccountDao ad = (AccountDao)ac.getBean("accountDao");
//        System.out.println(ad);
        as.saveAccount();
        ac.close();

    }
}
