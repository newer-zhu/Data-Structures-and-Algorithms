package leetcode_notes;


import common.TreeNode;

import java.util.*;

public class Hot100 {

    public int subarraySum(int[] nums, int k) {
        int[] count = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            count[i] = count[i-1] + nums[i-1];
        }
        int r = 0;
        for (int i = nums.length; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (count[i]-count[j] == k) r++;
            }
        }
        return r;
    }
    public int findUnsortedSubarray(int[] nums) {
        //2,6,4,8,10,9,15
        //max是左到右遍历维护的最大值
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        //r在遍历结束后是不满足递增的最后一个下标
        int l = -1, r = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (max > nums[i]){
                r = i;
            }else {
                max = nums[i];
            }
            if (min < nums[n-1-i]){
                l = n-1-i;
            }else {
                min = nums[n-1-i];
            }
        }
        return l == -1? 0 : r - l + 1;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        //root1和root2不会有其中一个为空
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }

    //title621
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) count[c-'A'] += 1;
        Arrays.sort(count);
        //Axx Axx A
        int minLen = (count[25]-1) * (n+1) + 1;
        for (int i = 24; i >= 0; i--) {
            //剩下的比出现最多的频次少或者相同
            if (count[i] == count[25]){
                minLen += 1;
            }
        }
        //task.length正好插满，如ABCD ABCD，没插满则是ABCD ABCx
        return Math.max(tasks.length, minLen);
    }
    //3.滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //abba
                l = Math.max(map.get(s.charAt(i)) + 1, l);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - l + 1);
        }
        return max;
    }

    //title 5
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int max = 1, begin = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = 1;
        char[] arr = s.toCharArray();

        for (int L = 2; L <= len; L++) {
            for (int left = 0; left < len; left++) {
                int right = L + left - 1;
                if (right >= len)
                    break;
                if (arr[left] != arr[right]) {
                    dp[left][right] = 0;
                } else {
                    if (right - left < 3) {
                        dp[left][right] = 1;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right] == 1 && right - left + 1 > max) {
                    max = right - left + 1;
                    begin = left;
                }
            }
        }

        return s.substring(begin, begin + max);
    }
}
