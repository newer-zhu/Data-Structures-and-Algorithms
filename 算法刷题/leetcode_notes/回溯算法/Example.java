package leetcode_notes.回溯算法;

import java.util.*;

public class Example {

    //还原IP
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return ans; // 算是剪枝了
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int index,int num) {
        if (num == 3){
            if (isValid(s, index, s.length()-1)){
                ans.add(s);
                return;
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isValid(s, index, i)){
                num++;
                s = s.substring(0, i+1) + "."+s.substring(i+1);
                dfs(s, i+2, num);
                num--;
                s = s.substring(0, i+1) + s.substring(i+2);
            }else {
                break;
            }
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

    //去重思想
    class FindSubsequences{
        //递增子序列，这题无法用排序后比较来去重了，只能用set。因为不能对数组元素位置进行改动
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> findSubsequences(int[] nums) {
            dfs(nums, 0, new LinkedList<Integer>());
            return res;
        }

        private void dfs(int[] nums, int index, LinkedList<Integer> path) {
            if (path.size() > 1){
                res.add(new LinkedList<>(path));
            }

            HashSet<Integer> set = new HashSet<>();
            for (int i = index; i < nums.length; i++) {
                if ((!path.isEmpty() && nums[i] < path.peekLast()) || (set.contains(nums[i]))) continue;
                set.add(nums[i]);
                path.addLast(nums[i]);
                dfs(nums, i+1, path);
                path.removeLast();
            }
        }
    }

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
                ans.add(new ArrayList<Integer>(perm));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                /**
                 * 题目中要求返回的是不重复的列表，如[1，1，2]和[1,2,1]ok
                 * [1,1,2]和[1,1,2]不ok
                 * 对于所给的列表中相邻重复的元素，如上面的1，1；可以看成1a，1b
                 * 则结果集中的某个列表需要加以限制，比如只取1a，1b，这样结果中的某个列表就是[...,1a.1b....],避免重复的元素
                 * vis[i - 1]为false时说明1a不在perm里，说明是add后又delete掉了，结果自然包含了此位为1的答案
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
}
