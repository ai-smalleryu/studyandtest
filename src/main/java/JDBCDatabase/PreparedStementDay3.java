package JDBCDatabase;

import java.sql.*;
/*
批操作
 */
public class PreparedStementDay3 {
    static Connection connection;
    static  Statement statement;

    static
    {
        PropertJdbc propertJdbc = new PropertJdbc();
        try {
            connection= propertJdbc.connectionFactory();
            System.out.println(connection+"测试");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void Test1() throws SQLException {
       try
       {
           //批处理操作使用Statement
           connection.setAutoCommit(false);//设置手动提交
           statement = connection.createStatement();
           long l=System.currentTimeMillis();
           for (int i=13;i<10000;i++)
           {
               statement.addBatch("insert into student1 (name ,password,age) values ('tom','sss',13)");
           }
           statement.executeBatch();
           connection.commit();
           long end=System.currentTimeMillis();
           System.out.println(end-l);
          /* String s="select * from student1 where id > ?";
           PreparedStatement preparedStatement = connection.prepareStatement(s);

           preparedStatement.setInt(1,2);
           ResultSet resultSet = preparedStatement.executeQuery();
           Student1 student1=null;
           while (resultSet.next())
           {
               student1=new Student1();
               System.out.println( resultSet.getInt("id")+resultSet.getString("name")+resultSet.getString("password")+resultSet.getInt("age"));
               System.out.println( resultSet.getInt(1)+resultSet.getString(2)+resultSet.getString(3)+resultSet.getInt(4));
               student1.setId(resultSet.getInt(1));
               student1.setName(resultSet.getString(2));
               student1.setPassword(resultSet.getString(3));
               student1.setAge(resultSet.getInt(4));
               System.out.println(student1+"@");
           }*/


       }catch (Exception e)
       {
           e.printStackTrace();
       }finally {
           try{if (statement!=null)statement.close();}catch (Exception e){e.printStackTrace();}
           try{if (connection!=null)connection.close();}catch (Exception e){e.printStackTrace();}
          // try{if (statement!=null)statement.close();}catch (Exception e){e.printStackTrace();}
       }
    }

    public static void main(String[] args) throws SQLException {
        PreparedStementDay3 preparedStementDay3 = new PreparedStementDay3();
      //  preparedStementDay3.Test1();


    }
}
