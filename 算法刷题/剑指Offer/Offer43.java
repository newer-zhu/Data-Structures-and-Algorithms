package 剑指Offer;

public class Offer43 {
    public int countDigitOne(int n) {
        // mulk 表示 10^k,mulk 100 表示此数百位数上1的个数
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk;
            long remain = n % (10 * mulk);
            if (remain < mulk){
                ans += 0;
            }else if (remain >= mulk && remain < 2 * mulk){
                ans += remain - mulk + 1;
            }else if (remain >= mulk){
                ans += mulk;
            }
//          Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
