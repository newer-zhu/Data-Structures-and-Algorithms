package leetcode_notes.贪心;

import common.TreeNode;

import java.util.*;

public class Example {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int right = intervals[0][1];
        int c = 1;
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= right){
                right = intervals[i][1];
                c++;
            }

        }
        return intervals.length - c;
    }

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

    //摆动序列
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int curDiff = 0;
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i-1];
            if ((curDiff < 0 && preDiff >= 0) || (curDiff > 0 && preDiff <= 0)){
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    //跳跃游戏
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int can = nums[0];
        for (int i = 1; i < n; i++){
            //跳到这一步时能量can小于0，则跳不到这一步
            if(can - 1 < 0) return false;
            //能量值可以不变，但是当这一步拾取的能量值比原有的大时就覆盖
            can = Math.max(can - 1, nums[i]);
        }
        return can >= 0;
    }

    //跳跃游戏2
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        int steps = 0;
        //能到达的最远距离和右边界
        int max = 0, right = 0;
        //在访问最后一个元素之前，我们的边界一定大于等于最后一个位置
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == right){
                steps++;
                right = max;
            }
        }
        return steps;
    }

    //加油站
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int curSum = 0, totalSum = 0, index = 0;
        for (int i = 0;i < n ; i++) {
            //路过i这个加油站剩余的油
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0){//如果剩余的油小于0，[0,i]区间的加油站都可以排除
                //假设下一个加油站可以作为起点
                index = (i+1) % n;
                curSum = 0;
            }
        }
        //先决条件，cost必须小于等于gas
        if (totalSum < 0) return -1;
        return index;
    }

    //根据身高重建队列
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0]-o1[0] == 0) return o1[1] - o2[1];
                else return o2[0]-o1[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            //如果该index上已经有了元素，那么原有的元素会被后移
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[people.length][]);
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        //统计最后出现的位置
        for (int i = 0; i < chars.length; i++) edge[chars[i] - 'a'] = i;

        int right = 0, last = -1;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, edge[s.charAt(i) - 'a']);
            if (right == i){
                list.add(right - last);
                last = right;
            }
        }
        return list;
    }

    public int monotoneIncreasingDigits(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int start = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i-1]){
                arr[i-1]--;
                start = i;
            }
        }
        while (start < arr.length){
            arr[start] = '9';
            start++;
        }
        return Integer.parseInt(new String(arr));
    }

    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int sum = 0;
        for (int p : prices) {
            if (p + fee < buy) {
                buy = p + fee;
            } else if (p > buy){
                sum += p - buy;
                buy = p;
            }
        }
        return sum;
    }

    static int res = 0;
    public int minCameraCover(TreeNode root) {
        res = 0;//这行必须有
        if (traversal(root) == 0){
            res++;
        }
        return res;
    }

    /**
     * @return 1摄像头， 2已覆盖， 0没覆盖
     */
    private int traversal(TreeNode cur){
        if (cur == null) return 2;
        int left = traversal(cur.left);
        int right = traversal(cur.right);

        if (left == 2 && right == 2) return 0;

        if (left == 0 || right == 0){
            res++;
            return 1;
        }

        if (left == 1 || right == 1) return 2;
        return -1;
    }

    public int candy(int[] ratings) {
        int res = 0;
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < candy.length; i++){
            if (ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            }
        }
        for (int j = candy.length - 2; j >= 0; j--){
            if (ratings[j] > ratings[j+1]){
                candy[j] = Math.max(candy[j], candy[j+1] + 1);
            }
        }
        for (int k : candy)
            res += k;
        return res;
    }
}
