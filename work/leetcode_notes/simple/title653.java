package leetcode_notes.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class title653 {
    ArrayList<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        order(root);
        int j = 0;
        int i = list.size() - 1;
        while (i > j){
            if (list.get(i) + list.get(j) == k)
                return true;
            else if (list.get(j) + list.get(i) > k)
                i--;
            else
                j++;
        }
        return false;
    }

    public void order(TreeNode node){
        if (node.left != null)
            order(node.left);
        list.add(node.val);
        if (node.right != null) {
            order(node.right);
        }
    }

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
}
