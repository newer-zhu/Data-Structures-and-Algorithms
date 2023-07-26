package leetcode_notes.树;

import Tree_2_3.Tree;
import common.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.Collectors;

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

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    //title95
    private List<TreeNode> generateTrees(int l, int r) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }
        // 枚举可行根节点
        for (int i = l; i <= r; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(l, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, r);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);//注意放这里
                    currTree.left = left;
                    currTree.right = right;
                    res.add(currTree);
                }
            }
        }
        return res;
    }

    //221
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return (int) Math.pow(max, 2);
    }

    //t106
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inLeft, int inRight, int poLeft, int poRight) {
        if (inLeft > inRight || poLeft > poRight) return null;
        int rootVal = postorder[poRight];
        TreeNode node = new TreeNode();
        int inIndex = 0;//root在中序的下标
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal){
                inIndex = i;
                break;
            }
        }
        int leftNum = inIndex - inLeft;//左子树个数
        node.left = buildTree(inorder, postorder, inLeft, inIndex-1, poLeft, poLeft + leftNum - 1);
        node.right = buildTree(inorder, postorder, inIndex+1, inRight, poLeft + leftNum, poRight-1);
        return node;
    }
}
