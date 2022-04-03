package 剑指Offer;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayDeque;

public class Offer07 {
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int len = preorder.length-1;
        return buildTree(0,len,0,len);
    }

    public TreeNode buildTree( int preL, int preR, int inL, int inR){
        if (preL > preR){
            return null;
        }
        //前序遍历第一个就是根节点
        TreeNode node = new TreeNode(preorder[preL]);
        int len = 0;
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == preorder[preL]){
                //此根节点左子树的长度
                len = i - inL;
            }
        }
        node.left = buildTree(preL+1,preL+len,inL,inL+len-1);
        node.right = buildTree(preL+len+1,preR,inL+len+1,inR);
        return node;
    }

}
