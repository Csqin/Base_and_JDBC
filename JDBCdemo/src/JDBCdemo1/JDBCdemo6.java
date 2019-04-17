package JDBCdemo1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
     * 	* 练习：
         * 需求：
            1. 通过键盘录入用户名和密码
            2. 判断用户是否登录成功
                * select * from user where username = "" and password = "";
                * 如果这个sql有查询结果，则成功，反之，则失败
 */

/**
 *  1. SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接。会造成安全性问题
             1. 输入用户随便，输入密码：a' or 'a' = 'a
             2. sql：select * from user where username = 'fhdsjkf' and password = 'a' or 'a' = 'a'
 */
public class JDBCdemo6 {

    public static void main(String[] args) {
        //1.键盘录入，接受用户名和密码
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();

        //2.调用方法
        boolean flage = new JDBCdemo6().login(username, password);
        //3.判断结果，输出不同语句
        if (flage)
            {
                System.out.println("登录成功");
            }
        else
            {
                System.out.println("用户名或密码错误");
            }
    }

    /**
     * 登录方法
     */
    private   boolean login(String username,String password)
    {
        Connection connection =null;
        Statement statement =null;
        ResultSet resultSet=null;

        //连接数据库判断是否登录成功
        if (username==null || password==null)
        {
            return  false;
        }
        //1.获取连接
        try
        {

            connection = JDBCutiles.getConnection();

            //2.定义sql
            String sql="select *  from user where username='"+username+"' and password='"+password+"' ";

            //3.获取执行sql的对象
            statement = connection.createStatement();

            //4.执行查询
            statement.executeQuery(sql);
            resultSet = statement.getResultSet();

            //5.判断
            return resultSet.next();  //如果有下一行，则返回true

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
                JDBCutiles.close(resultSet,statement,connection);
        }

        return  false;
    }
}
