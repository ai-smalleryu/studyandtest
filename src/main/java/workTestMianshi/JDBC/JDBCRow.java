package workTestMianshi.JDBC;

import com.mysql.cj.xdevapi.RowFactory;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class JDBCRow {
    static String driver;
    static String url;
    static String name;
    static String password;

    static {
        driver = "com.mysql.cj.jdbc.Driver";
        //数据库信息包括url name password
        url = "jdbc:mysql://localhost:3306/stu";//数据库连接最后是需要进入的库
        name = "root";//密码
        password = "root";
    }

    public static void main(String[] args) {
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "select * from student1";
        try (Connection con = DriverManager.getConnection(url, name, password);
             PreparedStatement s = con.prepareStatement(sql);
        ) {
            ResultSet resultSet = s.executeQuery();
            //创造行集对象
            //行集是为了解决数据在数据库连接时候数据是可见的，但是当数据库连接关闭时数据是会消失的这对于数据
            // 需要持久显示是不利的，行集是保存查询出的数据，当数据库连接关闭时数据依旧是可以进行读取
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.populate(resultSet);
            while (cachedRowSet.next()){
                System.out.println(cachedRowSet.getInt(1)+cachedRowSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
