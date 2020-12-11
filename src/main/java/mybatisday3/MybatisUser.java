package mybatisday3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MybatisUser {
    public static void main(String[] args) {
        test4();
    }

    /*
      User selectUserId(int id);
    List<User> getUserlikename(String str);

    User getUserByMap(Map<String ,Object> map);
    int deleteId(int id);

     */
    static String source = "mybatisday3/mybatis-config.xml";

    public static void test1() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(source);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectUserId(2);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(source);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userlikename = mapper.getUserlikename("ja%");
            for (User u : userlikename
            ) {
                System.out.println(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test3() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(source);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("id",4);
            hashMap.put("name","dest");
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userByMap = mapper.getUserByMap(hashMap);
            for (User u:userByMap
                 ) {
                System.out.println(u);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
    public static void test4(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(source);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int i = mapper.deleteId(2);
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
