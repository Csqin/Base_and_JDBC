package JDBCdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCRUDdemo3 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
                statement = connection.createStatement();
                String sql="delete  from str   where name= ''  ";
                int i = statement.executeUpdate(sql);
                System.out.println(i);

                if (i>0){ System.out.println("删除成功"); }
                else {System.out.println("删除失败"); }
        }
        catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (statement !=null)
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
}
