package 剑指Offer;

public class Offer60 {
    /**
     * 1. n个骰子的结果取值范围是【n, 6*n】,也就是6*n-n+1 = 5*n+1种结果
     * 2.每个骰子只有6种结果，每种结果1/6的概率（废话）
     * 2. n个骰子求和结果为x的概率 = sum(n-1个骰子求和结果为x-1，x-2，x-3....x-6)
     */
    public double[] dicesProbability(int n) {
        //dp[x,y]代表x个骰子扔出求和结果为y的概率
        double[][] dp = new double[n+1][6*n+1];
        //初始化只有一个骰子的情况
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1.0/6.0;
        }
        for (int i = 2; i <= n; i++) {
            //i-1个骰子结果求和的所有可能值的概率
            for (int j = i-1; j <= i*6; j++) {
                //递推公式
                for (int k = 1; k <= 6; k++) {
                    dp[i][j+k] += dp[i-1][j] / 6.0;
                }
            }
        }
        //转化一下答案
        double[] res = new double[5 * n + 1];
        for (int i = n; i < 6*n+1 ; i++) {
            res[i-n] = dp[n][i];
        }
        return res;
    }
}
