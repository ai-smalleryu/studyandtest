package FinallyStudying.facestudy01;


public class Hand {
    /*有一个N行N列国际象棋棋盘, 棋盘左下角一格为(0,0)点, 棋盘右上角一格为(N-1, N-1)点,
    现有一颗”马”棋子位于棋盘(R, C)点,
    求出最终这个”马”棋子在K次之内或者恰好K次移动到棋盘之外的概率.马棋子移动规则:
    马棋子移动一次,可分解为两步:
    1 ）向上,下,左,右中其中一个方向移动两格
    2）向1中方向的垂直方向移动一格*/
    int a[][] = {{1, 2}, {2, 1}, {1, -2}, {-2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, -1}};//八种运动情况
    int cout = 0;
    int arry[][];
    int sum = 0;
    int num;

    public void T(int k, int n) {//放盘大小
        for (int i = 1; i <= k; i++) {
            for (int c = 0; c < n; c++) {
                for (int r = 0; r < n; r++) {
                    for (i = 0; i < a.length; i++) {
                        sum++;//总次数
                        int m = r + a[i][0];
                        int l = c + a[i][1];
                        if (0 <= m && m < n - 1 && 0 <= l && l < n - 1) {//求出在里的次数
                            num++;
                        }
                    }
                }
            }
        }
        double t=(sum-num)/sum;
        System.out.println(t);
    }

}
