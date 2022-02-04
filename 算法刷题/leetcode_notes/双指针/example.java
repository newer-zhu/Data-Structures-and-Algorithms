package leetcode_notes.双指针;

import leetcode_notes.medium.title15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class example {
    public static void main(String[] args) {
    }
    /** title15
     * 给你一个由 n 个整数组成的数组 nums。
     * 请你找出并返回满足下述全部条件且不重复的四元组 a + b + c = 0
     * （若两个四元组元素一一对应，则认为两个四元组重复）
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < N-2; i++) {
            //第一层去重
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            //a+b+c=0，a，b都在递增，所以c需要递减
            int right = N-1;
            for (int j = i + 1; j < N - 1; j++) {
                //第二层去重
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                while (j < right){
                    if (nums[i] + nums[j] + nums[right] == 0){
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[right]);
                        res.add(ans);
                        break;
                    }else if (nums[right] + nums[i] + nums[j] < 0){
                        break;//剪枝
                    }
                    right--;
                }
            }
        }
        return res;
    }

}
