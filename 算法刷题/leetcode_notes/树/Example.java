package leetcode_notes.树;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Example {
    //105
    Map map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) return null;
        for(int i=0; i < len;  i++){
            map.put(inorder[i], i);
        }
        return build(preorder,0, len-1,0, len-1);
    }

    public TreeNode build(int[] pre,int prestart, int preEnd, int inStart, int inEnd){
        if (prestart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[prestart]);
        int pIndex = (int)map.get(root.val);
        root.left = build(pre, prestart+1, pIndex-inStart+prestart,
                inStart, pIndex-1);
        root.right = build(pre, pIndex-inStart+prestart+1, preEnd,
                pIndex+1, inEnd);
        return root;
    }
}
