package leetcode_notes.simple;

public class title226 {
    public title637.TreeNode invertTree(title637.TreeNode root) {
        if (root == null)
            return null;
        title637.TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
