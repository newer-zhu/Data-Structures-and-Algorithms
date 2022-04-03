package 剑指Offer;

public class Offer49 {
    public int nthUglyNumber(int n) {
        if (n <= 0) return -1;
        //丑数必定有前面的丑数x2,x3或x5所得
        //p前面的元素已经用掉了乘p的机会
        int p2 =0, p3=0, p5=0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[p2]*2, dp[p3]*3), dp[p5]*5);
            //不同else为了去重，比如10，p2++,p5++
            if (dp[i] == dp[p2]*2) p2++;
            if (dp[i] == dp[p3]*3) p3++;
            if (dp[i] == dp[p5]*5) p5++;
        }
        return dp[n];
    }
}
