package leetcode_notes;

public class title104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(root.left == null? 0 : maxDepth(root.left),root.right == null? 0 : maxDepth(root.right)) + 1;
    }
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
