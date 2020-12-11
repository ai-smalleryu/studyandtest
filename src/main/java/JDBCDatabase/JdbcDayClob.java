package JDBCDatabase;

import java.sql.*;
import java.util.ArrayList;

public class JdbcDayClob {

    public static void main(String[] args) {
        Connection con;
        String driver = "com.mysql.cj.jdbc.Driver";
        //数据库信息包括url name password
        String url = "jdbc:mysql://localhost:3306/stu";//数据库连接最后是需要进入的库
        String name = "root";//密码
        String password = "root";
        ResultSet resultSet;
        PreparedStatement statement;
        try {
            ArrayList<Student1> student1s = new ArrayList<>();
            Class.forName(driver);
            con = DriverManager.getConnection(url, name, password);

            String sql = "select * from student1";
            //Clob大数据存储时候
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            Student1 student1 = null;
            while (resultSet.next()) {
                student1 = new Student1();
                student1.setId(resultSet.getInt("id"));
                student1.setName(resultSet.getString("name"));
                student1.setPassword(resultSet.getString("password"));
                student1.setAge(resultSet.getInt("age"));
                student1s.add(student1);
                // System.out.println(resultSet.getInt("id")+"=="+resultSet.getString("name")+resultSet.getString("password")+resultSet.getInt("age"));
            }
            for (Student1 s : student1s) {
                System.out.println(s.toString() + "=======");
            }
        } catch (Exception e) {
            System.out.println("错误");
            e.printStackTrace();
        } finally {


        }
    }
}


