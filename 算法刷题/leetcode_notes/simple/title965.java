package leetcode_notes.simple;

public class title965 {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root,root.val);
    }

    public boolean isUnivalTree(TreeNode root,int val) {
        if (root != null) {
            if (root.val == val && isUnivalTree(root.left, val) && isUnivalTree(root.right, val))
                return true;
            else
                return false;
        }else
            return true;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
