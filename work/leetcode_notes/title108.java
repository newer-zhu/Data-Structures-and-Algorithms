package leetcode_notes;

public class title108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        root.left = sort(nums,nums.length/2);

    }

    public TreeNode sort(int[] nums, int index){
        if (nums.length == 0)
            return null;
        TreeNode root = new TreeNode(nums[index / 2]);
        return root;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
