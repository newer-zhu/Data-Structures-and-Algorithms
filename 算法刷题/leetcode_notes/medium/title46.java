package leetcode_notes.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 回溯算法经典
 */
public class title46 {
    public static void main(String[] args) {
        title46 t = new title46();
        ArrayList<ArrayList<Integer>> permute = t.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }


    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        int len = nums.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (len == 0)
            return res;
        backTrack(nums, len, 0, new ArrayDeque(len), new boolean[len], res);
        return res;
    }

    /**
     * dep，path，used都是状态参数
     */
    public void backTrack(int[] nums, int len, int dep, ArrayDeque path, boolean[] used, ArrayList<ArrayList<Integer>> res){
        if (dep == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++){
            if (used[i])
                continue;
            path.addLast(nums[i]);
            used[i] = true;
            backTrack(nums, len, dep + 1, path, used, res);

            path.removeLast();
            used[i] = false;
        }
    }
}
