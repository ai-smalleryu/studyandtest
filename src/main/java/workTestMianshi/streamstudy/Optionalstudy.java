package workTestMianshi.streamstudy;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Optional容器对象
 */
public class Optionalstudy {
    public static void main(String[] args) {
        //test();
        //testempty();
        testClas();
        test6();
    }

    @Test
    private static void testClas() {

        Optional<Student> optionalStudent = Optional.of(new Student(1, "tom"));
        if (optionalStudent.isPresent()) {//判断Option中是否有数据有返回true
            Student student = optionalStudent.get();//get取出数据
            System.out.println(student);
        }
        Stream<Student> studentStream =
                Stream.of(new Student(1, "yom"), new Student(2, "mk"));//创建对象放入到流中
        //获取流中的信息并且转换生成map集合
        Map<Integer, String> map = studentStream.collect(Collectors.toMap(Student::getId, Student::getName));
        map.forEach((k, v) -> System.out.println(k + "--->" + v));
    }

    private static void testempty() {
        Optional<Integer> empty = Optional.empty();
        if (empty.isPresent()) {
            empty.get();
        }//如果这个集合有值则取值
        else {
            System.out.println("------");
        }
    }

    private static void test() {
        Optional<Integer> optionalInteger = Optional.empty();//声明一个空的Optional
        Integer integer = optionalInteger.orElse(1000);
        System.out.println(optionalInteger.orElse(100));//如果值是空则输出100
    }

    private static void test6() {
        System.out.println("-------------------------------");
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"tom"));
        students.add(new Student(2,"tom"));
        students.add(new Student(3,"tom"));
        students.add(new Student(4,"tom"));
        students.add(new Student(5,"tom"));
        students.stream().map(s->s.getId()).filter(w->w>3).forEach(System.out::println);
        System.out.println("-------------------------------");
    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


