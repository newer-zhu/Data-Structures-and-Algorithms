package BinaryTree;

public class ThreadBinaryTree {

    public static void main(String[] args) {
        Node a = new Node(1, "a");
        Node b = new Node(2, "b");
        Node c = new Node(3, "c");
        Node d = new Node(4, "d");
        Node e = new Node(5, "e");
        Node f = new Node(6, "f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;

        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree(a);



        threadBinaryTree.threaded();

        threadBinaryTree.threadedInfix();
    }




    private Node root;

    public ThreadBinaryTree(Node root){
        this.root = root;
    }

    public void threaded(){
        Node.threadedNodes(root);
    }

    /**
     * 中序遍历线索化
     */
    public void threadedInfix(){
        //辅助节点初始化指向根节点
        Node node = root;
        while (node != null){
            //如果节点的左flag为0说明是左指针并没被线索化，则一直往左追
            while (node.leftFlag == 0){
                node = node.left;
            }
            //此时左指针被线索化，先打印出此节点
            System.out.println(node);
            //如果右指针指向的是后继，则一边往右追一边打印，因为右指针本来就是指向中序输出的下一个节点
            while (node.rightFlag == 1){
                node = node.right;
                System.out.println(node);
            }
            //如果右指针没被线索化，则把node的右节点赋给node，继续下一次循环
            node = node.right;
        }
    }


    static class Node{
        private int no;
        private String name;
        private Node left;
        private Node right;
        //0代表子树，1代表前后继
        private int leftFlag;
        private int rightFlag;
        //指向前驱节点
        static private Node pre;

        public static void threadedNodes(Node node){
            if (node == null)
                return;
            //线索化左子树
            threadedNodes(node.left);
            //线索化当前节点
            if (node.left == null){
                node.left = pre;
                node.setLeftFlag(1);
            }
            if (pre != null && pre.right == null){
                pre.right = node;
                pre.setRightFlag(1);
            }
            //前驱节点变成当前节点
            pre = node;
            //线索化右子树
            threadedNodes(node.right);

        }

        public Node(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name+'}' ;
        }

        public int getLeftFlag() {
            return leftFlag;
        }

        public void setLeftFlag(int leftFlag) {
            this.leftFlag = leftFlag;
        }

        public int getRightFlag() {
            return rightFlag;
        }

        public void setRightFlag(int rightFlag) {
            this.rightFlag = rightFlag;
        }



        /**
         * 中序查找
         * @param no
         * @return
         */
        public Node infixSearch(int no){
            Node resNode = null;
            if (this.left != null)
                resNode = this.left.infixSearch(no);
            if (resNode != null)
                return resNode;
            else if (this.no == no)
                return this;
            if (this.right != null)
                resNode = this.right.infixSearch(no);
            return resNode;
        }
    }
}


