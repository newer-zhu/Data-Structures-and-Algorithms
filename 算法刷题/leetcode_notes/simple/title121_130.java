package leetcode_notes.simple;

public class title121_130 {
    //title122
    //动态规划，定义状态dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，
    // dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
    //dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
    //dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
    public int DP(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    //leetcode_notes.贪心，找不相交的区间和最大
    public int Greedy(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

}
