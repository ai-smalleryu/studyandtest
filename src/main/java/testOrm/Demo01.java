package testOrm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
测试使用object数组封装一条记录
 */
public class Demo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = PropertJdbc.connectionFactory();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //new ArrayList<>()
        try {
            String sql="select * from emp where id =?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,1);
            resultSet = preparedStatement.executeQuery();
            List<Object> o=null;
            while (resultSet.next())
            {
                o=new ArrayList<>();
                System.out.println(resultSet.getInt("id")+resultSet.getString("empname")+
                        resultSet.getDouble("salary")+resultSet.getDate("birthday"));

                System.out.println(resultSet.getInt(1)+resultSet.getString(2)+
                        resultSet.getDouble(3)+resultSet.getDate(4));

                o.add(resultSet.getObject(1));
                o.add(resultSet.getObject(2));
                o.add(resultSet.getObject(3));
                o.add(resultSet.getObject(4));
            }
            for (Object o1:o) {
                System.out.println(o1+"信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }


    }
}
