package leetcode_notes.DFS;

import java.util.*;

public class Medium {

    //回溯模板
    List<List<Integer>> res = null;
    ArrayList<Integer> fac = null;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        fac = new ArrayList<>();
        dfs(k, n, 1);
        return res;
    }

    private void dfs(int k, int n, int index){
        if (k == fac.size() && n == 0) {
            res.add(new ArrayList<>(fac));
            return;
        }else if (n < 0 || k < fac.size()){
            return;
        }

        for (int i = index; i <= 9; i++) {
            fac.add(i);
            dfs(k, n-i, i+1);
            fac.remove(fac.size()-1);
        }
    }

    //区别就是结果需要去重
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<Integer> factor = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs2(candidates, target, factor, ans, 0);
        return ans;
    }

    public void dfs2(int[] candidates, int target, Deque<Integer> factor, List<List<Integer>> ans, int index){
        if (target == 0){
            ans.add(new ArrayList<>(factor));
            return;
        }else if (target < 0){
            return;
        }
        for (int i = index; i < candidates.length; i++){
            //此条件能保证去重,candidates[index]只能为根一次
            if (i > index && candidates[i] == candidates[i-1]) continue;
            factor.addLast(candidates[i]);
            dfs2(candidates, target - candidates[i], factor, ans, i + 1);
            factor.removeLast();
        }
    }

    //分割回文子串
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs3(new ArrayList<String>(), 0, s);
        return ans;
    }

    private void dfs3(List<String> path, int index, String s) {
        if (index >= s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isRecur(s, index, i)){
                path.add(s.substring(index, i + 1));
            }else {
                continue;
            }
            dfs3(path, i+1, s);
            path.remove(path.size()-1);
        }
    }

    private boolean isRecur(String s, int index, int i) {
        while (index <= i){
            if (s.charAt(index) != s.charAt(i))
                return false;
            index++;
            i--;
        }
        return true;
    }


}
