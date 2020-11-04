package leetcode_notes;

public class title55 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1){
            if (isBalanced(root.left) && isBalanced(root.right))
                return true;
        }
        return false;
    }

    
    public int getHeight(TreeNode node){
        if (node == null)
            return 0;
        return Math.max(node.left == null ? 0 : getHeight(node.left), node.right == null ? 0 : getHeight(node.right)) + 1;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
