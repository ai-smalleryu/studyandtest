package workTestMianshi.IOFile;

import java.io.*;

/**
 * 序列化与反序列化
 */
public class xuliehua {
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("序列化.dat"));
             ObjectInputStream in=new ObjectInputStream(new FileInputStream("序列化.dat"))) {
            User user = new User(1, "wqw", "sas");
            User user1 = new User(2, "qw", "sas");
            out.writeObject(user);
            out.writeObject(user1);
            User u=(User) in.readObject();
            User u2=(User) in.readObject();
            System.out.println(u+""+u2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable{
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
}
