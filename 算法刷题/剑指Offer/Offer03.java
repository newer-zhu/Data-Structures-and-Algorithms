package 剑指Offer;

public class Offer03 {
    //空间复杂度只有O(1)
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while (nums[i] != i){
                int t = nums[nums[i]];
                if (t == nums[i])
                    return nums[i];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
        }
        return -1;
    }
}
