package workTestMianshi.clone;

public class A {
    int id;

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                '}';
    }

    public A(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
