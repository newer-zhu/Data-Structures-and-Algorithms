package leetcode_notes.单调栈;

import java.util.*;


public class Medium {

    //栈底到栈头是递减的
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]){
                Integer index = stack.pollLast();
                ans[index] = i - index;
            }
            stack.addLast(i);
        }
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i< nums1.length ; i++){
            map.put(nums1[i],i);
        }
        int[] res = new int[len1];
        Arrays.fill(res, -1);
        stack.addLast(0);

        for (int i = 1; i < len2; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peekLast()]){
                Integer index = stack.pollLast();
                if (map.containsKey(nums2[index])){
                    //nums1中的下标
                    Integer in = map.get(nums2[index]);
                    res[in] = nums2[i];
                }
            }
            stack.addLast(i);
        }
        return res;
    }

    //栈底到栈头是递减的
    public int[] dailyTemperature(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2*n; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast() % n] < nums[i % n]){
                Integer index = stack.pollLast() % n;
                ans[index] = nums[i % n];
            }
            stack.addLast(i);
        }
        return ans;
    }

    //滑动窗口的最大值
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            //单调队列头部已经不在k段内了
            while (!list.isEmpty() && list.peekFirst() < i-k+1){
                list.pollFirst();
            }

            //保持队列单调递减
            while (!list.isEmpty() && nums[list.peekLast()] < nums[i]){
                list.pollLast();
            }

            list.addLast(i);

            if(i >= k - 1){
                ans[index++] = nums[list.peek()];
            }
        }

        return ans;
    }
}
