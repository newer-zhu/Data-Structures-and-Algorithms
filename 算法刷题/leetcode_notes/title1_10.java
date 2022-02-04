package leetcode_notes;

import javafx.collections.ObservableIntegerArray;
import leetcode_notes.simple.title160;

import java.util.*;

public class title1_10 {
    //1.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //3.滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int l = 0; l < s.length(); l++){
            if (map.containsKey(s.charAt(l))){
                left = Math.max(left, map.get(l) + 1);
            }
            ans = Math.max(ans, l - left + 1);
            map.put(s.charAt(l), l);
        }
        return ans;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0, sum = 0;
        while (l1 != null || l2 != null) {
            //长度较短的那条后面补0
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            sum += n1 + n2 ;
            if (head == null) {//第一次添加节点
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            sum /= 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (sum > 0) {
            tail.next = new ListNode(carry);
        }
        return head;

    }
    //title 5
    public String longestPalindrome(String s) {;
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int max = 1, begin = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = 1;
        char[] arr = s.toCharArray();
        for (int L = 2; L <= len; L++){
            for (int left = 0; left < len; left++){
                int right = L + left - 1;
                if (right >= len)
                    break;
                if (arr[left] != arr[right]){
                    dp[left][right] = 0;
                }else {
                    if (right - left < 3){
                        dp[left][right] = 1;
                    }else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right] == 1 && right - left + 1 > max){
                    max = right - left + 1;
                    begin = left;
                }
            }
        }

        return s.substring(begin, begin + max);
    }

    //title6
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        //每一行
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;//现在位于哪一行
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            //当前行加入此个字母
            rows.get(curRow).append(c);
            //控制方向的指针：只有到临界行才会转向
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }


        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    //7. 注意溢出问题
    public int reverse(int x) {
        long l = 0;
        while(x != 0){
            l = l*10 + (x % 10);
            x = x / 10;
        }
        return (int) l == l ? (int) l : 0;
    }
}
