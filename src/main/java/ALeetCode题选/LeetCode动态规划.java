package ALeetCode题选;

/**
 * @Author Administrator
 * @PACKAGE_NAME: FinallyStudying.facestudy02
 * @PROJECT_NAME: studyandtest
 * @USER: Administrator
 * @DATE: 2020/12/10 14:47
 */
public class LeetCode动态规划 {
}
class Shelve {
    private static final int MAX_BOOK_HEIGHT = 1000;
    private static final int MAX_BOOK_NUM = 1000;
    private static final int MAX_SHELVE_HEIGHT = MAX_BOOK_HEIGHT * MAX_BOOK_NUM;

    private int[][] books;
    private int width;
    private int[] height;

    public Shelve(int[][] books, int width) {
        this.books = books;
        this.width = width;
        this.height = new int[books.length];
    }


    //DP:保存height以复用
    private void setHeight(int i, int h){
        if(this.height[i] == 0) {
            this.height[i] = h;
        }
    }


    public int minHeight(int start) {
        int idx,i, widthSum = 0, bWidth, bHeight, maxLayerHeight=books[start][1];
        if(this.height[start]!=0){
            return this.height[start];
        }
        //计算最后一层最多可以放几本书
        for(idx=start;idx>=0;idx--){
            bWidth = books[idx][0];
            bHeight = books[idx][1];
            widthSum+=bWidth;
            if(widthSum>this.width){
                break;
            }
            if(maxLayerHeight<bHeight){
                maxLayerHeight = bHeight;
            }
        }
        if(idx == -1){
            setHeight(start, maxLayerHeight);
            return maxLayerHeight;
        }
        int minShelveHeight,tempShelveHeight;
        minShelveHeight = maxLayerHeight+minHeight(idx);
        widthSum=0;
        maxLayerHeight = books[start][1];
        //若最后一层不排满书,则必定因为存在更高的书,利用该特点裁剪分支
        for(i=start;i>idx; i--) {
            bWidth = books[i][0];
            bHeight = books[i][1];
            widthSum += bWidth;
            if (widthSum > this.width) {
                break;
            }
            if (maxLayerHeight < bHeight) {
                tempShelveHeight = maxLayerHeight + minHeight(i);
                if (tempShelveHeight < minShelveHeight) {
                    minShelveHeight = tempShelveHeight;
                }
                maxLayerHeight = bHeight;
            }
        }
        setHeight(start, minShelveHeight);
        return minShelveHeight;
    }
}

class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        Shelve shelve = new Shelve(books, shelf_width);
        return shelve.minHeight(books.length-1);
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Solution2 {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp=new int[books.length+1];//+1是因为防止下方的dp[j+1]越界；
        //
        dp[books.length]=0;
        for(int i=0;i<books.length;i++){//容易忘记写；
            dp[i]=Integer.MAX_VALUE;
        }
        //dp;
        for(int i=books.length-1;i>=0;i--){
            int left_width=shelf_width;//每次换新层就要修改成初始值；
            int max_width=0;//本层的最大高度初始化；
            //这么写和下面这么写是一样的； 就是else break；一定不能少，因为少了就不符合题意 按顺序存放的要求了；
            for(int j=i;j<books.length ;j++){//因为是把后面的书放上去；
                //if(left_width>=0){
                if(left_width>=books[j][0]){//要弄清left_width的含义；
                    max_width=Math.max(max_width,books[j][1]);
                    dp[i]=Math.min(dp[i],max_width+dp[j+1]);//是dp[j+1]而不是dp[i+1]；同时又因为j>=i所以不会越界,dp也是基于之前计算的结果思考的；
                    left_width-=books[j][0];
                }else{//else break；一定不能少，因为少了就不符合题意 按顺序存放的要求了；
                    break;
                }
            }
        }
        return dp[0];
    }
}
