package ALeetCode题选.algorithmproblems.trees;

import java.util.LinkedList;

/**
 * Copyright (c) 2020-2030 尚硅谷 All Rights Reserved
 * <p>
 * Created by wushengran
 */
public class TreePrinter {
    // 1. 先序遍历
    public static void printTreePreOrder(TreeNode root){
        // 处理基准情况
        if (root == null) return;

        System.out.print(root.val + "\t");    // 先打印根
        printTreePreOrder(root.left);        // 打印左子树
        printTreePreOrder(root.right);       // 打印右子树
    }

    // 2. 中序遍历
    public static void printTreeInOrder(TreeNode root){
        if (root == null) return;

        printTreeInOrder(root.left);
        System.out.print(root.val + "\t");
        printTreeInOrder(root.right);
    }

    // 3. 后序遍历
    public static void printTreePostOrder(TreeNode root){
        if (root == null) return;

        printTreePostOrder(root.left);
        printTreePostOrder(root.right);
        System.out.print(root.val + "\t");
    }

    // 4. 层序遍历
    public static void printTreeLevelOrder(TreeNode root){
        // 利用队列保存遍历的节点
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);    // 根节点入队

        // 只要队列不为空，就一直出队，然后将当前节点的子节点入队
        while (!queue.isEmpty()){
            TreeNode currNode = queue.poll();    // 当前节点出队
            System.out.print(currNode.val + "\t");    // 访问当前节点

            // 将子节点入队
            if (currNode.left != null)
                queue.offer(currNode.left);
            if (currNode.right != null)
                queue.offer(currNode.right);
        }
    }

    public static void main(String[] args) {
        // 打印一棵树，测试
        /*
        *      1
        *     / \
        *    2  3
        *      / \
        *     4   5
        *      \
        *       6
        * */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        node4.right = node6;

        printTreePreOrder(node1);
        System.out.println();

        printTreeInOrder(node1);
        System.out.println();

        printTreePostOrder(node1);
        System.out.println();

        printTreeLevelOrder(node1);
    }
}
