package leetcode_notes.medium;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//使用迭代前序遍历
public class title144_AAA {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        pre(root, res);
        return res;
    }

    public void pre(TreeNode root, List<Integer> res){
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                res.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
    }
}

class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
