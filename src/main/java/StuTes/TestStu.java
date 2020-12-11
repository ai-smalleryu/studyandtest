package StuTes;

public class TestStu {
    public static void main(String[] args) {
        Stude s=()->new Student();

        Stude stude=Student::new;
    }
}
//接口
@FunctionalInterface
interface  Stude
{
    Student getStudent();
}