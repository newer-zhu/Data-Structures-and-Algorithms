package huffmanCode;


import org.w3c.dom.Node;

import java.util.*;
import java.util.function.ToIntFunction;

public class HuffmanCode {
    public static void main(String[] args) {
        String s = "i love java.";
        //获得字节数组
        byte[] bytes = s.getBytes();
        //生成node节点
        List<Node> nodes = getNodes(bytes);
        //变成赫夫曼树
        Node node = huffmanTree(nodes);
        //压缩成数组
        byte[] zip = zip(bytes, getCodes(node));
        System.out.println(Arrays.toString(zip));

    }
    static Map<Byte,String> huffMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static Map<Byte,String> getCodes(Node root){
        if (root == null){
            return null;
        }
        getCodes(root.left,"0",sb);
        getCodes(root.right,"1",sb);
        return huffMap;
    }

    /**
     * 把字符和其编码放入Map
     * @param node
     * @param code
     * @param sb
     */
    public static void getCodes(Node node,String code,StringBuilder sb){
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node != null){
            //判断是否是叶子节点
            if (node.data == null){
                getCodes(node.left,"0",sb2);
                getCodes(node.right,"1",sb2);
            }else {
                huffMap.put(node.data,sb2.toString());
            }
        }
    }

    public static byte[] zip(byte[] bytes,Map<Byte,String> huffMap){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes){
            sb.append(huffMap.get(b));
        }
        int len = (sb.length() + 7) / 8;
        byte[] bt = new byte[len];
        int c = 0;
        for (int i=0; i<sb.length(); i+=8){
            String strByte;
            if (i+8 > sb.length()){
                strByte = sb.substring(i);
            }else {
                strByte = sb.substring(i, i + 8);
            }
            bt[c++] =(byte) Integer.parseInt(strByte,2);
        }
        return bt;
    }

    /**
     * 把字符数组中元素出现的次数生成Node节点集合返回
     * @param bytes
     * @return
     */
    public static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
        Integer count = 0;
        //把字符出现的次数存进map
        for (byte b : bytes){
            count = map.get(b);
            if (count == null){
               map.put(b,1);
            }else {
                map.put(b,count+1);
            }
        }
        for (Map.Entry<Byte,Integer> entry : map.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    /**
     * 创建赫夫曼树
     */
    public static Node huffmanTree(List<Node> list){
        while (list.size() > 1){
            Collections.sort(list);
            Node left = list.get(0);
            Node right = list.get(1);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        return list.get(0);
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preOrder(Node node){
        if (node == null)
            return;
        node.preOrder();
    }

    /**
     * 节点
     */
    static class Node implements Comparable<Node>{
        Byte data;
        int weight;
        Node left;
        Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        public void preOrder(){
            System.out.println(this);
            if (this.left != null)
                this.left.preOrder();
            if (this.right != null)
                this.right.preOrder();
        }
    }
}



