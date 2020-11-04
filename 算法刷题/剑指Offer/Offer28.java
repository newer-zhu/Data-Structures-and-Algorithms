package 剑指Offer;

public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return judge(root.left,root.right);
    }

    public boolean judge(TreeNode l, TreeNode r){
        if (l == null && r == null)
            return true;
        if (l.val == r.val)
            return judge(l.left,r.right) && judge(l.right,r.left);
        else
            return false;
    }
}

class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
