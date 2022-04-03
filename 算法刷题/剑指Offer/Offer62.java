package 剑指Offer;

public class Offer62 {
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    //(此轮过后的num下标 + m) % 上轮元素个数 = 上轮num的下标

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }
}
