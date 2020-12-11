package workTestMianshi.clone;

public class Student implements Cloneable {
    public Student(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public A a;

    public A getA() {
        return a;
    }

    public Student(A a, String name, int id, String password) {
        this.a = a;
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "a=" + a +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    public void setA(A a) {
        this.a = a;
    }

    private String name;
    private int id;
    private String password;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
