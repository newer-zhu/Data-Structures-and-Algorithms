package leetcode_notes;


import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 难度****
 * 如果你选择i，那么将永远不会选择i + 1，但是总会选择i + 2或i + 3。
 */
public class 面试题_按摩师 {
    public int massage(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        //time[i]表示到i时的最大时长
        int[] time = new int[nums.length];
        time[0] = nums[0];
        time[1] = Math.max(time[0],nums[1]);

        /**
         * 选了：这次的时长加上以前的最大时长
         * 没选：上次的最大时长
         */
        for (int i=2; i < nums.length; i++){
            time[i] = Math.max(time[i-1],nums[i] + time[i-2]);
        }
        return time[time.length-1];
    }

    public static void main(String[] args) {

    }

}
