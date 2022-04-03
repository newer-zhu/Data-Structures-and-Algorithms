package leetcode_notes.贪心;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {
    public int maxProfit(int[] prices) {
        int res = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            res = Math.max(res, prices[i] - low);
        }
        return res;
    }

    //title678
    public boolean checkValidString(String s) {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }

    //title453
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

    public int minMoves1(int[] nums) {
        int l = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - l * min;
    }

    //title316

    /**
     *字符串是升序的字典序才是最小
     */
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char[] arr = s.toCharArray();
        //单调栈，字符从底向上慢慢升序且相对顺序不变
        ArrayDeque<Character> deque = new ArrayDeque<>();
        //字符出现的最后的下标
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[arr[i] - 'a'] = i;
        }
        for (int i = 0; i < len; i++) {
            //当前字符不在单调栈中，在单调栈中出现过说明此下标已经没机会了
            if (!deque.contains(arr[i])){
                //此字符字典序在栈顶字符前面且栈顶字符最后一次出现的下标比此字符的大 就弹出栈顶字符
                while (!deque.isEmpty() && deque.peekLast() > arr[i] && lastIndex[deque.peekLast() - 'a'] > i){
                    deque.removeLast();
                }
                deque.addLast(arr[i]);
            }
        }
        for (Character c : deque){
            sb.append(c);
        }
        return sb.toString();
    }


    //title406
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int[] a, int[] b) -> (a[0] == b[0]?  a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] i : people) {
            res.add(i[1], i); //把数组放在目标索引位置上，原来有数了，会被往后挤
        }
        return res.toArray(new int[0][2]); //容器转成数组
    }

    //title1005
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 排序，把可能有的负数排到前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 贪心：如果是负数，而k还有盈余，就把负数反过来
            if (nums[i] < 0 && k > 0) {
                nums[i] = -1 * nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        // 如果k没剩，那说明能转的负数都转正了，已经是最大和，返回sum
        // 如果k有剩，说明负数已经全部转正，所以如果k还剩偶数个就自己抵消掉，不用删减，如果k还剩奇数个就减掉2倍最小正数。
        return sum - (k % 2 == 0 ? 0 : 2 * nums[0]);
    }
}
