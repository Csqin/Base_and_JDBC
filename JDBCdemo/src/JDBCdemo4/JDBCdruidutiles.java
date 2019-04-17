package JDBCdemo4;

import JDBCdemo1.JDBCutiles;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCdruidutiles {

    private static DataSource dataSource;

             static
                {
                    try {
                        //1.加载配置文件
                        Properties properties=new Properties();
                        InputStream in = JDBCutiles.class.getClassLoader().getResourceAsStream("druid.properties");
                        properties.load(in);
                        //2.获取DataSource
                        dataSource = DruidDataSourceFactory.createDataSource(properties);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                /**
                 * 获取连接
                 */
                public  static  Connection getConnection() throws SQLException {
                    return  dataSource.getConnection();
                }

                public  static  DataSource getDataSource()
                {
                    return  dataSource;
                }
                /**
                 * 释放资源
                 */

                public  static   void close( Statement statement, Connection connection)
                {
                    JDBCdruidutiles.close(null,statement,connection);
                }
                public  static   void close(ResultSet resultSet, Statement statement, Connection connection)
                {
                    if (resultSet !=null){
                        try {
                            resultSet.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (statement !=null){
                        try {
                            resultSet.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection !=null){
                        try {
                            resultSet.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }


}
