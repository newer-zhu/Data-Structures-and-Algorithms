package AVL_Tree;

public class AVLTree {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
//        int[] ints = {10,11,7,6,8,9};
        int[] ints = {5,6,8,9,3};
        for (int i : ints){
            avlTree.addNode(new Node(i));
        }
        System.out.println(avlTree.root.getHeight());
        avlTree.root.infixOrder();
    }
    private  Node root;

    public void addNode(  Node node){
        if (root == null) {
            root = node;
            return;
        }
        root.addNode(node);
    }

    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            return;
        }
    }

}


class Node {
    private int val;
    Node left;
    Node right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node(int val) {
        this.val = val;
    }

    //返回左子树的高度
    public int getLeftHeight(){
        if (left == null)
            return 0;
        else
            return left.getHeight();
    }

    //返回右子树的高度
    public int getRightHeight(){
        if (right == null)
            return 0;
        else
            return right.getHeight();
    }

    //返回当前节点的高度,以该节点为根节点的高度
    public int getHeight(){
        return Math.max(left == null? 0:left.getHeight(),right == null? 0:right.getHeight()) + 1;
    }

    //左旋转
    public void leftRotate(){
        //创建新节点，值为当前根节点的值
        Node temp = new Node(val);
        //新节点的左子树设置为当前节点的左子树
        temp.left = left;
        //新节点右子树设置为当前节点右子树的左子树
        temp.right = right.left;
        //当前节点的值替换成右子节点的值
        val = right.val;
        //把当前节点的右子树设为当前节点右子树的右子树
        right = right.right;
        //当前节点的左子树设为新的节点
        left = temp;
    }

    //右旋转
    public void rightRotate(){
        Node temp = new Node(val);
        temp.right = right;
        temp.left = left.right;
        val = left.val;
        left = left.left;
        right = temp;
    }


    public void addNode(Node node){
        if (node == null)
            return;
        if (node.val < this.val){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.addNode(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.addNode(node);
            }
        }
        //左旋转
        if (getRightHeight() - getLeftHeight() > 1){
            if (right != null && right.getLeftHeight() > right.getRightHeight()){
                right.rightRotate();
            }
            leftRotate();
            return;
        }else if (getLeftHeight() - getRightHeight() > 1){//右旋转
            if (left != null && left.getRightHeight() > left.getLeftHeight()){
                left.leftRotate();
            }
            rightRotate();
        }
    }


    public void infixOrder(){
        if (this.left != null)
            this.left.infixOrder();
        System.out.println(this.val);
        if (this.right != null)
            this.right.infixOrder();
    }
}
