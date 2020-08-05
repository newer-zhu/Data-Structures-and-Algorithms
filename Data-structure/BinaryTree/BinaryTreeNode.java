package BinaryTree;


public class BinaryTreeNode {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = new Node(1,"a");
        Node n2 = new Node(2,"b");
        Node n3 = new Node(3,"c");
        Node n4 = new Node(4,"d");

        root.setLeft(n2);
        root.setRight(n3);
        n3.setLeft(n4);
        tree.setRoot(root);

        tree.infixOrder();
    }

    static class Node{
        private int no;
        private String name;
        private Node left;
        private Node right;

        public Node(int no, String name) {
            this.no = no;
            this.name = name;
        }

        /**
         * 前序遍历
         */
        public void PreOrder(){
            System.out.println(this);
            if (this.left != null){
                this.left.PreOrder();
            }
            if (this.right != null){
                this.right.PreOrder();
            }
        }

        /**
         * 中序遍历
         * @return
         */
        public void infixOrder(){
            if (this.left != null){
                this.left.infixOrder();
            }
            System.out.println(this);
            if (this.right != null){
                this.right.infixOrder();
            }
        }

        /**
         * 后序遍历
         * @return
         */
        public void postOrder(){
            if (this.left != null){
                this.left.postOrder();
            }
            if (this.right != null){
                this.right.postOrder();
            }
            System.out.println(this);

        }

        /**
         * 前序遍历查找
         * @return没有找到返回null
         */
        public Node preSearch(int no){
            Node resNode = null;//返回的节点
            if (this.no == no)//找到返回
                return this;
            else if (this.left != null)//存在左子树继续递归
                resNode = this.left.preSearch(no);
            if (resNode != null)//如果结果不为空则找到了
                return resNode;
            if (this.right != null)//没找到继续向右子树递归
                resNode = this.right.preSearch(no);
            return resNode;
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

        /**
         * 后序查找
         * @return
         */
        public Node postSearch(int no){
            Node resNode = null;
            if (this.left != null)
                resNode = this.left.postSearch(no);
            if (resNode != null)
                return resNode;
            if (this.right != null)
                resNode = this.right.postSearch(no);
            return this.no==no ? this : resNode;

        }

        /**
         * 删除节点
         * @return
         */
        public void delete(int no){
            //如果左子节点是要删除的节点则直接置为空
            if (this.left != null && this.left.no == no ){
                this.left = null;
                return;
            }
            //如果右子节点是要删除的节点则直接置为空
            if (this.right != null && this.right.no == no){
                this.right = null;
                return;
            }
            //如果都不是则继续向左子树递归
            if (this.left != null)
                this.left.delete(no);
            //继续向右子树递归
            if (this.right != null)
                this.right.delete(no);

        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static class Tree{
        private Node root;

        public void setRoot(Node root) {
            this.root = root;
        }

        /**
         * 前序遍历
         */
        public void preOrder(){
            if (this.root != null){
                root.PreOrder();
            }else {
                System.out.println("空树！");
            }
        }

        public void postOrder(){
            if (this.root != null){
                root.postOrder();
            }else {
                System.out.println("空树！");
            }
        }

        public void infixOrder(){
            if (this.root != null){
                root.infixOrder();
            }else {
                System.out.println("空树！");
            }
        }

        /**
         * 后序查找
         */
        public Node postSearch(int no){
            if (root != null){
                return root.postSearch(no);
            }
            System.out.println("空树");
            return null;
        }

        /**
         * 删除节点
         */
        public void delete(int no){
            if (root != null){
                if (root.getNo() == no)
                    root = null;
                else
                    root.delete(no);
            }else {
                System.out.println("空树");
            }
        }



    }
}
