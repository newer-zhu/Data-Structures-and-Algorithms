package leetcode_notes;

public class title53 {
    public int maxSubArray(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            if (sum >= max){
                max = sum;
            }else {
                max = nums[i];
                sum = 0;
            }
        }
        return max;
    }
}
