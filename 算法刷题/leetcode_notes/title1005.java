package leetcode_notes;

import java.util.Arrays;

public class title1005 {
    public static void main(String[] args) {
        int i = largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4
                , 2}, 2);
    }
    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        //记录小于0的值的个数
        for (i=0; i < A.length; i++){
            if (A[i] >= 0)
                break;
        }
        //全大于0
        if (i == 0){
            if (!(K % 2 == 0)){
                A[0] = -A[0];
            }
        }
        else {
            int d = i > K? K : i;
            for (int j=0; j<d;j++){
                A[j] = -A[j];
            }
            if ((i < K)){
                if (!((K - i) % 2 == 0)){
                    if (Math.abs(A[i]) < Math.abs(A[i - 1])){
                        A[i] = -A[i];
                    }else {
                        A[i-1] = -A[i-1];
                    }
                }
            }
        }
        i = 0;
        for (int j=0; j< A.length; j++){
            i += A[j];
        }
        return i;
    }
}
