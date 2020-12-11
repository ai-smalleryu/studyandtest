package workTestMianshi;

import sun.misc.Version;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClassForm {
    public static void main(String[] args) throws ClassNotFoundException {
        //获得Class的三种方式
        Class<? extends TestS> aClass = new TestS().getClass();
        Class a = TestS.class;
        Class<?> aClass1 = Class.forName("workTestMianshi.TestS");
        //拿到父类的方法
        Class<?> superclass = aClass.getSuperclass();
        Method[] methods1 = superclass.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }

        System.out.println("----------------");
        String name = TestS.class.getName();
        System.out.println(name);
        Method[] methods = TestS.class.getMethods();
        for (Method method : methods) {
            System.out.println(method + "方法名");
        }
        Class s = TestS.class;
        System.out.println(s);
        //一个属性的反射类型用Filed表示
        try {
            System.out.println("-----------");
            Field[] fields = s.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println("-----------++++");
            Method setName = s.getMethod("setName", String.class);//拿到set方法
            TestS testS1 = new TestS();
            Object sd = setName.invoke(testS1, "sd");
            System.out.println(testS1.getName());
            //拿到get方法
            Method getName = s.getMethod("getName");
            System.out.println(getName + "get方法");
            System.out.println("=============");
            //获取一个注解的值
            Field id1 = s.getDeclaredField("id");
            id1.setAccessible(true);
            Annotation[] annotations = id1.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation + "aaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
            workTestMianshi.s annotation = id1.getAnnotation(s.class);
            System.out.println(annotation.value());


            //可以拿到私有内容getDeclaredField 去掉只能公有方法

            Field id = s.getDeclaredField("id");
            id.setAccessible(true);//将这个属性的修饰符改为无效
            Field name1 = s.getDeclaredField("name");
            name1.setAccessible(true);
            TestS testS = new TestS();
            id.set(testS, 1);
            name1.set(testS, "sss");
            System.out.println(testS);
            System.out.println("----------------");
            Field[] declaredFields = s.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField);
            }
            System.out.println("--------------");
            //获取构造器
            Constructor[] constructors = s.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
            try {
                System.out.println("===============");
                //反射获取有参构造器
                Constructor constructor = s.getConstructor(int.class, String.class, LocalDate.class);
                System.out.println(constructor);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}

class StringPool58Demo {
    public static void main(String[] args) {
        String s="sas_xz_csd_asd#$#";
        int indexOf = s.lastIndexOf("_");
        System.out.println(indexOf+"-------------------------"+s.length());
        int len=s.length()-indexOf-1;
        System.out.println(len+"=============");
        System.out.println(s.substring(indexOf+1));
        System.out.println(s.indexOf("_"));
        inter();
        
    }

    private static void inter() {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println("------------");

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());

        System.out.println(Version.getJvmSpecialVersion());


    }

}
