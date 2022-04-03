package leetcode_notes.动态规划;

import java.util.Arrays;

public class 零一背包问题 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

        //dp[i][j]:0-i的数中能否找到和为j的组合
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++){
            dp[i][0] = true;
            dp[i][nums[i]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i]){//背包都装不下nums[i]了，只能不选
                    dp[i][j] = dp[i-1][j];
                }else {
                    //不选nums[i]和选nums[i]
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        //优化成一维数组
//        for (int i = 0; i < n; i++) {
//            int num = nums[i];
//            for (int j = target; j >= num; --j) {
//                dp[j] |= dp[j - num];
//            }
//        }
        return dp[n-1][target];
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        //dp[j]:j容量的背包最多装dp[j]的石头
        int[] dp = new int[sum/2 + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = dp.length-1; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        //前半段：dp[dp.length-1],后半段：sum-dp[dp.length-1] 答案：后半段-前半段
        return sum - 2*dp[dp.length-1];
    }

    public int findMaxForm(String[] strs, int m, int n) {
        //背包容量成了二维，而背包容量需要倒序遍历
//        dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        int oneNum = 0, zeroNum = 0;
        for (String s :  strs) {
            oneNum = 0; zeroNum = 0;
            for(char c : s.toCharArray()){
                if (c == '1') oneNum++;
                else zeroNum++;
            }
            for (int i = m; i >= zeroNum ; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
