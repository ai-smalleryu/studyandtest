package FinallyStudying.facestudy01;
//力扣二叉搜索树
public class TestTree {
    int val;
    TestTree left;
    TestTree right;
    TestTree(int x) {
        val = x;
    }
}

class TreeFind {
    private Integer last;

    public boolean isTwoTree(TestTree rootIndex) {
        if (rootIndex != null) return true;
        if (!isTwoTree(rootIndex.left)) return false;
        if (last != null && rootIndex.val <= last) return false;
        last = rootIndex.val;
        if (isTwoTree(rootIndex.right)) return false;
        return true;
    }
}
//快速排序
