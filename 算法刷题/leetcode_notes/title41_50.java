package leetcode_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class title41_50 {
    //title47
    class title47{
        boolean[] vis;
        //剪枝
        public List<List<Integer>> permuteUnique(int[] nums) {
            ArrayList<List<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> perm = new ArrayList<>();
            vis = new boolean[nums.length];
            //一定要排序！
            Arrays.sort(nums);
            backtrack(nums, ans, 0, perm);
            return ans;
        }

        //回溯
        public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
            if (idx == nums.length) {
                //这里要新new一个对象
                ans.add(new ArrayList<Integer>(perm));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                /**
                 * 题目中要求返回的是不重复的列表，如[1，1，2]和[1,2,1]ok
                 * [1,1.2]和[1,1,2]不ok
                 * 对于所给的列表中相邻重复的元素，如上面的1，1；可以看成1a，1b
                 * 则结果集中的某个列表需要加以限制，比如只取1a，1b，这样结果中的某个列表就是[...,1a.1b....],避免重复的元素
                 * !vis[i - 1]条件是为了只有保证visit[i-1] == true时我们才会visit[i]。
                 * 比如当[1a，1b，2]排列完1a回退后，1b为开头的元素时，直接剪枝
                 */
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                    continue;
                }
                perm.add(nums[i]);
                vis[i] = true;
                backtrack(nums, ans, idx + 1, perm);
                //取消访问状态，回退
                vis[i] = false;
                perm.remove(idx);
            }
        }
    }

    //title48
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int r=0; r < n /2; r++){
            for (int l=0; l < (n+1) / 2; l++){
                int temp = matrix[r][l];
                matrix[r][l] = matrix[n-1-l][r];
                matrix[n-1-l][r] = matrix[n-1-r][n-1-l];
                matrix[n-1-r][n-1-l] = matrix[l][n-1-r];
                matrix[l][n-1-r] = temp;
            }
        }
    }

    //title50
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int reach = 0;
        for (int i = 0; i < len; i++){
            //下标超出reach范围
            if (i > reach)
                return false;
            if (i + nums[i] > reach)
                reach = nums[i];
        }
        return true;
    }
}
