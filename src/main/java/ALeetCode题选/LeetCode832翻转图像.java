package ALeetCode题选;

/**
 *
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * 示例 1：
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class LeetCode832翻转图像 {
    public static void main(String[] args) {
        int[][] as=new int[][]{{1,0,1}};
        flipAndInvertImage(as);

    }
    public static int[][] flipAndInvertImage(int[][] A) {
        //获取到每个元素
        for(int num[]:A){
            int n = num.length;
            int low = 0;
            int high = n-1;
            while(low<=high){
                int temp = num[low];
                num[low++] = num[high]^1;
                num[high--] = temp^1;
            }
        }
        return A;
    }
}
