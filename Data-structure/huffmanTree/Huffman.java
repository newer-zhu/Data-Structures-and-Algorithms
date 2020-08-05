package huffmanTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Huffman {
    public static void main(String[] args) {
        int[] arr = {67,29,38,15,7,8,23,10,4,1,3,6,13};
        preOrder(formHuffman(arr));
    }

    public static Node formHuffman(int[] arr){
        List<Node> nodes = new ArrayList<>();
        for (int val : arr){//把每个节点变成节点
            nodes.add(new Node(val));
        }

        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取出权值最小的二叉树（一个节点）
            Node left = nodes.get(0);
            //取出权值第二小的二叉树（一个节点）
            Node right = nodes.get(1);
            //构建新的二叉树
            Node parent = new Node(left.val + right.val, left, right);
//        删除处理过的二叉树
            nodes.remove(left);
            nodes.remove(right);
            //parent加入到集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 前序遍历
     */
    public static void preOrder(Node node){
        System.out.println(node);
        if (node.left != null)
            preOrder(node.left);
        if (node.right != null)
            preOrder(node.right);
    }

    static class Node implements Comparable<Node>{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }

        /**
         * 从小到大排序
         * @param o
         * @return
         */
        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }


}
