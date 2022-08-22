package workTestMianshi.JDBC;

import org.junit.Test;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

/**
 * @project studyandtest workTestMianshi.JDBC
 * @description:
 * @author: 玉雨钰瑜
 * @time: 8.1.22 14:13
 */
public class JDBCGetTableMeta {
    static String driver;
    static String url;
    static String name;
    static String password;

    static {
        driver = "com.mysql.cj.jdbc.Driver";
        //数据库信息包括url name password
        url = "jdbc:mysql://localhost:3306/stu";//数据库连接最后是需要进入的库
        name = "root";//密码
        password = "root@1q2w3e";
    }

    public static void main(String[] args) {
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "select * from student limit 1";
        try (Connection con = DriverManager.getConnection(url, name, password);
             PreparedStatement rs = con.prepareStatement(sql);
        ) {
            ResultSetMetaData rsmd = rs.getMetaData();

            //获取当前表格的列数
            int columns = rsmd.getColumnCount();
            System.out.println("列数:" + columns);

            //输出当前表格的表头
            System.out.println("------------------");
            for (int i = 0; i < columns; i++) {
                System.out.print(rsmd.getColumnTypeName(i + 1));
                System.out.println("====");
                //System.out.println(rsmd.getColumnType(i + 1)+"\t");
                System.out.print(rsmd.getColumnName(i + 1) + "\t"+rsmd.getColumnType(i + 1));
            }
            System.out.println();
            System.out.println("------------------");
/*            //输出表数据
            while (rsmd.next()) {
                //输出一行
                for (int i = 0; i < columns; i++) {
                    System.out.print(rs.getObject(i + 1) + "\t");
                }
                System.out.println();
            }*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
