package 剑指Offer;

import linkedList.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * dfs
 */
public class Offer38 {
    class Solution1 {
        List<String> res;
        char[] c;
        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);
            return res.toArray(new String[res.size()]);
        }
        void dfs(int x) {
            if(x == c.length - 1) {
                res.add(String.valueOf(c)); // 添加排列方案
                return;
            }
            HashSet<Character> set = new HashSet<>();
            for(int i = x; i < c.length; i++) {
                if(set.contains(c[i])) continue; // 重复，因此剪枝
                set.add(c[i]);
                swap(i, x); // 交换，将 c[i] 固定在第 x 位
                dfs(x + 1); // 开启固定第 x + 1 位字符
                swap(i, x); // 恢复交换
            }
        }
        void swap(int a, int b) {
            char tmp = c[a];
            c[a] = c[b];
            c[b] = tmp;
        }
    }

    ///回溯
    class Solution2{
        List<String> rec;
        boolean[] vis;//标记是否使用过这个字母

        public String[] permutation(String s) {
            int n = s.length();
            rec = new ArrayList<String>();
            vis = new boolean[n];
            char[] arr = s.toCharArray();
            //排序字母，相同的字母会相邻
            Arrays.sort(arr);
            StringBuffer perm = new StringBuffer();
            backtrack(arr, 0, n, perm);

            int size = rec.size();
            String[] recArr = new String[size];
            for (int i = 0; i < size; i++) {
                recArr[i] = rec.get(i);
            }
            return recArr;
        }

        public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
            //加如结果集
            if (i == n) {
                rec.add(perm.toString());
                return;
            }
            for (int j = 0; j < n; j++) {
//            这个限制条件保证了对于重复的字符，我们一定是从左往右依次填入的空位中的
                if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                    continue;
                }
                vis[j] = true;
                perm.append(arr[j]);
                backtrack(arr, i + 1, n, perm);
                perm.deleteCharAt(perm.length() - 1);
                vis[j] = false;
            }
        }
    }

}


