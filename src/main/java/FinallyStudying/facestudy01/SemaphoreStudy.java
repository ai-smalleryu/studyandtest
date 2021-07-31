package FinallyStudying.facestudy01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class SemaphoreStudy {
    public static void main(String[] args) {
        //信号量
        Semaphore semaphore = new Semaphore(1);//模拟停车位
        for (int i = 0; ; i++) {//相当于9辆车去抢夺车位
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                try {
                    semaphore.acquire();//获得模拟位置并进行阻塞
                    System.out.println(Thread.currentThread().getName() + "\t车获得车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "\t车离开位置");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();//释放占用的资源
                }
            }, String.valueOf(i)).start();

        }
    }
}


class SemaphoreStudy2 {
    public static void main(String[] args) {
        //信号量
        Semaphore semaphore = new Semaphore(3);//模拟停车位
        for (int i = 0; i < 15; i++) {//相当于9辆车去抢夺车位

            new Thread(() -> {
                try {
                    semaphore.acquire();//获得模拟位置并进行阻塞
                    System.out.println(Thread.currentThread().getName() + "\t车获得车位");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t车离开位置");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();//释放占用的资源
                }
            }, String.valueOf(i)).start();

        }
    }
}

/**
 * 栈链表实现，next指向下一个
 *
 * @param <T>
 */
class Link<T> {
    static class Node<T> {
        T item;
        Node<T> next;

        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    //栈顶初始化
    Node<T> top = new Node<T>();

    public void push(T item) {
        //next指向新插入的对象
        top = new Node<T>(item, top);
    }

    public T pop() {
        T sd = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return sd;
    }

    public static void main(String[] args) {
        Link<String> stringLink = new Link<>();
        String[] s = {"as", "zx", "cxxc", "zzzz"};
        for (String s1 : s) {
            stringLink.push(s1);
        }
        String s1;
        while ((s1 = stringLink.pop()) != null) {
            System.out.println(s1);
        }
    }
}

class A {

    public static int[] randFun(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = (int) (Math.random() * (array.length - 1)); //随机下标交换
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] ints = randFun(array);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}


class Demo {

    // 记录背包的总容量
    public int packageweight;
    // 记录商品总数
    public int productnum;
    // 记录每个商品的重量
    public ArrayList<Integer> weights;
    // 记录每个商品的价值
    public ArrayList<Integer> values;

    public static void main(String[] args) throws Exception {

        // 初始化demo实例
        Demo demo = new Demo();

        while (true) {
            // 读取测试文件中数据
            demo.readdata();
            // 初始化价值记录表
            int[][] m = demo.initpkdata();
            int[][] res = demo.result(m);
            System.out.println("********背包总容量********");
            System.out.println(demo.packageweight);
            System.out.println("********商品总数，及其各个商品重量与价值情况***********");
            System.out.println("商品总数：" + demo.productnum);
            for (int i = 0; i < demo.weights.size(); i++) {
                System.out.print(demo.weights.get(i) + " ");
            }
            System.out.println();
            for (int i = 0; i < demo.values.size(); i++) {
                System.out.print(demo.values.get(i) + " ");
            }
            System.out.println();

            System.out.println("********商品价值记录表********");
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("此时背包中最大价值总和为：" + res[demo.productnum][demo.packageweight]);

            System.out.println("装入背包中商品序号为：");
            demo.findproducts(res);
            System.out.println();
        }
    }

    /**
     * 读取测试数据
     *
     * @throws Exception
     */
    public void readdata() throws Exception {
        /*
         * 选择测试文件序号
         */
        System.out.println("共六组测试数据（1~6）,请输入数据编号：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        /*
         * 读取数据
         */
        BufferedReader br = new BufferedReader(new FileReader("./src/input_assgin02_0" + num + ".dat"));
        String string = br.readLine();

        /*
         * 获取测试文件中 背包容纳空间 以及 各个物品的信息
         */
        this.packageweight = Integer.parseInt(string.split(" ")[0]);
        this.productnum = Integer.parseInt(string.split(" ")[1]);

        String weight = br.readLine();
        this.weights = new <Integer>ArrayList();
        for (int i = 0; i < this.productnum; i++) {
            this.weights.add(Integer.parseInt(weight.split(" ")[i]));
        }

        String value = br.readLine();
        this.values = new <Integer>ArrayList();
        for (int i = 0; i < this.productnum; i++) {
            this.values.add(Integer.parseInt(value.split(" ")[i]));
        }
    }

    /**
     * 初始化背包问题（记录价值的表格）
     * m[i][0] = 0 :表示背包重量为0，不能装东西，因此价值全为0
     * m[0][j] = 0 :表示没有可以装的物品，因此价值为0
     */
    public int[][] initpkdata() {
        int[][] m = new int[this.productnum + 1][this.packageweight + 1];

        for (int i = 0; i <= this.productnum; i++) {
            m[i][0] = 0;
        }
        for (int j = 0; j <= this.packageweight; j++) {
            m[0][j] = 0;
        }

        return m;
    }

    /**
     * 计算背包问题
     *
     * @return 修改相应价值记录后的表
     */
    public int[][] result(int[][] arr) {

        for (int i = 1; i <= this.productnum; i++) {
            for (int j = 1; j <= this.packageweight; j++) {

                // 当第i件物品重量大于当前包的容量 则放不进去
                // 所以当前背包所含价值等于前i-1件商品的价值
                if (this.weights.get(i - 1) > j) {
                    arr[i][j] = arr[i - 1][j];
                }
                // 当第i件商品能放进去时
                // 1 放入商品，价值为：arr[i-1][j-(int)this.weights.get(i-1)] + (int)this.values.get(i-1)
                // 2不放入商品，价值为前i-1件上篇价值和：arr[i][j] = arr[i-1][j];
                // 此时最大价值为上述两种方案中最大的一个
                else {
                    if (arr[i - 1][j] < arr[i - 1][j - this.weights.get(i - 1)] + this.values.get(i - 1)) {
                        arr[i][j] = arr[i - 1][j - this.weights.get(i - 1)] + this.values.get(i - 1);
                    } else {
                        arr[i][j] = arr[i - 1][j];
                    }
                }
            }
        }

        return arr;
    }

    /**
     * 查找那些商品放在背包中
     */
    public void findproducts(int[][] arr) {
        int j = this.packageweight;
        for (int i = this.productnum; i > 0; i--) {
            if (arr[i][j] > arr[i - 1][j]) {
                System.out.print(i + "  ");//输出选中的物品的编号
                j = j - this.weights.get(i - 1);
                if (j < 0) {
                    break;
                }
            }
        }
    }
}

