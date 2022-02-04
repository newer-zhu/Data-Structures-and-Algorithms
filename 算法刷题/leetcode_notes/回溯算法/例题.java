package leetcode_notes.回溯算法;

import java.util.*;

public class 例题 {
    //title39
    /**
     * 凡是求多少种解法的题考虑用回溯
     * 此解法无剪枝，每次dfs都分为选或不选两种情况，建模的是一颗二叉树
     * 也可以建模成一颗多叉树，但是要注意去重
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> factor = new ArrayList<>();
        dfs(candidates, target, factor, ans, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, ArrayList<Integer> factor, List<List<Integer>> ans, int index){
        if (index == candidates.length) return;
        if (target == 0){
            ans.add(new ArrayList<>(factor));
            return;
        }
        //跳过不选
        dfs(candidates, target, factor, ans, index+1);
        if (target - candidates[index] >= 0){
            factor.add(candidates[index]);
            dfs(candidates, target - candidates[index], factor, ans, index);
            factor.remove(factor.size() - 1);
        }
    }

    /**
     * title15，注意本题的去重思想
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }

    //title40
    /**
     * 建模成一颗多叉树
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<Integer> factor = new ArrayDeque<>();
        //升序
        Arrays.sort(candidates);
        dfs2(candidates, target, factor, ans, 0);
        return ans;
    }

    private void dfs2(int[] candidates, int target, Deque<Integer> factor, List<List<Integer>> ans, int index){
        if (target == 0){
            ans.add(new ArrayList<>(factor));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            //剪枝
            if (target - candidates[i] < 0) break;
            //此条件能保证去重
            if (i > index && candidates[i] == candidates[i-1]) continue;
            factor.addLast(candidates[i]);
            dfs2(candidates, target - candidates[i], factor, ans, i + 1);
            factor.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> fac = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i + 1;
        dfs3(nums, k, res, fac, 0);
        return res;
    }

    private void dfs3(int[] nums, int k, List<List<Integer>> res, ArrayList<Integer> fac, int p){
        if (fac.size() == k){
            res.add(new ArrayList<>(fac));
            return;
        }
        for (int i = p; i < nums.length; i++){
            fac.add(nums[i]);
            dfs3(nums, k, res, fac, i + 1);
            fac.remove(fac.size() - 1);
        }
    }
}
