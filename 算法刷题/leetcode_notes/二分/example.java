package leetcode_notes.二分;

import common.ListNode;

import java.util.*;

public class example {
    //title23
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right){
        if (left > right){
            return null;
        }else if (left == right){
            return lists[left];
        }
        int mid = (left + right) / 2;
        return merge2Lists(merge(lists, left, mid), merge(lists, mid+1, right));
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null){
            return l1 == null? l2:l1;
        }
        ListNode p1 = l1, p2 = l2;
        ListNode ans = new ListNode(0);
        ListNode tail = ans;
        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                tail.next = p2;
                p2 = p2.next;
            }else {
                tail.next = p1;
                p1 = p1.next;
            }
            tail = tail.next;
        }
        tail.next = (p1 == null? p2:p1);
        return ans.next;
    }

    //title33

    /**
     *二分时一定有一边有序，另一半部分有序。
     * 只在有序的那一边查找，否则继续二分
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0] == target? 0 : -1;
        int l = 0, r = n-1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            //左半部分有序
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {//右半部分有序
                if (nums[mid] < target && target <= nums[n-1]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix[0].length;
        int m = matrix.length;
        int begin = 0, mid = 0, end =  m * n;
        while (begin < end){
            mid = (begin + end) / 2;
            if (target > matrix[mid / n][mid % n]){
                begin = mid + 1;
            }else {
                end = mid;
            }
        }
        return matrix[begin / n][begin % n] == target;
    }
}
