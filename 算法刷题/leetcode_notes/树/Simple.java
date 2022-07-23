package leetcode_notes.树;


import common.TreeNode;

import java.util.HashSet;

public class Simple {
    //404
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root.left != null){
            if (root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null){
            sum += sumOfLeftLeaves(root.right);
        }

        return sum;
    }

    /**
     * @return 是不是平衡树
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    /**
     * @return 左右子树最大高度，不是平衡树返回-1
     */
    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
