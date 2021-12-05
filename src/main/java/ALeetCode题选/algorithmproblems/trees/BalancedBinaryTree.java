package ALeetCode题选.algorithmproblems.trees;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(2);
        TreeNode node24 = new TreeNode(3);
        TreeNode node25 = new TreeNode(3);
        TreeNode node26 = new TreeNode(4);
        TreeNode node27 = new TreeNode(4);

        node21.left = node22;
        node21.right = node23;

        node22.left = node24;
        node22.right = node25;

        node24.left = node26;
        node24.right = node27;

        TreePrinter.printTreeLevelOrder(node1);
        System.out.println();
        TreePrinter.printTreeLevelOrder(node21);
        System.out.println();

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();

        System.out.println(balancedBinaryTree.isBalanced(node1));
        System.out.println(balancedBinaryTree.isBalanced(node21));
    }

    // 1. 先序遍历
    public boolean isBalanced1(TreeNode root){
        // 基准情况
        if (root == null) return true;

        // 如果不为空，需要判断左右子树的高度差，然后递归调用判断左右子树是否平衡
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced1(root.left)
                && isBalanced1(root.right);
    }

    // 计算树高度的方法
    public int height(TreeNode root){
        // 递归调用，处理基准情况
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // 2. 后序遍历
    public boolean isBalanced(TreeNode root){
        return balanceHeight(root) > -1;
    }

    // 修改height方法，得到左右子树高度的同时，就判断是否平衡，如果不平衡直接返回-1
    public int balanceHeight(TreeNode root){
        // 递归调用，处理基准情况
        if (root == null) return 0;

        // 递归调用，得到左右子树的高度
        int leftHeight = balanceHeight(root.left);
        int rightHeight = balanceHeight(root.right);

        // 首先根据左右子树高度判断是否平衡
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
