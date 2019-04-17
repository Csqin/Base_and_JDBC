package JDBCdemo4;

import JDBCdemo1.JDBCutiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试JDBCdruidutiles
 */
public class DruidDemo2 {

    public static void main(String[] args) {
        Connection connection =null;
        PreparedStatement preparedStatement=null;

        try
        {
            //获取connection对象
            connection = JDBCdruidutiles.getConnection();
            //定义sql语句
            String sql="insert into user values(null,?,?)";
            //创建执行sql语句对象
            preparedStatement = connection.prepareStatement(sql);
            //给？赋值
            preparedStatement.setString(1,"小李子");
            preparedStatement.setString(2,"123456789");
            //执行sql语句，并且返回受影响的行数
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //归还connection对象
        finally
        {
            JDBCutiles.close(preparedStatement,connection);
        }
    }
}
