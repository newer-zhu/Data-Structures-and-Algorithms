package 剑指Offer;

public class Offer42 {
    public int maxSubArray(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        //第i的数字结尾的最大和f(i)， 答案是max(f(i))
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
//      我们可以考虑 num[i] 单独成为一段还是加入前面的那一段
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
