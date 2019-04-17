package JDBCdemo2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 	* 练习：
 * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 1. 定义Emp类
 2. 定义方法 public List<Emp> findAll(){}
 3. 实现方法 select * from emp;
 */
@SuppressWarnings("ALL")
public class JDBCdemo5 {
    public static void main(String[] args) {
        List<Emp> list = new JDBCdemo5().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    public List<Emp> findAll()
    {
        //变量抽取，为最后释放资源提供判断
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        List<Emp> list=null;
        Emp emp=null;
        try
        {
            //连接数据库
             Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
             statement = connection.createStatement();
             String sql="select * from emp";
             resultSet = statement.executeQuery(sql);
             //创建Emp类型的 ArrayList集合
             list=new ArrayList<Emp>();
            while(resultSet.next())
            {
                //获取resultSet接口返回的结果集的数据
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                //创建emp对象
                emp=new Emp();
                                                                                        //多次创建对象，多次赋值
                //给emp对象赋值
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                //emp对象添加到list集合中
                list.add(emp);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //释放资源
        finally
        {
            if (resultSet !=null)
            {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement !=null)
            {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

}
