package org.example.distributed.transactions;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @link https://seata.io/zh-cn/docs/overview/what-is-seata.html
 *
 * @author liyunfei
 **/
public class JdbcTest {

       @Test
       public void testMySQLTransaction() throws ClassNotFoundException, SQLException {
              Class.forName("");
              Connection connection = DriverManager.getConnection("","","");
              Statement statement = connection.createStatement();
              statement.execute("");
              try {
                  connection.commit();
              }catch (Exception e){
                  connection.rollback();
              }finally {
                  connection.close();
              }
       }
}
