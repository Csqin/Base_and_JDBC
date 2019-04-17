package JDBCdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCRUDdemo1 {

    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        //抛出异常（防止找不见数据库驱动）
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String sql="insert into str  values(2,'c',100)";
            //创建数据库连接对象
            connection= DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            //创建statement对象执行sql语句
            statement = connection.createStatement();
            //获取statement对象执行返回受影响的行数
            int i   = statement.executeUpdate(sql);
            System.out.println(i);
            if (i>0)
            {
                System.out.println("添加成功");
            }
            else
            {
                System.out.println("添加失败");
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            //避免空指针异常（sql语句错误）
            //释放资源
             if (statement !=null)
             {
                 try {
                     statement.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
            //避免空指针异常（连接语句错误）
            if (connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
