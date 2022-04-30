package leetcode_notes.栈;

import common.ListNode;

import java.util.*;

public class example {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                Integer index = stack.poll();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }

    //title84
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];//左边比下标i柱子高度低的最近的柱子下标
        int[] right = new int[len];//右边比下标i柱子高度低的最近的柱子下标
        LinkedList<Integer> stack = new LinkedList<>();
        //单调栈可以维护比柱子i低的两边最近的柱子下标
        for (int i = 0; i < len; ++i){
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]){
                stack.removeLast();
            }
            left[i] = (stack.isEmpty()? -1:stack.peekLast());
            stack.add(i);
        }
        stack.clear();
        for (int i = len-1; i >= 0; --i){
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]){
                stack.removeLast();
            }
            right[i] = (stack.isEmpty()? len:stack.peekLast());
            stack.add(i);
        }

        //计算面积
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }

    public int countArrangement(int n) {
        boolean[] vis = new boolean[n];
        List<Integer>[] match = new List[n+1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i % j == 0 || j % i == 0)
                    match[i].add(j);
            }
        }
        int num = 0;
        count(1, n, num, vis, match);
        return num;
    }

    public void count(int index, int n, int num, boolean[] vis, List<Integer>[] match){
        if (index == n + 1){
            num++;
            return;
        }
        for (int i : match[index]){
            if (!vis[i]){
                vis[i] = true;
                count(index+1, n, num, vis, match);
                vis[i] = false;
            }
        }
    }

    //有效的括号
    public boolean isValid(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                deque.push(')');
            else if (s.charAt(i) == '[')
                deque.push(']');
            else if (s.charAt(i) == '{') {
                deque.push('}');
            }else if (deque.isEmpty() || deque.peek() != s.charAt(i))
                return false;
            else deque.pop();
        }
        return deque.isEmpty();
    }

}
