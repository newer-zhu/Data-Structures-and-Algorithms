package leetcode_notes.simple;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 判断是否能整除，能的话就除
 */
public class title261_270 {
    //title263
    public boolean isUgly(int num) {
        if(num == 0)
            return false;
        while (num % 2 == 0){
            num /= 2;
        }
        while (num % 3 == 0){
            num /= 3;
        }
        while (num % 5 == 0){
            num /= 5;
        }
        return num == 1;
    }

    //title264
    //思路：最小堆，丑数必定是2x， 3x， 5x
    public int nthUglyNumber1(int n) {
        int[] factors = {2, 3, 5};
        //去重
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++){
            long cur = heap.poll();
            ugly = (int) cur;
            for (int factor : factors){
                long next = cur * factor;
                if (set.add(next)){
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    //动态规划+三指针
    //思路：dp[i] 表示第i个丑数， 定义三个指针 p_2,p_3,p_5 表示下一个丑数是当前指针指向的丑数乘以对应的质因数。初始时，三个指针的值都是 1
    //dp[i] = min(dp[p2]*2, dp[p3]*3, dp[p5]*5), 然后比较dp[i]和dp[p2],dp[p3],dp[p5]是否相等，相等则对应指针加1
    public int nthUglyNumber2(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
