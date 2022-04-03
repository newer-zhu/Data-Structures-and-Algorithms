package 剑指Offer;

import common.Node;

public class Offer36 {
    //构建双向链表要保存上一个节点，head保存头节点便于返回
    common.Node pre, head;
    public common.Node treeToDoublyList(common.Node root) {
        if (root == null)
            return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    //结束时，head指向头节点，pre指向尾节点
    void dfs(Node node){
        //越过了叶子节点
        if (node == null)
            return;
        dfs(node.left);
        //链表头节点
        if (pre == null)
            head = node;

        else if (pre != null)
            pre.right = node;
        node.left = pre;
        pre = node;

        dfs(node.right);
    }
}
