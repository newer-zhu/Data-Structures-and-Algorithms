package leetcode_notes;

public class title51_60 {
//    title53=========动态规划
    //思路：设置一个值res记录最大值，pre记录f(n-1),f(n) = max(f(n-1)+x, x).
// 如果带来的是负增长效果不如从我自己开始，这时res记录最大值的效果就在这里
    public int maxSubArray(int[] nums) {
        int res = nums[0], pre = 0;
        for (int i = 0; i < nums.length; i++){
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }

    //title55===========
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
