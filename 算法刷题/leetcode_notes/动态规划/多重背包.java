package leetcode_notes.动态规划;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 多重背包 {
    //title518
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0]= 1;

        for (int i = 1; i < coins.length; i++) {//先遍历物品，在遍历容量；解决组合问题
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

    //title377
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target+1; i++) {//先遍历容量，在遍历物品。解决排列问题
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {//遍历背包
            for (int j = 0; j < i; j++) {//遍历物品
                String sub = s.substring(j, i - j);
                //dp[j]必须是true，且s[i,j]在set中存在
                if (set.contains(sub) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
