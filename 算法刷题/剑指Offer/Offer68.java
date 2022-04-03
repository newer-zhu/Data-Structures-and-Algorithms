package 剑指Offer;

import common.TreeNode;

public class Offer68 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q){
            return root;
        }
        TreeNode lNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);

        if (lNode != null && rNode != null){
            return root;
        }
        return lNode == null? rNode : lNode;
    }

}
