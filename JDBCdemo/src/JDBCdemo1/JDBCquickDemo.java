package JDBCdemo1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
@SuppressWarnings("all")
public class JDBCquickDemo {
    public static void main(String[] args) throws Exception {

        //1。导入驱动jar包
        //2.注册驱动（加载进内存）
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象
        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
        //连接本机mysql时，端口号为默认的3306时，可以简写成为下列语句
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
        //sql语句
        String sql="update  str set score=98  WHERE id=2";
        //创建statement对象执行sql语句
        Statement statement = connection.createStatement();
        //执行成功返回受影响的行数
        int i = statement.executeUpdate(sql);

        if (i>0){System.out.println("Succeess"); }
        else { System.out.println("erorr"); }

        statement.close();
        connection.close();
    }
}
