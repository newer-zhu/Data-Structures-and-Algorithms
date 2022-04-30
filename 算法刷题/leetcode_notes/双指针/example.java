package leetcode_notes.双指针;

import common.ListNode;
import leetcode_notes.medium.title15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class example {

    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length){
            while (fast < nums.length && val != nums[fast]){
                nums[slow++] = nums[fast++];
            }
            fast++;
        }
        return slow;
    }

    /** title15
     * 给你一个由 n 个整数组成的数组 nums。
     * 请你找出并返回满足下述全部条件且不重复的三元组 a + b + c = 0
     * （若两个三元组元素一一对应，则认为两个三元组重复）
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < N-2; i++) {
            //第一层去重
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            //a+b+c=0，a，b都在递增，所以c需要递减
            int right = N - 1;
            for (int j = i + 1; j < N - 1; j++) {
                //第二层去重
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                while (j < right){
                    if (nums[i] + nums[j] + nums[right] == 0){
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[right]);
                        res.add(ans);
                        break;//a，b，c已经确定
                    }else if (nums[right] + nums[i] + nums[j] < 0){
                        break;//剪枝，nums[right] + nums[i] + nums[j]只会越来越小
                    }
                    right--;
                }
            }
        }
        return res;
    }


    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int res = Integer.MAX_VALUE;
        int val = nums[0];
        for (end = 0; end < nums.length; end++){
            val += nums[end];
            while (val >= target){
                res = Math.min(res, end - start + 1);
                val -= nums[start++];
            }
        }
        return res == Integer.MAX_VALUE? 0  : res;
    }

    /**
     * title142
     * 入环点a 相遇点b 环中剩下c
     * 慢指针在第一圈必定能和快指针相遇，设相遇时fast已经走了n圈
     * 从相遇点b到入环点a的距离加上 n-1 圈的环长，恰好等于从链表头部到入环点的距离
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null){
            if (fast.next.next == null){
                return null;
            }else {
                fast = fast.next.next;
            }
            slow = slow.next;
            //相遇
            if (fast == slow){
                ListNode node = head;
                //node走到入环点，则slow也从相遇点走到入环点
                while (node != slow){
                    node = node.next;
                    slow = slow.next;
                }
                return node;
            }
        }
        return null;
    }

}
