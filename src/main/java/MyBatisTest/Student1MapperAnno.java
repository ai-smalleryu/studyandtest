package MyBatisTest;

import org.apache.ibatis.annotations.Select;

/*
基于注解的接口
 */
public interface Student1MapperAnno {
    @Select("select * from student1 where id" +
            "=#{id}")
    public Student1 getStudentId(int id);
}
