package leetcode_notes.数组;

import java.util.ArrayList;
import java.util.List;

public class Simple {

    //title448
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            nums[(num - 1) % n] += n;//为什么要 % n，因为赋值时可能会影响后面的元素
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {//说明这个数字没有出现在原数组里
                ret.add(i + 1);
            }
        }
        return ret;
    }

    //title766
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length-1; i++){
            for (int j=0; j < matrix[0].length-1; j++){
                if (matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }
        return true;
    }
}
