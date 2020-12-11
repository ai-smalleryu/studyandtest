package workTestMianshi;

import java.util.Objects;

public class Testequals {
    private int i;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Testequals)) return false;
        Testequals that = (Testequals) o;
        return i == that.i &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, name);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Testequals testequals = new Testequals();
        System.out.println(testequals);
    }
}
