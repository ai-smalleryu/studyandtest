package workTestMianshi.Exception;

public class LinkException {
    static void f() throws Exception {
        throw new Exception("f错误");

    }

    static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            throw new Exception("g错误", e);

        }
    }

    static void g2() throws Exception {
        try {
            f();
        } catch (Exception e) {
            Exception f = new Exception("g错误");//创建自己所需要抛出的错误
            f.initCause(e);

            throw f;

        }
    }

    public static void main(String[] args) throws Exception {
        g2();
    }
}
