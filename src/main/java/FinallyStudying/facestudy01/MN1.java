package FinallyStudying.facestudy01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Administrator
 * @PACKAGE_NAME FinallyStudying.facestudy01
 * @PROJECT_NAME studyandtest
 * @Date: 2021/2/1 19:19
 * @Version 1.0
 */
public class MN1 {
    //矩阵转置 不规则和规则 0
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<int[]>();
        list.add(new int[]{1, 2, 3});
        list.add(new int[]{111, 2, 3});
        list.add(new int[]{12, 2, 3});
        list.add(new int[]{31, 2, 3,18});
        int[][] mn = MN(list);
        int[][] t = T(mn);   //t 就是 转置后的，没有写数组转换为list 其实就是方法反过来
    }
    public static int[][]  MN(List<int[]> list) {
        //将list转换成数组，便于处理
        int s=0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> ints = new ArrayList<>();
            s = s>list.get(i).length?s:list.get(i).length;
        }
        System.out.println(s);
        int[][] a=new int[list.size()][s];
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            for (int j = 0; j < s; j++) {
                try {
                    a[i][j]=ints[j];
                }catch (Exception e){
                    a[i][j]=0;
                }
            }
        }
        return a;
    }

    public static int[][]  T(int[][] MN) {
        int m=MN.length;
        int n=MN[0].length;
        int[][] TNM = new int[m][n];
        //转置主体
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                TNM[i][j] = MN[j][i];
                TNM[j][i] = MN[i][j];
            }
        }
        //这个只是输出
        for (int i = 0; i <TNM.length ; i++) {
            for (int j = 0; j < TNM[i].length; j++) {
                System.out.print(TNM[i][j]+"\t");
            }
            System.out.println();
        }
        return TNM;
    }
}
