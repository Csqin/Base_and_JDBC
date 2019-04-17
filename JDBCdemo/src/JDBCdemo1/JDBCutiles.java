package JDBCdemo1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
             * ## 抽取JDBC工具类 ： JDBCUtils
             * 目的：简化书写
             * 分析：
             1. 注册驱动也抽取
             2. 抽取一个方法获取连接对象
             * 需求：不想传递参数（麻烦），还得保证工具类的通用性。
             * 解决：配置文件
             jdbc.properties
             url=
             user=
             password=
 */
public class JDBCutiles {

    private   static  String url;
    private   static  String user;
    private   static  String password;
    private   static  String driver;
    /**
     * 文件的读取，只需要读取一次即可拿到这些值。使用静态代码块
     */
    static
    {
        //读取资源文件，获取值。
        try {
                     //1. 创建Properties集合类。
                    Properties properties=new Properties();
                    //获取src路径下的文件的方式--->ClassLoader 类加载器
                    ClassLoader classLoader = JDBCutiles.class.getClassLoader();

                    //返回值为URL
                    URL resource = classLoader.getResource("propertie.properties");

                    //通过getPath()方法获取String类型的路径
                    String path = resource.getPath();

                     //2. 加载文件
                    properties.load(new FileReader(path));

                    //3. 获取数据，赋值
                     driver = properties.getProperty("driver");
                    user = properties.getProperty("user");
                     password = properties.getProperty("password");
                     url = properties.getProperty("url");

                    //4. 注册驱动
                    Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }


    /**
     * 释放资源
     * @param statement
     * @param connection
     */
    public  static  void close(Statement statement, Connection connection)
    {
          if(statement !=null)
          {
              try {
                  statement.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }

        if(connection !=null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public  static  void close(ResultSet resultSet, Statement statement, Connection connection)
    {
        if(resultSet !=null)
        {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement !=null)
        {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection !=null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
