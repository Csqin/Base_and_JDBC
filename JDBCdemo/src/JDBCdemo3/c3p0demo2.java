package JDBCdemo3;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0demo2 {

    public static void main(String[] args) throws SQLException {

         ////1.创建数据库连接池对象
         DataSource dataSourceour=new ComboPooledDataSource();
        Connection connection =null;
        //2. 获取连接对象
        for (int i = 1; i <=11; i++)
        {
            connection = dataSourceour.getConnection();
            System.out.println(i+":"+connection);
            //获取第五个对象时
            if (i==5)
            {
                //归还连接对象
                connection.close();
            }
        }
        //归还全部连接对象
        connection.close();
    }



}
