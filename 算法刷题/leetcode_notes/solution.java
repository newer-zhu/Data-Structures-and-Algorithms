package leetcode_notes;

public class solution {

    public static void main(String[] args) {

    }


    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lHeight = 0;
        int rHeight = 0;
        TreeNode node = root;
        while (node != null || node.left != null || node.right != null){
            node = node.left;
            if (!isBalanced(node))
                return false;
            lHeight++;
        }
        node = root;
        while (node != null ||node.right != null || node.left != null){
            node = node.right;
            if (!isBalanced(node))
                return false;
            rHeight++;
        }
        return Math.abs(lHeight - rHeight) > 1 ? false : true;
    }


    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
