package leetcode_notes.work;

import java.util.Arrays;

/**
 * @author: Hodor_Zhu
 * @description
 * @date: 2023/6/26 22:10
 */
public class Top150 {
    /**
     * @author hodor_zhu
     * @description https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
     * @date 2023/6/26 22:11
     */
    public int removeDuplicates(int[] nums) {
        int last = 2, suffix = 2;
        for (;suffix < nums.length; suffix++) {
            if(nums[suffix] != nums[last-2])
                nums[last++] = nums[suffix];
        }
        return last;
    }

/**
 * @author hodor_zhu
 * @description https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/7/1 15:01
 */
    public int majorityElement(int[] nums) {
        int n = nums[0], c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (n != nums[i]) c--; else c++;
            //i此时不可能 >= nums.length
            if (c == 0) n = nums[i+1];
        }
        return n;
    }

    /**
     * https://leetcode.cn/problems/rotate-array/comments/
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length - 1);
    }
    public void rotate(int[] nums, int a, int b) {
        while (a < b){
            int t = nums[a];
            nums[a++] = nums[b];
            nums[b--] = t;
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        Arrays.fill(arr, 1);
        int left = 1, right = 1;//保留arr[i]左右的乘积
        for (int i = 0; i < len; i++){
            //双指针i和len-i-1终会相遇，这里arr[i] = arr[i] * left右侧的arr[i]已经包含了右乘积
            arr[i] *= left;
            left *= nums[i];//更新左乘积
            //下面同理
            arr[len-i-1] *= right;
            right *= nums[len-i-1];
        }
        return arr;
    }
}
