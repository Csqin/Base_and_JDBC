package JDBCdemo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ## JDBC控制事务：
    1. 事务：一个包含多个步骤的业务操作。如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败。
    2. 操作：
         1. 开启事务
         2. 提交事务
         3. 回滚事务
    3. 使用Connection对象来管理事务
         * 开启事务：setAutoCommit(boolean autoCommit) ：调用该方法设置参数为false，即开启事务
         * 在执行sql之前开启事务
         * 提交事务：commit()
         * 当所有sql都执行完提交事务
         * 回滚事务：rollback()
         * 在catch中回滚事务
 */
public class JDBCdemo8 {

    public static void main(String[] args) {
        Connection connection =null;
        PreparedStatement preparedStatement1 =null;
        PreparedStatement preparedStatement2 =null;
        try
        {
            //1.获取连接
            connection = JDBCutiles.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            //2.定义sql
            String sql1=" update account  set balance=balance - ? where  id= ?";
            String sql2=" update account  set balance=balance + ? where id= ?";
            //3.获取执行sql对象
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);
            //4. 设置参数
            preparedStatement1.setDouble(1,500);
            preparedStatement1.setInt(2,1);

            preparedStatement2.setDouble(1,500);
            preparedStatement2.setInt(2,2);
            //5.执行sql

            preparedStatement1.executeUpdate();
            //手动制造异常
            int i=3/0;
            preparedStatement2.executeUpdate();
            //提交事务
           connection.commit();

        } catch (Exception e) {
            //事务回滚
            try {
                if(connection != null)
                {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        finally
        {
            JDBCutiles.close(preparedStatement1,connection);
            JDBCutiles.close(preparedStatement2,null);
        }
    }
}
