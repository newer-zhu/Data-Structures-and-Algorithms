package leetcode_notes;

import common.ListNode;

import java.util.HashMap;

public class title201_210 {
    public static void main(String[] args) {
    }


    //title203
    public ListNode removeElements(ListNode head, int val) {
        //题目要求返回结果的头节点，就设置虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null){
            if (pre.next.val == val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    //title205
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i=0; i < s.length(); i++){
            if (map.get(s.charAt(i)) == null){
                if (map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            }
            else if(map.get(s.charAt(i)) != t.charAt(i))
                return false;
        }
        return true;
    }

    //title207
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if (prerequisites.length == 0)
//            return true;
//        else {
//            int[] col = prerequisites[0];
//            for (int[] i : prerequisites){
//                if (col[0] == i[1]){
//                    return false;
//                }
//
//            }
//        }
//    }
}
