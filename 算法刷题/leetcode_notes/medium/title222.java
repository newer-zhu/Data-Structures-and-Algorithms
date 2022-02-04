package leetcode_notes.medium;

public class title222 {
    //222.性质：完全二叉树的子树也是完全二叉树，一直遍历左子节点就可以获得呃层数
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = getDep(root.left);
        int r = getDep(root.right);
        if (l == r){
            return (1 << l) + countNodes(root.right);
        }else {
            return (1 << r) + countNodes(root.left);
        }
    }

    public int getDep(TreeNode t){
        int d = 0;
        if (t == null)
            return 0;
        while (t != null){
            d++;
            t = t.left;
        }
        return d;
    }
}
