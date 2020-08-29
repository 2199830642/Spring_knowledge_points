package chen.study.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 是一个创建Bean对象的工厂
 *
 * Bean：在计算机英语中有可重用组件的含义
 * JavaBean:用java语言编写的可重用组件
 *          JavaBean != 实体类   JavaBean范围远大于实体类
 *
 *   它就是创建service和dao对象的
 *   第一个：需要一个配置文件来配置service和dao
 *              配置的内容：唯一标志=全限定类名（key=value）
 *
 *   第二个：通过读取配置文件中配置的内容反射创建Bean对象
 *
 *   配置文件可以选用两种方式：xml或properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties pro;
    //定义一个map用于存放我们要创建的对象，称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为pro赋值
    static {
        try {
            //实例化对象
            pro = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            pro.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = pro.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = pro.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器之中
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据Bean的名称获取Bean对象   如果不用容器那就是多例对象，如果用了 那就是单例对象
     *
     * @param BeanName
     * @return
     */
    public static Object getBean(String BeanName) {
        /*Object bean = null;
        String beanPath = pro.getProperty(BeanName);
        try {
            bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return beans.get(BeanName);
    }
}
