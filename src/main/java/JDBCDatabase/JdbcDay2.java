package JDBCDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
测试sql语句和
 */
public class JdbcDay2 {
    public  void TestSql() throws SQLException, ClassNotFoundException {
        PropertJdbc propertJdbc = new PropertJdbc();
        Connection connection = propertJdbc.connectionFactory();
       /* Statement statement = connection.createStatement();
        String string="insert into student1 values(4,'aaaaaa','dddd',23)";//注意数据库的信息约束
        statement.execute(string);*/
        //这种方法只能用来字符串拼接的方法sql语句不灵活，并且容易发生sql注入的危险

        //多使用PreparedStatement,进行预编译
        String sql="insert into student1 values (?,?,?,?)";//索引从1开始

        PreparedStatement pt = connection.prepareStatement(sql);
        pt.setInt(1,12);
        pt.setString(2,"name");
        pt.setString(3,"sasdq");
        pt.setInt(4,23);
        pt.executeUpdate();
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JdbcDay2 jdbcDay2 = new JdbcDay2();
        jdbcDay2.TestSql();
        }
}
