package guigujvmstu.chapter01_bytecode.mytest;

/**
 * @Author: Administrator
 * @PACKAGE_NAME guigujvmstu.chapter01_bytecode.mytest
 * @PROJECT_NAME studyandtest
 * @Date: 2021/4/17 18:11
 * @Version 1.0
 */
public class TestReturn {
    public static void main(String[] args) {
        String func = func();
        System.out.println(func);
    }
    public static String func() {
        String str = "hello";
        try{
            return str;
        }
        finally{
            str = "atguigu";
            System.out.println(str+"------------");
        }
    }
}
