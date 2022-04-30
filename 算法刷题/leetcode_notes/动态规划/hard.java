package leetcode_notes.动态规划;

public class hard {
    /**
     * 在单词 A 中插入一个字符；
     *
     * 在单词 B 中插入一个字符；
     *
     * 修改单词 A 的一个字符。
     * dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i][j]+int(word1[i]!=word2[j]))
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (m * n == 0){
            return n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        //初始化
        for (int i = 0; i < n + 1; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i < n + 1; i++){
            for (int j = 1; j < m + 1; j++) {
                int step = Math.min(dp[i-1][j]+1, dp[i][j-1]+1);
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] += Math.min(step, dp[i-1][j-1]);
                }else {
                    //末尾不同则替换
                    dp[i][j] += Math.min(step, dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[n][m];
    }

    public int numDistinct(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= s.length(); i++) dp[i][0] = 1;
        for (int j = 1; j <= t.length(); j++) dp[0][j] = 0;

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (t.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }
}
