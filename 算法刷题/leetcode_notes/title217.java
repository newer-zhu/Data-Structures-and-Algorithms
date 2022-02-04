package leetcode_notes;

import java.util.Arrays;

public class title217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1);
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1])
                return true;
        }
        return false;
    }
}
