package leetcode_notes.simple;

import java.util.ArrayList;

public class title404 {

    static int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        findLeft(root);
        return sum;
    }

    public void findLeft(TreeNode node){
        if (node.right != null)
            findLeft(node.right);
        if(node.left != null){
            if (node.left.left == null && node.left.right == null)
                sum += node.left.val;
            findLeft(node.left);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

