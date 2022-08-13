package leetcode_notes.双指针;

import common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class example {
    //tile15
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 现在要增加 left，减小 right，但是不能重复
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
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

    //滑动窗口
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
