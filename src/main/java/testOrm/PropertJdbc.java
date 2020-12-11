package testOrm;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PropertJdbc {
   static String driver;
    static String url;
    static  String name;
    static String password;
    static
    {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("E:\\JavaTest\\untitled\\src\\jdbc.properties"));
            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            name=properties.getProperty("name");
            password=properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public static  Connection connectionFactory() throws ClassNotFoundException, SQLException {
    Class.forName(driver);
    long l = System.currentTimeMillis();
    Connection connection = DriverManager.getConnection(url, name, password);
    long l2 = System.currentTimeMillis();

    return  connection;
}
}
