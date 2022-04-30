package leetcode_notes.树;

import common.TreeNode;

public class Medium {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isSameExactly(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    //树的节点从A开始严格相同
    public boolean isSameExactly(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return isSameExactly(A.left, B.left) && isSameExactly(A.right, B.right);
    }
}
