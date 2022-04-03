package 剑指Offer;

public class Offer16 {
    //快速幂
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            //b % 2 == 1
            if((b & 1) == 1) res *= x;
            x *= x;//例：3^5 * 1  = 9*3^2 * (1 *= x)
            b >>= 1;// b/= 2;
        }
        return res;
    }
}
