package ImpLambda;

import designpatterns23.bridge.Apple;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author Administrator
 * @PACKAGE_NAME: ImpLambda
 * @PROJECT_NAME: studyandtest
 * @DESCRIPTION:
 * @USER: Administrator
 * @DATE: 2020/11/23 9:41
 */
public class LamFilter {
    @Test
    public void test1() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom", 8900, 11, "male", "New York"));
        personList.add(new Person("Jack", 7000, 23, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 13, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 22, "female", "New York"));
        personList.add(new Person("Owen", 9500, 34, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 15, "female", "New York"));
        List<String> collect = personList.stream()
                .filter(s -> s.getSalary() > 8000)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(collect);
        Map<String, List<Person>> collect1 = personList.stream()
                .filter((Person a) -> a.getSalary() > 8000) //筛选出大于8000的
                .collect(groupingBy(Person::getName));//按颜色分组  最后得到map
        collect1.forEach((k, v) -> {
            System.out.println(k + "----->" + v);
        });
        System.out.println(collect1);
    }

    public static void main(String[] args) {
        boolean b;
        if (b=true){

        }
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        list.stream().filter(s -> s > 6).forEach(System.out::println);
    }

}

@Data
@Setter
@Getter
class Person {
    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区

    // 构造方法
    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

}
