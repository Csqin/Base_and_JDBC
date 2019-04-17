package JDBCdemo5;

import JDBCdemo2.Emp;
import JDBCdemo4.JDBCdruidutiles;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JDBCTemplateDemo2 {

         private    JdbcTemplate template=new JdbcTemplate(JDBCdruidutiles.getDataSource());
         //修改db1里的emp表
        //1. 修改1001号数据的 salary 为 10000
       @Test
        public  void test1()
       {
               String sql="update emp set salary =?  where id = ?";
               int i = template.update(sql,10000,1001);
               System.out.println(i);
       }
        // 2. 添加一条记录
        @Test
        public  void test2()
        {
            String sql="insert into emp(id,ename,dept_id)  values(?,?,?)";
            int i = template.update(sql, 1015, "小李子", 20);
            System.out.println(i);
        }
        //3. 删除刚才添加的记录
        @Test
        public  void test3()
        {
            String sql="delete from emp where id=?";
            int i = template.update(sql, 1015);
            System.out.println(i);
        }
        //4. 查询id为1001的记录，将其封装为Map集合
        @Test
        public  void test4()
        {
            String sql="select * from emp where id=?";
            Map<String, Object> map = template.queryForMap(sql, 1001);
            System.out.println(map);
        }
        //	5. 查询所有记录，将其封装为List
        @Test
        public  void test5()
        {
            String sql="select * from emp ";
            List<Map<String, Object>> list = template.queryForList(sql);

            for (Map<String, Object> stringObjectMap : list) {
                System.out.println(stringObjectMap);
            }
        }
        //	6. 查询所有记录，将其封装为Emp对象的List集合
        @Test
        public  void test6()
        {
            String sql="select * from emp ";
            List<Emp> empList = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
            for (Emp emp : empList) {
                System.out.println(emp);
            }
        }
        //	7. 查询总记录数
        @Test
        public  void test7()
        {
            String sql=" select count(id) from emp";
            Integer integer = template.queryForObject(sql, int.class);
            System.out.println(integer);
        }
}
