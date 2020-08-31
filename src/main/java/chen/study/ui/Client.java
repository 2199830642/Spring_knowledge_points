package chen.study.ui;

import chen.study.dao.AccountDao;
import chen.study.service.AccountService;
import chen.study.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext：它可以加在类路径下的配置文件，要求配置文件必须在类路径下
     *      FileSystemXmlApplicationContext：他可以加载磁盘任意路径下的配置文件，必须有访问权限
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的
     *
     * 核心容器的两个接口引发出的问题
     * ApplicationContext:  适用于单例对象   更多采用此接口定义容器对象
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是说只要一读取完配置文件马上就创建配置文件中配置的对象
     * BeanFactory:   适用于多例对象
     *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式，什么时候根据id获取对象，什么时候创建对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        AccountService as = (AccountService)ac.getBean("accountService");
        AccountDao accountDao = ac.getBean("accountDao",AccountDao.class);
        System.out.println(as);
        System.out.println(accountDao);
        as.saveAccount();

        /*//------------BeanFactory-----------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService as = (AccountService)factory.getBean("accountService");
        System.out.println(as);*/
    }
}
