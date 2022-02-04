package leetcode_notes.medium;

import java.util.*;


public class title41_50 {
    /**title46
     * 回溯算法经典
     */

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

    //title49======考验对map的掌握
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            //对单词排序
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            //必须用排序过后的数组作为key
            String key = new String(arr);
            //值储存的是结果，如果第一次出现就new一个新的list，否则每次将本次遍历的单词
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            //更新结果
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
