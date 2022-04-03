package 剑指Offer;
import java.util.HashMap;

public class Offer35 {

    HashMap<Node, Node> map = new HashMap<>();
    /**
     * 给我一个节点，我还给你节点
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        if (!map.containsKey(head)){
            Node headNew = new Node(head.val);
            map.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return null;
//        }
//        for (Node node = head; node != null; node = node.next.next) {
//            Node nodeNew = new Node(node.val);
//            nodeNew.next = node.next;
//            node.next = nodeNew;
//        }
//        for (Node node = head; node != null; node = node.next.next) {
//            Node nodeNew = node.next;
//            nodeNew.random = (node.random != null) ? node.random.next : null;
//        }
//        Node headNew = head.next;
//        for (Node node = head; node != null; node = node.next) {
//            Node nodeNew = node.next;
//            node.next = node.next.next;
//            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
//        }
//        return headNew;
//    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
