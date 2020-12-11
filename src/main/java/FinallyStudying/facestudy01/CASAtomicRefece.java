package FinallyStudying.facestudy01;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用
 */
public class CASAtomicRefece {
    public static void main(String[] args) {
        User tom = new User(1, "tom");
        User jar = new User(2, "jar");
        AtomicReference<User> userAtomicReference=new AtomicReference<>();
        userAtomicReference.set(tom);
        System.out.println(userAtomicReference.compareAndSet(tom, jar)+"\t 修改为"+userAtomicReference.get().toString());
    }
}
class User{
    public int age;
    public String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
