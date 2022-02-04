package leetcode_notes;

public class title111_120 {
    //title111
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }else{
            if (root.left == null)
                return minDepth(root.right) + 1;
            if (root.right == null)
                return minDepth(root.left) + 1;
            else
                return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
        }
    }
}
