package designpatterns23.bridge;
//抽象电脑类型
public abstract class Computer {
    //组合品牌
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }
    public void info(){
        //通过传进来的属性调用品牌
        brand.info();
    }

}
