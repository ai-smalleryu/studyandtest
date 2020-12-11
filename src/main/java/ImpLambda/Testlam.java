package ImpLambda;


import java.sql.*;
import java.util.StringJoiner;

public class Testlam {
    static
    {
        Connection connection=null;
        try {
            System.out.println("init---");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    }
}
