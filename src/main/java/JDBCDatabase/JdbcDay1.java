package JDBCDatabase;

import com.google.common.collect.Sets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class JdbcDay1 {

    public static void main(String[] args) {
        //开发
        String dev="studio:update,studio:delete,api:delete,studio:add,catalogue:delete,api:update,catalogue:update,catalogue:add,api:add";
        //运维
        String devops="alertHistory:delete,alertHistory:update,task:delete,alertGroup:update,task:update,alertGroup:add,task:add,alertInstance:update,alertHistory:add,alertInstance:add,alertGroup:delete,alertInstance:delete";
        //共有的权限
        String common="jobInstance:delete,alertInstance:get,savePoint:add,studio:get,savePoint:delete,jobInstance:update,history:get,catalogue:get,database:update,metaData:delete,statement:add,document:update,clusterConfig:update,note:add,sysConfig:get,metaData:get,note:delete,jobInstance:get,database:add,cluster:delete,sysConfig:update,cluster:get,history:update,history:delete,clusterConfig:add,jar:delete,api:get,cluster:add,jar:get,database:get,jar:update,note:update,statement:update,document:get,history:add,alertGroup:get,savePoint:get,statement:delete,task:get,cluster:update,document:add,sysConfig:delete,savePoint:update,jobInstance:add,metaData:add,alertHistory:get,sysConfig:add,database:delete,metaData:update,statement:get,clusterConfig:delete,note:get,clusterConfig:get,jar:add,document:delete";
        Set<String> commons = Arrays.stream(common.split(",")).collect(Collectors.toSet());
        Set<String> devSets = Arrays.stream(dev.split(",")).collect(Collectors.toSet());
        Set<String> devopSets = Arrays.stream(devops.split(",")).collect(Collectors.toSet());

        Set devopsPermissions = Sets.union(commons, devopSets);
        Set devPermissions = Sets.union(commons, devSets);

        Connection con;
        String driver="com.mysql.cj.jdbc.Driver";
        //数据库信息包括url name password
        String url="jdbc:mysql://localhost:3306/stu";//数据库连接最后是需要进入的库
        String name="root";//密码
        String password="root@1q2w3e";
        ResultSet resultSet;
        Statement statement;
        try{
            ArrayList<Student1> student1s = new ArrayList<>();
            Class.forName(driver);
            con = DriverManager.getConnection(url, name, password);
            statement = con.createStatement();
            String sql="select id from student";
            resultSet = statement.executeQuery(sql);
            Student1 student1=null;
            while (resultSet.next())
            {
              student1=new Student1();;
                student1.setId(resultSet.getInt("id"));
                student1.setName(resultSet.getString("name"));
                student1.setAge(resultSet.getInt("age"));
                student1s.add(student1);
               // System.out.println(resultSet.getInt("id")+"=="+resultSet.getString("name")+resultSet.getString("password")+resultSet.getInt("age"));
            }
            for (Student1 s:student1s) {
                System.out.println(s.toString()+"=======");
            }
        }catch (Exception e)
        {
            System.out.println("错误");
            e.printStackTrace();
        }finally {


        }
    }
}

class Test{
    public static void main(String[] args) {
        //开发
        String dev="studio:update,studio:delete,api:delete,studio:add,catalogue:delete,api:update,catalogue:update,catalogue:add,api:add";
        //运维
        String devops="alertHistory:delete,alertHistory:update,task:delete,alertGroup:update,task:update,alertGroup:add,task:add,alertInstance:update,alertHistory:add,alertInstance:add,alertGroup:delete,alertInstance:delete";
        //共有的权限
        String common="jobInstance:delete,alertInstance:get,savePoint:add,studio:get,savePoint:delete,jobInstance:update,history:get,catalogue:get,database:update,metaData:delete,statement:add,document:update,clusterConfig:update,note:add,sysConfig:get,metaData:get,note:delete,jobInstance:get,database:add,cluster:delete,sysConfig:update,cluster:get,history:update,history:delete,clusterConfig:add,jar:delete,api:get,cluster:add,jar:get,database:get,jar:update,note:update,statement:update,document:get,history:add,alertGroup:get,savePoint:get,statement:delete,task:get,cluster:update,document:add,sysConfig:delete,savePoint:update,jobInstance:add,metaData:add,alertHistory:get,sysConfig:add,database:delete,metaData:update,statement:get,clusterConfig:delete,note:get,clusterConfig:get,jar:add,document:delete";
        Set<String> commons = Arrays.stream(common.split(",")).collect(Collectors.toSet());
        Set<String> devSets = Arrays.stream(dev.split(",")).collect(Collectors.toSet());
        Set<String> devopSets = Arrays.stream(devops.split(",")).collect(Collectors.toSet());
        Set devopsPermissions = Sets.union(commons, devopSets);
        Set devPermissions = Sets.union(commons, devSets);
        System.out.println(devopsPermissions.size() +"\t"+devPermissions.size());

        String s1 = devops + "," + common;
        String s2= dev+","+common;
        String s1ops="";
        for (String s : s1.split(",")) {
            s1ops+="'"+s+"',";
        }
        System.out.println(s1ops);

        String s2devs="";
        for (String s : s2.split(",")) {
            s2devs+="'"+s+"',";
        }
        System.out.println(s2devs);
    }
}
