package leetcode_notes.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class title440_449 {
    //title448
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //官方题解
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;

//        Arrays.sort(nums);
//        ArrayList<Integer> res = new ArrayList<>();
//        int p = 0;
//        for (int i=0; i < nums.length; i++){
//            if (nums[i] != p + 1){
//                for (int j = p + 1; j < nums[i]; j++)
//                    res.add(j);
//            }
//            p = nums[i];
//        }
//        if (p+1 != nums.length){
//            for (int j = p + 1; j < nums.length; j++)
//                res.add(j);
//        }
//        return res;
    }
}
