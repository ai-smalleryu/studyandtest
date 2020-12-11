package workTestMianshi.IOFile;

import java.io.*;
import java.time.LocalDate;

public class ObjectOutIn {

        public static void main(String[] args) throws IOException {
            try (ObjectOutputStream objectOutputStream =
                         new ObjectOutputStream(new FileOutputStream("users.dat"))) {

                User tom = new User(1, "Tom", LocalDate.now());
                User jerry = new User(2, "Kerry", LocalDate.now());
            //new User(1, "Tom", LocalDate.now());
                objectOutputStream.writeObject(tom);
                objectOutputStream.writeObject(jerry);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (ObjectInputStream objectInputStream =
                         new ObjectInputStream(new FileInputStream("users.dat"))) {

                User tom = (User)objectInputStream.readObject();
                User jerry = (User)objectInputStream.readObject();
                System.out.println(tom);
                System.out.println(jerry);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
}
static class User {
        private Integer id;
        private String name;
        private LocalDate birthday;

        public User(Integer id, String name, LocalDate birthday) {
            this.id = id;
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", birthday=" + birthday +
                    '}';
        }
    }}