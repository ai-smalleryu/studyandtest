package MyBatisTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        MybatisTest mybatisTest = new MybatisTest();
        mybatisTest.test3();
    }

    public void test1() throws IOException {
        String resource = "MybatisTest/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //唯一标识和mapper的id一样但是为了能够不造成名称相同的情况下使得引用混论一般用mapper的namespace+id作为第一个唯一标识符，
            Student1 student1 = sqlSession.selectOne("MyBatisTest.StudentMapperInter.getStudentId", 2);
            System.out.println(student1 + "学生信息");
        } finally {
            sqlSession.close();
        }

    }

    public void test2() throws IOException {
        String resource = "MyBatisTest/mybatis-config.xml";
        InputStream input = Resources.getResourceAsStream(resource);
        //建立sqlssionfact对象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(input);
        //打开对象opensession
        SqlSession sqlSession = build.openSession();
        try {
            //获得接口的实现对象
            StudentMapperInter mapper = sqlSession.getMapper(StudentMapperInter.class);
            Student1 studentId = mapper.getStudentId(2);
            System.out.println(studentId);

        } finally {
            sqlSession.close();
        }

    }

    public void test3() throws IOException {
        String source = "MyBatisTest/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(source);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        try {
            Student1MapperAnno mapper = sqlSession.getMapper(Student1MapperAnno.class);
            Student1 studentId = mapper.getStudentId(2);
            System.out.println(studentId);
        } finally {
            sqlSession.close();
        }
    }
}
