package StuTes;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class Student {
    private int id;
    private String name;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }



    public Student(int id,String name) {
        this.id = id;
        this.name=name;
       // System.out.println("有参");
    }

    public  Student()
    {
        System.out.println("无参构造器");
    }

    public static void main(String[] args) {
        String html = "{Something must have been changed since you leave}";
        boolean mus = html.contains("mus");
        System.out.println(mus);
    }
}
