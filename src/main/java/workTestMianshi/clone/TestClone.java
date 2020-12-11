package workTestMianshi.clone;

public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(0);
        a.setId(1);
        Student student = new Student(a,"wa", 2, "wes");
        Student clone = (Student) student.clone();
        student.setId(90);
        a.setId(12);
        clone.setA(a);
        System.out.println(student.toString()+"aa"+clone.toString());
        System.out.println(student.getA().getId());
    }
}
