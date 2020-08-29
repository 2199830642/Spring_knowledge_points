package chen.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 *        耦合：程序间的依赖关系
 *              包括：类之间的依赖
 *                   方法间的依赖
 */
public class JDBCDemo01 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Spring","root","1nianzhijian");
        //3.获取操作数据库的预处理对象
        PreparedStatement ps = conn.prepareStatement("select * from account");
        //4.执行sql，获取结果集
        ResultSet rs = ps.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
