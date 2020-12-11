package workTestMianshi.JDBC;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class AutoClum {
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
        String sql = "insert into student1 ( name ) values ('asdazz'),('csssx')";
        try (Connection connection = DriverManager.getConnection(url, name, password);
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            while (keys.next()) {
                System.out.println(keys.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


class AutoIncrementTest {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO users(name) values('tom')";
        try (Connection connection =
                     DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "peter", "820517")) {
            Statement statement = connection.createStatement();
           /* statement.execute("DROP TABLE IF EXISTS users");
            statement.execute("create table users(id int primary key auto_increment, name varchar(20))");
            statement.executeUpdate("INSERT INTO users(name) values('jerry')");*/
            statement.executeUpdate(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet key = statement.getGeneratedKeys();
            if (key != null) {
                key.next();
                System.out.println(key.getInt(1));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

class LobTest {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "peter", "820517")) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS lob");
            statement.execute("create table lob(id int, b_lob longblob, c_lob longtext)");
/**
 * LOB:  Large Object
 *
 * 1. blob二进制大对象，存放图片，视频，文件等
 * 2. clob字符大对象，存放大量的文本。mysql中叫做text类型
 *
 * create table lob(
 * 	id int,
 * 	b_lob longblob,
 * 	c_lob longtext
 * );
 */
        //存储二进制文件
            Blob blob = connection.createBlob();
            OutputStream outputStream = blob.setBinaryStream(1);
            InputStream inputStream
                    = new BufferedInputStream(new FileInputStream("p.png"));
            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }
            outputStream.flush();

            PreparedStatement preparedStatement
                    = connection.prepareStatement("INSERT INTO lob (id, b_lob) values(?,?)");
            preparedStatement.setInt(1, 1);
            preparedStatement.setBlob(2, blob);

            preparedStatement.execute();

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}























