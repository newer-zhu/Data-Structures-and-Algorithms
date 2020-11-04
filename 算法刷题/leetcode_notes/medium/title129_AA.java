package leetcode_notes.medium;

import java.util.ArrayList;
import java.util.List;

public class title129_AA {
    List<String> arr = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        StringBuilder sb = new StringBuilder();
        pre(root, sb);
        int sum = 0;
        for (String s : arr){
            sum += Integer.valueOf(s);
        }
        return sum;
    }

    public void pre(TreeNode node, StringBuilder path){
        path.append(node.val);
        if (node.left == null && node.right == null){
            arr.add(path.toString());
            path.deleteCharAt(path.length()-1);
        }
        if (node.left != null){
            pre(node.left, path);
        }
        if (node.right != null){
            pre(node.right, path);
        }
        path.deleteCharAt(path.length()-1);
    }


}
