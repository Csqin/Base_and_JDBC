package JDBCdemo1;

import java.sql.*;
import java.util.Scanner;

/**
 *  PreparedStatement：执行sql的对象
 1. SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接。会造成安全性问题
         1. 输入用户随便，输入密码：a' or 'a' = 'a
         2. sql：select * from user where username = 'fhdsjkf' and password = 'a' or 'a' = 'a'

 2. 解决sql注入问题：使用PreparedStatement对象来解决
 3. 预编译的SQL：参数使用?作为占位符
 4. 步骤：
         1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
         2. 注册驱动
         3. 获取数据库连接对象 Connection
         4. 定义sql
         * 注意：sql的参数使用？作为占位符。 如：select * from user where username = ? and password = ?;
         5. 获取执行sql语句的对象 PreparedStatement  Connection.prepareStatement(String sql)
         6. 给？赋值：
         * 方法： setXxx(参数1,参数2)
         * 参数1：？的位置编号 从1 开始
         * 参数2：？的值
         7. 执行sql，接受返回结果，不需要传递sql语句
         8. 处理结果
         9. 释放资源

 5. 注意：后期都会使用PreparedStatement来完成增删改查的所有操作
         1. 可以防止SQL注入
         2. 效率更高
 */
public class JDBCdemo7 {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();

        boolean flage = new JDBCdemo7().login2(username, password);
        if (flage)
            {
                System.out.println("登录成功");
            }
        else
            {
                System.out.println("用户名或密码错误");
            }
    }


    private   boolean login2(String username,String password)
    {
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        if (username==null || password==null)
        {
            return  false;
        }
        try
        {

            connection = JDBCutiles.getConnection();
            String sql="select *  from user where username=? and password=? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
                //释放资源
                JDBCutiles.close(resultSet,preparedStatement,connection);
        }

        return  false;
    }
}
