package designpatterns23.bridge;

//苹果电脑
public class Apple implements Brand {
    @Override
    public void info() {
        System.out.println("苹果品牌");
    }
}
