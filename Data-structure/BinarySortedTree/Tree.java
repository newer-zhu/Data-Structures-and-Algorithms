package BinarySortedTree;


public class Tree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arr = {7,3,10,12,5,1,9,2};
        for (int i : arr)
            tree.addNode(new Node(i));
        tree.delNode(7);
        tree.infixOrder();
    }
    private Node root;

    public void addNode( Node node){
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

    public Node searchDel(int val){
        if (root == null)
            return null;
        return root.searchDel(val);
    }

    public Node searchPar(int val){
        if (root == null)
            return null;
        return root.searchPar(val);
    }

    public void delNode(int val){
        if (root == null)
            return;
        Node target = searchDel(val);
        if (target == null)
            return;
        //要删除的节点恰好是root节点并且root没有子树
        if (root.left == null && root.right == null){
            root = null;
            return;
        }
         Node parent = searchPar(val);
        //要删除的是叶子节点
        if (target.left == null && target.right == null){
            //判断要删除的节点是父节点的左还是右节点
            if (parent.getVal() > target.getVal()){
                parent.left = null;
            }else {
                parent.right = null;
            }//要删除的节点下有两颗子树
        }else if (target.left != null && target.right != null){
            //找到被删除节点target右子树下的最小值节点min，把min的值赋予target，再将min节点删除
            Node temp = target.right;
            while (temp.left != null){
                temp = temp.left;
            }
            int min = temp.getVal();
            delNode(temp.getVal());
            target.setVal(min);

        }else {//要删除的节点下有一颗子树
            //被删除的节点没有父节点，如还剩10，1两个节点，要删除10时，直接让root等于1
            if (parent == null){
                if (target.left != null)
                    root = target.left;
                else
                    root = target.right;
            }
            //要删除的节点有左子树且节点本身是父节点的左子节点
            if (target.left != null && target.getVal() == parent.left.getVal()){
                parent.left = target.left;
                //要删除的节点有右子树且节点本身是父节点的左子节点
            }else if (target.right != null && target.getVal() == parent.left.getVal()){
                parent.left = target.right;
                //要删除的节点有左子树且节点本身是父节点的右子节点
            }else if (target.left != null && target.getVal() == parent.right.getVal()){
                parent.right = target.left;
            }else {
                //要删除的节点有有子树且节点本身是父节点的右子节点
                parent.right = target.right;
            }
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
        }

    /**
     * 找到删除的节点
     * @param val
     * @return
     */
    public Node searchDel(int val){
        Node del = null;
        if (val == this.val){
            del = this;
        } else if (val < this.val){
            if (this.left == null)
                return null;
            del = this.left.searchDel(val);
        }else {
            if (this.right == null)
                return null;
            del = this.right.searchDel(val);
        }
        return del;
    }

    /**
     * 找到要删除节点的父节点
     * @param val
     * @return
     */
    public Node searchPar(int val){
        Node par = null;
        if ((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)){
            par = this;
        }else {
            if (val < this.val && this.left != null){
                par = this.left.searchPar(val);
            }else if (val >= this.val && this.right != null){
                par = this.right.searchPar(val);
            }else {
                return null;
            }
        }
        return par;
    }

    public void infixOrder(){
        if (this.left != null)
            this.left.infixOrder();
        System.out.println(this.val);
        if (this.right != null)
            this.right.infixOrder();
    }
}
