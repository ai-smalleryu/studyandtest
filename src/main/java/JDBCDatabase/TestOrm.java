package JDBCDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class TestOrm {
    static Connection con;
    static
    {
        PropertJdbc propertJdbc = new PropertJdbc();
        try {
            con= propertJdbc.connectionFactory();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
