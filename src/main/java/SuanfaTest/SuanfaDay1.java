package SuanfaTest;

public class SuanfaDay1 {
    public static void main(String[] args) {
       boolean b=test2(17);
        System.out.println(b);
        
    }
    public static void test1(){
        int[] b={1,2,3,4,5,6};
        int[] a=b.clone();
        for (int i:a){
            System.out.print(i);
        }
        System.out.println("---------");
        int n=b.length;
//与对应的进行数字互换
        for (int i=0;i<n/2;i++){
            int temp=b[n-i-1];
            b[n-1-i]=b[i];
            b[i]=temp;
        }
        for (int c :b){
            System.out.print(c);
        }
    }
    public static boolean test2(int m){
        //测试数字是否是素数
        if (m<2)return false;
        for (int i=2;i*i<m;i++){
            if (m%i==0)return false;
        }
        return true;
    }
}
