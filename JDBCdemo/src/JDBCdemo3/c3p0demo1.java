package JDBCdemo3;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0demo1 {

    public static void main(String[] args) throws SQLException {

         ////1.创建数据库连接池对象
         DataSource dataSourceour=new ComboPooledDataSource();
        //2. 获取连接对象
         Connection connection = dataSourceour.getConnection();

         System.out.println(connection);
         //归还连接对象
         connection.close();
    }



}
