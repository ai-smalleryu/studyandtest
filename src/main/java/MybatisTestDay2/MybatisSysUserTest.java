package MybatisTestDay2;

import MyBatisTest.Student1;
import MyBatisTest.StudentMapperInter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisSysUserTest {
    public static void main(String[] args) throws Exception {
        MybatisSysUserTest mybatisTest = new MybatisSysUserTest();
        mybatisTest.test2();
    }

    @Test
    public void test1() throws IOException {
        String resource = "MybatisTestDay2/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //唯一标识和mapper的id一样但是为了能够不造成名称相同的情况下使得引用混论一般用mapper的namespace+id作为第一个唯一标识符，
            Student1 student1 = sqlSession.selectOne("MybatisTestDay2.SysUserInter.getSaysUsersId", 2);
            System.out.println(student1 + "学生信息");
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void test2() throws IOException {
        String resource = "MybatisTestDay2/mybatis-config.xml";
        InputStream input = Resources.getResourceAsStream(resource);
        //建立sqlssionfact对象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(input);
        //打开对象opensession
        SqlSession sqlSession = build.openSession();
        try {
            //获得接口的实现对象
            SysUserInter mapper = sqlSession.getMapper(SysUserInter.class);
            SysUser saysUsersId = mapper.getSaysUsersId(2);
            //多参数传值时候需要在mapper文件的查询语句使用0 1 或者param1和param2传参
            SysUser saysUsersIdmore = mapper.getSaysUsersIdmore(1, "1223");
            System.out.println(saysUsersIdmore + "param传参");
            //多个参数推荐命名空间，在接口传参时候MybatisTestDay2.SysUserInter
            SysUser saysUsersIdmore1 = mapper.getSaysUsersIdmore2(1, "1223");
            System.out.println(saysUsersIdmore1 + "命名空间");
            System.out.println(saysUsersId + "单参");
            // SysUser saysUsersAll = mapper.getSaysUsersAll(0);


        } finally {
            sqlSession.close();
        }

    }

    public void test3() throws IOException {
        String source = "MybatisTestDay2/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(source);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //sqlsession不会自动提交需要手动设置openSession(true);自动提交
        SqlSession sqlSession = build.openSession();
        try {
            SysUserInter mapper = sqlSession.getMapper(SysUserInter.class);
            SysUser sysUser = new SysUser();
            sysUser.setId(26);
            sysUser.setUserName("jar1ry");
            sysUser.setUserPassword("tea3asa");
            sysUser.setUserEmail("asas@as.mad");
            sysUser.setUserInfo("aaaa");
            sysUser.setUserImg(new byte[]{123, 31, 12});
            mapper.addSysUser(sysUser);
            //手动提交
            sqlSession.commit();
            SysUser sysUsertId = mapper.getSaysUsersId(1);
            System.out.println(sysUsertId.toString());
        } finally {
            sqlSession.close();
        }
    }

    /*
    数组集合的形式特殊处理

    1.对于Collection（List，set）会把传入的List集合和数组转换成map集合的形式
    key：
     */
    //map
    public void test4() throws IOException {
        String source = "MybatisTestDay2/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(source);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //sqlsession不会自动提交需要手动设置openSession(true);自动提交
        SqlSession sqlSession = build.openSession();
        try {
            SysUserInter mapper = sqlSession.getMapper(SysUserInter.class);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", 3);
            hashMap.put("name", "admin3");
            SysUser saysUsersIdMap = mapper.getSaysUsersIdMap(hashMap);
            System.out.println(saysUsersIdMap + "使用map方法");

        } finally {
            sqlSession.close();
        }
    }

    /*
    list 有错误
     */
    public void test5() throws IOException {
        String source = "MybatisTestDay2/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(source);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //sqlsession不会自动提交需要手动设置openSession(true);自动提交
        SqlSession sqlSession = build.openSession();
        try {
            SysUserInter mapper = sqlSession.getMapper(SysUserInter.class);
            /*
            虽然封装成的是list但是取值还是list【0】 这是key值
             */
            ArrayList<Object> objects = new ArrayList<>();
            objects.add(3);
            objects.add("admin3");
            SysUser saysUsersIdMap = mapper.getSaysUsersList(objects);
            System.out.println(saysUsersIdMap + "使用list方法");

        } finally {
            sqlSession.close();
        }
    }

    /*
    如果多个参数经常使用但是不是业务模型的信息，则编写数据对象
    #{}以预编译的形式将参数设置到sql语句中PreparedStatement
    ${}直接拼接sql语句 有安全问题Statement
    大多数情况使用#{}
    比如需要拼接的sql语句
    不是参数情况下比如需要的信息是表明
     */
    public void test6() throws IOException {
        String source = "MybatisTestDay2/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(source);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //sqlsession不会自动提交需要手动设置openSession(true);自动提交
        SqlSession sqlSession = build.openSession();
        try {
            SysUserInter mapper = sqlSession.getMapper(SysUserInter.class);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", 3);
            hashMap.put("name", "admin3");
            hashMap.put("name2", "sys_user");
            SysUser saysUsersIdMap = mapper.getSaysUsersIdMapdoller(hashMap);
            System.out.println(saysUsersIdMap + "使用map方法测试$");

        } finally {
            sqlSession.close();
        }
    }

    public void test7() throws IOException {
        String string = "MybatisTestDay2/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(string);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //需要手动提交 可以在里加true自动提交
        SqlSession sqlSession = build.openSession();
        try {
            SysUserInter mapper = sqlSession.getMapper(SysUserInter.class);
            List<SysUser> sysUserByLikeName = mapper.getSysUserByLikeName("ad%");
            for (SysUser s : sysUserByLikeName) {
                System.out.println(s);
            }
            //使用map的时候不能使用resultMap因为在里的映射回合下面相互冲突
         /*  Map<String, Object> userByLikeName = mapper.getUserMap(2);
            System.out.println(userByLikeName);*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }

    public void test8() throws Exception {
        String sour = "MybatisTestDay2/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(sour);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        try {
            SysUserInter mapper = sqlSession.getMapper(SysUserInter.class);
            List<SysUser> sysUserByLikeName = mapper.getSysUserByLikeName("a%");
            for (SysUser s : sysUserByLikeName
            ) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
