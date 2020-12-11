package workTestMianshi.compar;

import java.util.Arrays;

public class User implements Comparable<User> {

    private int id;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(User o) {
        if (this.id > o.id) {
            return 1;
        } else if (this.id < o.id) {
            return -1;
        } else {
            if (this.name.charAt(0) > o.name.charAt(0)) {
                return 1;
            } else if (this.name.charAt(0) < o.name.charAt(0)) {
                return -1;
            } else {
                if (this.password.charAt(0) > o.password.charAt(0)) {
                    return 1;
                } else if (this.name.charAt(0) < o.name.charAt(0)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

  /*  public int t(User o){
        return (this.id!=o.id)?(this.id>o.id?1:-1):(this.name.charAt(0)!=o.name.charAt(0)?(this.name.charAt(0)>o.name.charAt(0)?1:-1):(this.password.charAt(0)))
    }*/

    public static void main(String[] args) {
        User user1 = new User(1,"na","ko");
        User user2 = new User(3,"tom","kaao");
        User user3 = new User(2,"na","dako");
        User[] u={user1,user2,user3};
        Arrays.sort(u);
        for (User user : u) {
            System.out.println(user);
        }
    }
}
