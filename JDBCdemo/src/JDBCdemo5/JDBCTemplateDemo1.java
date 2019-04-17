package JDBCdemo5;

import JDBCdemo4.JDBCdruidutiles;
import org.springframework.jdbc.core.JdbcTemplate;

/**
         * Spring框架对JDBC的简单封装。提供了一个JDBCTemplate对象简化JDBC的开发
         * 步骤：
                 1. 导入jar包
                 2. 创建JdbcTemplate对象。依赖于数据源DataSource ds
                     * JdbcTemplate template = new JdbcTemplate(ds);
 */
public class JDBCTemplateDemo1 {

    public static void main(String[] args) {

        JdbcTemplate template=new JdbcTemplate(JDBCdruidutiles.getDataSource());
        String sql="update user  set password=? where id=4";
        int i = template.update(sql, "0123");
        System.out.println(i);
    }
}
