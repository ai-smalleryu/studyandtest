package JDBCDatabase;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.sql.*;

/*
测试时间
 */
public class JdbcDateTime {
    static Connection connection;
    static PreparedStatement statement;
    static
    {
        PropertJdbc propertJdbc = new PropertJdbc();
        try {
            connection=propertJdbc.connectionFactory();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public long date(String  s)
    {

        return  1;
    }
    public void testDate()
    {
        try
        {
            String sql="insert into datatest values(?,?,?)";
             statement = connection.prepareStatement(sql);
            Date date = new Date(System.currentTimeMillis());//时间知道日年月日的组合
            for (int i = 0; i < 1000; i++) {

            }
            System.out.println("另外一个信息");
            statement.setInt(1,12);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            statement.setDate(2,date);
            statement.setTimestamp(3,timestamp);
            statement.execute();

            //将程序中的字符串存入到数据库中的CLOB中
           // statement.setClob(1,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaas".getBytes()))));
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
          try {
              if (statement!=null) {
                  statement.close();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
            try {
                if (connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JdbcDateTime jdbcDateTime = new JdbcDateTime();
        jdbcDateTime.testDate();
    }
}
