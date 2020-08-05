package BinaryTree;

public class ArrayBinaryTree {
    public static void main(String[] args) {
        ArrayBinaryTree tree = new ArrayBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        tree.preOrder();
    }

    private static int[] arr;

    public ArrayBinaryTree(int[] arr){
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }


    public static void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("空数组");
        }
        //先输出本节点
        System.out.printf("%d \t",arr[index]);
        //左子节点递归输出
        if((index*2 + 1) < arr.length){
            preOrder(index*2 + 1);
        }
        //右子节点递归输出
        if ((index*2 +1) < arr.length){
            preOrder(index*2 + 2);
        }
    }
}
