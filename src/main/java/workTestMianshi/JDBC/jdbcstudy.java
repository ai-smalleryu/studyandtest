package workTestMianshi.JDBC;

import JDBCDatabase.Student1;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcstudy {
    public static void main(String[] args) throws ClassNotFoundException {

        String driver = "com.mysql.cj.jdbc.Driver";
        //数据库信息包括url name password
        String url = "jdbc:mysql://localhost:3306/stu";//数据库连接最后是需要进入的库
        String name = "root";//密码
        String password = "root";
        String sql = "select * from student1";
        Class.forName(driver);
        List<Student1> student1s = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, name, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();
             Statement statement = con.createStatement(); ) {
            boolean b = statement.execute(sql);
            /**
             * execute可以运行任何sql语句返回的是Boolean值
             * executeQuery是select
             */
            System.out.println(b+"布尔值");
            if (b) {
                ResultSet resultSet1 = statement.getResultSet();
                while (resultSet1.next()) {
                    Student1 student1 = new Student1();
                    student1.setId(resultSet1.getInt("id"));
                    student1.setName(resultSet1.getString("name"));
                    student1.setPassword(resultSet1.getString("password"));
                    student1.setAge(resultSet1.getInt("age"));
                    System.out.println(student1);
                }

            }
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
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            ResultSetMetaData metaData = resultSet.getMetaData();//获得表格级别的元数据
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.println(metaData.getColumnTypeName(i));
                System.out.println(metaData.getColumnCount()+"==="+metaData.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
//获得这个数据库中所有的表格
class StudaJDBC {
    public static void main(String[] args) throws ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        //数据库信息包括url name password
        String url = "jdbc:mysql://localhost:3306/stu";//数据库连接最后是需要进入的库
        String name = "root";//密码
        String password = "root";
        Class.forName(driver);
        try (Connection con = DriverManager.getConnection(url, name, password);
        ) {
            DatabaseMetaData metaData = con.getMetaData();
            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
            //取出所有相关 的元数据
            while (tables.next()){
                //获得的分别是数据库名-----------null----------------------数据库中表名
                System.out.println(tables.getString(1)+"=="+tables.getString(2)+"0000000"+tables.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class testBanch{
    public static void main(String[] args) throws ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        //数据库信息包括url name password
        String url = "jdbc:mysql://localhost:3306/stu";//数据库连接最后是需要进入的库
        String name = "root";//密码
        String password = "root";
        Class.forName(driver);
        String sql="insert into student1(name,password,age)values('tom','passs',13)";
        try (Connection connection=DriverManager.getConnection(url,name,password);
        ){

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}