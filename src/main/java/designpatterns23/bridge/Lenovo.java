package designpatterns23.bridge;

//联想电脑
public class Lenovo implements Brand {
    @Override
    public void info() {
        System.out.println("联想品牌");
    }
}
