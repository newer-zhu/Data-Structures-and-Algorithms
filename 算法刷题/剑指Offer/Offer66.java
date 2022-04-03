package 剑指Offer;

public class Offer66 {
    public int[] constructArr(int[] a) {
        if (a.length == 0)
            return new int[0];
        int[] res = new int[a.length];
        res[0] = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = a[i-1] * res[i-1];
        }
        int r = 1;
        for (int i = a.length-1; i >= 0 ; i--) {
            res[i] *= r;
            r *= a[i];
        }
        return res;
    }
}
