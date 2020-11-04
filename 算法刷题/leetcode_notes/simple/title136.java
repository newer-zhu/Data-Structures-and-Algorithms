package leetcode_notes.simple;

import java.util.HashSet;
//注意异或运算
public class title136 {
    public static void main(String[] args) {
        singleNumber(new int[]{4,1,2,1,2});
    }
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        int result=0;
        for(int i=0;i<len;i++){
            result ^=nums[i];
        }
        return result;
    }
}
