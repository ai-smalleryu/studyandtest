package ThreadTest;

import ListMap.HashMapIt;

import javax.xml.stream.events.EndDocument;


/**
 * 静态代理
 * 真实角色
 * 代理角色
 * 实现公共接口
 */

public class StaticProxy {
    public static void main(String[] args) {
        new weddingMarry(new HappyMarry()).happy();
    }

}

interface Marry {
    void happy();
}

//真实角色
class HappyMarry implements Marry {

    @Override
    public void happy() {
        System.out.println("aaaaasasefwfcdxz");
    }
}

//代理角色
class weddingMarry implements Marry {

    private Marry tag;

    public weddingMarry(Marry tag) {
        this.tag = tag;
    }

    @Override
    public void happy() {
        read();
        this.tag.happy();
        end1();
    }

    private void end1() {
        System.out.println("可以");
    }

    private void read() {
        System.out.println("不足hi");
    }
}