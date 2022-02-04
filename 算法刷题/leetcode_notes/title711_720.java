package leetcode_notes;

public class title711_720 {
//    title714
    //dp[i][1]表示持有股票的最大利润，dp[i][0]代表不持有股票
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
    //leetcode_notes.贪心
    public int maxProfit_Greedy(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int profit  = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] + fee < buy){
                buy = prices[i] + fee;
            }else if (prices[i] > buy){
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
