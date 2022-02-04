package leetcode_notes.动态规划;

import leetcode_notes.simple.title653;
import leetcode_notes.title100;
import util.TreeNode;

import java.math.BigDecimal;
import java.security.UnrecoverableEntryException;
import java.util.*;


public class medium {

    //变通成打家劫舍问题
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int n : nums){
            max = Math.max(n, max);
        }
        int[] sum = new int[max + 1];
        for (int x : nums){
            sum[x] += x;
        }
        return rob(nums);
    }

    private int rob(int[] nums){
        int n = nums.length;
        if (n <= 1){
            return n == 0? 0 : nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i){
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        int can = nums[0];
        for (int i = 1; i < n; i++){
            if(can - 1 < 0) return false;
            can = Math.max(can - 1, nums[i]);
            if (i + can >= n - 1) return true;
        }
        return false;
    }

    //title45
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        //能到达的最远距离和右边界
        int reach = 0, end = 0;
        int step = 0;
        //不需要访问最后一个元素。我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」
        for (int i = 0; i < n - 1; i++){
            reach = Math.max(reach, i + nums[i]);
            if (i == end){
                end = reach;
                step++;
            }
        }
        return step;
    }

    //title918
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0], pre = nums[0], min = nums[0], pre1 = nums[0],sum = nums[0];
        //分别求出nums[0]到nums[N-1]的最大子序和max和最小子序和min
        for (int i = 1; i < nums.length; i++){
            sum += nums[i];
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
            pre1 = Math.min(pre1 + nums[i], nums[i]);
            min = Math.min(min, pre1);
        }
        /**
         * situation1: 结果就在num[0]到 nums[N-1]之间，则常规情况返回max
         * situation2: 结果需要回头，则必定包含nums[N-1] 和 nums[0], 这个时候由于两头需要想中间靠拢
         * 则必须保证中间一段为最小子序和
         * max < 0则min < max < 0,min <= sum <= max
         */
        if (max < 0)
            return max;
        return Math.max(max, sum - min);
    }

    //title1152
    public int maxProduct(int[] nums) {
        int N = nums.length;
        int[] maxF = new int[N];
        int[] minF = new int[N];
        //最大值
        maxF[0] = nums[0];
        //最小值
        minF[0] = nums[0];
        int res = nums[0];
        //不知道当前nums[i]正负，不知道前几项连乘正负
        for (int i = 1; i < nums.length; i++){
            /**
             * 如果当前值为正，则 max (maxF[i - 1] * nums[i] , num[i])
             * 如果当前值为负，则 max (maxF[i - 1] * nums[i] , num[i] * minF[i - 1])
             */
            maxF[i] = Math.max(maxF[i - 1]*nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1]*nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            res = Math.max(res, maxF[i]);
        }
        return res;
    }

    //title1014
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int res = 0, max = values[0] + 0;
        for (int i = 1; i < len; i++) {
            //j > i, 这里把j看作外层循环
            res = Math.max(res, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return res;
    }

    //
    public int maxProfit(int[] prices) {
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

    //title309
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        //dp本身表示截止第i天的最大收益
        //0表示当天手里有股票
        //1表示当天结束时处于冷冻期
        //1表示当天没有股票
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][1] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - 2);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    //title139
    public boolean wordBreak(String s, List<String> wordDict) {
        int size = wordDict.size();
        boolean[] dp = new boolean[size + 1];
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        //这里的转移方程分两层循环，dp[i]的状态不仅仅依赖dp[i-1], 而是依赖dp[0 ~ i-1]
        for (int i = 1; i < size; i++){
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[size];
    }

    ///title42
    /**
     * 下标 i 的雨水 = min( [i]左边最高柱子高度 - [i]右边最高柱子高度 ) - i的柱子高度
     */
    public int trap(int[] height) {
        int N = height.length;
        if (N == 0) return 0;
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];
        leftMax[0] = height[0]; rightMax[N-1] = height[N-1];
        int res = 0;
        for (int i = N - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for (int i = 0; i < N; i++) {
            res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return res;
    }

    //title246
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2,  num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(num2,Math.min(num3, num5));
            if (dp[i] == num2)
                p2++;
            if (dp[i] == num3)
                p3++;
            if (dp[i] == num5)
                p5++;
        }
        return dp[n];
    }

    //title96
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix[0].length;
        for (int i = n-2; i >= 0; i--){
            for (int j = 0; j < n; j++){
                if (j == 0){
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }else if (j == n-1){
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }else {
                    matrix[i][j] += Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }
            }
        }
        Arrays.sort(matrix[0]);
        return matrix[0][0];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.fill(dp, amount + 1);
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]  + 1);
                }
            }
        }
        return dp[amount] > amount ? -1  : dp[amount];
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);
        for (int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int[] temp = new int[primes.length];
            for (int j = 0; j < primes.length; j++){
                temp[j] = dp[pointers[j]] * primes[j];
                min = Math.min(min, temp[j]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++){
                if(min == temp[j])
                    pointers[j]++;
            }
        }
        return dp[n];
    }

    //title650
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0){
                    dp[i] = dp[j] + dp[i / j];
                }
            }
            break;
        }
        return dp[n];
    }

    //title1218
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    //title249
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int j = 0; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        //遍历背包
        for (int i = 1; i <= n; i++){
            //遍历物品
            for (int j = 1; j*j <= i; j++){
                //dp[i - j*j]在dp[i]之前就已经min处理过了，一直往前推到dp[0] = 0
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }

    //title647
    public int countSubstrings(String s) {
        int len = s.length();
        //【i，j】左闭右闭
        int[][] dp = new int[len][len];
        int cnt = 0;
        //注意遍历顺序，这样可以防止 i+1和j-1没被处理过就被拿去判断
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {//只有一个字母
                    dp[i][j] = 1;
                    cnt++;
                } else {//内部是回文或者只有两个字母且最外部左右两个相等
                    if ((j-i == 1 || dp[i+1][j-1] == 1) && s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                        cnt++;
                    }else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return cnt;
    }
}
